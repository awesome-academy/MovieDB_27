package com.yennguyen.yen.moviedb_27.screen.movie;

import android.databinding.BaseObservable;

import com.yennguyen.yen.moviedb_27.BuildConfig;
import com.yennguyen.yen.moviedb_27.data.model.Movie;
import com.yennguyen.yen.moviedb_27.data.model.MoviesResult;
import com.yennguyen.yen.moviedb_27.data.repository.MovieRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MovieViewModel extends BaseObservable implements MovieAdapter.setOnClickListener,
        MovieAdapter.setFavoriteClickListener {
    private MovieAdapter mAdapter;
    private MovieRepository mRepository;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private int mId;
    private int mPage = 1;

    public MovieViewModel(MovieRepository repository) {
        mRepository = repository;
        mAdapter = new MovieAdapter();
        mAdapter.setListener(this);
        mAdapter.setFavoriteListener(this);
        getMoviesByGenre(mId);
    }

    public void getMoviesByGenre(int id) {
        mId = id;
        Disposable disposable = mRepository.getMoviesByGenre(BuildConfig.API_KEY, id, mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MoviesResult>() {
                    @Override
                    public void accept(MoviesResult moviesResult) throws Exception {
                        mAdapter.addMovie(moviesResult.getMovies());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void onItemClick(Movie movie) {

    }

    @Override
    public void onFavoriteClick(Movie movie) {

    }

    public MovieAdapter getAdapter() {
        return mAdapter;
    }
}
