package com.example.attijarilite.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.attijarilite.R;
import com.example.attijarilite.databinding.ActivityRefillBinding;

public class RefillActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        ActivityRefillBinding refillBinding;
        super.onCreate(savedInstanceState);
        refillBinding = DataBindingUtil.setContentView(this, R.layout.activity_refill);
        refillBinding.iconback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Spinner inwiSpinner = refillBinding.inwispinner;
        Spinner orangeSpinner = refillBinding.orangespinner;
        ArrayAdapter<CharSequence> inwiAdapter = ArrayAdapter.createFromResource(this,
                R.array.inwi, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> orangeAdapter = ArrayAdapter.createFromResource(this,R.array.orange, android.R.layout.simple_spinner_item);
        inwiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        orangeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        inwiSpinner.setAdapter(inwiAdapter);
        orangeSpinner.setAdapter(orangeAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getApplicationContext(),HomePageActivity.class);
        startActivity(intent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}