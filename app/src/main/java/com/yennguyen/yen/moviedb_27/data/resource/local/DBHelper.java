package com.yennguyen.yen.moviedb_27.data.resource.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "moviedb";
    public static final String TABLE_NAME = "movie";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_BACKDROP_PATH = "backdrop_path";
    public static final String COLUMN_OVERVIEW = "overview";
    public static final String COLUMN_POSTER_PATH = "poster_path";
    public static final String COLUMN_RELEASE_DATE = "release_date";
    public static final String COLUMN_REVENUE = "revenue";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_VOTE_AVERAGE = "vote_average";
    public static final String COLUMN_VOTE_COUNT = "vote_count";
    public static final int VERSION = 1;
    private static DBHelper sIntance;

    private static final String QUERY_CREATE_MOVIE_ENTRY = "CREATE TABLE " + TABLE_NAME + " ( "
            + COLUMN_ID + " INTEGER NOT NULL, "
            + COLUMN_BACKDROP_PATH + " TEXT, "
            + COLUMN_OVERVIEW + "TEXT, "
            + COLUMN_POSTER_PATH + " TEXT, "
            + COLUMN_RELEASE_DATE + "TEXT ,"
            + COLUMN_REVENUE + "TEXT, "
            + COLUMN_TITLE + "TEXT, "
            + COLUMN_VOTE_AVERAGE + "FLOAT"
            + COLUMN_VOTE_COUNT + "FLOAT )";

    public static DBHelper getInstance(Context context) {
        if (sIntance == null) {
            sIntance = new DBHelper(context);
        }
        return sIntance;
    }

    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY_CREATE_MOVIE_ENTRY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
