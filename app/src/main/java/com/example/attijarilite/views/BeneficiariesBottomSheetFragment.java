package com.example.attijarilite.views;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attijarilite.R;
import com.example.attijarilite.adapter.TransferAllBeneficiariesAdapter;
import com.example.attijarilite.model.Beneficiary;
import com.example.attijarilite.viewmodel.AllBeneficiariesViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

public class BeneficiariesBottomSheetFragment extends BottomSheetDialogFragment {
    private TransferAllBeneficiariesAdapter.OnBeneficiaryListener onBeneficiaryListener;
    private TransferAllBeneficiariesAdapter adapter;
    private AllBeneficiariesViewModel beneficiariesViewModel;

    public BeneficiariesBottomSheetFragment(TransferAllBeneficiariesAdapter.OnBeneficiaryListener onBeneficiaryListener) {
        this.onBeneficiaryListener = onBeneficiaryListener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        beneficiariesViewModel = new ViewModelProvider(requireActivity()).get(AllBeneficiariesViewModel.class);
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.beneficiaries_bottom_sheet_layout,null);
        bottomSheetDialog.setContentView(view);
        RecyclerView recyclerView = view.findViewById(R.id.beneficiaries);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new TransferAllBeneficiariesAdapter(new TransferAllBeneficiariesAdapter.OnBeneficiaryListener() {
            @Override
            public void onBeneficiaryClick(int position) {
                onBeneficiaryListener.onBeneficiaryClick(position);
                dismiss();
            }
        });
        recyclerView.setAdapter(adapter);
        beneficiariesViewModel.getAllBeneficiaries().observe(getActivity(), new Observer<List<Beneficiary>>() {
            @Override
            public void onChanged(List<Beneficiary> beneficiaries) {
                adapter.setBeneficiaryList(beneficiaries);
            }
        });
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        return bottomSheetDialog;
    }
}
