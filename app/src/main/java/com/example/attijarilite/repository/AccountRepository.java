package com.example.attijarilite.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.attijarilite.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {



    public MutableLiveData<List<Account>> getAllAccounts(){
        MutableLiveData<List<Account>> accountList = new MutableLiveData<>();
        ArrayList<Account> accounts = new ArrayList<>();
        Account account1 = new Account("account number345678904567",(double)5000,"account type");
        Account account2 = new Account("account number 23456789",(double)445678,"account type");
        Account account3 = new Account("account number345678456",(double)4567,"account type");
        Account account4 = new Account("account number2345678907",(double)7890,"account type");
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accountList.setValue(accounts);
        return accountList;
    }
}
