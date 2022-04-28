package com.example.attijarilite.repository;


import androidx.lifecycle.MutableLiveData;

import com.example.attijarilite.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    public MutableLiveData<List<Transaction>> getAllTransactions(){
        MutableLiveData<List<Transaction>> mutableLiveData = new MutableLiveData<>();
        List<Transaction> transactionList = new ArrayList<>();
        Transaction transaction1 = new Transaction("Date date1","transaction object1","bénificiaire",(double) 111111);
        Transaction transaction2 = new Transaction("Date date2","transaction object2","bénificiaire",(double) 2222);
        Transaction transaction3 = new Transaction("Date date3","transaction object3","bénificiaire",(double) 3333);
        Transaction transaction4 = new Transaction("Date date4","transaction object4","bénificiaire",(double) 444444);
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        transactionList.add(transaction4);
        transactionList.add(transaction4);
        transactionList.add(transaction4);
        transactionList.add(transaction4);
        transactionList.add(transaction4);
        mutableLiveData.setValue(transactionList);
        return mutableLiveData;
    }

    public MutableLiveData<List<Transaction>> getTransactionsByCard(String cardNumber){
        MutableLiveData<List<Transaction>> mutableLiveData = new MutableLiveData<>();
        List<Transaction> transactionList = new ArrayList<>();
        Transaction transaction1 = new Transaction("Date date1","transaction object1","bénificiaire",(double) 111111);
        Transaction transaction2 = new Transaction("Date date2","transaction object2","bénificiaire",(double) 2222);
        Transaction transaction3 = new Transaction("Date date3","transaction object3","bénificiaire",(double) 3333);
        Transaction transaction4 = new Transaction("Date date4","transaction object4","bénificiaire",(double) 444444);
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        transactionList.add(transaction4);
        mutableLiveData.setValue(transactionList);
        return mutableLiveData;
    }

    public MutableLiveData<List<Transaction>> getTransactionByAccount(){
        MutableLiveData<List<Transaction>> mutableLiveData = new MutableLiveData<>();
        List<Transaction> transactionList = new ArrayList<>();
        Transaction transaction1 = new Transaction("Date date1","transaction object1","bénificiaire",(double) 111111);
        Transaction transaction2 = new Transaction("Date date2","transaction object2","bénificiaire",(double) 2222);
        Transaction transaction3 = new Transaction("Date date3","transaction object3","bénificiaire",(double) 3333);
        Transaction transaction4 = new Transaction("Date date4","transaction object4","bénificiaire",(double) 444444);
        Transaction transaction5 = new Transaction("Date date4","transaction object4","bénificiaire",(double) 444444);
        Transaction transaction6 = new Transaction("Date date4","transaction object4","bénificiaire",(double) 444444);
        Transaction transaction7 = new Transaction("Date date4","transaction object4","bénificiaire",(double) 444444);
        Transaction transaction8 = new Transaction("Date date4","transaction object4","bénificiaire",(double) 444444);
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        transactionList.add(transaction4);
        transactionList.add(transaction5);
        transactionList.add(transaction6);
        transactionList.add(transaction7);
        transactionList.add(transaction8);
        mutableLiveData.setValue(transactionList);
        return mutableLiveData;

    }
}
