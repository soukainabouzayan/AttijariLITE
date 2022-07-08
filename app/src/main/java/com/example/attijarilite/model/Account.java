package com.example.attijarilite.model;

import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("id")
    private Long id;
    @SerializedName("accountNumber")
    private String accountNumber;
    @SerializedName("accountBalance")
    private float accountBalance;
    @SerializedName("agency")
    private  String agency;
    @SerializedName("accountType")
    private String accountType;
    @SerializedName("entitled")
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
