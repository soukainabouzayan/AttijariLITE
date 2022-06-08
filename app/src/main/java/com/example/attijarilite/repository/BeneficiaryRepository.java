package com.example.attijarilite.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.attijarilite.model.Account;
import com.example.attijarilite.model.Beneficiary;

import java.util.ArrayList;
import java.util.List;

public class BeneficiaryRepository {
    public MutableLiveData<List<Beneficiary>> getAllBeneficiairy(){
        MutableLiveData<List<Beneficiary>> beneficiaryList = new MutableLiveData<>();
        ArrayList<Beneficiary> beneficiaries = new ArrayList<>();
        Beneficiary beneficiary = new Beneficiary("physique","soukaina","bouzayan","0000000000000000");
        beneficiaries.add(beneficiary);
        beneficiaries.add(beneficiary);
        beneficiaries.add(beneficiary);
        beneficiaries.add(beneficiary);
        beneficiaries.add(beneficiary);
        beneficiaries.add(beneficiary);
        beneficiaries.add(beneficiary);
        beneficiaryList.setValue(beneficiaries);
        return beneficiaryList;

    }
}
