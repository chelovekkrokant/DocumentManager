package com.github.chelovekkrokant.documentmanager.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Invoice {
    @Id
    private String number;
    private LocalDate date;
    @Column(name="'user'")
    private String user;
    private BigDecimal amount;
    private String currency;
    private BigDecimal exchangeRate;
    private String product;
    private BigDecimal quantity;

    public String getNumber() {
        return number;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getUser() {
        return user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
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
