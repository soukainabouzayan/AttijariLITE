package com.example.attijarilite.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.attijarilite.model.Account;
import com.example.attijarilite.model.Card;
import com.example.attijarilite.network.APIService;
import com.example.attijarilite.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardRepository {

    public MutableLiveData<List<Card>> getAllCards(){
        MutableLiveData<List<Card>> mutableLiveData = new MutableLiveData<>();
        List<Card> list = new ArrayList<>();
        Card card = new Card("1111 1111 1111 1111 1111",(float) 1233,"20/8","VISA");
        Card card2 = new Card("0000 0000 0000 0000 0000",(float) 1500,"05/05","VISA");
        list.add(card);
        list.add(card);
        list.add(card);
        list.add(card2);
        list.add(card2);
        mutableLiveData.setValue(list);
        return mutableLiveData;
    }
    public MutableLiveData<List<Card>> getAllCardsRetro(){
        MutableLiveData<List<Card>> cards = new MutableLiveData<>();
        APIService apiService = RetrofitInstance.getRetrofitInstance().create(APIService.class);
        Call<List<Card>> call = apiService.getAllCards();
        call.enqueue(new Callback<List<Card>>() {
            @Override
            public void onResponse(Call<List<Card>> call, Response<List<Card>> response) {
                if (!response.isSuccessful()){
                    System.out.println("code : "+response.code());
                    return;
                }
                cards.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Card>> call, Throwable t) {

            }
        });
        return cards;
    }
}
