package com.example.pawan.rs_application;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class deleted extends AppCompatActivity {

    Del_RAdapter rAdapter;
    NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleted);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        final RecyclerView r_del_list = (RecyclerView) findViewById(R.id.del_rec_view);
        rAdapter = new Del_RAdapter(getApplicationContext());
        if (r_del_list != null) {
            r_del_list.setAdapter(rAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());

            r_del_list.setLayoutManager(llm);

            r_del_list.setItemAnimator(new DefaultItemAnimator());

            r_del_list.addOnItemTouchListener(
                    new R_ItemClickListener(getApplicationContext(), r_del_list,new R_ItemClickListener.OnItemClickListener() {

                        @Override
                        public void onItemClick(View view, int position) {

                            Intent disp_note = new Intent(getApplicationContext(),open_note.class);
                            DBHandler db = new DBHandler(getApplicationContext());
                            String[] notes = db.get_del_single_note(position);
                            disp_note.putExtra("Note",notes);
                            db.close();
                            startActivity(disp_note);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                        }
                    }));
        }//If

    }//onCreate

}//End of class
