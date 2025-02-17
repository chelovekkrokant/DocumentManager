package com.github.chelovekkrokant.documentmanager.dao.impl;


import com.github.chelovekkrokant.documentmanager.dao.DAOGeneric;
import org.hibernate.SessionFactory;

import java.util.List;

public class DAOImplGeneric<T1, T2> implements DAOGeneric<T1, T2> {
    private final Class<T1> currentClass;
    private final SessionFactory sessionFactory;

    public DAOImplGeneric(Class<T1> currentClass, SessionFactory sessionFactory) {
        this.currentClass = currentClass;
        if (sessionFactory == null){
            throw new IllegalArgumentException("The SessionFactory is null");
        }
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(T1 entity) {
        sessionFactory.inTransaction(session -> session.persist(entity));
    }

    @Override
    public void delete(T2 id) {
        sessionFactory.inTransaction(session -> {
            T1 entity = session.get(currentClass, id);
            if (entity != null) {
                session.remove(entity);
            }
        });
    }

    @Override
    public T1 get(T2 id) {
        return sessionFactory.fromTransaction(session -> session.get(currentClass, id));
    }

    @Override
    public List<T1> getAll() {
        return sessionFactory.fromTransaction(session ->
                session.createQuery("from " + currentClass.getName(), currentClass).getResultList()
        );
    }

    @Override
    public void update(T1 entity) {
        sessionFactory.inTransaction(session -> session.merge(entity));
    }
}
