package com.github.chelovekkrokant.documentmanager.entity;

import java.math.BigDecimal;
import jakarta.persistence.Entity;

@Entity
public class DocumentPaymentRequest extends Document {
    private String counterparty;
    private BigDecimal amount;
    private String currency;
    private BigDecimal exchangeRate;
    private BigDecimal commission;

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
