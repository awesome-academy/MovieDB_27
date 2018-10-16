package com.yennguyen.yen.moviedb_27.data.resource.remote.service;

import com.yennguyen.yen.moviedb_27.data.model.Cast;
import com.yennguyen.yen.moviedb_27.data.model.CastsResult;
import com.yennguyen.yen.moviedb_27.data.model.GenresResult;
import com.yennguyen.yen.moviedb_27.data.model.Movie;
import com.yennguyen.yen.moviedb_27.data.model.MovieDetail;
import com.yennguyen.yen.moviedb_27.data.model.MoviesResult;
import com.yennguyen.yen.moviedb_27.data.model.TrailerMoviesResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieAPI {
    @GET("movie/{type}")
    Observable<MoviesResult> getMoviesOfCategories(@Path("type") String type,
                                                   @Query("api_key") String api_key,
                                                   @Query("page") int page);

    @GET("genre/movie/list")
    Observable<GenresResult> getGenre(@Query("api_key") String api_key);

    @GET("movie/{id}")
    Observable<Movie> getMovie(@Query("api_key") String api_key);

    @GET("movie/{id}")
    Observable<MovieDetail> getMovieDetail(@Path("id") int id,
                                           @Query("api_key") String api_key,
                                           @Query("append_to_response") String append);

    @GET("discover/movie")
    Observable<MoviesResult> getMoviesByGenre(@Query("api_key") String api_key,
                                              @Query("with_genres") int genreId,
                                              @Query("page") int page);

    @GET("discover/movie")
    Observable<MoviesResult> getMoviesByCast(@Query("api_key") String api_key,
                                             @Query("with_cast") int castId,
                                             @Query("page") int page);
    @GET("discover/movie")
    Observable<MoviesResult> getMoviesByCompany(@Query("api_key") String api_key,
                                             @Query("with_company") int companyId,
                                             @Query("page") int page);

    @GET("search/movie")
    Observable<MoviesResult> searchMoviesbyTitle(@Query("api_key") String api_key,
                                                 @Query("query") String title,
                                                 @Query("page") int page);

    @GET("search/movie")
    Observable<MoviesResult> searchMoviesbyGenre(@Query("api_key") String api_key,
                                                 @Query("with_genre") int genreId,
                                                 @Query("page") int page);

    @GET("movie/{movie_id}/recommendations")
    Observable<MoviesResult> getMoviesRecommend(@Query("api_key") String api_key,
                                                @Query("page") int page);

    @GET("movie/{movie_id}/videos")
    Observable<TrailerMoviesResult> getTrailers(@Query("api_key") String api_key);

    @GET("person/{person_id}")
    Observable<Cast> getCasts(@Query("api_key") String api_key);

    @GET("movie/{movie_id}/credits")
    Observable<CastsResult> getCastsOfMovie(@Query("api_key") String api_key);

}
