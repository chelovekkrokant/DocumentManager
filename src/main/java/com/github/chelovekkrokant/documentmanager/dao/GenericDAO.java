package com.github.chelovekkrokant.documentmanager.dao;

import java.util.List;

public interface GenericDAO<T1, T2> {
    void save(T1 entity);
    void delete(T2 id);
    T1 get(T2 id);
    List<T1> getAll();
    void update(T1 entity);
}
