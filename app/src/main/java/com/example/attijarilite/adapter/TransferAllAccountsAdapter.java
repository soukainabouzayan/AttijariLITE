package com.example.attijarilite.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.attijarilite.R;
import com.example.attijarilite.databinding.AccountsBottomSheetItemBinding;
import com.example.attijarilite.model.Account;

import java.util.ArrayList;
import java.util.List;

public class TransferAllAccountsAdapter extends RecyclerView.Adapter<TransferAllAccountsAdapter.AccountHolder> {
    private List<Account> accountList;
    private OnAccountListener onAccountListener;
    public TransferAllAccountsAdapter() {
    }
    public TransferAllAccountsAdapter(OnAccountListener onAccountListener) {
        this.onAccountListener = onAccountListener;
    }

    @NonNull
    @Override
    public TransferAllAccountsAdapter.AccountHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AccountsBottomSheetItemBinding itemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),R.layout.accounts_bottom_sheet_item,parent,false);
        return new AccountHolder(itemBinding,onAccountListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TransferAllAccountsAdapter.AccountHolder holder, int position) {
        holder.itemBinding.setAccount(accountList.get(position));
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
        private AccountsBottomSheetItemBinding itemBinding;
        OnAccountListener onAccountListener;
        public AccountHolder(AccountsBottomSheetItemBinding itemBinding, OnAccountListener onAccountListener) {
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
