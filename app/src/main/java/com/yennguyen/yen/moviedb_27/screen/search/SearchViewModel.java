package com.yennguyen.yen.moviedb_27.screen.search;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.support.v7.widget.SearchView;

import com.yennguyen.yen.moviedb_27.BuildConfig;
import com.yennguyen.yen.moviedb_27.data.model.MoviesResult;
import com.yennguyen.yen.moviedb_27.data.repository.MovieRepository;
import com.yennguyen.yen.moviedb_27.screen.movie.MovieAdapter;
import com.yennguyen.yen.moviedb_27.utils.Constants;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SearchViewModel extends BaseObservable {
    public ObservableBoolean mIsLoading = new ObservableBoolean();
    private MovieAdapter mAdapter;
    private MovieRepository mRepository;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private int mPage = 1;
    private String mTextSearch;

    public SearchViewModel(MovieRepository repository) {
        mAdapter = new MovieAdapter();
        mRepository = repository;
    }

    public void setUpSearch(SearchView searchView) {
        mIsLoading.set(true);
        RxSearchObservable.fromView(searchView)
                .debounce(Constants.TIME_OUT, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .filter(text -> {
                    if(text.isEmpty()) return false;
                    else return true;
                })
                .distinctUntilChanged()
                .subscribe(result -> {
                   searchMovieByTitle(result);
                   mTextSearch = result;
                   mIsLoading.set(false);
                });
    }

    public void searchMovieByTitle(String title) {
        mIsLoading.set(true);
        Disposable disposable = mRepository.searchMoviesByTitle(BuildConfig.API_KEY, title, mPage)
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

                    }
                });
        mCompositeDisposable.add(disposable);
    }

    public MovieAdapter getAdapter() {
        return mAdapter;
    }

    public void onLoadMore(){
        mIsLoading.set(false);
        mPage++;
        searchMovieByTitle(mTextSearch);
    }
}
