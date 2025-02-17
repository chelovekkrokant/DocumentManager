module com.github.chelovekkrokant.documentmanager.documentmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.desktop;

    opens com.github.chelovekkrokant.documentmanager to javafx.fxml;
    opens com.github.chelovekkrokant.documentmanager.entity;
    exports com.github.chelovekkrokant.documentmanager;
    exports com.github.chelovekkrokant.documentmanager.controller;
    opens com.github.chelovekkrokant.documentmanager.controller to javafx.fxml;
}