package com.venaseph.hearthlopedia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import pl.droidsonroids.gif.GifImageView;

public class CardActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private TextView flavorTextView, rarityTextView, typeTextView, artistTextView, setTextView, costTextView, textTextView;
    private GifImageView cardImgView;
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
        Glide.with(this).load(card.getImgGold()).transition(DrawableTransitionOptions.withCrossFade()).into(cardImgView);
        if (card.getFlavor() != null) {
            flavorTextView.setText("\"" + card.getFlavor() + "\"");
        }
        rarityTextView.setText(card.getRarity());
        typeTextView.setText(card.getType());
        artistTextView.setText(card.getArtist());
        setTextView.setText(card.getCardSet());
        costTextView.setText(card.getCost());
        //deal with inline html for all versions
        textTextView.setText(card.getText());
        if (card.getText() != null) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                textTextView.setText(Html.fromHtml(card.getText(),Html.FROM_HTML_MODE_LEGACY));
            } else {
                textTextView.setText(Html.fromHtml(card.getText()));
            }
        }




    }


    private void toolBarSetup() {
        //Needs work, frag/logo/search functionality
        toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        toolBar.setLogo(R.drawable.hslogo);

    }
}
