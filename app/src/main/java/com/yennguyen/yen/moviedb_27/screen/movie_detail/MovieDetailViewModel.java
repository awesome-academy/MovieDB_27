package com.yennguyen.yen.moviedb_27.screen.movie_detail;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.yennguyen.yen.moviedb_27.BuildConfig;
import com.yennguyen.yen.moviedb_27.data.model.Movie;
import com.yennguyen.yen.moviedb_27.data.model.MovieDetail;
import com.yennguyen.yen.moviedb_27.data.model.TrailerMovie;
import com.yennguyen.yen.moviedb_27.data.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MovieDetailViewModel extends BaseObservable implements TrailerAdapter.setOnItemClick {
    public ObservableField<Movie> mMovieObservableField = new ObservableField<>();
    public ObservableField<MovieDetail> mMovieDetailObservableField = new ObservableField<>();
    private TrailerAdapter mTrailerAdapter;
    private CastAdapter mCastAdapter;
    private CompanyAdapter mCompanyAdapter;
    private MovieRepository mRepository;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private Context mContext;
    private List<TrailerMovie> mTrailerMovies;

    public MovieDetailViewModel(Context context, MovieRepository repository) {
        mContext = context;
        mTrailerMovies = new ArrayList<>();
        mRepository = repository;
        mTrailerAdapter = new TrailerAdapter();
        mCastAdapter = new CastAdapter();
        mCompanyAdapter = new CompanyAdapter();
    }

    public void setMovie(Movie movie) {
        mMovieObservableField.set(movie);
    }

    public TrailerAdapter getTrailerAdapter() {
        return mTrailerAdapter;
    }

    public CastAdapter getCastAdapter() {
        return mCastAdapter;
    }

    public CompanyAdapter getCompanyAdapter(){
        return mCompanyAdapter;
    }

    public void getMovieDetail(int id) {
        Disposable disposable = mRepository.getMovieDetail(BuildConfig.API_KEY, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieDetail>() {
                    @Override
                    public void accept(MovieDetail movieDetail) throws Exception {
                        mTrailerAdapter.addTrailer(movieDetail.getTrailerMovieResult().getTrailerMovies());
                        mCastAdapter.addCast(movieDetail.getCastResult().getCasts());
                        mCompanyAdapter.getCompany(movieDetail.getCompanies());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onItemClick(TrailerMovie trailerMovie) {

    }
}
