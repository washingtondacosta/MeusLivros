package com.washington.MeusLivros.dao.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.postgresql.ds.PGPoolingDataSource;

public class DataSourceFactory {
	private final DataSource daso;
	private static final Logger LOGGER = Logger.getLogger(DataSourceFactory.class.getName());

    DataSourceFactory()
    {
    	PGPoolingDataSource daso = new PGPoolingDataSource();
        String rootPath =
                Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("database.properties")).getPath();        
        InputStream input = null;
        
        try {
        	input = new FileInputStream(rootPath);
            Properties prop = new Properties();
            prop.load(input);
        	daso.setDatabaseName(prop.getProperty("database"));
    		daso.setServerName(prop.getProperty("serverName"));
    		daso.setPortNumber(5432);
    		daso.setUser(prop.getProperty("user"));
    		daso.setPassword(prop.getProperty("password"));
        }
        
        // Exception occurs when file database.properties not found 
        catch (FileNotFoundException e) {
        	// For simplicity just Log  the Exceptions
        	LOGGER.log(Level.SEVERE, "Arquivo de propriedades do banco de dados n�o encontrado",e);
        } 
        // Exception occurs when I/O error
        catch (IOException e) {
        	// For simplicity just Log  the Exceptions
        	LOGGER.log(Level.SEVERE, "Erro IO",e);
        } finally {
			if (input !=null) {
				try {
					input.close();
				} 
				// Exception occurs when failed to close input streams
				catch (IOException e) {
					// For simplicity just Log  the Exceptions
					LOGGER.log(Level.SEVERE, "Falha ao fechar streams",e);
				}
			}
		}
        this.daso = daso;
    }
    
    public static Connection getConnection() throws SQLException
    {
        return SingletonHelper.INSTANCE.daso.getConnection();
    }

    private static class SingletonHelper
    {
        private static final DataSourceFactory INSTANCE = new DataSourceFactory();
    }
}
