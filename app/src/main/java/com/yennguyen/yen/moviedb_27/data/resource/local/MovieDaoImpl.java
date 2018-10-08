package com.yennguyen.yen.moviedb_27.data.resource.local;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.yennguyen.yen.moviedb_27.data.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements MovieDao {
    private static DBHelper mDBHelper;
    private static MovieDaoImpl sInstance;

    private List<Movie> mMovies;

    private MovieDaoImpl(DBHelper dbHelper) {
        mDBHelper = dbHelper;
    }

    public static synchronized MovieDaoImpl getInstance(DBHelper dbHelper) {
        if (sInstance == null) {
            sInstance = new MovieDaoImpl(dbHelper);
        }
        return sInstance;
    }

    @Override
    public Movie getMovie() {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        Cursor cursor = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            cursor = db.rawQuery(mDBHelper.TABLE_NAME, selection(), null);
        }

        Movie movie = getMovieFromCursor(cursor);
        return movie;
    }

    @Override
    public List<Movie> getMovies() {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        Cursor cursor = db.query(DBHelper.TABLE_NAME, null,
                null, null, null,
                null, null);
        mMovies = new ArrayList<>();
        mMovies = getMoviesFromCursor(cursor);
        return mMovies;
    }

    @Override
    public boolean addMovie(Movie movie) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_ID, movie.getId());
        values.put(DBHelper.COLUMN_BACKDROP_PATH, movie.getBackdropPath());
        values.put(DBHelper.COLUMN_OVERVIEW, movie.getOverview());
        values.put(DBHelper.COLUMN_POSTER_PATH, movie.getPosterPath());
        values.put(DBHelper.COLUMN_REVENUE, movie.getRevenue());
        values.put(DBHelper.COLUMN_RELEASE_DATE, movie.getReleaseDate());
        values.put(DBHelper.COLUMN_TITLE, movie.getTitle());
        values.put(DBHelper.COLUMN_VOTE_COUNT, movie.getVoteCount());
        values.put(DBHelper.COLUMN_VOTE_AVERAGE, movie.getVoteAverage());
        db.insert(DBHelper.TABLE_NAME, null, values);
        return true;
    }

    @Override
    public boolean deleteMovie(Movie movie) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();
        db.delete(DBHelper.TABLE_NAME, DBHelper.COLUMN_ID + "=?",
                new String[]{String.valueOf(movie.getId())});
        return true;
    }

    @Override
    public boolean addToFavorite(Movie movie) {
        return false;
    }

    private List<Movie> getMoviesFromCursor(Cursor cursor) {
        List<Movie> movies = new ArrayList<>();
        if(cursor == null) return movies;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Movie movie = getMovieFromCursor(cursor);
            movies.add(movie);
        }
        cursor.close();
        return movies;
    }

    private Movie getMovieFromCursor(Cursor cursor) {
        Movie movie = new Movie();
        movie.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_ID)));
        movie.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_BACKDROP_PATH)));
        movie.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_OVERVIEW)));
        movie.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_TITLE)));
        movie.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_RELEASE_DATE)));
        movie.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_REVENUE)));
        movie.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_VOTE_AVERAGE)));
        movie.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_VOTE_COUNT)));
        movie.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.COLUMN_POSTER_PATH)));
        return movie;
    }

    private String[] selection() {
        return new String[]{
                DBHelper.COLUMN_ID,
                DBHelper.COLUMN_TITLE,
                DBHelper.COLUMN_OVERVIEW,
                DBHelper.COLUMN_VOTE_COUNT,
                DBHelper.COLUMN_VOTE_AVERAGE,
                DBHelper.COLUMN_REVENUE,
                DBHelper.COLUMN_RELEASE_DATE,
                DBHelper.COLUMN_POSTER_PATH,
                DBHelper.COLUMN_BACKDROP_PATH,
        };
    }
}
