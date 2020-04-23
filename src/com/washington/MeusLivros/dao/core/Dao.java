package com.washington.MeusLivros.dao.core;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.washington.MeusLivros.model.Livros;

public interface Dao<T, ID> {
	
	List<T> findAll() throws SQLException;
	
	boolean save(T o) throws SQLException;
	
	boolean update(T o) throws SQLException;
	
	boolean delete (T o) throws SQLException;

	Optional<Livros> find(int id) throws SQLException;
}
