package com.yennguyen.yen.moviedb_27.screen.movie;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.yennguyen.yen.moviedb_27.data.model.Movie;

public class ItemMovieViewModel extends BaseObservable {
    public ObservableField<Movie> mMovieObservableField = new ObservableField<>();
    private MovieAdapter.setOnClickListener mListener;
    private MovieAdapter.setFavoriteClickListener mFavoriteListener;

    public ItemMovieViewModel(MovieAdapter.setOnClickListener listener,
                              MovieAdapter.setFavoriteClickListener favoriteListener) {
        mListener = listener;
        mFavoriteListener = favoriteListener;
    }

    public void setMovies(Movie movie) {
        mMovieObservableField.set(movie);
    }
}
