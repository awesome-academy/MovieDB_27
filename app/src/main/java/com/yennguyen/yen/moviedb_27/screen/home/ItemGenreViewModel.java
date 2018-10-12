package com.yennguyen.yen.moviedb_27.screen.home;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;

import com.yennguyen.yen.moviedb_27.data.model.Genre;
import com.yennguyen.yen.moviedb_27.screen.movie.MovieActivity;
import com.yennguyen.yen.moviedb_27.utils.Constants;

public class ItemGenreViewModel extends BaseObservable {
    public ObservableField<Genre> mGenreObservableField = new ObservableField<>();
    private GenreAdapter.ItemClickListener mListener;

    public ItemGenreViewModel(GenreAdapter.ItemClickListener listener){
        mListener = listener;
    }

    public void setGenre(Genre genre){
        mGenreObservableField.set(genre);
    }


    public static Intent getMoviesIntent (Context context, Genre genre){
        Intent intent = new Intent(context, MovieActivity.class);
        intent.putExtra(Constants.EXTRA_GENRE, genre);
        return intent;
    }
    public void onItemClick(View view) {
        if(mGenreObservableField == null) return;
        view.getContext().startActivity(getMoviesIntent(view.getContext(), mGenreObservableField.get()));
        mListener.onItemClick(mGenreObservableField.get());
    }
}
