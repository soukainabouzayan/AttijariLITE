package com.example.attijarilite.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.attijarilite.R;
import com.example.attijarilite.databinding.ActivityTransferBinding;
import java.util.Calendar;

public class TransferActivity extends AppCompatActivity {
    ActivityTransferBinding transferBinding;
    EditText executionDate;
    DatePickerDialog  datePickerDialog;
    Spinner accountSenderSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        transferBinding = DataBindingUtil.setContentView(this,R.layout.activity_transfer);
        transferBinding.iconback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HomePageActivity.class);
                startActivity(intent);
            }
        });
        executionDate = transferBinding.executionDate;
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        executionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog = new DatePickerDialog(
                        TransferActivity.this,R.style.my_calendar_theme,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        executionDate.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        accountSenderSpinner = transferBinding.accountSenderSpinner;
    }
}