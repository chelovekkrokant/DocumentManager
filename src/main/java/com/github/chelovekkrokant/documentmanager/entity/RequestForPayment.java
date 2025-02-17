package com.github.chelovekkrokant.documentmanager.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RequestForPayment {
    @Id
    private String number;
    private LocalDate date;
    @Column(name="'user'")
    private String user;
    private String counterparty;
    private BigDecimal amount;
    private String currency;
    private BigDecimal exchangeRate;
    private BigDecimal commission;

    public String getNumber() {
        return number;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getUser() {
        return user;
    }

    public String getCounterparty() {
        return counterparty;
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

    public BigDecimal getCommission() {
        return commission;
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

    public void setCounterparty(String counterparty) {
        this.counterparty = counterparty;
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

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return String.format("RequestForPayment{" +
                        "number : %s, date : %tY, " +
                        "user : %s, counterparty : %s, " +
                        "amount : %f, currency : %s, " +
                        "exchangeRate : %f, commission : %f}",
                number, date, user, counterparty, amount, currency, exchangeRate, commission);
    }
}
