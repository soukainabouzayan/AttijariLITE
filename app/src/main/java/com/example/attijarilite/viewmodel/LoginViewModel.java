package com.example.attijarilite.viewmodel;


import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.attijarilite.model.User;
import com.example.attijarilite.repository.LoginRepository;

public class LoginViewModel extends ViewModel {
    public MutableLiveData<String> identifier = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<User> userMutableLiveData;
    public LoginRepository loginRepository;
    public MutableLiveData<User> getUserMutableLiveData(){
        if(userMutableLiveData == null){
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;
    }
    public void onClick(View view){


    }

}
