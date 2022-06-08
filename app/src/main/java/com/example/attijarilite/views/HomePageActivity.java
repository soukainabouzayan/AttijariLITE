package com.example.attijarilite.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attijarilite.R;
import com.example.attijarilite.adapter.HistoryAdapter;
import com.example.attijarilite.databinding.ActivityHomePageBinding;
import com.example.attijarilite.model.Transaction;
import com.example.attijarilite.viewmodel.BalanceViewModel;
import com.example.attijarilite.viewmodel.AllTransactionsViewModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {
    ActivityHomePageBinding activityHomePageBinding;
    BalanceViewModel balanceViewModel;
    private AllTransactionsViewModel historyViewModel;
    private HistoryAdapter historyAdapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
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
        historyAdapter = new HistoryAdapter();
        historyViewModel = new ViewModelProvider(this).get(AllTransactionsViewModel.class);
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
                Intent intent = getIntent();
                Intent intent2 = new Intent(getApplicationContext(),AccountsPageActivity.class);
                intent2.putExtra("identifier",intent.getStringExtra("identifier"));
                startActivity(intent2);
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
        activityHomePageBinding.paymentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),PaymentOrRefillActivity.class));
            }
        });
        drawerLayout = activityHomePageBinding.drawerLayout;
        navigationView = activityHomePageBinding.navView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.cards:
                        startActivity(new Intent(getApplicationContext(),AllCardsActivity.class));
                        return true;
                    case R.id.home:
                        activityHomePageBinding.drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.accounts:
                        startActivity(new Intent(getApplicationContext(),AccountsPageActivity.class));
                        return true;
                    case R.id.transfer:
                        startActivity(new Intent(getApplicationContext(),TransferActivity.class));
                        return true;
                    case R.id.phone_refill:{
                        startActivity(new Intent(getApplicationContext(),RefillActivity.class));}
                    case R.id.payment:{
                        startActivity(new Intent(getApplicationContext(),PaymentActivity.class));}
                }

                return true;
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