package com.github.chelovekkrokant.documentmanager.repository;

import com.github.chelovekkrokant.documentmanager.entity.DocumentEntity;

import java.util.List;

public interface DocumentRepository {
    List<DocumentEntity> getAllSorted();

    void save(DocumentEntity entity);

    void deleteMultiple(List<DocumentEntity> entities);

    DocumentEntity get(DocumentEntity entity);
}
