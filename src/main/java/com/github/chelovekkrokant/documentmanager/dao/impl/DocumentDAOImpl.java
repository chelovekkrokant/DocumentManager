package com.github.chelovekkrokant.documentmanager.dao.impl;

import com.github.chelovekkrokant.documentmanager.dao.DocumentDAO;
import com.github.chelovekkrokant.documentmanager.entity.DocumentEntity;
import org.hibernate.SessionFactory;

import java.util.List;

public class DocumentDAOImpl<T extends DocumentEntity> extends GenericDAOImpl<T, String> implements DocumentDAO<T> {
    public DocumentDAOImpl(Class<T> persistentClass, SessionFactory factory) {
        super(persistentClass, factory);
    }

    @Override
    public void deleteMultiple(List<String> numbers) {
        if (numbers.isEmpty()) return;
        sessionFactory.inTransaction(session ->
                session.createMutationQuery("delete from " + persistentClass.getName() + " where number in (:numbers)")
                        .setParameter("numbers", numbers)
                        .executeUpdate());
    }
}
