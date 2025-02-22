package com.github.chelovekkrokant.documentmanager.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class DocumentEntity implements Serializable {
    @Id
    protected String number;
    protected LocalDate date = LocalDate.now();
    @Column(name = "'user'")
    protected String user;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getUser() {
        return user;
    }

    public String getNumber() {
        return number;
    }
}
