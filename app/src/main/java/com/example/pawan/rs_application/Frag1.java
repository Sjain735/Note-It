package com.example.pawan.rs_application;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Admin on 8/6/2016.
 */
public class Frag1 extends Fragment {

    public Frag1()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup Container, Bundle SavedInstanceState)
    {
        View V= inflater.inflate(R.layout.frag1,Container, false);
        TextView textview = (TextView) V.findViewById(R.id.frag1_text1);
        textview.setText("Fragment 1");
        return V;

    }

}

