package com.venaseph.hearthlopedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class Intro_Splash extends AppCompatActivity {
    private Intent main;
    private int SLEEP_TIMER = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Hide title bar on slash screen/load
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_intro__splash);
        SplashLauncher splash = new SplashLauncher();
        splash.start();
    }

    private class SplashLauncher extends Thread {
        //Little timer thread for my faux load screen
        public void run() {

            try {
                sleep(1000 * SLEEP_TIMER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            startActivity(main = new Intent(Intro_Splash.this, MainActivity.class));
            Intro_Splash.this.finish();
        }
    }

}
