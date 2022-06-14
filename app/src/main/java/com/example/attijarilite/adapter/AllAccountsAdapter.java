package com.example.attijarilite.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.attijarilite.R;
import com.example.attijarilite.databinding.ItemaccountBinding;
import com.example.attijarilite.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AllAccountsAdapter extends RecyclerView.Adapter<AllAccountsAdapter.AccountHolder> {
    private List<Account> accountList;
    private OnAccountListener onAccountListener;
    public AllAccountsAdapter() {
    }

    public AllAccountsAdapter(List<Account> accountList, OnAccountListener onAccountListener) {
        this.accountList = accountList;
        this.onAccountListener = onAccountListener;
    }

    @NonNull
    @Override
    public AllAccountsAdapter.AccountHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemaccountBinding itemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),R.layout.itemaccount,parent,false);
        return new AccountHolder(itemBinding,onAccountListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AllAccountsAdapter.AccountHolder holder, int position) {
        Account currentAccount = accountList.get(position);
        holder.itemBinding.setAccount(currentAccount);
    }

    @Override
    public int getItemCount() {
        if (accountList != null){
            return accountList.size();
        }
        else
            return 0;
    }
    public void setAccountList(ArrayList<Account> accountList){
        this.accountList = accountList;
        notifyDataSetChanged();
    }

    public class AccountHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemaccountBinding itemBinding;
        OnAccountListener onAccountListener;
        public AccountHolder(ItemaccountBinding itemBinding, OnAccountListener onAccountListener) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
            itemView.setOnClickListener(this);
            this.onAccountListener = onAccountListener;
        }

        @Override
        public void onClick(View view) {
            onAccountListener.onAccountClick(getAdapterPosition());
        }
    }
    public interface OnAccountListener{
        void onAccountClick(int position);
    }
}
