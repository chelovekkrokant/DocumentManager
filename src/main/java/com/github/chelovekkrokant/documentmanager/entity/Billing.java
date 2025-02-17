package com.github.chelovekkrokant.documentmanager.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Billing {
    @Id
    private String number;
    private LocalDate date;
    @Column(name="'user'")
    private String user;
    private BigDecimal amount;
    private String employee;

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

    public String getEmployee() {
        return employee;
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

    public void setEmployee(String employee) {
        this.employee = employee;
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
