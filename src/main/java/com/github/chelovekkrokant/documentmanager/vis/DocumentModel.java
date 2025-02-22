package com.github.chelovekkrokant.documentmanager.vis;

import com.github.chelovekkrokant.documentmanager.vis.impl.DocumentPropertyModelImpl;
import javafx.collections.ObservableList;

public interface DocumentModel {

    public ObservableList<DocumentPropertyModelImpl> getAllProperties();

    public String getBasicProperties();
}
