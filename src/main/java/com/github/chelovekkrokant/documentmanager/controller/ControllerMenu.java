package com.github.chelovekkrokant.documentmanager.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMenu implements Initializable {
    @FXML
    private Button invoiceButton;
    @FXML
    private Button paymentRequestButton;
    @FXML
    private Button paymentSlipButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        invoiceButton.setOnAction(_ -> openDocumentEditingWindow());
        paymentRequestButton.setOnAction(_ -> openDocumentEditingWindow());
        paymentSlipButton.setOnAction(_ -> openDocumentEditingWindow());
    }

    private void openDocumentEditingWindow() {
    }
}
