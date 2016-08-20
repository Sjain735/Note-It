package com.example.pawan.rs_application;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Pawan on 20-Aug-16.
 */
public class RAdapter extends RecyclerView.Adapter<RAdapter.ViewHolder> {

    public int Type_Text = 1;

    public RAdapter (Context context){
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

        if(holder.HolderId==1){
            holder.Text.setText("Working!");
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public int getItemViewType (int position){
        return Type_Text;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        int HolderId; TextView Text;

        public ViewHolder(View itemView, int View_Type, Context context) {
            super(itemView);

            if (View_Type==Type_Text){
                Text = (TextView) itemView.findViewById(R.id.type1_text);
                HolderId = 1;
            }//If

        }//Constructor
    }//ViewHolder Class
}
