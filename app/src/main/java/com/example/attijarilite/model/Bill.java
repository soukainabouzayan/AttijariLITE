package com.example.attijarilite.model;

public class Bill {
    private String billNumber;
    private Double billAmount;
    private String company;

    public Bill(String billNumber, Double billAmount, String company) {
        this.billNumber = billNumber;
        this.billAmount = billAmount;
        this.company = company;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
