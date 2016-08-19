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
public class MyAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] titles;
    private  final int[] image;

    public MyAdapter(Context context, String[] titles, int[] image) {
        super(context, R.layout.list_items, titles);
        this.context = context;
        this.titles = titles;
        this.image = image;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_items, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
        TextView textView1 = (TextView) rowView.findViewById(R.id.title);
        imageView.setImageResource(image[position]);
        textView1.setText(titles[position]);

        // Change icon based on name
        String s = titles[position];

        System.out.println(s);


        return rowView;
    }
}