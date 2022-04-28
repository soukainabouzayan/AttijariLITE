package com.example.attijarilite.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.attijarilite.model.User;

/// as singleton
public class LoginRepository {

    public MutableLiveData<User> getLoginUser(String identifier){
        MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();
        User user = new User("identifier","password");
        userMutableLiveData.setValue(user);
        return userMutableLiveData;
    }
}
