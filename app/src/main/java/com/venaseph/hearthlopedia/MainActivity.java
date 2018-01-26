package com.venaseph.hearthlopedia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager rvLayoutManager;
    private RecyclerView.Adapter rvAdaptor;
    private FetchJson fetchJSON;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBarSetup();
        recyclerViewSetup();
        fetchJSON = new FetchJson();
        try {
            fetchJSON.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void recyclerViewSetup() {
        // Grab/Assign Recycler View
        recyclerView = findViewById(R.id.recyclerView_Main);

        //Init/Assign Layout Manager to RecyclerView
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);

        //Init/Assign Adaptor to RecyclerView
        rvAdaptor = new RecyclerAdaptor();
        recyclerView.setAdapter(rvAdaptor);
    }

    private void toolBarSetup() {
        //Needs work, frag/logo/search functionality
        toolbar = findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.hslogo);
    }
}

