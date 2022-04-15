package com.example.attijarilite.model;

public class Transaction {
    private String transactionDate;
    private String object;
    private String beneficiary;
    private Double transactionAmount;
    private String cardNUmber;

    public String getCardNUmber() {
        return cardNUmber;
    }

    public void setCardNUmber(String cardNUmber) {
        this.cardNUmber = cardNUmber;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Transaction(String transactionDate, String transactionObject, String beneficiary, Double transactionAmount) {
        this.transactionDate = transactionDate;
        this.object = transactionObject;
        this.beneficiary = beneficiary;
        this.transactionAmount = transactionAmount;
    }

    public Transaction(String transactionDate, String object, Double transactionAmount) {
        this.transactionDate = transactionDate;
        this.object = object;
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return object;
    }

    public void setTransactionType(String transactionType) {
        this.object = transactionType;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
