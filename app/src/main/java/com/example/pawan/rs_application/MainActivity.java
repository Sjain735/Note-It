package com.example.pawan.rs_application;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    FloatingActionButton add;
    RAdapter rAdapter;
    Menu menu;
    String note[];
    ImageView del;
    NavigationView nv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nv = (NavigationView) findViewById(R.id.nav_view);
        if (nv != null) {
            nv.setNavigationItemSelectedListener(this);
        }

        del = (ImageView) findViewById(R.id.main_del);
        if (del != null) {
            del.setOnClickListener(this);
            del.setVisibility(View.GONE);
        }
/*
        final MenuItem item_del = menu.findItem(R.id.toolbar_trash);
        item_del.setVisible(false);
*/
        add = (FloatingActionButton) findViewById(R.id.add_note);
        if (add != null) {
            add.setOnClickListener(this);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        final RecyclerView r_list = (RecyclerView) findViewById(R.id.main_recycler_view);
        rAdapter = new RAdapter(getApplicationContext());
        if (r_list != null) {

            r_list.setAdapter(rAdapter);

            LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
            r_list.setLayoutManager(llm);

            r_list.setItemAnimator(new DefaultItemAnimator());

            r_list.addOnItemTouchListener(
                    new R_ItemClickListener(getApplicationContext(), r_list,new R_ItemClickListener.OnItemClickListener() {

                        @Override
                        public void onItemClick(View view, int position) {

                            del.setVisibility(View.GONE);
                            Intent disp_note = new Intent(getApplicationContext(),open_note.class);
                            DBHandler db = new DBHandler(getApplicationContext());
                            String[] notes = db.get_single_note(position);
                            disp_note.putExtra("Note",notes);
                            db.close();
                            startActivity(disp_note);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            // item_del.setVisible(true);
                            del.setVisibility(View.VISIBLE);
                            DBHandler db = new DBHandler(getApplicationContext());
                            note = db.get_single_note(position);
                            db.close();
                        }
                    }));
        }

    }//End of onCreate

    @Override
    protected void onResume(){
        super.onResume();
        rAdapter.notifyDataSetChanged();
        del.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.add_note)
        {
            Intent intent = new Intent(this,new_note.class);
            startActivity(intent);
        }

        if (v.getId()==R.id.main_del){
            DBHandler db = new DBHandler(getApplicationContext());
            db.delete_note(note[2],note[3]);
            db.close();
            rAdapter.notifyDataSetChanged();
            del.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.nav_notes){

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

        }else if(id==R.id.nav_trash){

            Intent intent = new Intent(this,deleted.class);
            startActivity(intent);

        }else if(id==R.id.nav_settings){


        }else if(id==R.id.nav_about){


        }
        return true;
    }// End of NavigationItemSelected

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.icons_toolbar,menu);
        menu = this.menu;
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
/*        int id = item.getItemId();

        if (id == R.id.toolbar_trash){
            DBHandler db = new DBHandler(getApplicationContext());
            db.delete_note(note[2],note[3]);
            db.close();
            return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }

}//End of MainActivity

