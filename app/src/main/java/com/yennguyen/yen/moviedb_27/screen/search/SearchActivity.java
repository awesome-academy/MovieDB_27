package com.yennguyen.yen.moviedb_27.screen.search;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yennguyen.yen.moviedb_27.R;
import com.yennguyen.yen.moviedb_27.data.model.Movie;
import com.yennguyen.yen.moviedb_27.data.repository.MovieRepository;
import com.yennguyen.yen.moviedb_27.data.resource.local.MovieLocalDataSource;
import com.yennguyen.yen.moviedb_27.data.resource.remote.MovieRemoteDataSource;
import com.yennguyen.yen.moviedb_27.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivitySearchBinding mBinding;
    private SearchViewModel mViewModel;
    private MovieRepository mRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        mRepository = MovieRepository.getInstants(MovieLocalDataSource.getInstance(this),
                MovieRemoteDataSource.getInstance(this));
        mViewModel = new SearchViewModel(mRepository);
        mViewModel.setUpSearch(mBinding.searchView);
        mBinding.setViewModel(mViewModel);
        setToolBar();
    }
    public void setToolBar(){
        setSupportActionBar(mBinding.toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mBinding.toolbar.setNavigationOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
