package com.venaseph.hearthlopedia;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

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
}

