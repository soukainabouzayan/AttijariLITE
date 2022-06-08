package com.example.attijarilite.views;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attijarilite.R;
import com.example.attijarilite.databinding.ActivityLoginPageBinding;
import com.example.attijarilite.model.User;
import com.example.attijarilite.network.APIService;
import com.example.attijarilite.network.AccessToken;
import com.example.attijarilite.network.RetrofitInstance;
import com.example.attijarilite.viewmodel.LoginViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginPageActivity extends AppCompatActivity {
    ActivityLoginPageBinding activityLoginPageBinding;
    LoginViewModel loginViewModel;
    EditText etIdentifier;
    EditText etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginPageBinding = DataBindingUtil.setContentView(this,R.layout.activity_login_page);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        activityLoginPageBinding.setLifecycleOwner(this);
        etIdentifier = activityLoginPageBinding.identifier;
        etPassword = activityLoginPageBinding.password;
        activityLoginPageBinding.setLoginviewmodel(loginViewModel);
        loginViewModel.getUserMutableLiveData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {

            }
        });
        activityLoginPageBinding.connexionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
            }
        });
    }
    public void getAccessToken(){
        APIService service = RetrofitInstance.getRetrofitInstance().create(APIService.class);
        String identifier = etIdentifier.getText().toString();
        String password = etPassword.getText().toString();
        Call<AccessToken> call = service.getAccessToken("attijarilite-frontend","password",
                "IMXJqLOPCSQ0SIyki5OaMyFkEHfAYEUI","openid",identifier,password);
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if(response.isSuccessful()){
                    AccessToken accessToken = response.body();
                    startActivity(new Intent(getApplicationContext(),HomePageActivity.class));
                }
                else{
                    Toast.makeText(LoginPageActivity.this,"Error",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                Toast.makeText(LoginPageActivity.this,"Error : "+t,Toast.LENGTH_LONG).show();
            }
        });
    }

    }