package br.com.biblioteca.service;

import javax.sql.DataSource;

import br.com.biblioteca.dao.PessoaDAO;
import br.com.biblioteca.model.Pessoa;



public class PessoaService extends GenericService<Pessoa>{
    
    public PessoaService(DataSource dataSource) {
        super(new PessoaDAO(dataSource));
    }
}
