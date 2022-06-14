package com.example.attijarilite.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.attijarilite.R;
import com.example.attijarilite.adapter.BillAdapter;
import com.example.attijarilite.databinding.ActivityBillBinding;
import com.example.attijarilite.model.Bill;
import com.example.attijarilite.viewmodel.BillViewModel;

import java.util.ArrayList;
import java.util.List;

public class BillActivity extends AppCompatActivity implements BillAdapter.OnBillListener {
    ActivityBillBinding billBinding;
    BillViewModel billViewModel;
    BillAdapter billAdapter;
    List<Bill> bills;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        billBinding = DataBindingUtil.setContentView(this, R.layout.activity_bill);
        RecyclerView recyclerView = billBinding.mybills;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        billViewModel = new ViewModelProvider(this).get(BillViewModel.class);
        billAdapter = new BillAdapter(bills, this);
        recyclerView.setAdapter(billAdapter);
        getAllDev();
    }

    private void getAllDev() {
        billViewModel.getAllBills().observe(this, new Observer<List<Bill>>() {
            @Override
            public void onChanged(@Nullable List<Bill> bills) {
                billAdapter.setBillList((ArrayList<Bill>) bills);
            }
        });
    }


    @Override
    public void onBillClicked(int position) {

    }
}