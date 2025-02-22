package com.github.chelovekkrokant.documentmanager.dao.impl;

import com.github.chelovekkrokant.documentmanager.dao.GenericDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {
    protected final Class<T> persistentClass;
    protected final SessionFactory sessionFactory;

    public GenericDAOImpl(Class<T> persistentClass, SessionFactory factory) {
        this.persistentClass = persistentClass;
        if (factory == null) {
            throw new IllegalArgumentException("SessionFactory must not be null");
        }
        this.sessionFactory = factory;
    }

    @Override
    public void save(T entity) {
        sessionFactory.inTransaction(session -> session.persist(entity));
    }

    @Override
    public void update(T entity) {
        sessionFactory.inTransaction(session -> session.merge(entity));
    }

    @Override
    public void delete(K id) {
        sessionFactory.inTransaction(session -> {
            T entity = session.get(persistentClass, id);
            if (entity != null) {
                session.remove(entity);
            }
        });
    }

    @Override
    public T get(K id) {
        return sessionFactory.fromTransaction(session -> session.get(persistentClass, id));
    }

    @Override
    public List<T> getAll() {
        return sessionFactory.fromTransaction(session ->
                session.createQuery("from " + persistentClass.getName(), persistentClass).getResultList()
        );
    }
}
