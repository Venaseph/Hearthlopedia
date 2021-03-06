package com.venaseph.hearthlopedia;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import pl.droidsonroids.gif.GifImageView;

public class CardActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private TextView flavorTextView, rarityTextView, typeTextView, artistTextView, setTextView, nameTextView, rateLabelTextView;
    private GifImageView cardImgView;
    private ImageView statsImageView;
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
        card = RecyclerAdaptor.cardList.Standard.get(key);

        cardImgView = findViewById(R.id.cardImgView);
        flavorTextView = findViewById(R.id.flavorTextView);
        rarityTextView = findViewById(R.id.rarityTextView);
        typeTextView = findViewById(R.id.typeTextView);
        artistTextView = findViewById(R.id.artistTextView);
        setTextView = findViewById(R.id.setTextView);
        ratingBar = findViewById(R.id.ratingBar);
        rateLabelTextView = findViewById(R.id.rateLabelTextView);
        nameTextView = findViewById(R.id.nameTextView);
        statsImageView = findViewById(R.id.statsImageView);
        name = card.getName();

        toolBarSetup();
        setCardValues();
        managePremium();

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

        statsImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    statsImageView.setImageResource(R.drawable.premium);
                } else if (motionEvent.getAction() == android.view.MotionEvent.ACTION_UP){
                    statsImageView.setImageResource(R.drawable.charts);
                }
                return true;
            }
        });

    }

    private void managePremium() {

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
        toolBar = findViewById(R.id.app_bar);
        setSupportActionBar(toolBar);
        //deal with status bar color since theme.appcompact will not correctly via xml
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.share:
                Toast.makeText(getApplicationContext(), "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.info:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://hearthstone.gamepedia.com/" + card.getName().replaceAll(" ", "_"))));
                break;
            case R.id.contact:
                sendEmail();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    private void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:")).setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"hearthlopedia@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hey Hearthlopedia!");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "I was looking at " + card.getName() + " and was thinking....");

        try {
            startActivity(Intent.createChooser(emailIntent, "send"));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(CardActivity.this, "No Client found", Toast.LENGTH_LONG).show();
        }
    }


}
