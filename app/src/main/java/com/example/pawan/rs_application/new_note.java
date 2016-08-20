package com.example.pawan.rs_application;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class new_note extends AppCompatActivity {

    LinearLayout linear1;
    EditText etext1,etext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

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
    public  void onBackPressed(){
        super.onBackPressed();

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf_date = new SimpleDateFormat("DD-MMM-yyyy");
        SimpleDateFormat sdf_time = new SimpleDateFormat("HH:mm:SS");
        String time = sdf_time.format(c.getTime());
        String date = sdf_date.format(c.getTime());

        String name = String.valueOf(etext1.getText());
        String text = String.valueOf(etext2.getText());

        Log.d("ADD_name", name);
        Log.d("ADD_text", text);
        Log.d("ADD_time", time);
        Log.d("ADD_date", date);

        DBHandler db = new DBHandler(getApplicationContext());
        db.new_note(name,text,time, date);
    }

}
