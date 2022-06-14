package com.example.attijarilite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attijarilite.R;
import com.example.attijarilite.databinding.ItemBillBinding;
import com.example.attijarilite.model.Bill;

import java.util.ArrayList;
import java.util.List;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.BillHolder> {
    private List<Bill> bills;
    private OnBillListener onBillListener;

    public BillAdapter(List<Bill> bills, OnBillListener onBillListener) {
        this.bills = bills;
        this.onBillListener = onBillListener;
    }

    @NonNull
    @Override
    public BillHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBillBinding billBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_bill,parent,false);
        return new BillHolder(billBinding,onBillListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BillHolder holder, int position) {
        Bill currentBill = bills.get(position);
        holder.billBinding.setBill(currentBill);
    }

    @Override
    public int getItemCount() {
        if (bills!=null){
            return bills.size();
        }
        else
            return 0;
    }
    public void setBillList(ArrayList<Bill> bills){
        this.bills = bills;
        notifyDataSetChanged();
    }

    public class BillHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemBillBinding billBinding;
        OnBillListener onBillListener;

        public BillHolder(@NonNull ItemBillBinding billBinding, OnBillListener onBillListener) {
            super(billBinding.getRoot());
            this.billBinding = billBinding;
            itemView.setOnClickListener(this);
            this.onBillListener = onBillListener;


        }

        @Override
        public void onClick(View view) {
            onBillListener.onBillClicked(getAdapterPosition());
        }
    }
    public interface OnBillListener{
        void onBillClicked(int position);
    }
}
