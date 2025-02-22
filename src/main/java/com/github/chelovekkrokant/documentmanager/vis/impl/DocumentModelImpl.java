package com.github.chelovekkrokant.documentmanager.vis.impl;

import com.github.chelovekkrokant.documentmanager.vis.DocumentModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class DocumentModelImpl implements DocumentModel {
    public final BooleanProperty checked = new SimpleBooleanProperty(false);
    public final StringProperty type;
    public final ObservableList<DocumentPropertyModelImpl> attributes;

    public DocumentModelImpl(StringProperty type, ObservableList<DocumentPropertyModelImpl> attributes) {
        this.type = type;
        this.attributes = attributes;
    }

    public ObservableList<DocumentPropertyModelImpl> getAllProperties() {
        return attributes;
    }

    public String getBasicProperties() {
        String basicInfo = "%s от %s номер %s".formatted(type.get(), attributes.get(1).value.get(), attributes.get(0).value.get());
        basicInfo = basicInfo.substring(0, 1).toUpperCase() + basicInfo.substring(1);
        return basicInfo;
    }
}
