package com.yennguyen.yen.moviedb_27.screen.movie;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yennguyen.yen.moviedb_27.R;
import com.yennguyen.yen.moviedb_27.data.model.Genre;
import com.yennguyen.yen.moviedb_27.data.repository.MovieRepository;
import com.yennguyen.yen.moviedb_27.data.resource.local.MovieLocalDataSource;
import com.yennguyen.yen.moviedb_27.data.resource.remote.MovieRemoteDataSource;
import com.yennguyen.yen.moviedb_27.databinding.ActivityGenreBinding;
import com.yennguyen.yen.moviedb_27.utils.Constants;

public class MovieActivity extends AppCompatActivity {
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
        Genre genre = (Genre) getIntent().getSerializableExtra(Constants.EXTRA_GENRE);
        mMovieViewModel.getMoviesByGenre(genre.getId());
        getSupportActionBar().setTitle(genre.getName());
    }
}
