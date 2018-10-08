package com.yennguyen.yen.moviedb_27.screen.favorite;

import android.support.v4.app.Fragment;

import com.yennguyen.yen.moviedb_27.data.model.Movie;

import java.util.List;

public class FavoriteFragment extends Fragment {
    private static FavoriteFragment sFavoriteFragment;
    private List<Movie> mMovies;

    public static FavoriteFragment newInstance(List<Movie> movies) {
        sFavoriteFragment = new FavoriteFragment();
        return sFavoriteFragment;
    }
}
