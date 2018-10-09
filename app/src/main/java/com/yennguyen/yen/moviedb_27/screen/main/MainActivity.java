package com.yennguyen.yen.moviedb_27.screen.main;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.yennguyen.yen.moviedb_27.databinding.ActivityMainBinding;

import com.yennguyen.yen.moviedb_27.R;

public class MainActivity extends AppCompatActivity {
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainViewModel = new MainViewModel(this);
        binding.setViewModel(mMainViewModel);
        setSupportActionBar(binding.toolbar);
    }
}
