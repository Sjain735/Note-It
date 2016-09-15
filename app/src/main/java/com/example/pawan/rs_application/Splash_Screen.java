package com.example.pawan.rs_application;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class Splash_Screen extends Activity {

    private final int duration = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splash_Screen.this,MainActivity.class);
                Splash_Screen.this.startActivity(mainIntent);
                Splash_Screen.this.finish();
            }
        }, duration);

    }
}
