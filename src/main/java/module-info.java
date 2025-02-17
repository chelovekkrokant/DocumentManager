module com.github.chelovekkrokant.documentmanager.documentmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;

    opens com.github.chelovekkrokant.documentmanager to javafx.fxml;
    exports com.github.chelovekkrokant.documentmanager;
}