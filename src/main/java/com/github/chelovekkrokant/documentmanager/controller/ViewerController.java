package com.github.chelovekkrokant.documentmanager.controller;

import com.github.chelovekkrokant.documentmanager.vis.impl.DocumentPropertyModelImpl;
import com.github.chelovekkrokant.documentmanager.vis.ViewerIShowEl;
import com.github.chelovekkrokant.documentmanager.vis.DocumentsViewModel;
import com.google.inject.Inject;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewerController implements Initializable {
    private final DocumentsViewModel viewModel;
    private Stage stage;

    @Inject
    public ViewerController(DocumentsViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @FXML
    private ListView<DocumentPropertyModelImpl> documentAttributesListView;
    @FXML
    private Button okButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Platform.runLater(() -> {
            stage = (Stage) okButton.getScene().getWindow();
            stage.setOnCloseRequest(_ ->
                    viewModel.cancelEditing());
        });

        documentAttributesListView.setCellFactory(_ -> new ViewerIShowEl());

        documentAttributesListView.getItems().addAll(
                viewModel.getViewedDocument().getAllProperties()
        );

        okButton.setOnAction(_ -> stage.close());
    }
}
