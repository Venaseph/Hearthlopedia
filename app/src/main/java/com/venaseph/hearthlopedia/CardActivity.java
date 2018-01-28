package com.venaseph.hearthlopedia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class CardActivity extends AppCompatActivity {
    private Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        toolBarSetup();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void toolBarSetup() {
        //Needs work, frag/logo/search functionality
        toolBar = findViewById(R.id.toolbar);
        toolBar.setLogo(R.drawable.hslogo);

    }
}
