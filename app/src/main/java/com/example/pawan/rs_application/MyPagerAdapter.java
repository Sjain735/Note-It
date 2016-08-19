package com.example.pawan.rs_application;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Admin on 8/6/2016.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    int count=2;

    public MyPagerAdapter (FragmentManager fm)
    {
        super(fm);
    }


    public int getCount()
    {
        return count;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch(position)
        {
            case 0: { Frag1 fm1 = new Frag1();
                return fm1; }

            case 1: { Frag2 fm2 = new Frag2();
                return fm2; }

            default: { Frag1 fm1 = new Frag1();
                return fm1; }
        }

    }

}

