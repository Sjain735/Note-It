package com.example.pawan.rs_application;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    String[] Text1;
    int[] image = {R.drawable.coffee2, R.drawable.dinner, R.drawable.coffee, R.drawable.dinner2, R.drawable.hotel,
            R.drawable.hotel, R.drawable.hotel, R.drawable.hotel};

    ListView list1;
    ImageView add;
    ImageView del;
    //NavigationView nv = (NavigationView) findViewById(R.id.nav_view);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        add = (ImageView) findViewById(R.id.add_note);
        if (add != null) {
            add.setOnClickListener(this);
        }
        del = (ImageView) findViewById(R.id.del_note);
        if (del != null) {
            del.setOnClickListener(this);
        }

        /*
        ViewPager pager;
        pager = (ViewPager) findViewById(R.id.pager_main);
        MyPagerAdapter madapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(madapter);
        */

        /*Getting Names of Notes
        DBHandler db = new DBHandler(getApplicationContext());
        Text1 = db.get_name();

        list1 = (ListView) findViewById(R.id.main_list);
        Adapter1 adapter = new Adapter1(getApplicationContext(),Text1);
        list1.setAdapter(adapter);
        */
    }

    @Override
    protected void onResume(){
        super.onResume();

        //Displaying Notes
        DBHandler db = new DBHandler(getApplicationContext());

        String [] Name = db.get_name();
        list1 = (ListView) findViewById(R.id.main_list);
        TextView text = new TextView(getApplicationContext());

        for (int i=0;i<db.get_count();i++){
            text.setText(Name[i]);
            list1.addView(text);
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.add_note)
        {
            Intent intent = new Intent(this,new_note.class);
            startActivity(intent);

            /*EditText etext1 = new EditText(getApplicationContext());
            etext1.getText();
            linear1.addView(etext1);
            Log.d("ADD_text", String.valueOf(etext1));
            Log.d("ADD_time", String.valueOf(System.currentTimeMillis()));

            DBHandler db = new DBHandler(getApplicationContext());
            db.new_note("try", String.valueOf(etext1)); */

        }else if (v.getId()==R.id.del_note){
            Log.d("DEL","del working or not");
        }

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id==R.id.nav_item_1){

        }else if(id==R.id.nav_item_2){

        }else if(id==R.id.nav_item_3){

        }else if(id==R.id.nav_item_4){

        }

        return true;
    }
}

