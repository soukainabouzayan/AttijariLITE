package com.example.attijarilite.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.attijarilite.repository.CardRepository;

public class AllCardsViewModel extends ViewModel {
    private CardRepository cardRepository;

    public AllCardsViewModel() {
        cardRepository = new CardRepository();
    }
    public LiveData getAllCards(){
        return cardRepository.getAllCards();
    }
}
