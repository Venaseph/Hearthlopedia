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
    private TextView flavorTextView;
    private String flavor, cardClass, type, artist, set, rarity, name, img;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        flavorTextView = findViewById(R.id.flavorTextView);
        cardImageView = findViewById(R.id.cardImgView);
        flavorTextView.setText(flavor);

        toolBarSetup();
        getBundleValues();

    }

    private void getBundleValues() {
        //change value to static key from recycler
        extras = getIntent().getExtras();
        if (extras != null) {
            flavorTextView.setText(getIntent().getExtras().getString("CARD_FLAVOR"));
            Picasso.with(this).load(getIntent().getExtras().getString("CARD_IMG")).into(cardImageView);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void toolBarSetup() {
        //Needs work, frag/logo/search functionality
        toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        toolBar.setLogo(R.drawable.hslogo);

    }
}
