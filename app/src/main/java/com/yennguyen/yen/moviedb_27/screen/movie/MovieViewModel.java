package com.yennguyen.yen.moviedb_27.screen.movie;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;

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
    public ObservableBoolean mIsLoading = new ObservableBoolean();
    private MovieAdapter mAdapter;
    private MovieRepository mRepository;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private int mId;
    private int mPage = 1;
    private int mTotalPage = 0;
    private String mType;

    public MovieViewModel(MovieRepository repository) {
        mIsLoading.set(true);
        mRepository = repository;
        mAdapter = new MovieAdapter();
        mAdapter.setListener(this);
        mAdapter.setFavoriteListener(this);
        getMoviesByGenre(mId);
    }

    public void getMoviesByGenre(int id) {
        mIsLoading.set(true);
        mId = id;
        Disposable disposable = mRepository.getMoviesByGenre(BuildConfig.API_KEY, id, mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MoviesResult>() {
                    @Override
                    public void accept(MoviesResult moviesResult) throws Exception {
                        mAdapter.addMovie(moviesResult.getMovies());
                        mIsLoading.set(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mIsLoading.set(true);
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    public void getMoviesByCategory(String type) {
        mIsLoading.set(true);
        mType = type;
        Disposable disposable = mRepository.getMoviesOfCategories(type, BuildConfig.API_KEY, mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MoviesResult>() {
                    @Override
                    public void accept(MoviesResult moviesResult) throws Exception {
                        mAdapter.addMovie(moviesResult.getMovies());
                        mIsLoading.set(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mIsLoading.set(true);
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    public void getMoviesByCast(int id) {
        mIsLoading.set(true);
        mId = id;
        Disposable disposable = mRepository.getMoviesByCast(BuildConfig.API_KEY, id, mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MoviesResult>() {
                    @Override
                    public void accept(MoviesResult moviesResult) throws Exception {
                        mAdapter.addMovie(moviesResult.getMovies());
                        mIsLoading.set(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mIsLoading.set(true);
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    public void getMoviesByCompany(int id) {
        mIsLoading.set(true);
        mId = id;
        Disposable disposable = mRepository.getMoviesByCompany(BuildConfig.API_KEY, id, mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MoviesResult>() {
                    @Override
                    public void accept(MoviesResult moviesResult) throws Exception {
                        mAdapter.addMovie(moviesResult.getMovies());
                        mIsLoading.set(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mIsLoading.set(true);
                    }
                });
        mCompositeDisposable.add(disposable);
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

    public void onLoadMore() {
        mIsLoading.set(true);
        ++mPage;
        getMoviesByCategory(mType);
        getMoviesByGenre(mId);
        getMoviesByCast(mId);
        getMoviesByCompany(mId);
    }
}
