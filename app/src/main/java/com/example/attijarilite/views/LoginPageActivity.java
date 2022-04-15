package com.example.attijarilite.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.attijarilite.R;
import com.example.attijarilite.databinding.ActivityLoginPageBinding;
import com.example.attijarilite.viewmodel.LoginViewModel;

public class LoginPageActivity extends AppCompatActivity {
    ActivityLoginPageBinding activityLoginPageBinding;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginPageBinding = DataBindingUtil.setContentView(this,R.layout.activity_login_page);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        activityLoginPageBinding.setLoginviewmodel(loginViewModel);
        activityLoginPageBinding.setLifecycleOwner(this);
        activityLoginPageBinding.connexionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HomePageActivity.class);
                startActivity(intent);
            }
        });

    }
}