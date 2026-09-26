package br.com.biblioteca.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.ResultSet;

import javax.sql.DataSource;

import br.com.biblioteca.model.Emprestimo;

public class EmprestimoDAO extends GenericDAO<Emprestimo> {

    public EmprestimoDAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected String getInsertSql() {
        return "INSERT INTO emprestimo "
            + "(idPessoa, idLivro, dataEmprestimo, dataDevolucao) "
            + "VALUES (?, ?, ?, ?)";
    }

    @Override
    protected void setInsertParameters(
            PreparedStatement statement, Emprestimo emprestimo)
            throws SQLException {

        statement.setLong(1, emprestimo.getIdPessoa());
        statement.setLong(2, emprestimo.getIdLivro());
        statement.setDate(3, Date.valueOf(emprestimo.getDataEmprestimo()));

        if (emprestimo.getDataDevolucao() == null) {
            statement.setNull(4, Types.DATE);
        } else {
            statement.setDate(
                4, Date.valueOf(emprestimo.getDataDevolucao())
            );
        }
    }

    @Override
    protected String getUpdateSql() {
        return "UPDATE emprestimo SET "
            + "idPessoa=?, idLivro=?, dataEmprestimo=?, dataDevolucao=? "
            + "WHERE id=?";
    }

    @Override
    protected void setUpdateParameters(
            PreparedStatement statement, Emprestimo emprestimo)
            throws SQLException {

        setInsertParameters(statement, emprestimo);
        statement.setLong(5, emprestimo.getId());
    }

    @Override
    protected String getTableName() {
        return "emprestimo";
    }

    @Override
    protected Emprestimo mapResultSetToEntity(ResultSet resultSet)
            throws SQLException {

        Emprestimo emprestimo = new Emprestimo();

        emprestimo.setId(resultSet.getLong("id"));
        emprestimo.setIdPessoa(resultSet.getLong("idPessoa"));
        emprestimo.setIdLivro(resultSet.getLong("idLivro"));
        emprestimo.setDataEmprestimo(
            resultSet.getDate("dataEmprestimo").toLocalDate()
        );

        Date dataDevolucao = resultSet.getDate("dataDevolucao");
        emprestimo.setDataDevolucao(
            dataDevolucao == null ? null : dataDevolucao.toLocalDate()
        );

        return emprestimo;
    }
}