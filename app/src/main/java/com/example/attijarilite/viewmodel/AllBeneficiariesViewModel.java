package com.example.attijarilite.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.attijarilite.model.Beneficiary;
import com.example.attijarilite.repository.BeneficiaryRepository;

public class AllBeneficiariesViewModel extends ViewModel {
    private BeneficiaryRepository beneficiaryRepository;

    public AllBeneficiariesViewModel() {
        beneficiaryRepository = new BeneficiaryRepository();
    }
    public LiveData getAllBeneficiaries(){
        return beneficiaryRepository.getAllBeneficiairy();
    }
}
