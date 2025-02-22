package com.github.chelovekkrokant.documentmanager.entity;

import jakarta.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class InvoiceEntity extends DocumentEntity {
    private BigDecimal quantity;
    private String product;
    private BigDecimal exchangeRate;
    private String currency;
    private BigDecimal amount;

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("Invoice{" +
                        "number : %s, date : %tY, " +
                        "user : %s, amount : %f, " +
                        "currency : %s, exchangeRate : %f" +
                        "product : %s, quantity : %f}",
                number, date, user, amount, currency, exchangeRate, product, quantity);
    }
}
