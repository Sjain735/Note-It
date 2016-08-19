package com.example.pawan.rs_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admin on 8/6/2016.
 */
public class Adapter1 extends ArrayAdapter<String> {
    private final Context context;
    private final String[] titles;

    public Adapter1(Context context, String[] name) {
        super(context, R.layout.list_adapter1, name);
        this.context = context;
        this.titles = name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_adapter1, parent, false);
        TextView textView1 = (TextView) rowView.findViewById(R.id.note_name);
        textView1.setText(titles[position]);

        // Change icon based on name
        String s = titles[position];

        System.out.println(s);


        return rowView;
    }
}
