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
import com.example.attijarilite.adapter.TransferAllAccountsAdapter;
import com.example.attijarilite.model.Account;
import com.example.attijarilite.viewmodel.AllAccountsViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class AccountsBottomSheetFragment extends BottomSheetDialogFragment {
    private TransferAllAccountsAdapter.OnAccountListener onAccountListener;
    AllAccountsViewModel accountsViewModel;
    TransferAllAccountsAdapter adapter;

    public AccountsBottomSheetFragment(TransferAllAccountsAdapter.OnAccountListener onAccountClick) {
        this.onAccountListener= onAccountClick;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        accountsViewModel = new ViewModelProvider(requireActivity()).get(AllAccountsViewModel.class);
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.accounts_bottom_sheet_layout,null);
        bottomSheetDialog.setContentView(view);
        RecyclerView recyclerView = view.findViewById(R.id.accounts);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new TransferAllAccountsAdapter(new TransferAllAccountsAdapter.OnAccountListener() {
            @Override
            public void onAccountClick(int position) {
                onAccountListener.onAccountClick(position);
                dismiss();
            }
        });
        recyclerView.setAdapter(adapter);
        accountsViewModel.getAllAccounts().observe(getActivity(), new Observer<List<Account>>() {
            @Override
            public void onChanged(@Nullable List<Account> accounts) {
                adapter.setAccountList((ArrayList<Account>) accounts);
            }
        });
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        return bottomSheetDialog;
    }

}
