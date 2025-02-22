module com.github.chelovekkrokant.documentmanager.documentmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.desktop;
    requires com.google.guice;

    opens com.github.chelovekkrokant.documentmanager to javafx.fxml;
    opens com.github.chelovekkrokant.documentmanager.entity;
    exports com.github.chelovekkrokant.documentmanager;
    exports com.github.chelovekkrokant.documentmanager.controller;

    exports com.github.chelovekkrokant.documentmanager.util to com.google.guice;
    opens com.github.chelovekkrokant.documentmanager.controller to javafx.fxml, com.google.guice;
    opens com.github.chelovekkrokant.documentmanager.vis.util;
    opens com.github.chelovekkrokant.documentmanager.vis.impl;
    opens com.github.chelovekkrokant.documentmanager.vis;
}
