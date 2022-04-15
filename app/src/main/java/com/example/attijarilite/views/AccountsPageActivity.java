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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accountsBinding = DataBindingUtil.setContentView(this,R.layout.activity_accounts_page);
        accountsBinding.iconback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HomePageActivity.class);
                startActivity(intent);
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
        ///get the list of dev from api response
        accountsViewModel.getAllAccounts().observe(this, new Observer<List<Account>>() {
            @Override
            public void onChanged(@Nullable List<Account> accounts) {
                ///if any thing change the update the UI
                accountsAdapter.setAccountList((ArrayList<Account>) accounts);
            }
        });
    }

    @Override
    public void onAccountClick(int position) {
        Intent intent = new Intent(getApplicationContext(),AccountDetailsActivity.class);
        startActivity(intent);
    }
}