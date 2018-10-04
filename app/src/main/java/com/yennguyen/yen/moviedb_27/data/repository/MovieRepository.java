package com.yennguyen.yen.moviedb_27.data.repository;

import com.yennguyen.yen.moviedb_27.data.model.Cast;
import com.yennguyen.yen.moviedb_27.data.model.CastsResult;
import com.yennguyen.yen.moviedb_27.data.model.GenresResult;
import com.yennguyen.yen.moviedb_27.data.model.Movie;
import com.yennguyen.yen.moviedb_27.data.model.MoviesResult;
import com.yennguyen.yen.moviedb_27.data.model.TrailerMoviesResult;
import com.yennguyen.yen.moviedb_27.data.resource.MovieDataSource;

import java.util.List;

import io.reactivex.Observable;

public class MovieRepository implements MovieDataSource.LocalDataSource, MovieDataSource.RemoteDataSource {
    private static MovieRepository sInstants;
    private MovieDataSource.LocalDataSource mLocalDataSource;
    private MovieDataSource.RemoteDataSource mRemoteDataSource;

    private MovieRepository(MovieDataSource.LocalDataSource localDataSource,
                            MovieDataSource.RemoteDataSource remoteDataSource) {
        mLocalDataSource = localDataSource;
        mRemoteDataSource = remoteDataSource;
    }

    public static MovieRepository getInstants(MovieDataSource.LocalDataSource localDataSource,
                                              MovieDataSource.RemoteDataSource remoteDataSource) {
        if (sInstants == null) {
            sInstants = new MovieRepository(localDataSource, remoteDataSource);
        }
        return sInstants;
    }

    @Override
    public Movie getMovieLocal(int id) {
        return mLocalDataSource.getMovieLocal(id);
    }

    @Override
    public List<Movie> getMoviesLocal() {
        return mLocalDataSource.getMoviesLocal();
    }

    @Override
    public boolean addMovie(Movie movie) {
        return mLocalDataSource.addMovie(movie);
    }

    @Override
    public boolean deleteMovie(Movie movie) {
        return mLocalDataSource.deleteMovie(movie);
    }

    @Override
    public boolean isFavorite(Movie movie) {
        return mLocalDataSource.isFavorite(movie);
    }

    @Override
    public Observable<MoviesResult> getMoviesOfCategories(String type, String api_key, int page) {
        return mRemoteDataSource.getMoviesOfCategories(type, api_key, page);
    }

    @Override
    public Observable<GenresResult> getGenres(String api_key) {
        return mRemoteDataSource.getGenres(api_key);
    }

    @Override
    public Observable<Movie> getMovie(String api_key) {
        return mRemoteDataSource.getMovie(api_key);
    }

    @Override
    public Observable<MoviesResult> getMoviesByGenre(String api_key, int genreId, int page) {
        return mRemoteDataSource.getMoviesByGenre(api_key, genreId, page);
    }

    @Override
    public Observable<MoviesResult> getMoviesByCast(String api_key, int castId, int page) {
        return mRemoteDataSource.getMoviesByCast(api_key, castId, page);
    }

    @Override
    public Observable<MoviesResult> searchMoviesByTitle(String api_key, String title, int page) {
        return mRemoteDataSource.searchMoviesByTitle(api_key, title, page);
    }

    @Override

    public Observable<MoviesResult> searchMoviesByGenre(String api_key, int genreId, int page) {
        return mRemoteDataSource.searchMoviesByGenre(api_key, genreId, page);
    }

    @Override
    public Observable<MoviesResult> getMoviesRecommend(String api_key, int page) {
        return mRemoteDataSource.getMoviesRecommend(api_key, page);
    }

    @Override
    public Observable<TrailerMoviesResult> getTrailers(String api_key) {
        return mRemoteDataSource.getTrailers(api_key);
    }

    @Override
    public Observable<Cast> getCasts(String api_key) {
        return mRemoteDataSource.getCasts(api_key);
    }

    @Override
    public Observable<CastsResult> getCastsOfMovie(String api_key) {
        return mRemoteDataSource.getCastsOfMovie(api_key);
    }
}
