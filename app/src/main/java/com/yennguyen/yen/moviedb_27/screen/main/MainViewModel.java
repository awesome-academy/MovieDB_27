package com.yennguyen.yen.moviedb_27.screen.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.yennguyen.yen.moviedb_27.R;
import com.yennguyen.yen.moviedb_27.data.model.Movie;
import com.yennguyen.yen.moviedb_27.data.repository.MovieRepository;
import com.yennguyen.yen.moviedb_27.data.resource.local.MovieLocalDataSource;
import com.yennguyen.yen.moviedb_27.data.resource.remote.MovieRemoteDataSource;
import com.yennguyen.yen.moviedb_27.screen.favorite.FavoriteFragment;
import com.yennguyen.yen.moviedb_27.screen.home.HomeFragment;
import com.yennguyen.yen.moviedb_27.screen.setting.SettingFragment;

import java.util.List;

public class MainViewModel implements BottomNavigationView.OnNavigationItemSelectedListener {
    private FragmentManager mFragmentManager;
    private HomeFragment mHomeFragment;
    private FavoriteFragment mFavoriteFragment;
    private SettingFragment mSettingFragment;
    private Fragment mCurrentFragment;

    public MainViewModel (AppCompatActivity appCompatActivity){
        List<Movie> movies = MovieRepository.getInstants(MovieLocalDataSource.getInstance(appCompatActivity),
                MovieRemoteDataSource.getInstance()).getMoviesLocal();
        mHomeFragment = HomeFragment.newInStance();
        mFavoriteFragment = FavoriteFragment.newInstance(movies);
        mSettingFragment = SettingFragment.newInstance();
        mCurrentFragment = mHomeFragment;
        mFragmentManager = appCompatActivity.getSupportFragmentManager();
        mFragmentManager.beginTransaction().add(R.id.frame_container, mHomeFragment)
                .add(R.id.frame_container, mFavoriteFragment)
                .add(R.id.frame_container, mSettingFragment)
                .show(mHomeFragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_home :
                showfragment(mHomeFragment, mCurrentFragment);
                mCurrentFragment = mHomeFragment;
                return true;
            case R.id.navigation_favorite :
                showfragment(mFavoriteFragment, mCurrentFragment);
                mCurrentFragment = mFavoriteFragment;
                return true;
            case R.id.navigation_setting :
                showfragment(mSettingFragment, mCurrentFragment);
                mCurrentFragment = mSettingFragment;
        }
        return false;
    }
    private void showfragment(Fragment fragmentShow, Fragment fragmentHide){
        mFragmentManager.beginTransaction().hide(fragmentHide).show(fragmentShow);
    }
}
