package com.example.attijarilite.model;

public class Card {
    private String number;
    private Double balance;
    private String expirationDate;

    public Card(String number, Double balance, String expirationDate) {
        this.number = number;
        this.balance = balance;
        this.expirationDate = expirationDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
