package com.example.attijarilite.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.attijarilite.model.Transaction;
import com.example.attijarilite.repository.TransactionRepository;

import java.util.List;

public class TransactionByCardViewModel extends ViewModel {
    private TransactionRepository transactionRepository;
    public TransactionByCardViewModel() {
        transactionRepository = new TransactionRepository();
    }
    public LiveData<List<Transaction>> getTransactionsByCard(String cardNumber){
        return transactionRepository.getTransactionsByCard(cardNumber);
    }
    public LiveData<List<Transaction>> getTransactionsByCard(){
        return transactionRepository.getTransactionsByCard();
    }
}
