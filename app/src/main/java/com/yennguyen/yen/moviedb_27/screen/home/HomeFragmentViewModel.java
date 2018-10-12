package com.yennguyen.yen.moviedb_27.screen.home;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.yennguyen.yen.moviedb_27.BuildConfig;
import com.yennguyen.yen.moviedb_27.data.model.Category;
import com.yennguyen.yen.moviedb_27.data.model.Genre;
import com.yennguyen.yen.moviedb_27.data.model.GenresResult;
import com.yennguyen.yen.moviedb_27.data.repository.MovieRepository;
import com.yennguyen.yen.moviedb_27.screen.movie.MovieActivity;
import com.yennguyen.yen.moviedb_27.utils.Constants;

import io.reactivex.CompletableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomeFragmentViewModel implements GenreAdapter.ItemClickListener {
    private GenreAdapter mAdapter;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private MovieRepository mMovieRepository;
    private Category mCategory;

    public HomeFragmentViewModel(MovieRepository movieRepository) {
        mMovieRepository = movieRepository;
        mAdapter = new GenreAdapter();
        mAdapter.setItemClickListener(this);
        mCategory = new Category();
        getGenres();
    }

    private void getGenres() {
        Disposable disposable = mMovieRepository.getGenres(BuildConfig.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GenresResult>() {
                    @Override
                    public void accept(GenresResult genresResult) throws Exception {
                        mAdapter.setGenres(genresResult.getGenres());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onItemClick(Genre genre) {

    }

    public GenreAdapter getAdapter() {
        return mAdapter;
    }

    public void onPopularClick(View view) {
        setMovieCategory(Constants.KEY_POPULAR, Constants.NAME_POPULAR);
        view.getContext().startActivity(getIntent(view.getContext(), mCategory));
    }

    public void onTopRateClick(View view) {
        setMovieCategory(Constants.KEY_TOP_RATE, Constants.NAME_TOP_RATE);
        view.getContext().startActivity(getIntent(view.getContext(), mCategory));
    }

    public void onNowPlayingClick(View view) {
        setMovieCategory(Constants.KEY_NOW_PLAYING, Constants.NAME_NOW_PLAYING);
        view.getContext().startActivity(getIntent(view.getContext(), mCategory));
    }

    public void onUpComingClick(View view) {
        setMovieCategory(Constants.KEY_UP_COMING, Constants.NAME_UP_COMING);
        view.getContext().startActivity(getIntent(view.getContext(), mCategory));
    }

    public static Intent getIntent(Context context, Category category) {
        Intent intent = new Intent(context, MovieActivity.class);
        intent.putExtra(Constants.EXTRA_CATEGORY, category);
        return intent;
    }

    private void setMovieCategory(String key, String name){
        mCategory.setKey(key);
        mCategory.setName(name);
    }
}
