package com.example.attijarilite.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.attijarilite.R;
import com.example.attijarilite.databinding.ActivityTransferBinding;
import com.example.attijarilite.model.Account;
import com.example.attijarilite.viewmodel.AllAccountsViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TransferActivity extends AppCompatActivity {
    ActivityTransferBinding transferBinding;
    EditText executionDate;
    DatePickerDialog  datePickerDialog;
    String[] arr = new String[] { "A", "B", "C", "D", "E" };
    ArrayList<Account> accounts = new ArrayList<>();

    AllAccountsViewModel accountsViewModel;
    AlertDialog.Builder accountsBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        transferBinding = DataBindingUtil.setContentView(this,R.layout.activity_transfer);
        accountsViewModel = new ViewModelProvider(this).get(AllAccountsViewModel.class);
        transferBinding.iconback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
        transferBinding.accountSenderChoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountsBuilder = new AlertDialog.Builder(TransferActivity.this);
                accountsBuilder.setTitle("Compte émetteur")
                        .setNegativeButton("Annuler", null).
                        setIcon(R.drawable.bank_account_60)
                        .setItems(arr, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        transferBinding.textView.setText(arr[i]);
                    }
                });
                AlertDialog alert = accountsBuilder.create();
                alert.show();
            }
        });
    }


}