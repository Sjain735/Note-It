package com.example.pawan.rs_application;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class open_note extends AppCompatActivity {

    TextView T_name; TextView T_date; TextView T_text; TextView T_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_note);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        Intent in = getIntent();
        String[] notes = in.getStringArrayExtra("Note");


        T_name = (TextView) findViewById(R.id.open_note_title);
        if (T_name != null) {
            T_name.setText(notes[0]);
            Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/Xoxoxa.ttf");
            T_name.setTypeface(myFont);
        }

        T_text = (TextView) findViewById(R.id.open_note_content);
        if (T_text != null) {
            T_text.setText(notes[1]);
            Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/Xoxoxa.ttf");
            T_text.setTypeface(myFont);
        }

        T_date = (TextView) findViewById(R.id.open_note_date);
        if (T_date != null) {
            T_date.setText(notes[2]);
            Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/An ode to noone.ttf");
            T_date.setTypeface(myFont);
        }

        T_time = (TextView) findViewById(R.id.open_note_time);
        if (T_time != null) {
            T_time.setText(notes[3]);
            Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/An ode to noone.ttf");
            T_time.setTypeface(myFont);
        }

    }
}
