package com.github.chelovekkrokant.documentmanager.vis;

import com.github.chelovekkrokant.documentmanager.vis.impl.DocumentPropertyModelImpl;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

public class EditorShowEl extends ListCell<DocumentPropertyModelImpl> {
    private final HBox hbox = new HBox();
    private final Text key = new Text();

    private final TextField value = new TextField();

    public EditorShowEl() {
        super();
        hbox.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(hbox, Priority.ALWAYS);
        HBox.setHgrow(value, Priority.ALWAYS);
        HBox.setHgrow(value, Priority.ALWAYS);
        value.setMaxWidth(Double.MAX_VALUE);
        hbox.setSpacing(15);
        value.textProperty().addListener((_, oldValue, newValue) -> {
            if (newValue.contains(",")) {
                value.setText(oldValue);
            }
        });
        hbox.getChildren().addAll(key, value);
    }


    @Override
    protected void updateItem(DocumentPropertyModelImpl item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            key.setText(item.key.getValue());
            item.value.bind(value.textProperty());
            setGraphic(hbox);
        }
    }
}