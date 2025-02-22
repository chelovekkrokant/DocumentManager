package com.github.chelovekkrokant.documentmanager.vis.util;

import com.github.chelovekkrokant.documentmanager.vis.impl.DocumentModelImpl;
import com.github.chelovekkrokant.documentmanager.vis.impl.DocumentPropertyModelImpl;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;

public class DocumentFactory {
    public static DocumentModelImpl createEmptyInvoice() {
        return new DocumentModelImpl(new SimpleStringProperty("Накладная"), FXCollections.observableArrayList(
                new DocumentPropertyModelImpl("Номер", ""),
                new DocumentPropertyModelImpl("Дата", ""),
                new DocumentPropertyModelImpl("Пользователь", ""),
                new DocumentPropertyModelImpl("Сумма", ""),
                new DocumentPropertyModelImpl("Валюта", ""),
                new DocumentPropertyModelImpl("Курс валюты", ""),
                new DocumentPropertyModelImpl("Товар", ""),
                new DocumentPropertyModelImpl("Количество", "")
        ));
    }

    public static DocumentModelImpl createEmptyPaymentRequest() {
        return new DocumentModelImpl(new SimpleStringProperty("Платежка"), FXCollections.observableArrayList(
                new DocumentPropertyModelImpl("Номер", ""),
                new DocumentPropertyModelImpl("Дата", ""),
                new DocumentPropertyModelImpl("Пользователь", ""),
                new DocumentPropertyModelImpl("Сумма", ""),
                new DocumentPropertyModelImpl("Сотрудник", "")
        ));
    }

    public static DocumentModelImpl createEmptyPaymentSlip() {
        return new DocumentModelImpl(new SimpleStringProperty("Заявка на оплату"), FXCollections.observableArrayList(
                new DocumentPropertyModelImpl("Номер", ""),
                new DocumentPropertyModelImpl("Дата", ""),
                new DocumentPropertyModelImpl("Пользователь", ""),
                new DocumentPropertyModelImpl("Контрагент", ""),
                new DocumentPropertyModelImpl("Сумма", ""),
                new DocumentPropertyModelImpl("Валюта", ""),
                new DocumentPropertyModelImpl("Курс валюты", ""),
                new DocumentPropertyModelImpl("Комиссия", "")
        ));
    }
}
