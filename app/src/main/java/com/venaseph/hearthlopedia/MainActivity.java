package com.venaseph.hearthlopedia;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager rvLayoutManager;
    private RecyclerView.Adapter rvAdaptor;
    public CardList cardList;
    private Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBarSetup();

        recyclerViewSetup();
        cardList = fetchJSON();

    }

    private void recyclerViewSetup() {
        // Grab/Assign Recycler View
        recyclerView = findViewById(R.id.recyclerView_Main);


        //Init/Assign Layout Manager to RecyclerView
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);
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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        //hide stuff I don't want on the menu on the front page
        MenuItem info = menu.findItem(R.id.info);
        MenuItem share = menu.findItem(R.id.share);
        info.setVisible(false);
        share.setVisible(false);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.share:
                Toast.makeText(getApplicationContext(), "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.info:
                Toast.makeText(getApplicationContext(), "Info", Toast.LENGTH_SHORT).show();
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
        emailIntent.putExtra(Intent.EXTRA_TEXT, "I love your app! You rock.");

        try {
            startActivity(Intent.createChooser(emailIntent, "send"));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "No Client found", Toast.LENGTH_LONG).show();
        }
    }


    private CardList fetchJSON() {

        final OkHttpClient client = new OkHttpClient();
        String url = "https://omgvamp-hearthstone-v1.p.mashape.com/cards";
        String key = "mSCkyyFuiMmshxkH3QTA6RsLglGGp1GG15ajsnJdGUUoajgNgt";
        Request request = new Request.Builder()
                .header("X-Mashape-Key", key)
                .url(url)
                .build();
        //On a new thread
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();

                Gson gson = new GsonBuilder().create();

                cardList = new CardList();
                cardList = gson.fromJson(body, CardList.class);

                cardList = filterList(cardList);

                runOnUiThread(new Runnable() {
                    //View hierarchy issues, run on main thread
                    public void run() {
                        rvAdaptor = new RecyclerAdaptor(cardList, context);
                        recyclerView.setAdapter(rvAdaptor);
                    }
                });

            }
        });
    return cardList;
    }

    public CardList filterList(CardList cardList) {
        cardList.Standard = new ArrayList<Card>();

        for (Card i : cardList.Basic) {
            if(i.getImg() != null) {
                if (i.getType().equals("Minion") || i.getType().equals("Spell")) {
                    cardList.Standard.add(i);
                }
            }
        }

        for (Card i : cardList.Classic) {
            if(i.getImg() != null) {
                if (i.getType().equals("Minion") || i.getType().equals("Spell")) {
                    cardList.Standard.add(i);
                }
            }
        }

        for (Card i : cardList.Knights) {
            if((i.getType().equals("Minion") || i.getType().equals("Spell")) && (i.getRarity() != null) && (i.getImg() != null)) {
                cardList.Standard.add(i);
            }
        }

        for (Card i : cardList.Karazhan) {
            if((i.getType().equals("Minion") || i.getType().equals("Spell")) && (i.getRarity() != null)&& (i.getImg() != null)) {
                    cardList.Standard.add(i);
            }
        }

        for (Card i : cardList.Kolbolds) {
            if((i.getType().equals("Minion") || i.getType().equals("Spell")) && (i.getRarity() != null)&& (i.getImg() != null)) {
                cardList.Standard.add(i);
            }
        }

        return cardList;
    }

}


