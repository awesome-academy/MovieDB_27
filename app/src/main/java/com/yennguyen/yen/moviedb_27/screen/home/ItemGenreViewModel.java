package com.yennguyen.yen.moviedb_27.screen.home;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;

import com.yennguyen.yen.moviedb_27.data.model.Genre;

public class ItemGenreViewModel extends BaseObservable {
    public ObservableField<Genre> mGenreObservableField = new ObservableField<>();
    private GenreAdapter.ItemClickListener mListener;

    public ItemGenreViewModel(GenreAdapter.ItemClickListener listener){
        mListener = listener;
    }

    public void setGenre(Genre genre){
        mGenreObservableField.set(genre);
    }

    public void onItemClick(View view) {

    }
}
