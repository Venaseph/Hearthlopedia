package com.venaseph.hearthlopedia;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Chris on 1/25/2018.
 */

class FetchJson {

    private final OkHttpClient client = new OkHttpClient();
    String url = "https://omgvamp-hearthstone-v1.p.mashape.com/cards";
    String key = "mSCkyyFuiMmshxkH3QTA6RsLglGGp1GG15ajsnJdGUUoajgNgt";
    

    public void run() throws IOException {
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
                    System.out.println(body);

            }
        });

    }

}
