package com.example.attijarilite.repository;


import androidx.lifecycle.MutableLiveData;


import com.example.attijarilite.model.Bill;
import com.example.attijarilite.network.APIService;
import com.example.attijarilite.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BillRepository {
    public MutableLiveData<List<Bill>> getAllBills(){
        MutableLiveData<List<Bill>> bills = new MutableLiveData<>();
        APIService apiService = RetrofitInstance.getRetrofitInstance().create(APIService.class);
        Call<List<Bill>> call = apiService.getAllBills();
        call.enqueue(new Callback<List<Bill>>() {
            @Override
            public void onResponse(Call<List<Bill>> call, Response<List<Bill>> response) {
                if (!response.isSuccessful()){
                    System.out.println("code : "+response.code());
                    return;
                }
                bills.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Bill>> call, Throwable t) {

            }
        });
        return bills;
    }
}
