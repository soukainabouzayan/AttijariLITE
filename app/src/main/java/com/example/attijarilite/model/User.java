package com.example.attijarilite.model;


import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("owner")
    private String identifier;
    @SerializedName("password")
    private String password;
    @SerializedName("balance")
    private Double balance;

    public Double getBalance() {
        return balance;
    }

    public User() {
    }

    public User(@NonNull String identifier, @NonNull String password) {
        this.identifier = identifier;
        this.password = password;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getPassword() {
        return password;
    }
    public boolean isIdentifierValid() {
        return true;
    }


}
