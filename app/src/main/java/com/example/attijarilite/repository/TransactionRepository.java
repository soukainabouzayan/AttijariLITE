package com.example.attijarilite.repository;


import androidx.lifecycle.MutableLiveData;

import com.example.attijarilite.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    public MutableLiveData<List<Transaction>> getAllTransactions(){
        MutableLiveData<List<Transaction>> mutableLiveData = new MutableLiveData<>();
        List<Transaction> transactionList = new ArrayList<>();
        Transaction transaction1 = new Transaction("Date date1","transaction object1","bénificiaire",(float) 111.00);
        Transaction transaction2 = new Transaction("Date date2","transaction object2","bénificiaire",(float) 222.34);
        Transaction transaction3 = new Transaction("Date date3","transaction object3","bénificiaire",(float) 33.50);
        Transaction transaction4 = new Transaction("Date date4","transaction object4","bénificiaire",(float) 9.50);
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
        MutableLiveData<List<Transaction>> mutableLiveData2 = new MutableLiveData<>();
        List<Transaction> transactionList = new ArrayList<>();
        List<Transaction> transactionList2 = new ArrayList<>();
        Transaction transaction1 = new Transaction("Date date1","transaction object1","bénificiaire",(float) 111);
        Transaction transaction2 = new Transaction("Date date2","transaction object2","bénificiaire",(float) 222.00);
        Transaction transaction3 = new Transaction("Date date3","transaction object3","bénificiaire",(float) 33.56);
        Transaction transaction4 = new Transaction("Date date4","transaction object4","bénificiaire",(float) 444);
        Transaction transaction5 = new Transaction("Date date4","transaction object4","bénificiaire",(float) 12.09);
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        transactionList.add(transaction4);
        transactionList2.add(transaction5);
        transactionList2.add(transaction5);
        mutableLiveData.setValue(transactionList);
        mutableLiveData2.setValue(transactionList2);
        if(cardNumber.equals("1111 1111 1111 1111 1111")){
            return mutableLiveData2;
        }
        else
            return mutableLiveData;
    }
    public MutableLiveData<List<Transaction>> getTransactionsByCard(){
        MutableLiveData<List<Transaction>> mutableLiveData = new MutableLiveData<>();
        List<Transaction> transactionList = new ArrayList<>();
        Transaction transaction1 = new Transaction("Date date1","transaction object1","bénificiaire",(float) 111.50);
        Transaction transaction2 = new Transaction("Date date2","transaction object2","bénificiaire",(float) 222.00);
        Transaction transaction3 = new Transaction("Date date3","transaction object3","bénificiaire",(float) 33.54);
        Transaction transaction4 = new Transaction("Date date4","transaction object4","bénificiaire",(float) 444.34);
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        transactionList.add(transaction4);
        transactionList.add(transaction4);
        transactionList.add(transaction4);
        transactionList.add(transaction4);
        transactionList.add(transaction4);
        transactionList.add(transaction4);
        mutableLiveData.setValue(transactionList);
        return mutableLiveData;
    }


    public MutableLiveData<List<Transaction>> getTransactionByAccount(String accountNumber){
        MutableLiveData<List<Transaction>> mutableLiveData = new MutableLiveData<>();
        List<Transaction> transactionList = new ArrayList<>();
        Transaction transaction1 = new Transaction("Date date1","transaction object1","bénificiaire",(float) 111.0);
        Transaction transaction2 = new Transaction("Date date2","transaction object2","bénificiaire",(float) 222);
        Transaction transaction3 = new Transaction("Date date3","transaction object3","bénificiaire",(float) 333);
        Transaction transaction4 = new Transaction("Date date4","transaction object4","bénificiaire",(float) 444.0);
        Transaction transaction5 = new Transaction("Date date4","transaction object4","bénificiaire",(float) 200.00);
        Transaction transaction6 = new Transaction("Date date4","transaction object4","bénificiaire",(float) 1200.00);
        Transaction transaction7 = new Transaction("Date date4","transaction object4","bénificiaire",(float) 44.90);
        Transaction transaction8 = new Transaction("Date date4","transaction object4","bénificiaire",(float) 150.00);
        transactionList.add(transaction1);
        transactionList.add(transaction2);
        transactionList.add(transaction3);
        transactionList.add(transaction4);
        transactionList.add(transaction5);
        transactionList.add(transaction6);
        transactionList.add(transaction7);
        transactionList.add(transaction8);
        mutableLiveData.setValue(transactionList);
        MutableLiveData<List<Transaction>> mutableLiveData2 = new MutableLiveData<>();
        List<Transaction> transactionList2 = new ArrayList<>();
        Transaction transaction9 = new Transaction("Date date1","transaction object1","bénificiaire", 111111F);
        transactionList2.add(transaction9);
        transactionList2.add(transaction9);
        transactionList2.add(transaction9);
        mutableLiveData2.setValue(transactionList2);
        if (accountNumber.equals("account number1111111111")){
            return mutableLiveData2;
        }
        else
            return mutableLiveData;
    }
}
