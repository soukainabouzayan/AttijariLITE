package com.example.attijarilite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attijarilite.R;
import com.example.attijarilite.databinding.ItemTransactionByAccountBinding;
import com.example.attijarilite.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DetailsAccountAdapter extends RecyclerView.Adapter<DetailsAccountAdapter.Holder> {
    private List<Transaction> transactionList;
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTransactionByAccountBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_transaction_by_account,parent,false
        );
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.binding.setTransaction(transactionList.get(position));
    }

    @Override
    public int getItemCount() {
        if (transactionList != null)
            return transactionList.size();
        else
            return 0;
    }
    public void setTransactionList(ArrayList<Transaction> transactionList){
        this.transactionList = transactionList;
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ItemTransactionByAccountBinding binding;
        public Holder(ItemTransactionByAccountBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
