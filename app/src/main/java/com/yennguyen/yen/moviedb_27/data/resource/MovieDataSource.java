package com.yennguyen.yen.moviedb_27.data.resource;

import android.databinding.ObservableField;

import com.yennguyen.yen.moviedb_27.data.model.Cast;
import com.yennguyen.yen.moviedb_27.data.model.CastsResult;
import com.yennguyen.yen.moviedb_27.data.model.GenresResult;
import com.yennguyen.yen.moviedb_27.data.model.Movie;
import com.yennguyen.yen.moviedb_27.data.model.MovieDetail;
import com.yennguyen.yen.moviedb_27.data.model.MoviesResult;
import com.yennguyen.yen.moviedb_27.data.model.TrailerMoviesResult;

import java.util.List;

import io.reactivex.Observable;

public interface MovieDataSource {
    interface LocalDataSource {
        Movie getMovieLocal(int id);

        List<Movie> getMoviesLocal();

        boolean addMovie(Movie movie);

        boolean deleteMovie(Movie movie);

        boolean isFavorite(Movie movie);
    }

    interface RemoteDataSource {
        Observable<MoviesResult> getMoviesOfCategories(String type, String api_key, int page);

        Observable<GenresResult> getGenres(String api_key);

        Observable<Movie> getMovie(String api_key);

        Observable<MovieDetail> getMovieDetail(String api_key, int movieId);

        Observable<MoviesResult> getMoviesByGenre(String api_key, int genreId, int page);

        Observable<MoviesResult> getMoviesByCast(String api_key, int castId, int page);

        Observable<MoviesResult> getMoviesByCompany (String api_key, int companyId, int page);

        Observable<MoviesResult> searchMoviesByTitle(String api_key, String title, int page);

        Observable<MoviesResult> searchMoviesByGenre(String api_key, int genreId, int page);

        Observable<MoviesResult> getMoviesRecommend(String api_key, int page);

        Observable<TrailerMoviesResult> getTrailers(String api_key);

        Observable<Cast> getCasts(String api_key);

        Observable<CastsResult> getCastsOfMovie(String api_key);
    }
}
