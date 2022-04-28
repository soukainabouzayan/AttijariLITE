package com.example.attijarilite.model;

import androidx.annotation.NonNull;

public class User {
    private String identifier;
    private String password;

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
    public boolean isIdentifierValid(){
        return  true;
    }
    public boolean isPasswordValid(){
        return true;
    }
}
