package com.example.attijarilite.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.attijarilite.R;
import com.example.attijarilite.databinding.ActivityPaymentOrRefillBinding;

public class PaymentOrRefillActivity extends AppCompatActivity {
    ActivityPaymentOrRefillBinding paymentOrRefillBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        paymentOrRefillBinding = DataBindingUtil.setContentView(this,R.layout.activity_payment_or_refill);
        paymentOrRefillBinding.bills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),PaymentActivity.class));
            }
        });
        paymentOrRefillBinding.iconback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}