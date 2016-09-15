package com.example.pawan.rs_application;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by Pawan on 20-Aug-16.
 */
public class RAdapter extends RecyclerView.Adapter<RAdapter.ViewHolder> {

    public int Type_Text = 1;
    Context r_context;
    int pos = 1;

    public RAdapter (Context context){
        r_context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v; ViewHolder vItem = null;

        if (viewType==Type_Text){
            v= LayoutInflater.from(parent.getContext()).inflate(R.layout.r_type1,parent,false);
            vItem = new ViewHolder(v,viewType,parent.getContext());
        }

        return vItem;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        String[] Text_name;

        holder.setIsRecyclable(false);
        setAnimation(holder.container);

        pos = position;

        if(holder.HolderId==1){
            DBHandler db = new DBHandler(r_context);
            Text_name = db.get_name();
            holder.Text.setText(Text_name[position]);
            db.close();
        }
    }

    @Override
    public int getItemCount() {
        DBHandler db = new DBHandler(r_context);
        int note_count = db.get_count();
        db.close();
        return note_count;
    }

    public int getPosition (){
        return pos;
    }

    @Override
    public int getItemViewType (int position){
        return Type_Text;
    }

    private void setAnimation (View view){

        Animation animation = AnimationUtils.loadAnimation(r_context, android.R.anim.slide_in_left);
        view.startAnimation(animation);
    }


    // ViewHolder Class
    public class ViewHolder extends RecyclerView.ViewHolder {

        int HolderId; TextView Text;
        CardView container;

        public ViewHolder(View itemView, int View_Type, Context context) {
            super(itemView);

            container = (CardView) itemView.findViewById(R.id.type1_cardview);

            if (View_Type==Type_Text){
                Text = (TextView) itemView.findViewById(R.id.type1_text);
                HolderId = 1;
            }//If

        }//Constructor

    }//ViewHolder Class

}//RAdapter Class
