package com.yennguyen.yen.moviedb_27.screen.movie_detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;

import com.yennguyen.yen.moviedb_27.data.model.Cast;
import com.yennguyen.yen.moviedb_27.screen.movie.MovieActivity;
import com.yennguyen.yen.moviedb_27.utils.Constants;

public class ItemCastViewModel extends BaseObservable {
    public ObservableField<Cast> mCastObservableField = new ObservableField<>();
    private CastAdapter mCastAdapter;

    public ItemCastViewModel() {
        mCastAdapter = new CastAdapter();
    }

    public void setCast(Cast cast) {
        mCastObservableField.set(cast);
    }
    public void onItemClick(View view){
        view.getContext().startActivity(getIntent(view.getContext(), mCastObservableField.get()));
    }
    public static Intent getIntent(Context context, Cast cast){
        Intent intent = new Intent(context, MovieActivity.class);
        intent.putExtra(Constants.EXTRA_CAST, cast);
        return intent;
    }
}
