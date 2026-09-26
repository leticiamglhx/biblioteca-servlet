package br.com.biblioteca.service;

import javax.sql.DataSource;

import br.com.biblioteca.dao.LivroDAO;
import br.com.biblioteca.model.Livro;

public class LivroService extends GenericService<Livro>{
    
    public LivroService(DataSource dataSource) {
        super(new LivroDAO(dataSource));
    }
}
