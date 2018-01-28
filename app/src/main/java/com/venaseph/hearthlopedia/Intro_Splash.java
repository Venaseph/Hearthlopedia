package com.venaseph.hearthlopedia;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public class Intro_Splash extends AppCompatActivity {
    private Intent main;
    private int SLEEP_TIMER = 3;
    private boolean current = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkVersion();


        //Hide title bar on slash screen/load
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro__splash);

        //only run if checkVersion passes
        if (current) {
            SplashLauncher splash = new SplashLauncher();
            splash.start();
        }
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

    private void checkVersion() {
        int sdkVersion = Build.VERSION.SDK_INT;
        if (sdkVersion < 20) {
            //create alert to be nice
            current = false;
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false)
                    .setTitle("Unsupported Version")
                    .setMessage("Please update to run Hearth Market")
                    .setNeutralButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //close Activity on OK click
                                    Intro_Splash.this.finish();
                                }
                            });
            final AlertDialog alert = builder.create();
            alert.show();

            //building doesn't actually create the dialog, so you do after it's set
        }
    }

}
