package com.yennguyen.yen.moviedb_27.screen.movie_detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;

import com.yennguyen.yen.moviedb_27.data.model.TrailerMovie;
import com.yennguyen.yen.moviedb_27.screen.trailer.TrailerActivity;
import com.yennguyen.yen.moviedb_27.utils.Constants;

public class ItemTrailerViewModel extends BaseObservable {
    public ObservableField<TrailerMovie> mTrailerMovieObservableField = new ObservableField<>();
    private TrailerAdapter.setOnItemClick mListener;

    public ItemTrailerViewModel(TrailerAdapter.setOnItemClick listener) {
        mListener = listener;
    }

    public void setTrailer(TrailerMovie trailer) {
        mTrailerMovieObservableField.set(trailer);
    }
    public void onItemClick(View view){
        view.getContext().startActivity(getIntent(view.getContext(), mTrailerMovieObservableField.get()));
    }
    public static Intent getIntent(Context context, TrailerMovie trailerMovie){
        Intent intent = new Intent(context, TrailerActivity.class);
        intent.putExtra(Constants.EXTRA_TRAILER, trailerMovie);
        return intent;
    }
}
