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
import com.example.attijarilite.adapter.DetailsAccountAdapter;
import com.example.attijarilite.databinding.ActivityAccountDetailsBinding;
import com.example.attijarilite.model.Transaction;
import com.example.attijarilite.viewmodel.DetailsAccountViewModel;

import java.util.ArrayList;
import java.util.List;

public class AccountDetailsActivity extends AppCompatActivity {

    ActivityAccountDetailsBinding binding;
    DetailsAccountAdapter detailsAccountAdapter;
    DetailsAccountViewModel detailsAccountViewModel;
    ActivityAccountDetailsBinding accountDetailsBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_account_details);
        TextView accountNumber = binding.accountNumber;
        TextView accountType = binding.accountType;
        TextView accountBalance = binding.accountBalance;
        RecyclerView recyclerView = binding.transactionsByaccount;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        detailsAccountViewModel = new ViewModelProvider(this).get(DetailsAccountViewModel.class);
        detailsAccountAdapter = new DetailsAccountAdapter();
        recyclerView.setAdapter(detailsAccountAdapter);
        Intent intent = getIntent();
        accountNumber.setText(intent.getStringExtra("accountNumber"));
        accountType.setText(intent.getStringExtra("accountType"));
        accountBalance.setText(String.valueOf(intent.getFloatExtra("accountBalance",0)).concat(" DH"));
        binding.iconback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AccountsPageActivity.class);
                startActivity(intent);
            }
        });
        detailsAccountViewModel.getTransactionsByAccount(intent.getStringExtra("accountNumber")).observe(this, new Observer<List<Transaction>>() {
                @Override
                public void onChanged(List<Transaction> transactions) {
                    detailsAccountAdapter.setTransactionList((ArrayList<Transaction>) transactions);
                }
            });
    }

}