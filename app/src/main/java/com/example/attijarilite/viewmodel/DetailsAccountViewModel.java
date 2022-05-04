package com.example.attijarilite.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.attijarilite.model.Transaction;
import com.example.attijarilite.repository.TransactionRepository;

import java.util.List;

public class DetailsAccountViewModel extends ViewModel {
    private TransactionRepository repository;

    public DetailsAccountViewModel() {
        repository = new TransactionRepository();
    }

    public LiveData<List<Transaction>> getTransactionsByAccount(String accountNumber){
        return repository.getTransactionByAccount(accountNumber);
    }
}
