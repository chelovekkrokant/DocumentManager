package com.github.chelovekkrokant.documentmanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public abstract class Document implements Serializable {
    @Id
    protected String number;
    protected LocalDateTime date = LocalDateTime.now();
    @Column(name = "'user'")
    protected String user;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getUser() {
        return user;
    }

    public String getNumber() {
        return number;
    }
}
