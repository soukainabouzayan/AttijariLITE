package com.example.attijarilite.repository;



import androidx.lifecycle.MutableLiveData;

import com.example.attijarilite.model.Account;
import com.example.attijarilite.network.APIService;
import com.example.attijarilite.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountRepository {



    public MutableLiveData<List<Account>> getAllAccounts(){
        MutableLiveData<List<Account>> accountList = new MutableLiveData<>();
        ArrayList<Account> accounts = new ArrayList<>();
        Account account1 = new Account("account number1111111111",(float) 500,"account type 1");
        Account account2 = new Account("account number 2222222222",(float) 478,"account type 2");
        Account account3 = new Account("account number333333333",(float) 4567.34,"account type 3");
        Account account4 = new Account("account number444444444444",(float) 7890,"account type 4");
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account4);
        accounts.add(account4);
        accounts.add(account4);
        accounts.add(account4);
        accounts.add(account4);
        accounts.add(account4);
        accounts.add(account4);
        accounts.add(account4);
        accounts.add(account4);
        accountList.setValue(accounts);
        return accountList;
    }
    public MutableLiveData<List<Account>> getAllAccountsRetro(){
        MutableLiveData<List<Account>> accounts = new MutableLiveData<>();
        APIService apiService = RetrofitInstance.getRetrofitInstance().create(APIService.class);
        Call<List<Account>> call = apiService.getAllAccounts();
        call.enqueue(new Callback<List<Account>>() {
            @Override
            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                if (!response.isSuccessful()){
                    System.out.println("code : "+response.code());
                    return;
                }
                accounts.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Account>> call, Throwable t) {

            }
        });
        return accounts;
    }
    public MutableLiveData<Account> getAccountByAccountNumber(String accountNumber){
        MutableLiveData<Account> account = new MutableLiveData<>();
        APIService apiService = RetrofitInstance.getRetrofitInstance().create(APIService.class);
        Call<Account> call = apiService.getAccountByAccountNumber(accountNumber);
        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if (!response.isSuccessful()){
                    System.out.println("code : "+response.code());
                    return;
                }
                account.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {

            }
        });
        return account;
    }
}
