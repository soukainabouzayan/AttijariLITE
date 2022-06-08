package com.example.attijarilite.viewmodel;

import androidx.lifecycle.ViewModel;

public class TransferViewModel extends ViewModel {
    public Boolean isAmountValid(float amount){
        if (amount >=10 & amount<50000)
            return true;
        else
            return false;
    }
}
