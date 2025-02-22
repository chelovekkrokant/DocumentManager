package com.github.chelovekkrokant.documentmanager.dao;

import java.util.List;

public interface GenericDAO<T, K> {
    void save(T entity);

    void update(T entity);

    void delete(K id);

    T get(K id);

    List<T> getAll();
}