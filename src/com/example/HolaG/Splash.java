package com.example.HolaG;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Jorge on 25/11/15.
 */
public class Splash extends Activity {
    //esta clase es la que contiene la imagen de inicio de la aplicacion SPLASH
    private static final long SPLASH_SCREEN_DELAY = 3000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash);

        TimerTask task = new TimerTask() {
            public void run() {
                Intent mainIntent = new Intent().setClass(Splash.this, Login.class);
                startActivity(mainIntent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

}