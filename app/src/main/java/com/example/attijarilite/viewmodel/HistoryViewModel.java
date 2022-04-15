package com.example.attijarilite.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.attijarilite.model.Transaction;
import com.example.attijarilite.repository.TransactionRepository;

import java.util.List;

public class HistoryViewModel extends ViewModel {
    private TransactionRepository transactionRepository;
    public HistoryViewModel() {
        transactionRepository = new TransactionRepository();
    }
    public LiveData<List<Transaction>> getAllTransactions(){
        return transactionRepository.getAllTransactions();
    }
}
