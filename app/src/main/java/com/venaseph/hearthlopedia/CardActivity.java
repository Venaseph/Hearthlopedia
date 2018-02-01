package com.venaseph.hearthlopedia;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import pl.droidsonroids.gif.GifImageView;

public class CardActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private TextView flavorTextView, rarityTextView, typeTextView, artistTextView, setTextView, nameTextView, rateLabelTextView;
    private GifImageView cardImgView;
    private int key;
    private String name;
    public Card card;

    private SharedPreferences sharedPref;
    private RatingBar ratingBar;
    private float stars;


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
        ratingBar = findViewById(R.id.ratingBar);
        rateLabelTextView = findViewById(R.id.rateLabelTextView);
        nameTextView = findViewById(R.id.nameTextView);
        name = card.getName();

        toolBarSetup();
        setCardValues();

        //set up Sharedprefs populate stars
        sharedPref = this.getSharedPreferences("com.venaseph.hearthlopedia", Context.MODE_PRIVATE);
        ratingBar.setRating(sharedPref.getFloat(name, 0));
        //Listener for state change on stars
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                stars = ratingBar.getRating();
                sharedPref.edit().putFloat(name, stars).apply();
            }
        });

    }


    private void setCardValues() {

        Glide.with(this).load(card.getImgGold()).transition(DrawableTransitionOptions.withCrossFade()).into(cardImgView);

        if (card.getFlavor() != null) {
            flavorTextView.setText("\"" + card.getFlavor() + "\"");
        }
        nameTextView.setText(card.getName());
        rarityTextView.setText(card.getRarity());
        typeTextView.setText(card.getType());
        artistTextView.setText(card.getArtist());
        setTextView.setText(card.getCardSet());
        rateLabelTextView.setText("Rate " + card.getName());

        //deal with inline html for all versions
//        textTextView.setText(card.getText());
//        if (card.getText() != null) {
//            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//                textTextView.setText(Html.fromHtml(card.getText(),Html.FROM_HTML_MODE_LEGACY));
//            } else {
//                textTextView.setText(Html.fromHtml(card.getText()));
//            }
//        }

    }


    private void toolBarSetup() {
        //Needs work, frag/logo/search functionality
        toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        toolBar.setLogo(R.drawable.hslogo);

    }
}
