package com.yennguyen.yen.moviedb_27.utils;

import android.databinding.BindingAdapter;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.RecyclerView;

public class BindingUtils {
    @BindingAdapter("onNavigationItemSelected")
    public static void setOnNavigationItemSelectedListener(
            BottomNavigationView view,
            BottomNavigationView.OnNavigationItemSelectedListener listener){
        view.setOnNavigationItemSelectedListener(listener);
    }
    @BindingAdapter("recyclerAdapter")
    public static void setAdapterForRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter){
        recyclerView.setAdapter(adapter);
    }
}
