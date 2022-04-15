package com.example.attijarilite.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BalanceViewModel extends ViewModel {
    public MutableLiveData<Double> balance = new MutableLiveData<>();
    public BalanceViewModel() {
        balance.setValue((double) 200000);
    }

    public MutableLiveData<Double> getBalance() {
        return balance;
    }

    public void setBalance(MutableLiveData<Double> balance) {
        this.balance = balance;
    }
}
