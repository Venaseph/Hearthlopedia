package com.venaseph.hearthlopedia;

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
        //Needs work, frag/logo/search functionality
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.hslogo);
    }
}

