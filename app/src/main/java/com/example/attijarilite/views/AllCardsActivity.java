package com.example.attijarilite.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.attijarilite.R;
import com.example.attijarilite.adapter.AllCardsAdapter;
import com.example.attijarilite.adapter.DetailsAccountAdapter;
import com.example.attijarilite.databinding.ActivityAllCardsBinding;
import com.example.attijarilite.databinding.ItemCardBinding;
import com.example.attijarilite.model.Account;
import com.example.attijarilite.model.Card;
import com.example.attijarilite.model.Transaction;
import com.example.attijarilite.viewmodel.AllCardsViewModel;
import com.example.attijarilite.viewmodel.TransactionByCardViewModel;

import java.util.ArrayList;
import java.util.List;

public class AllCardsActivity extends AppCompatActivity implements AllCardsAdapter.OnCardListener {
    ActivityAllCardsBinding cardsBinding;
    //ItemCardBinding itemCardBinding;
    AllCardsAdapter cardsAdapter;
    AllCardsViewModel cardsViewModel;
    DetailsAccountAdapter transactionsByCardAdapter;
    TransactionByCardViewModel transactionsByCardViewModel;
    //String cardNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cardsBinding = DataBindingUtil.setContentView(this,R.layout.activity_all_cards);
        cardsBinding.iconback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
            }
        });
        ///cards recyclerview
        RecyclerView recyclerView = cardsBinding.cards;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        /*recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false));*/
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        cardsViewModel = new ViewModelProvider(this).get(AllCardsViewModel.class);
        cardsAdapter = new AllCardsAdapter(this);
        recyclerView.setAdapter(cardsAdapter);
        cardsViewModel.getAllCards().observe(this, new Observer<List<Card>>() {
            @Override
            public void onChanged(@Nullable List<Card> cardList) {
                cardsAdapter.setCardList((ArrayList<Card>) cardList );
            }
        });
    }

    @Override
    public void onCardClick(int position) {
        Intent intent = new Intent(getApplicationContext(),CardDetails.class);
        List<Card> cards = (List<Card>) cardsViewModel.getAllCards().getValue();
        intent.putExtra("cardBalance",cards.get(position).getBalance());
        intent.putExtra("cardNumber",cards.get(position).getNumber());
        intent.putExtra("cardType",cards.get(position).getType());
        startActivity(intent);
    }
}