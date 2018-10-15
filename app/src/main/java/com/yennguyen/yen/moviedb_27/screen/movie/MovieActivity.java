package com.yennguyen.yen.moviedb_27.screen.movie;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yennguyen.yen.moviedb_27.R;
import com.yennguyen.yen.moviedb_27.data.model.Cast;
import com.yennguyen.yen.moviedb_27.data.model.Category;
import com.yennguyen.yen.moviedb_27.data.model.Genre;
import com.yennguyen.yen.moviedb_27.data.repository.MovieRepository;
import com.yennguyen.yen.moviedb_27.data.resource.local.MovieLocalDataSource;
import com.yennguyen.yen.moviedb_27.data.resource.remote.MovieRemoteDataSource;
import com.yennguyen.yen.moviedb_27.databinding.ActivityGenreBinding;
import com.yennguyen.yen.moviedb_27.utils.Constants;

public class MovieActivity extends AppCompatActivity implements View.OnClickListener {
    private MovieRepository mMovieRepository;
    private MovieViewModel mMovieViewModel;
    private ActivityGenreBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_genre);
        mMovieRepository = MovieRepository.getInstants(MovieLocalDataSource.getInstance(this),
                MovieRemoteDataSource.getInstance(this));
        mMovieViewModel = new MovieViewModel(mMovieRepository);
        mBinding.setViewModel(mMovieViewModel);
        setSupportActionBar(mBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mBinding.toolbar.setNavigationOnClickListener(this);
        handleEvent();
    }

    private void handleEvent() {
        if (getIntent().hasExtra(Constants.EXTRA_CATEGORY)) {
            Category category = (Category) getIntent().getSerializableExtra(Constants.EXTRA_CATEGORY);
            getSupportActionBar().setTitle(category.getName());
            mMovieViewModel.getMoviesByCategory(category.getKey());
        } else if (getIntent().hasExtra(Constants.EXTRA_GENRE)) {
            Genre genre = (Genre) getIntent().getSerializableExtra(Constants.EXTRA_GENRE);
            mMovieViewModel.getMoviesByGenre(genre.getId());
            getSupportActionBar().setTitle(genre.getName());
        }else if(getIntent().hasExtra(Constants.EXTRA_CAST)){
            Cast cast = (Cast) getIntent().getSerializableExtra(Constants.EXTRA_CAST);
            mMovieViewModel.getMoviesByCast(cast.getId());
            getSupportActionBar().setTitle(cast.getName());
        }
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
