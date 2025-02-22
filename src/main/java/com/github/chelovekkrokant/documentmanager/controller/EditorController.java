package com.github.chelovekkrokant.documentmanager.controller;

import com.github.chelovekkrokant.documentmanager.vis.AlertBuilder;
import com.github.chelovekkrokant.documentmanager.vis.impl.DocumentPropertyModelImpl;
import com.github.chelovekkrokant.documentmanager.vis.EditorShowEl;
import com.github.chelovekkrokant.documentmanager.vis.DocumentsViewModel;
import com.google.inject.Inject;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditorController implements Initializable {
    private final DocumentsViewModel viewModel;
    private Stage stage;

    @Inject
    public EditorController(DocumentsViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @FXML
    private ListView<DocumentPropertyModelImpl> documentAttributesListView;
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        documentAttributesListView.setCellFactory(_ -> new EditorShowEl());
        documentAttributesListView.getItems().addAll(
                viewModel.getViewedDocument().getAllProperties()
        );

        okButton.setOnAction(_ -> {
            try {
                viewModel.saveCreated();
            } catch (RuntimeException e) {
                new AlertBuilder()
                        .setType(Alert.AlertType.ERROR)
                        .setTitle("ОШИБКА")
                        .setHeaderText("ОШИБКА ПРИ СОЗДАНИИ")
                        .setText("НЕКОРРЕКТНЫЕ ДАННЫЕ")
                        .show();
            }
            stage.close();
        });
        cancelButton.setOnAction(_ -> {
            viewModel.cancelEditing();
            stage.close();
        });

        Platform.runLater(() -> {
            stage = (Stage) cancelButton.getScene().getWindow();
            stage.setOnCloseRequest(_ ->
                    viewModel.cancelEditing());
        });
    }
}
