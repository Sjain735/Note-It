package com.example.pawan.rs_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class settings extends AppCompatActivity implements View.OnClickListener {

    ImageView theme_green, theme_yellow, theme_dark, theme_orange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        theme_green = (ImageView) findViewById(R.id.set_green);
        if (theme_green != null) {
            theme_green.setOnClickListener(this);
        }

        theme_yellow = (ImageView) findViewById(R.id.set_yellow);
        if (theme_yellow != null) {
            theme_yellow.setOnClickListener(this);
        }

        theme_dark = (ImageView) findViewById(R.id.set_dark);
        if (theme_dark != null) {
            theme_dark.setOnClickListener(this);
        }

        theme_orange = (ImageView) findViewById(R.id.set_orange);
        if (theme_orange != null) {
            theme_orange.setOnClickListener(this);
        }

    }//onCreate

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.set_green){

        }
        if(v.getId()==R.id.set_yellow){

        }
        if(v.getId()==R.id.set_dark){

        }
        if(v.getId()==R.id.set_orange){

        }//If
    }//onClickListener

}//Class
