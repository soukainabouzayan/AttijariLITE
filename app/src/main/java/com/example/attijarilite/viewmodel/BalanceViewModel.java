package com.example.attijarilite.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.attijarilite.repository.AccountRepository;

public class BalanceViewModel extends ViewModel {
    private AccountRepository accountRepository;
    public BalanceViewModel() {
        accountRepository = new AccountRepository();
    }
    public LiveData getUserBalance(String ownerIdentifier){
        return accountRepository.getUserBalance();
    }

}
