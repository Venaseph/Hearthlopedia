package com.venaseph.hearthlopedia;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import pl.droidsonroids.gif.GifImageView;

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
        final Card card = cardList.Basic.get(position);
        String cost = "0";
        //could have made values protected in class, but meh
        holder.cardName.setText(card.getName());
        holder.cardText.setText(card.getText());
        holder.cardFlavor.setText(card.getFlavor());

        if (card.getRarity() != null) {
            switch (card.getRarity()) {
                case "Common": cost = "40";
                    break;
                case "Rare": cost = "100";
                    break;
                case "Epic": cost = "400";
                    break;
                case "Legendary": cost = "1600";
                    break;
            }
        }

        holder.cardCost.setText(cost);
        Picasso.with(holder.cardImg.getContext()).load(card.getImg()).into(holder.cardImg);

    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView cardName;
        private TextView cardText;
        private TextView cardFlavor;
        private TextView cardCost;
        private GifImageView cardImg;
        //need to implement onclick here
        public CustomViewHolder(View itemView) {
            super(itemView);
            cardName = itemView.findViewById(R.id.cardTitle);
            cardText = itemView.findViewById(R.id.cardText);
            cardFlavor = itemView.findViewById(R.id.cardFlavor);
            cardCost = itemView.findViewById(R.id.dustTextView);
            cardImg = itemView.findViewById(R.id.cardImgView);
        }
    }

}

