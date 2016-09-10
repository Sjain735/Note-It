package com.example.pawan.rs_application;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    FloatingActionButton add;
    RAdapter rAdapter;
    Menu menu;
    String note[];
    ImageView del;
   // MenuItem item_del;
    NavigationView nv = null;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nv = (NavigationView) findViewById(R.id.nav_view);
        if (nv != null) {
            nv.setNavigationItemSelectedListener(this);
        }

        drawer = (DrawerLayout) findViewById(R.id.main_drawer);

        del = (ImageView) findViewById(R.id.main_del);
        if (del != null) {
            del.setOnClickListener(this);
            del.setVisibility(View.GONE);
        }
/*
        if (item_del != null){
            item_del.setVisible(false);
        }

        TextView toolbarTitle = (TextView) findViewById(R.id.main_toolbar_title);
        if (toolbarTitle != null) {
            Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/You're Gone.ttf");
            toolbarTitle.setTypeface(myFont);
        }
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
                          //  item_del.setVisible(true);
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
        drawer.closeDrawers();
        rAdapter.notifyDataSetChanged();
        del.setVisibility(View.GONE);
      //  item_del.setVisible(false);
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
            db.delete_note(note[3],note[2]);
            db.close();

            Snackbar snackbar = Snackbar
                    .make(drawer, "Note Deleted!", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            DBHandler db1 = new DBHandler(getApplicationContext());
                            db1.undo_delete_note(note[3],note[2]);
                            db1.close();
                            rAdapter.notifyDataSetChanged();
                            Snackbar sb = Snackbar.make(drawer, "Note Restored!", Snackbar.LENGTH_SHORT);
                            sb.show();
                        }
                    });

            snackbar.show();

            rAdapter.notifyDataSetChanged();
            del.setVisibility(View.GONE);
           // item_del.setVisible(false);
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

            Intent intent = new Intent(this,settings.class);
            startActivity(intent);

        }else if(id==R.id.nav_about){

            Intent intent = new Intent(this,about.class);
            startActivity(intent);

        }
        return true;
    }// End of NavigationItemSelected

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.icons_toolbar,menu);
        menu = this.menu;
     //   item_del = menu.findItem(R.id.toolbar_trash);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
       int id = item.getItemId();
/*
        if (id == R.id.toolbar_trash){
            Toast.makeText(getApplicationContext(),"Key Working",Toast.LENGTH_SHORT).show();
            DBHandler db = new DBHandler(getApplicationContext());
            db.delete_note(note[2],note[3]);
            db.close();
            return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }

}//End of MainActivity

