package com.example.attijarilite.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.attijarilite.R;
import com.example.attijarilite.adapter.TransferAllAccountsAdapter;
import com.example.attijarilite.adapter.TransferAllBeneficiariesAdapter;
import com.example.attijarilite.databinding.ActivityTransferBinding;
import com.example.attijarilite.model.Account;
import com.example.attijarilite.model.Beneficiary;
import com.example.attijarilite.viewmodel.AllAccountsViewModel;
import com.example.attijarilite.viewmodel.AllBeneficiariesViewModel;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TransferActivity extends AppCompatActivity {
    ActivityTransferBinding transferBinding;
    EditText executionDate;
    DatePickerDialog  datePickerDialog;
    ImageView iconback;
    ImageView accountSenderChoices;
    ImageView beneficiaryChoices;
    AllAccountsViewModel accountsViewModel;
    AllBeneficiariesViewModel beneficiariesViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        transferBinding = DataBindingUtil.setContentView(this, R.layout.activity_transfer);
        accountsViewModel = new ViewModelProvider(this).get(AllAccountsViewModel.class);
        beneficiariesViewModel = new ViewModelProvider(this).get(AllBeneficiariesViewModel.class);
        iconback = transferBinding.iconback;
        executionDate = transferBinding.executionDate;
        accountSenderChoices = transferBinding.accountSenderChoices;
        beneficiaryChoices = transferBinding.beneficiaryChoices;
        iconback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
            }
        });
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
                Locale.setDefault(Locale.FRANCE);
                datePickerDialog.show();
            }
        });
        accountSenderChoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountsBottomSheetFragment bottomSheetFragment = new AccountsBottomSheetFragment(
                        new TransferAllAccountsAdapter.OnAccountListener() {
                    @Override
                    public void onAccountClick(int position) {
                        List<Account> accounts = (List<Account>) accountsViewModel.getAllAccounts().getValue();
                        transferBinding.senderAccount.setText(accounts.get(position).getAccountNumber());
                    }
                });
                bottomSheetFragment.show(getSupportFragmentManager(),bottomSheetFragment.getTag());
            }

        });
        beneficiaryChoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BeneficiariesBottomSheetFragment bottomSheetFragment = new BeneficiariesBottomSheetFragment(
                        new TransferAllBeneficiariesAdapter.OnBeneficiaryListener() {
                            @Override
                            public void onBeneficiaryClick(int position) {
                                List<Beneficiary> beneficiaries = (List<Beneficiary>) beneficiariesViewModel.getAllBeneficiaries().getValue();
                                String fullName = beneficiaries.get(position).getFirstName() + " "+beneficiaries.get(position).getLastName();
                                transferBinding.beneficiary.setText(fullName);
                            }
                        }
                );
                bottomSheetFragment.show(getSupportFragmentManager(),bottomSheetFragment.getTag());
            }
        });




    }

}