package com.example.attijarilite.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attijarilite.R;
import com.example.attijarilite.databinding.ItemTransactionBinding;
import com.example.attijarilite.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {
    private List<Transaction> transactionList;

    public HistoryAdapter() {
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTransactionBinding transactionBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_transaction,parent,false);
        return new HistoryHolder(transactionBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder holder, int position) {
        holder.transactionBinding.setTransaction(transactionList.get(position));
    }

    @Override
    public int getItemCount() {
        if (transactionList != null){
            return transactionList.size();
        }
        else
            return 0;
    }
    public void setTransactionList(ArrayList<Transaction> transactionList){
        this.transactionList = transactionList;
        notifyDataSetChanged();
    }

    public class HistoryHolder extends RecyclerView.ViewHolder {
        private ItemTransactionBinding transactionBinding;
        public HistoryHolder(ItemTransactionBinding transactionBinding) {
            super(transactionBinding.getRoot());
            this.transactionBinding = transactionBinding;
        }
    }
}
