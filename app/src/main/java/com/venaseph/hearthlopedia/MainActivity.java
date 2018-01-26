package com.venaseph.hearthlopedia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager rvLayoutManager;
    private RecyclerView.Adapter rvAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBarSetup();
        recyclerViewSetup();

    }

    private void recyclerViewSetup() {
        // Grab Recycler View
        recyclerView = findViewById(R.id.recyclerView_Main);

        //Assign Layout Manager to RecyclerView
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);

        //Assign Adaptor to RecyclerView
        //rvAdaptor = new
    }

    private void toolBarSetup() {
        //Needs work, frag/logo/search functionality
        toolbar = findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.hslogo);
    }
}

