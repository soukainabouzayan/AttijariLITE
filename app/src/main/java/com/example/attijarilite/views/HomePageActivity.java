package com.example.attijarilite.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attijarilite.R;
import com.example.attijarilite.adapter.HistoryAdapter;
import com.example.attijarilite.databinding.ActivityHomePageBinding;
import com.example.attijarilite.model.Transaction;
import com.example.attijarilite.viewmodel.BalanceViewModel;
import com.example.attijarilite.viewmodel.HistoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {
    ActivityHomePageBinding activityHomePageBinding;
    BalanceViewModel balanceViewModel;
    private  HistoryViewModel historyViewModel;
    private HistoryAdapter historyAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomePageBinding = DataBindingUtil.setContentView(this,R.layout.activity_home_page);
        balanceViewModel = new ViewModelProvider(this).get(BalanceViewModel.class);
        activityHomePageBinding.setBalanceViewModel(balanceViewModel);
        activityHomePageBinding.setLifecycleOwner(this);
        RecyclerView recyclerView = activityHomePageBinding.transactions;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
        historyAdapter = new HistoryAdapter();
        recyclerView.setAdapter(historyAdapter);
        getAllDev();
        activityHomePageBinding.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityHomePageBinding.drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        activityHomePageBinding.myaccountslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AccountsPageActivity.class);
                startActivity(intent);
            }
        });
        activityHomePageBinding.mycardslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AllCardsActivity.class);
                startActivity(intent);
            }
        });
        activityHomePageBinding.transferlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),TransferActivity.class);
                startActivity(intent);
            }
        });
    }
    public void getAllDev(){
        historyViewModel.getAllTransactions().observe(this, new Observer<List<Transaction>>() {
            @Override
            public void onChanged(List<Transaction> transactions) {
                historyAdapter.setTransactionList((ArrayList<Transaction>) transactions);
            }
        });
    }
}