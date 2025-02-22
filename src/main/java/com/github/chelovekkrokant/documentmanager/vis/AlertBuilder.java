package com.github.chelovekkrokant.documentmanager.vis;

import javafx.scene.control.Alert;

public class AlertBuilder {
    private final Alert alert;

    public AlertBuilder() {
        alert = new Alert(Alert.AlertType.NONE);
    }

    public AlertBuilder setType(Alert.AlertType type) {
        alert.setAlertType(type);
        return this;
    }

    public AlertBuilder setTitle(String title) {
        alert.setTitle(title);
        return this;
    }

    public AlertBuilder setHeaderText(String headerText) {
        alert.setHeaderText(headerText);
        return this;
    }

    public AlertBuilder setText(String text) {
        alert.setContentText(text);
        return this;
    }

    public void show(){
        alert.show();
    }
}
