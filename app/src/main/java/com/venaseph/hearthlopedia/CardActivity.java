package com.venaseph.hearthlopedia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CardActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private TextView flavorTextView, rarityTextView, typeTextView, artistTextView, setTextView, costTextView, textTextView;
    private ImageView cardImgView;
    private String rarity, name;
    private int key;
    static Card card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        key = getIntent().getExtras().getInt(RecyclerAdaptor.CustomViewHolder.CARD_KEY);
        card = RecyclerAdaptor.cardList.Basic.get(key);

        cardImgView = findViewById(R.id.cardImgView);
        flavorTextView = findViewById(R.id.flavorTextView);
        rarityTextView = findViewById(R.id.rarityTextView);
        typeTextView = findViewById(R.id.typeTextView);
        artistTextView = findViewById(R.id.artistTextView);
        setTextView = findViewById(R.id.setTextView);
        costTextView = findViewById(R.id.costTextView);
        textTextView = findViewById(R.id.textTextView);

        toolBarSetup();
        setCardValues();

    }

    private void setCardValues() {
        Picasso.with(this).load(card.getImg()).into(cardImgView);
        flavorTextView.setText("\"" + card.getFlavor() + "\"");
        rarityTextView.setText(card.getRarity());
        typeTextView.setText(card.getType());
        artistTextView.setText(card.getArtist());
        setTextView.setText(card.getCardSet());
        costTextView.setText(card.getCost());
        textTextView.setText(card.getText());


    }


    private void toolBarSetup() {
        //Needs work, frag/logo/search functionality
        toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        toolBar.setLogo(R.drawable.hslogo);

    }
}
