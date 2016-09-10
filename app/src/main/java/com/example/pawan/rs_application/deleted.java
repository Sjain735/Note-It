package com.example.pawan.rs_application;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class deleted extends AppCompatActivity implements View.OnClickListener {

    Del_RAdapter rAdapter;
    NavigationView nv;
    ImageView del_forever,restore;
    String[] note;
    RelativeLayout del_rel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleted);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        del_rel = (RelativeLayout) findViewById(R.id.del_relative_layout);

        del_forever = (ImageView) findViewById(R.id.del_delete_forever);
        if (del_forever != null) {
            del_forever.setOnClickListener(this);
            del_forever.setVisibility(View.GONE);
        }
        restore = (ImageView) findViewById(R.id.del_restore);
        if (restore != null) {
            restore.setOnClickListener(this);
            restore.setVisibility(View.GONE);
        }

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

                            del_forever.setVisibility(View.GONE);
                            restore.setVisibility(View.GONE);
                            Intent disp_note = new Intent(getApplicationContext(),open_note.class);
                            DBHandler db = new DBHandler(getApplicationContext());
                            String[] notes = db.get_del_single_note(position);
                            disp_note.putExtra("Note",notes);
                            db.close();
                            startActivity(disp_note);
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {

                            del_forever.setVisibility(View.VISIBLE);
                            restore.setVisibility(View.VISIBLE);
                            DBHandler db = new DBHandler(getApplicationContext());
                            note = db.get_del_single_note(position);
                            db.close();
                        }
                    }));
        }//If

    }//onCreate

    @Override
    protected void onResume(){
        super.onResume();
        rAdapter.notifyDataSetChanged();
        del_forever.setVisibility(View.GONE);
        restore.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.del_delete_forever){
            DBHandler db = new DBHandler(getApplicationContext());
            db.delete_forever(note[3],note[2]);
            db.close();

            Toast.makeText(getApplicationContext(),"Note Deleted Permanently!",Toast.LENGTH_SHORT).show();

            rAdapter.notifyDataSetChanged();
            del_forever.setVisibility(View.GONE);
            restore.setVisibility(View.GONE);
        }

        if (v.getId()==R.id.del_restore){
            DBHandler db = new DBHandler(getApplicationContext());
            db.undo_delete_note(note[3],note[2]);
            db.close();

            rAdapter.notifyDataSetChanged();
            del_forever.setVisibility(View.GONE);
            restore.setVisibility(View.GONE);
        }
    }
}//End of class
