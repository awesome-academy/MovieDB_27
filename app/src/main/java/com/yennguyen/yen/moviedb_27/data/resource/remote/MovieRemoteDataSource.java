package com.yennguyen.yen.moviedb_27.data.resource.remote;

import com.yennguyen.yen.moviedb_27.data.model.Cast;
import com.yennguyen.yen.moviedb_27.data.model.CastsResult;
import com.yennguyen.yen.moviedb_27.data.model.GenresResult;
import com.yennguyen.yen.moviedb_27.data.model.Movie;
import com.yennguyen.yen.moviedb_27.data.model.MoviesResult;
import com.yennguyen.yen.moviedb_27.data.model.TrailerMoviesResult;
import com.yennguyen.yen.moviedb_27.data.resource.MovieDataSource;
import com.yennguyen.yen.moviedb_27.data.resource.remote.service.MovieAPI;
import com.yennguyen.yen.moviedb_27.data.resource.remote.service.MovieServiceClient;

import io.reactivex.Observable;

public class MovieRemoteDataSource implements MovieDataSource.RemoteDataSource {
    private MovieAPI mMovieAPI;
    private static MovieRemoteDataSource sMovieRemoteDataSource;

    private MovieRemoteDataSource(MovieAPI movieAPI) {
        mMovieAPI = movieAPI;
    }

    public static synchronized MovieRemoteDataSource getInstance() {
        if (sMovieRemoteDataSource == null) {
            sMovieRemoteDataSource = new MovieRemoteDataSource(MovieServiceClient.getInstance());
        }
        return sMovieRemoteDataSource;
    }

    @Override
    public Observable<MoviesResult> getMoviesOfCategories(String type, String api_key, int page) {
        return mMovieAPI.getMoviesOfCategories(type, api_key, page);
    }

    @Override
    public Observable<GenresResult> getGenres(String api_key) {
        return mMovieAPI.getGenre(api_key);
    }

    @Override
    public Observable<Movie> getMovie(String api_key) {
        return mMovieAPI.getMovie(api_key);
    }

    @Override
    public Observable<MoviesResult> getMoviesByGenre(String api_key, int genreId, int page) {
        return mMovieAPI.getMoviesByGenre(api_key, genreId, page);
    }

    @Override
    public Observable<MoviesResult> getMoviesByCast(String api_key, int castId, int page) {
        return mMovieAPI.getMoviesByCast(api_key, castId, page);
    }

    @Override
    public Observable<MoviesResult> searchMoviesByTitle(String api_key, String title, int page) {
        return mMovieAPI.searchMoviesbyTitle(api_key, title, page);
    }

    @Override
    public Observable<MoviesResult> searchMoviesByGenre(String api_key, int genreId, int page) {
        return mMovieAPI.searchMoviesbyGenre(api_key, genreId, page);
    }

    @Override
    public Observable<MoviesResult> getMoviesRecommend(String api_key, int page) {
        return null;
    }

    @Override
    public Observable<TrailerMoviesResult> getTrailers(String api_key) {
        return mMovieAPI.getTrailers(api_key);
    }

    @Override
    public Observable<Cast> getCasts(String api_key) {
        return mMovieAPI.getCasts(api_key);
    }

    @Override
    public Observable<CastsResult> getCastsOfMovie(String api_key) {
        return mMovieAPI.getCastsOfMovie(api_key);
    }
}
