package com.yennguyen.yen.moviedb_27.data.resource.local;

import com.yennguyen.yen.moviedb_27.data.model.Movie;

import java.util.List;

public interface MovieDao {
    Movie getMovie();
    List<Movie> getMovies ();
    boolean addMovie(Movie movie);
    boolean deleteMovie(Movie movie);
    boolean addToFavorite(Movie movie);
}
