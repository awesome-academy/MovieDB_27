package com.yennguyen.yen.moviedb_27.screen.home;

import android.support.v4.app.Fragment;

public class HomeFragment extends Fragment {
    private static HomeFragment sInstance;

    public static HomeFragment newInStance(){
        sInstance = new HomeFragment();
        return sInstance;
    }
}
