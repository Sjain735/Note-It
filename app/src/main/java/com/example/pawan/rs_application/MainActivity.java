package com.example.pawan.rs_application;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    FloatingActionButton add;
    RAdapter rAdapter;
    NavigationView nv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nv = (NavigationView) findViewById(R.id.nav_view);
        if (nv != null) {
            nv.setOnClickListener(this);
        }

        add = (FloatingActionButton) findViewById(R.id.add_note);
        if (add != null) {
            add.setOnClickListener(this);
        }


        final RecyclerView r_list = (RecyclerView) findViewById(R.id.main_recycler_view);
        rAdapter = new RAdapter(getApplicationContext());
        if (r_list != null) {
            r_list.setAdapter(rAdapter);
        }

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        if (r_list != null) {
            r_list.setLayoutManager(llm);
        }
        if (r_list != null) {
            r_list.setItemAnimator(new DefaultItemAnimator());
        }

        if (r_list != null) {
            r_list.addOnItemTouchListener(
              new R_ItemClickListener(getApplicationContext(), r_list,new R_ItemClickListener.OnItemClickListener() {

                @Override
                    public void onItemClick(View view, int position) {

                    Intent disp_note = new Intent(getApplicationContext(),open_note.class);
                    disp_note.putExtra("Position",position);
                    startActivity(disp_note);
                }

                @Override
                    public void onLongItemClick(View view, int position) {

                }
            }));
        }

    }//End of onCreate

    @Override
    protected void onResume(){
        super.onResume();
        rAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.add_note)
        {
            Intent intent = new Intent(this,new_note.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.nav_notes){

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

        }/*else if(id==R.id.nav_trash){

            Intent intent = new Intent(this,new_note.class);
            startActivity(intent);

        }else if(id==R.id.nav_settings){

            Intent intent = new Intent(this,new_note.class);
            startActivity(intent);

        }else if(id==R.id.nav_about){

            Intent intent = new Intent(this,new_note.class);
            startActivity(intent);
        }*/
        return true;
    }// End of NavigationItem
}//End of MainActivity

