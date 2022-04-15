package com.example.attijarilite.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.attijarilite.R;
import com.example.attijarilite.adapter.AllCardsAdapter;
import com.example.attijarilite.adapter.HistoryAdapter;
import com.example.attijarilite.databinding.ActivityAllCardsBinding;
import com.example.attijarilite.model.Card;
import com.example.attijarilite.viewmodel.AllCardsViewModel;
import com.example.attijarilite.viewmodel.TransactionByCardViewModel;

import java.util.ArrayList;
import java.util.List;

public class AllCardsActivity extends AppCompatActivity {
    ActivityAllCardsBinding cardsBinding;
    AllCardsAdapter cardsAdapter;
    AllCardsViewModel cardsViewModel;
    HistoryAdapter historyAdapter;
    TransactionByCardViewModel transactionByCardViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cardsBinding = DataBindingUtil.setContentView(this,R.layout.activity_all_cards);
        cardsBinding.iconback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HomePageActivity.class);
                startActivity(intent);
            }
        });
        ///cards recyclerview
        RecyclerView recyclerView = cardsBinding.cards;
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);
        cardsViewModel = new ViewModelProvider(this).get(AllCardsViewModel.class);
        cardsAdapter = new AllCardsAdapter();
        recyclerView.setAdapter(cardsAdapter);
        getAllDev();
    }
    public void getAllDev(){
        cardsViewModel.getAllCards().observe(this, new Observer<List<Card>>() {
            @Override
            public void onChanged(@Nullable List<Card> cardList) {
                cardsAdapter.setCardList((ArrayList<Card>) cardList );
            }
        });
    }

}