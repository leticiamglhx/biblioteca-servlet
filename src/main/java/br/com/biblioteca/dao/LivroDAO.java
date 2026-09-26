package br.com.biblioteca.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import br.com.biblioteca.model.Livro;

public class LivroDAO extends GenericDAO<Livro> {

    public LivroDAO(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	protected String getInsertSql() {
		return "INSERT INTO livro (titulo, autor, isbn, anoPublicacao) VALUES (?, ?, ?, ?)";
	}

	@Override
	protected void setInsertParameters(PreparedStatement statement, Livro livro)
			throws SQLException {
		statement.setString(1, livro.getTitulo());
        statement.setString(2, livro.getAutor());
        statement.setString(3, livro.getIsbn());
        statement.setInt(4, livro.getAnoPublicacao());
       
        

	}

	@Override
	protected String getUpdateSql() {
		return "UPDATE livro SET titulo=?, autor=?, isbn=?, anoPublicacao=? WHERE id=?";
	}

	@Override
	protected void setUpdateParameters(PreparedStatement statement, Livro livro)
			throws SQLException {
		statement.setString(1, livro.getTitulo());
		statement.setString(2, livro.getAutor());
		statement.setString(3, livro.getIsbn());
		statement.setInt(4, livro.getAnoPublicacao());
		statement.setLong(5, livro.getId());
	}

	@Override
	protected String getTableName() {
		return "livro";
	}

	@Override
	protected Livro mapResultSetToEntity(ResultSet resultSet) throws SQLException {
		Livro livro = new Livro();
		livro.setId(resultSet.getLong("id"));
		livro.setTitulo(resultSet.getString("titulo"));
		livro.setAutor(resultSet.getString("autor"));
		livro.setIsbn(resultSet.getString("isbn"));
		livro.setAnoPublicacao(resultSet.getInt("anoPublicacao"));


		
		

		return livro;
	}
    
}
