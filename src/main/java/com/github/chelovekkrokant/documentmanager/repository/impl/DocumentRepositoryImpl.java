package com.github.chelovekkrokant.documentmanager.repository.impl;

import com.github.chelovekkrokant.documentmanager.dao.DocumentDAO;
import com.github.chelovekkrokant.documentmanager.entity.DocumentEntity;
import com.github.chelovekkrokant.documentmanager.entity.InvoiceEntity;
import com.github.chelovekkrokant.documentmanager.entity.BillingEntity;
import com.github.chelovekkrokant.documentmanager.entity.PaymentRequestEntity;
import com.github.chelovekkrokant.documentmanager.repository.DocumentRepository;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DocumentRepositoryImpl implements DocumentRepository {
    private final DocumentDAO<InvoiceEntity> invoiceDao;
    private final DocumentDAO<BillingEntity> paymentRequestDao;
    private final DocumentDAO<PaymentRequestEntity> billingDAO;

    @Inject
    public DocumentRepositoryImpl(DocumentDAO<InvoiceEntity> invoiceDao,
                                  DocumentDAO<BillingEntity> paymentRequestDao,
                                  DocumentDAO<PaymentRequestEntity> billingDAO) {
        this.invoiceDao = invoiceDao;
        this.paymentRequestDao = paymentRequestDao;
        this.billingDAO = billingDAO;
    }

    @Override
    public List<DocumentEntity> getAllSorted() {
        List<DocumentEntity> documents = new ArrayList<>();
        documents.addAll(invoiceDao.getAll());
        documents.addAll(paymentRequestDao.getAll());
        documents.addAll(billingDAO.getAll());
        documents.sort(Comparator.comparing(DocumentEntity::getDate));
        return documents;
    }

    @Override
    public void save(DocumentEntity entity) {
        if (entity instanceof InvoiceEntity) {
            invoiceDao.save((InvoiceEntity) entity);
        }
        if (entity instanceof BillingEntity) {
            paymentRequestDao.save((BillingEntity) entity);
        }
        if (entity instanceof PaymentRequestEntity) {
            billingDAO.save((PaymentRequestEntity) entity);
        }
    }

    @Override
    public void deleteMultiple(List<DocumentEntity> entities) {
        List<String> invoiceNumbers = new ArrayList<>();
        List<String> paymentRequestNumbers = new ArrayList<>();
        List<String> paymentSlipNumbers = new ArrayList<>();
        for (DocumentEntity entity : entities) {
            if (entity instanceof InvoiceEntity) invoiceNumbers.add(entity.getNumber());
            if (entity instanceof BillingEntity) paymentRequestNumbers.add(entity.getNumber());
            if (entity instanceof PaymentRequestEntity) paymentSlipNumbers.add(entity.getNumber());
        }
        invoiceDao.deleteMultiple(invoiceNumbers);
        paymentRequestDao.deleteMultiple(paymentRequestNumbers);
        billingDAO.deleteMultiple(paymentSlipNumbers);
    }

    @Override
    public DocumentEntity get(DocumentEntity entity) {
        if (entity instanceof InvoiceEntity) return invoiceDao.get(entity.getNumber());
        if (entity instanceof BillingEntity) return paymentRequestDao.get(entity.getNumber());
        if (entity instanceof PaymentRequestEntity) return billingDAO.get(entity.getNumber());
        else throw new RuntimeException("Entity not found");
    }
}
