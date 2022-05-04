package com.example.attijarilite.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.attijarilite.R;
import com.example.attijarilite.databinding.ActivityRefillBinding;

public class RefillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityRefillBinding refillBinding;
        super.onCreate(savedInstanceState);
        refillBinding = DataBindingUtil.setContentView(this, R.layout.activity_refill);

    }
}