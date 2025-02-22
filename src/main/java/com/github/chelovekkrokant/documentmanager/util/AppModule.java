package com.github.chelovekkrokant.documentmanager.util;

import com.github.chelovekkrokant.documentmanager.dao.impl.DocumentDAOImpl;
import com.github.chelovekkrokant.documentmanager.entity.PaymentRequestEntity;
import com.github.chelovekkrokant.documentmanager.repository.DocumentRepository;
import com.github.chelovekkrokant.documentmanager.repository.impl.DocumentRepositoryImpl;
import com.github.chelovekkrokant.documentmanager.vis.LayerMapper;
import com.github.chelovekkrokant.documentmanager.entity.InvoiceEntity;
import com.github.chelovekkrokant.documentmanager.entity.BillingEntity;
import com.github.chelovekkrokant.documentmanager.vis.impl.DocumentViewModelImpl;
import com.github.chelovekkrokant.documentmanager.vis.DocumentsViewModel;
import com.github.chelovekkrokant.documentmanager.vis.impl.LayerMapperImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(LayerMapper.class).to(LayerMapperImpl.class);
        bind(DocumentsViewModel.class).to(DocumentViewModelImpl.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    public DocumentRepository provideDocumentRepository() {
        return new DocumentRepositoryImpl(
                new DocumentDAOImpl<>(InvoiceEntity.class, HibernateUtil.getSessionFactory()),
                new DocumentDAOImpl<>(BillingEntity.class, HibernateUtil.getSessionFactory()),
                new DocumentDAOImpl<>(PaymentRequestEntity.class, HibernateUtil.getSessionFactory())
        );
    }
}
