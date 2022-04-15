package com.example.attijarilite.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.attijarilite.model.Card;
import com.example.attijarilite.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CardRepository {

    public MutableLiveData<List<Card>> getAllCards(){
        MutableLiveData<List<Card>> mutableLiveData = new MutableLiveData<>();
        List<Card> list = new ArrayList<>();
        Card card = new Card("0000 0000 0000 0000 0000",(double) 1233,"20/8");
        list.add(card);
        list.add(card);
        list.add(card);
        list.add(card);
        list.add(card);
        list.add(card);
        mutableLiveData.setValue(list);
        return mutableLiveData;
    }
}
