package com.example.attijarilite.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.attijarilite.model.Account;
import com.example.attijarilite.repository.AccountRepository;

public class AllAccountsViewModel extends ViewModel {
    private AccountRepository accountRepository;
    public AllAccountsViewModel() {
        accountRepository = new AccountRepository();
    }
    public LiveData getAllAccounts(){
        return accountRepository.getAllAccounts();
    }
}
