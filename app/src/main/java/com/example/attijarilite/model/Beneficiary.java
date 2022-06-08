package com.example.attijarilite.model;

public class Beneficiary {
    private String type;
    private String firstName;
    private String lastName;
    private String rib;

    public Beneficiary(String type, String firstName, String lastName, String rib) {
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rib = rib;
    }

    public Beneficiary() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }
}
