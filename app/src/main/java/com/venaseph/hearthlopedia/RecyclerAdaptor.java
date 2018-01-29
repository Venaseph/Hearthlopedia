package com.venaseph.hearthlopedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by Chris on 1/25/2018.
 */

public class RecyclerAdaptor extends RecyclerView.Adapter<RecyclerAdaptor.CustomViewHolder> {
    //for bundle keys
    public static final String CARD_FLAVOR = "CARD_FLAVOR";
    private static final String CARD_CLASS = "CARD_CLASS";
    private static final String CARD_TYPE = "CARD_TYPE";
    private static final String CARD_ARTIST = "CARD_ARTIST";
    private static final String CARD_SET = "CARD_SET";
    private static final String CARD_RARITY = "CARD_RARITY";
    private static final String CARD_NAME = "CARD_NAME";
    private static final String CARD_IMG = "CARD_IMG";

    private static Intent intent;
    private static Bundle extras;
    public static CardList cardList;

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
        // Could have made values protected in class, but meh
        holder.cardName.setText(card.getName());
        holder.cardText.setText(card.getText());
        holder.cardFlavor.setText(card.getFlavor());

        // Handles dust value of card
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
        private Button moreButton;

        public CustomViewHolder(final View itemView) {
            super(itemView);

            cardName = itemView.findViewById(R.id.cardTitle);
            cardText = itemView.findViewById(R.id.cardText);
            cardFlavor = itemView.findViewById(R.id.cardFlavor);
            cardCost = itemView.findViewById(R.id.dustTextView);
            cardImg = itemView.findViewById(R.id.cardImgView);
            moreButton = itemView.findViewById(R.id.moreButton);

            moreButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), "Clicked:" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    intent = new Intent(itemView.getContext(), CardActivity.class);
                    extras = new Bundle();
                    extras.putString(CARD_FLAVOR, cardList.Basic.get(getAdapterPosition()).getFlavor());
                    extras.putString(CARD_IMG, cardList.Basic.get(getAdapterPosition()).getImg());
                    //intent.putExtras(extras);
                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }

}

