package com.yennguyen.yen.moviedb_27.data.resource.local;

import android.content.Context;

import com.yennguyen.yen.moviedb_27.data.model.Movie;
import com.yennguyen.yen.moviedb_27.data.resource.MovieDataSource;

import java.util.List;

public class MovieLocalDataSource implements MovieDataSource.LocalDataSource {
    private static MovieDao mDao;
    private static MovieLocalDataSource sMovieLocalDataSource;

    private MovieLocalDataSource(MovieDao dao) {
        mDao = dao;
    }

    public static synchronized MovieLocalDataSource getInstance(Context context) {
        if (sMovieLocalDataSource == null) {
            sMovieLocalDataSource = new MovieLocalDataSource(MovieDaoImpl.getInstance(DBHelper.getInstance(context)));
        }
        return sMovieLocalDataSource;
    }

    @Override
    public Movie getMovieLocal(int id) {
        return mDao.getMovie();
    }

    @Override
    public List<Movie> getMoviesLocal() {
        return mDao.getMovies();
    }

    @Override
    public boolean addMovie(Movie movie) {
        return mDao.addMovie(movie);
    }

    @Override
    public boolean deleteMovie(Movie movie) {
        return mDao.deleteMovie(movie);
    }

    @Override
    public boolean isFavorite(Movie movie) {
        return mDao.addToFavorite(movie);
    }
}
