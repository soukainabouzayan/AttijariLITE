package com.example.attijarilite.model;

public class Card {
    private String number;
    private float balance;
    private String expirationDate;
    private String type;
    private String accountSupport;
    private String owner;

    public Card(String number, float balance, String expirationDate, String type) {
        this.number = number;
        this.balance = balance;
        this.expirationDate = expirationDate;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getAccountSupport() {
        return accountSupport;
    }

    public String getOwner() {
        return owner;
    }
}
