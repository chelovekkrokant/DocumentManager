package com.github.chelovekkrokant.documentmanager.vis;

import com.github.chelovekkrokant.documentmanager.vis.impl.DocumentModelImpl;
import javafx.collections.ObservableList;
import java.io.File;
import java.io.IOException;

public interface DocumentsViewModel {

    void loadFromFile(File file) throws IOException, RuntimeException;

    void saveToFile(File file) throws IOException;

    void saveCreated() throws RuntimeException;

    void deleteChecked();

    void createNewInvoice();

    ObservableList<DocumentModelImpl> getDocumentItems();

    void createNewPaymentSlip();

    void createNewPaymentRequest();

    void viewSelectedDocument();

    void setSelectedDocument(DocumentModelImpl selectedDocument);

    DocumentModelImpl getSelectedDocument();

    DocumentModelImpl getViewedDocument();

    void cancelEditing();
}