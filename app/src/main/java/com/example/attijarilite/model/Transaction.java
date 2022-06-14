package com.example.attijarilite.model;

public class Transaction {
    private String libelle;
    private String operationDate;
    private String beneficiary;
    private float amount;
    private String relatedCard;
    private String accountNumber;

    public Transaction(String transactionDate, String object, String beneficiary, float transactionAmount, String cardNUmber, String relatedAccount) {
        this.operationDate = transactionDate;
        this.libelle = object;
        this.beneficiary = beneficiary;
        this.amount = transactionAmount;
        this.relatedCard = cardNUmber;
        this.accountNumber = relatedAccount;
    }
    public Transaction(String transactionDate, String transactionObject, String beneficiary, float transactionAmount) {
        this.operationDate = transactionDate;
        this.libelle = transactionObject;
        this.beneficiary = beneficiary;
        this.amount = transactionAmount;
    }
    public Transaction(String transactionDate, String object, float transactionAmount) {
        this.operationDate = transactionDate;
        this.libelle = object;
        this.amount = transactionAmount;
    }

    public String getRelatedCard() {
        return relatedCard;
    }

    public void setRelatedCard(String relatedCard) {
        this.relatedCard = relatedCard;
    }

    public String getObject() {
        return libelle;
    }

    public void setObject(String object) {
        this.libelle = object;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getTransactionDate() {
        return operationDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.operationDate = transactionDate;
    }

    public String getTransactionType() {
        return libelle;
    }

    public void setTransactionType(String transactionType) {
        this.libelle = transactionType;
    }

    public float getTransactionAmount() {
        return amount;
    }

    public void setTransactionAmount(float transactionAmount) {
        this.amount = transactionAmount;
    }
}
