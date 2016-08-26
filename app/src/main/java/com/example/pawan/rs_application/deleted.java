package com.example.pawan.rs_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class deleted extends AppCompatActivity {

    Del_RAdapter rAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleted);

        final RecyclerView r_del_list = (RecyclerView) findViewById(R.id.del_rec_view);
        rAdapter = new Del_RAdapter(getApplicationContext());
        if (r_del_list != null) {
            r_del_list.setAdapter(rAdapter);
        }

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        if (r_del_list != null) {
            r_del_list.setLayoutManager(llm);
        }
        if (r_del_list != null) {
            r_del_list.setItemAnimator(new DefaultItemAnimator());
        }

        if (r_del_list != null) {
            r_del_list.addOnItemTouchListener(
                    new R_ItemClickListener(getApplicationContext(), r_del_list,new R_ItemClickListener.OnItemClickListener() {

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
        }//If

    }//onCreate

}//End of class
