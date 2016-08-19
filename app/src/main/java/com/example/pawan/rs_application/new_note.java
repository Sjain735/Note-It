package com.example.pawan.rs_application;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class new_note extends AppCompatActivity {

    LinearLayout linear1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        linear1 = (LinearLayout) findViewById(R.id.new_note_linear);

        EditText etext1 = new EditText(getApplicationContext());
        etext1.setHint("Enter Name");
        etext1.setHintTextColor(Color.WHITE);
        etext1.setTextColor(Color.BLACK);
        linear1.addView(etext1);
        etext1.getText();

        EditText etext2 = new EditText(getApplicationContext());
        etext1.setHint("Enter Text");
        etext1.setHintTextColor(Color.WHITE);
        etext1.setTextColor(Color.BLACK);
        linear1.addView(etext2);
        etext1.getText();

        String date = "04/12/1996";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        Date date_use = null;
        try {
            date_use = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String time = String.valueOf(System.currentTimeMillis());


        Log.d("ADD_name", String.valueOf(etext1));
        Log.d("ADD_text", String.valueOf(etext2));
        Log.d("ADD_time",time);
        Log.d("ADD_date", String.valueOf(date_use));

        DBHandler db = new DBHandler(getApplicationContext());
        db.new_note(String.valueOf(etext1),String.valueOf(etext2),time, String.valueOf(date_use));
    }

}
