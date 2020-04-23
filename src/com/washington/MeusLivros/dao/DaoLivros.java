package com.washington.MeusLivros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.washington.MeusLivros.dao.core.DataSourceFactory;
import com.washington.MeusLivros.dao.core.LivrosDao;
import com.washington.MeusLivros.model.Livros;

public class DaoLivros implements LivrosDao {
	private DaoLivros() {
	}

	private static class SingletonHelper {
		private static final DaoLivros INSTANCE = new DaoLivros();
	}

	public static DaoLivros getInstance() {
		return SingletonHelper.INSTANCE;
	}

	@Override
	public Optional<Livros> find(int id) throws SQLException {

		String sql = "SELECT id,titulo,autor,anolancamento,resumo FROM livros WHERE id = ?";
		int id_livros = 0;
		String titulo = "", autor = "", anoLancamento = "", resumo = "";
		Connection conn = DataSourceFactory.getConnection();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			id_livros = resultSet.getInt("id");
			titulo = resultSet.getString("titulo");
			autor = resultSet.getString("autor");
			anoLancamento = resultSet.getString("anolancamento");
			resumo = resultSet.getString("resumo");
		}
		return Optional.of(new Livros(id_livros, titulo, autor, anoLancamento, resumo));
	}

	@Override
	public List<Livros> findAll() throws SQLException {
		List<Livros> listLivros = new ArrayList<>();
		String sql = "SELECT id,titulo,autor,anolancamento,resumo FROM livros";

		Connection conn = DataSourceFactory.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String titulo = resultSet.getString("titulo");
			String autor = resultSet.getString("autor");
			String anoLancamento = resultSet.getString("anolancamento");
			String resumo = resultSet.getString("resumo");

			Livros livros = new Livros(id, titulo, autor, anoLancamento, resumo);
			listLivros.add(livros);
		}

		return listLivros;
	}

	@Override
	public boolean save(Livros livros) throws SQLException {

		String sql = "INSERT into livros (titulo, autor, anolancamento, resumo) VALUES (?, ?, ?, ?)";
		boolean rowInserted = false;
		Connection conn = DataSourceFactory.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, livros.getTitulo());
			statement.setString(2, livros.getAutor());
			statement.setString(3, livros.getAnoLancamento());
			statement.setString(4, livros.getResumo());
			rowInserted = statement.executeUpdate() > 0;
		return rowInserted;
	}

	@Override
	public boolean update(Livros livros) throws SQLException {
		String sql = "UPDATE livros SET titulo = ?, autor = ?, anolancamento = ?, resumo = ?";
		sql += " WHERE id = ?";
		boolean rowUpdateted = false;
		Connection conn = DataSourceFactory.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, livros.getTitulo());
			statement.setString(2, livros.getAutor());
			statement.setString(3, livros.getAnoLancamento());
			statement.setString(4, livros.getResumo());
			statement.setInt(5, livros.getId());
			rowUpdateted = statement.executeUpdate() > 0;

		return rowUpdateted;
	}

	@Override
	public boolean delete(Livros livros) throws SQLException {

		String sql = "DELETE FROM livros where id = ?";
		boolean rowDeleted = false;

		Connection conn = DataSourceFactory.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, livros.getId());
			rowDeleted = statement.executeUpdate() > 0;

		return rowDeleted;
	}

}
