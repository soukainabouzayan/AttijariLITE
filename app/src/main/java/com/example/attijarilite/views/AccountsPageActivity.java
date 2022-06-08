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
import com.example.attijarilite.adapter.AllAccountsAdapter;
import com.example.attijarilite.databinding.ActivityAccountsPageBinding;
import com.example.attijarilite.model.Account;
import com.example.attijarilite.viewmodel.AllAccountsViewModel;

import java.util.ArrayList;
import java.util.List;

public class AccountsPageActivity extends AppCompatActivity implements AllAccountsAdapter.OnAccountListener {
    ActivityAccountsPageBinding accountsBinding;
    AllAccountsViewModel accountsViewModel;
    AllAccountsAdapter accountsAdapter;
    String idetifier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accountsBinding = DataBindingUtil.setContentView(this,R.layout.activity_accounts_page);
        Intent intent = getIntent();
        idetifier = intent.getStringExtra("identifier");
        accountsBinding.iconback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
            }
        });

        //bind recyclerview
        RecyclerView recyclerView = accountsBinding.accounts;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ////init the viewmodel
        accountsViewModel = new ViewModelProvider(this).get(AllAccountsViewModel.class);
        /// init the account adapter
        accountsAdapter = new AllAccountsAdapter(this);

        /// set the accountsAdapter to our recyclerview
        recyclerView.setAdapter(accountsAdapter);
        getAllDev();

    }
    public void getAllDev(){
        accountsViewModel.getAllAccounts().observe(this, new Observer<List<Account>>() {
            @Override
            public void onChanged(@Nullable List<Account> accounts) {
                accountsAdapter.setAccountList((ArrayList<Account>) accounts);
            }
        });
    }

    @Override
    public void onAccountClick(int position) {
        Intent intent = new Intent(getApplicationContext(),AccountDetailsActivity.class);
        List<Account> accounts = (List<Account>) accountsViewModel.getAllAccounts().getValue();
        intent.putExtra("accountNumber",accounts.get(position).getAccountNumber());
        intent.putExtra("accountType",accounts.get(position).getAccountType());
        intent.putExtra("accountBalance",accounts.get(position).getAccountBalance());
        startActivity(intent);
    }
}