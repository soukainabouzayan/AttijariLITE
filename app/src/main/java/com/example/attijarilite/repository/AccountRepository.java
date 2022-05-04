package com.example.attijarilite.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.attijarilite.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {



    public MutableLiveData<List<Account>> getAllAccounts(){
        MutableLiveData<List<Account>> accountList = new MutableLiveData<>();
        ArrayList<Account> accounts = new ArrayList<>();
        Account account1 = new Account("account number1111111111",(double)5000,"account type 1");
        Account account2 = new Account("account number 2222222222",(double)445678,"account type 2");
        Account account3 = new Account("account number333333333",(double)4567,"account type 3");
        Account account4 = new Account("account number444444444444",(double)7890,"account type 4");
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accountList.setValue(accounts);
        return accountList;
    }
}
