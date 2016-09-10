package com.example.pawan.rs_application;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class new_note extends AppCompatActivity implements View.OnClickListener {

    LinearLayout linear1;
    EditText etext1,etext2;
    ImageView save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        save = (ImageView) findViewById(R.id.new_save);
        if (save != null) {
            save.setOnClickListener(this);
        }

        linear1 = (LinearLayout) findViewById(R.id.new_note_linear);

        etext1 = new EditText(getApplicationContext());
        etext1.setHint("Enter Name");
        etext1.setPadding(5,5,0,0);
        etext1.setHintTextColor(Color.BLACK);
        etext1.setTextColor(Color.BLACK);
        linear1.addView(etext1);


        etext2 = new EditText(getApplicationContext());
        etext2.setPadding(5,32,0,0);
        etext2.setHint("Enter Text");
        etext2.setHintTextColor(Color.BLACK);
        etext2.setTextColor(Color.BLACK);
        linear1.addView(etext2);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.new_save){

            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf_date = new SimpleDateFormat("dd-MMM-yyyy");
            SimpleDateFormat sdf_time = new SimpleDateFormat("HH:mm:SS");
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

}//Class new_note
