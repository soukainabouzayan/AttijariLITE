package com.example.attijarilite.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.attijarilite.R;
import com.example.attijarilite.adapter.HistoryAdapter;
import com.example.attijarilite.databinding.ActivityCardDetailsBinding;
import com.example.attijarilite.model.Transaction;
import com.example.attijarilite.viewmodel.TransactionByCardViewModel;

import java.util.ArrayList;
import java.util.List;

public class CardDetails extends AppCompatActivity {
    ActivityCardDetailsBinding cardDetailsBinding;
    TransactionByCardViewModel transactionByCardViewModel;
    HistoryAdapter adapter;
    String cardNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cardDetailsBinding = DataBindingUtil.setContentView(this,R.layout.activity_card_details);
        Intent intent = getIntent();
        cardNumber = intent.getStringExtra("cardNumber");
        cardDetailsBinding.cardType.setText(intent.getStringExtra("cardType"));
        cardDetailsBinding.cardNumber.setText(intent.getStringExtra("cardNumber"));
        cardDetailsBinding.cardBalance.setText(String.valueOf(intent.getFloatExtra("cardBalance",0)).concat(" DH"));
        //bind recyclerview
        RecyclerView recyclerView = cardDetailsBinding.transactions;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ////init the viewmodel
        transactionByCardViewModel = new ViewModelProvider(this).get(TransactionByCardViewModel.class);
        /// init the account adapter
        adapter = new HistoryAdapter();

        /// set the accountsAdapter to our recyclerview
        recyclerView.setAdapter(adapter);
        getAllDev(cardNumber);
        cardDetailsBinding.iconback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    public void getAllDev(String cardNumber){
        transactionByCardViewModel.getTransactionsByCard(cardNumber).observe(this, new Observer<List<Transaction>>() {
            @Override
            public void onChanged(List<Transaction> transactions) {
                adapter.setTransactionList((ArrayList<Transaction>) transactions);
            }
        });
    }

}