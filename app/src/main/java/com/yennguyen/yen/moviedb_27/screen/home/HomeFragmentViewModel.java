package com.yennguyen.yen.moviedb_27.screen.home;

import android.content.Context;
import android.databinding.ObservableField;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.yennguyen.yen.moviedb_27.BaseViewModel;
import com.yennguyen.yen.moviedb_27.data.repository.MovieRepository;
import com.yennguyen.yen.moviedb_27.utils.Constants;


public class HomeFragmentViewModel extends BaseViewModel {
    private static final int POST_DELAY = 5000;
    private FragmentManager mFragmentManager;
    private MovieRepository mMovieRepository;
    private Runnable mRunnable;
    private Handler mHandler = new Handler();

    public HomeFragmentViewModel(MovieRepository movieRepository) {
        mMovieRepository = movieRepository;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

}
