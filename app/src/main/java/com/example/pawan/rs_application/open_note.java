package com.example.pawan.rs_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class open_note extends AppCompatActivity {

    TextView T_name; TextView T_date; TextView T_text; TextView T_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_note);

        Intent in = getIntent();
        int pos = in.getIntExtra("Position",0);

        DBHandler db = new DBHandler(getApplicationContext());
        String[][] notes = db.get_note();

        T_name = (TextView) findViewById(R.id.open_note_title);
        if (T_name != null) {
            T_name.setText(notes[pos][0]);
        }

        T_text = (TextView) findViewById(R.id.open_note_content);
        if (T_text != null) {
            T_text.setText(notes[pos][1]);
        }

        T_time = (TextView) findViewById(R.id.open_note_time);
        if (T_time != null) {
            T_time.setText(notes[pos][2]);
        }

        T_date = (TextView) findViewById(R.id.open_note_date);
        if (T_date != null) {
            T_date.setText(notes[pos][3]);
        }
    }
}
