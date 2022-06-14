package com.example.attijarilite.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.attijarilite.model.Bill;
import com.example.attijarilite.repository.BillRepository;

public class BillViewModel extends ViewModel {
    private BillRepository billRepository;

    public BillViewModel() {
        billRepository = new BillRepository();
    }

    public LiveData getAllBills(){
        return billRepository.getAllBills();
    }
}
