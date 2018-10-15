package com.yennguyen.yen.moviedb_27.screen.movie_detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yennguyen.yen.moviedb_27.R;
import com.yennguyen.yen.moviedb_27.data.model.Movie;
import com.yennguyen.yen.moviedb_27.data.repository.MovieRepository;
import com.yennguyen.yen.moviedb_27.data.resource.local.MovieLocalDataSource;
import com.yennguyen.yen.moviedb_27.data.resource.remote.MovieRemoteDataSource;
import com.yennguyen.yen.moviedb_27.databinding.ActivityMovieDetailBinding;
import com.yennguyen.yen.moviedb_27.utils.Constants;


public class MovieDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMovieDetailBinding mBinding;
    private MovieDetailViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail);
        MovieRepository repository = MovieRepository.getInstants(MovieLocalDataSource.getInstance(this),
                MovieRemoteDataSource.getInstance(this));
        mViewModel = new MovieDetailViewModel(this, repository);
        Movie movie = (Movie) getIntent().getSerializableExtra(Constants.EXTRA_MOVIE);
        mViewModel.setMovie(movie);
        mViewModel.getMovieDetail(movie.getId());
        mBinding.setViewModel(mViewModel);
        setToolBar(movie);
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    public void setToolBar(Movie movie){
        setSupportActionBar(mBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(movie.getTitle());
        mBinding.toolbar.setNavigationOnClickListener(this);
    }
}
