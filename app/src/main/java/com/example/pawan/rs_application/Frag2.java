package com.example.pawan.rs_application;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admin on 8/6/2016.
 */

public class Frag2 extends Fragment {

    public Frag2()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup Container, Bundle SavedInstanceState)
    {
        View V= inflater.inflate(R.layout.frag2,Container, false);
        TextView textview = (TextView) V.findViewById(R.id.frag2_text1);
        textview.setText("Fragment 2");
        ImageView imageview = (ImageView) V.findViewById(R.id.frag2_image1);
        imageview.setImageResource(R.drawable.coffee2);
        return V;

    }

}
