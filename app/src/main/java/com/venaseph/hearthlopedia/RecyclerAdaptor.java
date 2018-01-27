package com.venaseph.hearthlopedia;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Chris on 1/25/2018.
 */

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.CustomViewHolder> {

    public CardList cardList;

    public RecyclerAdaptor(CardList cardList) {
        this.cardList = cardList;
    }

    @Override
    //Number of Items
    public int getItemCount() {
        return cardList.Basic.size();
    }


    @Override
    public RecyclerAdaptor.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_row, parent, false);
        CustomViewHolder holder = new CustomViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdaptor.CustomViewHolder holder, int position) {

    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        //need to implement onclick here
        public CustomViewHolder(View itemView) {
            super(itemView);
        }
    }
}

