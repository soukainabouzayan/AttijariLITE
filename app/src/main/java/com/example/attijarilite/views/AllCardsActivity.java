package com.example.attijarilite.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;

import com.example.attijarilite.R;
import com.example.attijarilite.adapter.AllCardsAdapter;
import com.example.attijarilite.adapter.DetailsAccountAdapter;
import com.example.attijarilite.adapter.HistoryAdapter;
import com.example.attijarilite.databinding.ActivityAllCardsBinding;
import com.example.attijarilite.model.Card;
import com.example.attijarilite.model.Transaction;
import com.example.attijarilite.viewmodel.AllCardsViewModel;
import com.example.attijarilite.viewmodel.TransactionByCardViewModel;

import java.util.ArrayList;
import java.util.List;

public class AllCardsActivity extends AppCompatActivity {
    ActivityAllCardsBinding cardsBinding;
    AllCardsAdapter cardsAdapter;
    AllCardsViewModel cardsViewModel;
    DetailsAccountAdapter transactionsByCardAdapter;
    TransactionByCardViewModel transactionsByCardViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cardsBinding = DataBindingUtil.setContentView(this,R.layout.activity_all_cards);
        cardsBinding.iconback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
        RecyclerView transactionsByCard = cardsBinding.transactionsbycard;
        transactionsByCard.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false));
        transactionsByCard.setHasFixedSize(true);
        transactionsByCardViewModel = new ViewModelProvider(this).get(TransactionByCardViewModel.class);
        transactionsByCardAdapter = new DetailsAccountAdapter();
        transactionsByCard.setAdapter(transactionsByCardAdapter);
        getAllTransactions();
        getTransactionsByCard();

    }
    public void getAllTransactions(){
        cardsViewModel.getAllCards().observe(this, new Observer<List<Card>>() {
            @Override
            public void onChanged(@Nullable List<Card> cardList) {
                cardsAdapter.setCardList((ArrayList<Card>) cardList );
            }
        });
    }
    public void getTransactionsByCard(){
        transactionsByCardViewModel.getAllTransactions().observe(this, new Observer<List<Transaction>>() {
            @Override
            public void onChanged(List<Transaction> transactions) {
                transactionsByCardAdapter.setTransactionList((ArrayList<Transaction>) transactions);
            }
        });
    }

}