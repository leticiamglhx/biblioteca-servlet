package br.com.biblioteca.service;

import javax.sql.DataSource;

import br.com.biblioteca.dao.EmprestimoDAO;
import br.com.biblioteca.model.Emprestimo;

public class EmprestimoService extends GenericService<Emprestimo> {

    public EmprestimoService(DataSource dataSource) {
        super(new EmprestimoDAO(dataSource));
    }
}
