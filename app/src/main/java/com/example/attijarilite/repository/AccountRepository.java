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
        Account account1 = new Account("0000C000000003",(float) 2811.42,"Compte sur carnet");
        Account account2 = new Account("0000A000000001",(float) 3510.70,"Compte chèque");
        Account account3 = new Account("0000B000000002",(float) 32320.25,"Compte courant");
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
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
        MutableLiveData<Account> accounts = new MutableLiveData<>();
        List<Account> accountList = new ArrayList<>();
        APIService apiService = RetrofitInstance.getRetrofitInstance().create(APIService.class);
        Call<Account> call = apiService.getAccountByAccountNumber(accountNumber);
        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if (!response.isSuccessful()){
                    System.out.println("code : "+response.code());
                    return;
                }
                accounts.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {

            }
        });
        return accounts;
    }
    public MutableLiveData<Double> getUserBalance(String ownerIdentifier){
        MutableLiveData<Double> balance = new MutableLiveData<>();
        APIService apiService = RetrofitInstance.getRetrofitInstance().create(APIService.class);
        Call<Double> call = apiService.getUserBalance(ownerIdentifier);
        call.enqueue(new Callback<Double>() {
            @Override
            public void onResponse(Call<Double> call, Response<Double> response) {
                if (!response.isSuccessful()){
                    System.out.println("code : "+response.code());
                    return;
                }
                balance.setValue(response.body());

            }

            @Override
            public void onFailure(Call<Double> call, Throwable t) {

            }
        });
        return balance;
    }
    public MutableLiveData<Double> getUserBalance(){
        MutableLiveData<Double> balance = new MutableLiveData<>();
       balance.setValue(35410.74);
        return balance;
    }
}
