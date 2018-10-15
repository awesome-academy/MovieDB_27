package com.yennguyen.yen.moviedb_27.screen.movie;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;

import com.yennguyen.yen.moviedb_27.data.model.Movie;
import com.yennguyen.yen.moviedb_27.screen.movie_detail.MovieDetailActivity;
import com.yennguyen.yen.moviedb_27.utils.Constants;

public class ItemMovieViewModel extends BaseObservable {
    public ObservableField<Movie> mMovieObservableField = new ObservableField<>();
    private MovieAdapter.setFavoriteClickListener mFavoriteListener;
    private MovieAdapter.setOnClickListener mListener;

    public ItemMovieViewModel(MovieAdapter.setOnClickListener listener,
                              MovieAdapter.setFavoriteClickListener favoriteListener) {
        mListener = listener;
        mFavoriteListener = favoriteListener;
    }

    public void setMovies(Movie movie) {
        mMovieObservableField.set(movie);
    }

    public void onItemMovieClick(View view) {
        Intent intent = getIntent(view.getContext(), mMovieObservableField.get());
        view.getContext().startActivity(intent);
    }

    public static Intent getIntent(Context context, Movie movie) {
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(Constants.EXTRA_MOVIE, movie);
        return intent;
    }
}
