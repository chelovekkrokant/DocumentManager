package com.github.chelovekkrokant.documentmanager.dao;

import com.github.chelovekkrokant.documentmanager.entity.DocumentEntity;

import java.util.List;

public interface DocumentDAO<T extends DocumentEntity> extends GenericDAO<T, String> {
    void deleteMultiple(List<String> numbers);
}
