package com.github.chelovekkrokant.documentmanager.entity;

import java.math.BigDecimal;
import jakarta.persistence.Entity;

@Entity
public class BillingEntity extends DocumentEntity {
    private BigDecimal amount;
    private String employee;

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getEmployee() {
        return employee;
    }

    @Override
    public String toString() {
        return String.format("Billing{" +
                        "number : %s, date : %tY, " +
                        "user : %s, amount : %f, " +
                        "employee : %s}",
                number, date, user, amount, employee);
    }
}
