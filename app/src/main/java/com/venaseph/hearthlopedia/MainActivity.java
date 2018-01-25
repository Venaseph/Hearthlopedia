package com.venaseph.hearthlopedia;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBarSetup();

    }

    private void toolBarSetup() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Hearthlopedia");
        toolbar.setSubtitle("Subtitle");
        toolbar.setLogo(R.drawable.hslogo);
        toolbar.setTitleTextColor(Color.WHITE);
    }
}

