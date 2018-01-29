package com.venaseph.hearthlopedia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CardActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private ImageView cardImageView;
    private TextView flavorTextView, rarityTextView, typeTextView, artistTextView, setTextView, costTextView, textTextView;
    private String rarity, name;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        cardImageView = findViewById(R.id.cardImgView);
        flavorTextView = findViewById(R.id.flavorTextView);
        rarityTextView = findViewById(R.id.rarityTextView);
        typeTextView = findViewById(R.id.typeTextView);
        artistTextView = findViewById(R.id.artistTextView);
        setTextView = findViewById(R.id.setTextView);
        costTextView = findViewById(R.id.costTextView);
        textTextView = findViewById(R.id.textTextView);

        toolBarSetup();
        getBundleValues();

    }

    private void getBundleValues() {
        //change value to static key from recycler
        extras = getIntent().getExtras();
        if (extras != null) {
            Picasso.with(this).load(getIntent().getExtras().getString("CARD_IMG")).into(cardImageView);
            flavorTextView.setText(getIntent().getExtras().getString("CARD_FLAVOR"));
            textTextView.setText(getIntent().getExtras().getString("CARD_TEXT"));
            //classTextView.setText(getIntent().getExtras().getString("CARD_CLASS"));
            typeTextView.setText(getIntent().getExtras().getString("CARD_TYPE"));
            artistTextView.setText(getIntent().getExtras().getString("CARD_ARTIST"));
            setTextView.setText(getIntent().getExtras().getString("CARD_SET"));
            costTextView.setText(getIntent().getExtras().getString("CARD_COST"));
            rarity = getIntent().getExtras().getString("CARD_FLAVOR");
            rarityTextView.setText(rarity);
            name = getIntent().getExtras().getString("CARD_NAME");
        }

    }

    private void toolBarSetup() {
        //Needs work, frag/logo/search functionality
        toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        toolBar.setLogo(R.drawable.hslogo);

    }
}
