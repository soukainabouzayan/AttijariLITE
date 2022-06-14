package com.example.attijarilite.model;

public class Account {
    private Long id;
    private String accountNumber;
    private float accountBalance;
    private  String agency;
    private String accountType;
    private String entitled;

    public String getOwnerIdentifier() {
        return ownerIdentifier;
    }

    private String rib;
    private String ownerIdentifier;

    public Account(String accountNumber, float accountBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
    }

    public Account(String accountNumber, float accountBalance, String agency, String accountType, String entitled, String rib) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.agency = agency;
        this.accountType = accountType;
        this.entitled = entitled;
        this.rib = rib;
    }

    public Account(Long id, String accountNumber, float accountBalance, String agency, String accountType, String entitled, String rib, String ownerIdentifier) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.agency = agency;
        this.accountType = accountType;
        this.entitled = entitled;
        this.rib = rib;
        this.ownerIdentifier = ownerIdentifier;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getEntitled() {
        return entitled;
    }

    public void setEntitled(String entitled) {
        this.entitled = entitled;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }
}
