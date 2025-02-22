package com.github.chelovekkrokant.documentmanager.vis.impl;

import com.github.chelovekkrokant.documentmanager.vis.DocumentPropertyModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DocumentPropertyModelImpl implements DocumentPropertyModel {
    public StringProperty key = new SimpleStringProperty();
    public StringProperty value = new SimpleStringProperty();

    public DocumentPropertyModelImpl(String key, String value) {
        this.key.set(key);
        this.value.set(value);
    }

    public String getKey() {
        return key.get();
    }

    public String getValue() {
        return value.get();
    }
}
