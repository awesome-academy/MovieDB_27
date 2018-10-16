package com.yennguyen.yen.moviedb_27.screen.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.yennguyen.yen.moviedb_27.R;
import com.yennguyen.yen.moviedb_27.databinding.ActivityMainBinding;
import com.yennguyen.yen.moviedb_27.screen.search.SearchActivity;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        this.startActivity(getIntent(this));
        return true;
    }

    public static Intent getIntent(Context context){
        Intent intent = new Intent(context, SearchActivity.class);
        return intent;
    }
}
