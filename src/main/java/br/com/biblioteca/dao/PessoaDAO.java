package br.com.biblioteca.dao;

import java.sql.Date;

import br.com.biblioteca.model.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class PessoaDAO extends GenericDAO<Pessoa>{

	public PessoaDAO(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	protected String getInsertSql() {
		return "INSERT INTO pessoa (nome, dataNascimento) VALUES (?, ?)";
	}

	@Override
	protected void setInsertParameters(PreparedStatement statement, Pessoa pessoa)
			throws SQLException {
		statement.setString(1, pessoa.getNome());
        statement.setDate(2, Date.valueOf(pessoa.getDataNascimento()));

	}

	@Override
	protected String getUpdateSql() {
		return "UPDATE pessoa SET nome=?, dataNascimento=? WHERE id=?";
	}

	@Override
	protected void setUpdateParameters(PreparedStatement statement, Pessoa pessoa)
			throws SQLException {
		statement.setString(1, pessoa.getNome());
		statement.setDate(2, Date.valueOf(pessoa.getDataNascimento()));
		statement.setLong(3, pessoa.getId());
	}

	@Override
	protected String getTableName() {
		return "pessoa";
	}

	@Override
	protected Pessoa mapResultSetToEntity(ResultSet resultSet) throws SQLException {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(resultSet.getLong("id"));
		pessoa.setNome(resultSet.getString("nome"));
		pessoa.setDataNascimento(resultSet.getDate("dataNascimento").toLocalDate());
		
		
		return pessoa;
	}

}
