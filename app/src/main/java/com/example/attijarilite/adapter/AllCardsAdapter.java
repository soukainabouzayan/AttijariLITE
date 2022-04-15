package com.example.attijarilite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attijarilite.R;
import com.example.attijarilite.databinding.ItemCardBinding;
import com.example.attijarilite.model.Card;

import java.util.ArrayList;
import java.util.List;

public class AllCardsAdapter extends RecyclerView.Adapter<AllCardsAdapter.AllCardsHolder> {
    private List<Card> cardList;

    @NonNull
    @Override
    public AllCardsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCardBinding cardBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_card,parent,false);

        return new AllCardsHolder(cardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCardsHolder holder, int position) {
        holder.cardBinding.setCard(cardList.get(position));
    }

    @Override
    public int getItemCount() {
        if (cardList!=null){
            return cardList.size();
        }
        else
            return 0;
    }
    public void setCardList(ArrayList<Card> cardList){
        this.cardList = cardList;
        notifyDataSetChanged();
    }

    public class AllCardsHolder extends RecyclerView.ViewHolder {
        ItemCardBinding cardBinding;
        public AllCardsHolder(ItemCardBinding cardBinding) {
            super(cardBinding.getRoot());
            this.cardBinding = cardBinding;
        }
    }
}
