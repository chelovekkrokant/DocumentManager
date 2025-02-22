package com.github.chelovekkrokant.documentmanager.vis.util;

import com.github.chelovekkrokant.documentmanager.vis.impl.DocumentModelImpl;
import com.github.chelovekkrokant.documentmanager.vis.impl.DocumentPropertyModelImpl;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {

    public static void saveDocument(DocumentModelImpl document, File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(document.type.get());
            writer.newLine();

            for (DocumentPropertyModelImpl attribute : document.getAllProperties()) {
                writer.write(attribute.key.get() + ": " + attribute.value.get());
                writer.newLine();
            }
        }
    }

    public static DocumentModelImpl loadDocument(File file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file.toURI()));

        StringProperty type = new SimpleStringProperty(lines.getFirst());

        ObservableList<DocumentPropertyModelImpl> attributes = FXCollections.observableArrayList();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(": ");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                attributes.add(new DocumentPropertyModelImpl(key, value));
            }
        }

        return new DocumentModelImpl(type, attributes);
    }
}