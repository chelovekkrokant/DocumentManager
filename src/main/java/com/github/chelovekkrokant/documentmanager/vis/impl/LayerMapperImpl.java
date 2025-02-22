package com.github.chelovekkrokant.documentmanager.vis.impl;


import com.github.chelovekkrokant.documentmanager.entity.*;
import com.github.chelovekkrokant.documentmanager.vis.LayerMapper;
import com.github.chelovekkrokant.documentmanager.vis.util.DocumentFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LayerMapperImpl implements LayerMapper {
    public LayerMapperImpl() {}

    @Override
    public DocumentModelImpl mapRepoToVis(DocumentEntity entity) {
        if (Objects.isNull(entity)) throw new NullPointerException("null");
        switch (entity) {
            case InvoiceEntity invoice -> {
                DocumentModelImpl document = DocumentFactory.createEmptyInvoice();
                document.attributes.get(0).value.set(invoice.getNumber());
                document.attributes.get(1).value.set(formatDate(invoice.getDate()));
                document.attributes.get(2).value.set(invoice.getUser());
                document.attributes.get(3).value.set(invoice.getAmount().toString());
                document.attributes.get(4).value.set(invoice.getCurrency());
                document.attributes.get(5).value.set(invoice.getExchangeRate().toString());
                document.attributes.get(6).value.set(invoice.getProduct());
                document.attributes.get(7).value.set(invoice.getQuantity().toString());
                return document;
            }
            case BillingEntity billingEntity -> {
                DocumentModelImpl document = DocumentFactory.createEmptyPaymentRequest();
                document.attributes.get(0).value.set(billingEntity.getNumber());
                document.attributes.get(1).value.set(formatDate(billingEntity.getDate()));
                document.attributes.get(2).value.set(billingEntity.getUser());
                document.attributes.get(3).value.set(billingEntity.getAmount().toString());
                document.attributes.get(4).value.set(billingEntity.getEmployee());
                return document;
            }
            case PaymentRequestEntity paymentRequestEntity -> {
                DocumentModelImpl document = DocumentFactory.createEmptyPaymentSlip();
                document.attributes.get(0).value.set(paymentRequestEntity.getNumber());
                document.attributes.get(1).value.set(formatDate(paymentRequestEntity.getDate()));
                document.attributes.get(2).value.set(paymentRequestEntity.getUser());
                document.attributes.get(3).value.set(paymentRequestEntity.getCounterparty());
                document.attributes.get(4).value.set(paymentRequestEntity.getAmount().toString());
                document.attributes.get(5).value.set(paymentRequestEntity.getCurrency());
                document.attributes.get(6).value.set(paymentRequestEntity.getExchangeRate().toString());
                document.attributes.get(7).value.set(paymentRequestEntity.getCommission().toString());
                return document;
            }
            default -> {
            }
        }
        throw new RuntimeException();
    }

    @Override
    public DocumentEntity mapVisToRepo(DocumentModelImpl item) {
        for (DocumentPropertyModelImpl itemAttribute : item.getAllProperties()) {
            if (itemAttribute.value.get().isEmpty()){
                throw new RuntimeException(itemAttribute.key.get() + " is empty");
            }
        }
        switch (item.type.get()) {
            case "Накладная" -> {
                InvoiceEntity invoice = new InvoiceEntity();
                invoice.setNumber(item.attributes.get(0).value.getValue());
                invoice.setDate(parseDate(item.attributes.get(1).value.getValue()));
                invoice.setUser(item.attributes.get(2).value.getValue());
                invoice.setAmount(new BigDecimal(item.attributes.get(3).value.getValue()));
                invoice.setCurrency(item.attributes.get(4).value.getValue());
                invoice.setExchangeRate(new BigDecimal(item.attributes.get(5).value.getValue()));
                invoice.setProduct(item.attributes.get(6).value.getValue());
                invoice.setQuantity(new BigDecimal(item.attributes.get(7).value.getValue()));
                return invoice;
            }
            case "Платежка" -> {
                BillingEntity paymentRequest = new BillingEntity();
                paymentRequest.setNumber(item.attributes.get(0).value.getValue());
                paymentRequest.setDate(parseDate(item.attributes.get(1).value.getValue()));
                paymentRequest.setUser(item.attributes.get(2).value.getValue());
                paymentRequest.setAmount(new BigDecimal(item.attributes.get(3).value.getValue()));
                paymentRequest.setEmployee(item.attributes.get(4).value.getValue());
                return paymentRequest;
            }
            case "Заявка на оплату" -> {
                PaymentRequestEntity paymentSlip = new PaymentRequestEntity();
                paymentSlip.setNumber(item.attributes.get(0).value.getValue());
                paymentSlip.setDate(parseDate(item.attributes.get(1).value.getValue()));
                paymentSlip.setUser(item.attributes.get(2).value.getValue());
                paymentSlip.setCounterparty(item.attributes.get(3).value.getValue());
                paymentSlip.setAmount(new BigDecimal(item.attributes.get(4).value.getValue()));
                paymentSlip.setCurrency(item.attributes.get(5).value.getValue());
                paymentSlip.setExchangeRate(new BigDecimal(item.attributes.get(6).value.getValue()));
                paymentSlip.setCommission(new BigDecimal(item.attributes.get(7).value.getValue()));
                return paymentSlip;
            }
            case null, default -> {
            }
        }
        throw new RuntimeException();
    }

    private static final List<DateTimeFormatter> DATE_FORMATS = Arrays.asList(
            DateTimeFormatter.ofPattern("yyyy/MM/dd"),
            DateTimeFormatter.ofPattern("dd.MM.yyyy"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("yyyy.MM.dd"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy")
    );

    public static LocalDate parseDate(String dateString) {
        for (DateTimeFormatter formatter : DATE_FORMATS) {
            try {
                return LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException _) {
            }
        }
        throw new IllegalArgumentException("Can't parse date: " + dateString);
    }

    public static String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    
}
