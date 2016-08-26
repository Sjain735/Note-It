package com.example.pawan.rs_application;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.logging.LogRecord;

public class new_note extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linear1;
    EditText etext1,etext2;
    ImageView save,save_grey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        save = (ImageView) findViewById(R.id.new_save);
        if (save != null) {
            save.setOnClickListener(this);
        }

        save_grey = (ImageView) findViewById(R.id.new_save_grey);
        if (save_grey != null) {
            save_grey.setVisibility(View.GONE);
        }

        linear1 = (LinearLayout) findViewById(R.id.new_note_linear);

        etext1 = new EditText(getApplicationContext());
        etext1.setHint("Enter Name");
        etext1.setHintTextColor(Color.WHITE);
        etext1.setTextColor(Color.BLACK);
        linear1.addView(etext1);

        etext2 = new EditText(getApplicationContext());
        etext2.setHint("Enter Text");
        etext2.setHintTextColor(Color.WHITE);
        etext2.setTextColor(Color.BLACK);
        linear1.addView(etext2);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.new_save){
            /*save_grey = (ImageView) findViewById(R.id.new_save_grey);

            if (save_grey != null) {
                save_grey.setVisibility(View.VISIBLE);
                delay(2);
                save_grey.setVisibility(View.GONE);
            }*/
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf_date = new SimpleDateFormat("dd-MMM-yyyy");
            SimpleDateFormat sdf_time = new SimpleDateFormat("HH:mm");
            String time = sdf_time.format(c.getTime());
            String date = sdf_date.format(c.getTime());

            String name = String.valueOf(etext1.getText());
            String text = String.valueOf(etext2.getText());

            DBHandler db = new DBHandler(getApplicationContext());
            db.new_note(name,text,time, date);
            db.close();

            Toast.makeText(this,"Note Saved!",Toast.LENGTH_SHORT).show();
            finish();

        }//If
    }//onClickListener
/*
    public void delay(int seconds){
        final int milliseconds = seconds * 1000;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final Handler handler = new Handler() {

                };
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                    }
                }, milliseconds);
            }
        });
    }//delay fn*/

}//Class new_note
