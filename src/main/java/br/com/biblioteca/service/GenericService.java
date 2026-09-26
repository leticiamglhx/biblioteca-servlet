package br.com.biblioteca.service;

import java.util.List;

import br.com.biblioteca.dao.GenericDAO;
import br.com.biblioteca.model.GenericEntity;



public abstract class GenericService<T extends GenericEntity> {
    protected GenericDAO<T> dao;

    public GenericService(GenericDAO<T> dao) {
        this.dao = dao;
    }
    public void create(T entity) {
        dao.create(entity);
    }
    public List<T> getAll() {
        return dao.getAll();
    }
    public T getById(Long id) {
        return dao.getById(id);
    }
    public void update(T entity) {
        dao.update(entity);
    }
    public void delete(T entity) {
        dao.delete(entity);
    }
}