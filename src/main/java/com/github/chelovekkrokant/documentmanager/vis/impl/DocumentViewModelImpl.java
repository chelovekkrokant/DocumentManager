package com.github.chelovekkrokant.documentmanager.vis.impl;

import com.github.chelovekkrokant.documentmanager.repository.DocumentRepository;
import com.github.chelovekkrokant.documentmanager.entity.DocumentEntity;
import com.github.chelovekkrokant.documentmanager.vis.LayerMapper;
import com.github.chelovekkrokant.documentmanager.vis.util.DocumentFactory;
import com.github.chelovekkrokant.documentmanager.vis.util.FileManager;
import com.github.chelovekkrokant.documentmanager.vis.DocumentsViewModel;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class DocumentViewModelImpl implements DocumentsViewModel {
    private final DocumentRepository documentRepository;
    private final LayerMapper layerMapper;
    private final ObservableList<DocumentModelImpl> documentsList = FXCollections.observableArrayList();
    private DocumentModelImpl selectedDocument = null;
    private DocumentModelImpl viewedDocument = null;

    @Inject
    public DocumentViewModelImpl(DocumentRepository documentRepository, LayerMapper layerMapper) {
        this.documentRepository = documentRepository;
        this.layerMapper = layerMapper;
    }

    @Override
    public void loadFromFile(File file) throws IOException, RuntimeException {
        try {
            DocumentModelImpl document = FileManager.loadDocument(file);
            DocumentEntity entity = layerMapper.mapVisToRepo(document);
            documentRepository.save(entity);
            DocumentModelImpl savedDocument = layerMapper.mapRepoToVis(entity);
            documentsList.add(savedDocument);
        } catch (IOException e) {
            throw new IOException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveToFile(File file) throws IOException {
        FileManager.saveDocument(selectedDocument, file);
    }

    @Override
    public void saveCreated() throws RuntimeException {
        DocumentEntity entity = layerMapper.mapVisToRepo(viewedDocument);
        documentRepository.save(entity);
        DocumentModelImpl savedDocument = layerMapper.mapRepoToVis(entity);
        documentsList.add(savedDocument);
        viewedDocument = null;
        System.out.println(documentRepository.getAllSorted());
    }

    @Override
    public void deleteChecked() {
        List<DocumentEntity> entities = new ArrayList<>();
        for (DocumentModelImpl item : documentsList.filtered(item -> item.checked.get())) {
            entities.add(layerMapper.mapVisToRepo(item));
        }
        documentRepository.deleteMultiple(entities);
        documentsList.removeAll(
                documentsList.filtered(item -> item.checked.get())
        );
        System.out.println(documentRepository.getAllSorted());
    }

    @Override
    public void createNewInvoice() {
        viewedDocument = DocumentFactory.createEmptyInvoice();
    }

    @Override
    public ObservableList<DocumentModelImpl> getDocumentItems() {
        return documentsList;
    }

    @Override
    public void createNewPaymentSlip() {
        viewedDocument = DocumentFactory.createEmptyPaymentSlip();
    }

    @Override
    public void createNewPaymentRequest() {
        viewedDocument = DocumentFactory.createEmptyPaymentRequest();
    }

    @Override
    public void viewSelectedDocument() {
        if (selectedDocument != null) {
            viewedDocument = selectedDocument;
        }
    }

    @Override
    public void setSelectedDocument(DocumentModelImpl selectedDocument) {
        this.selectedDocument = selectedDocument;
    }

    @Override
    public DocumentModelImpl getSelectedDocument() {
        return selectedDocument;
    }

    @Override
    public DocumentModelImpl getViewedDocument() {
        return viewedDocument;
    }

    @Override
    public void cancelEditing() {
        viewedDocument = null;
        System.out.println(documentRepository.getAllSorted());
    }

}
