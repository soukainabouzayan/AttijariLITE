package com.example.attijarilite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attijarilite.R;
import com.example.attijarilite.databinding.BeneficiariesBottomSheetItemBinding;
import com.example.attijarilite.model.Beneficiary;

import java.util.List;

public class TransferAllBeneficiariesAdapter extends RecyclerView.Adapter<TransferAllBeneficiariesAdapter.BeneficiaryHolder> {
    private List<Beneficiary> beneficiaryList;
    private OnBeneficiaryListener onBeneficiaryListener;

    public TransferAllBeneficiariesAdapter() {
    }

    public TransferAllBeneficiariesAdapter(OnBeneficiaryListener onBeneficiaryListener) {
        this.onBeneficiaryListener = onBeneficiaryListener;
    }

    @NonNull
    @Override
    public TransferAllBeneficiariesAdapter.BeneficiaryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BeneficiariesBottomSheetItemBinding itemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.beneficiaries_bottom_sheet_item,parent,false);
        return new BeneficiaryHolder(itemBinding,onBeneficiaryListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TransferAllBeneficiariesAdapter.BeneficiaryHolder holder, int position) {
        holder.itemBinding.setBeneficiary(beneficiaryList.get(position));
    }

    @Override
    public int getItemCount() {
        if (beneficiaryList != null)
            return beneficiaryList.size();
        else
            return 0;
    }
    public void setBeneficiaryList(List<Beneficiary> beneficiaryList){
        this.beneficiaryList = beneficiaryList;
        notifyDataSetChanged();
    }

    public class BeneficiaryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private BeneficiariesBottomSheetItemBinding itemBinding;
        OnBeneficiaryListener onBeneficiaryListener;
        public BeneficiaryHolder(@NonNull BeneficiariesBottomSheetItemBinding itemBinding,OnBeneficiaryListener onBeneficiaryListener) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
            itemView.setOnClickListener(this);
            this.onBeneficiaryListener = onBeneficiaryListener;
        }

        @Override
        public void onClick(View view) {
            onBeneficiaryListener.onBeneficiaryClick(getAdapterPosition());
        }
    }
    public interface OnBeneficiaryListener{
        void onBeneficiaryClick(int position);
    }
}
