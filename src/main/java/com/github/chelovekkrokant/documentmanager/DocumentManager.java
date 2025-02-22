package com.github.chelovekkrokant.documentmanager;

import com.github.chelovekkrokant.documentmanager.util.AppModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class DocumentManager extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Injector injector = Guice.createInjector(new AppModule());
        FXMLLoader fx = new FXMLLoader(DocumentManager.class.getResource("main-menu.fxml"));
        fx.setControllerFactory(injector::getInstance);

        Scene scene = new Scene(fx.load());
        stage.setTitle("Менеджер документов");
        stage.setScene(scene);
        stage.setMinHeight(500);
        stage.setMinWidth(700);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}