package com.yennguyen.yen.moviedb_27.screen.home;

import com.yennguyen.yen.moviedb_27.BuildConfig;
import com.yennguyen.yen.moviedb_27.data.model.Genre;
import com.yennguyen.yen.moviedb_27.data.model.GenresResult;
import com.yennguyen.yen.moviedb_27.data.repository.MovieRepository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class HomeFragmentViewModel implements GenreAdapter.ItemClickListener {
    private GenreAdapter mAdapter;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private MovieRepository mMovieRepository;

    public HomeFragmentViewModel(MovieRepository movieRepository) {
        mMovieRepository = movieRepository;
        mAdapter = new GenreAdapter();
        mAdapter.setItemClickListener(this);
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
    public GenreAdapter getAdapter(){
        return mAdapter;
    }

}
