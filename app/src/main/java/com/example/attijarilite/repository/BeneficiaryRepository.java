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
        Beneficiary beneficiary = new Beneficiary("physique","soukaina","bouzayan","0000 0000 0000 0000 0000 0000");
        Beneficiary beneficiary1 = new Beneficiary("physique","mehdi","bouzayan","0000 0000 0000 0000 0000 0001");
        beneficiaries.add(beneficiary);
        beneficiaries.add(beneficiary1);
        beneficiaryList.setValue(beneficiaries);
        return beneficiaryList;

    }
}
