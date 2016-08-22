package com.example.pawan.rs_application;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.content.Context;
import android.view.GestureDetector;
import android.view.View;

/**
 * Created by Pawan on 22-Aug-16.
 */
public class R_ItemClickListener implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mlistener;

    public interface OnItemClickListener {

        public void onItemClick(View view, int position);

        public void onLongItemClick(View view, int position);
    }

    GestureDetector mgesturedetector;

    public R_ItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
        mlistener = listener;
        mgesturedetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && mlistener != null) {
                    mlistener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
                }
            }
        });

}

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View childView = rv.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mlistener != null && mgesturedetector.onTouchEvent(e)) {
            mlistener.onItemClick(childView, rv.getChildAdapterPosition(childView));
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {}

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) { }
}
