package com.yennguyen.yen.moviedb_27.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrailerMoviesResult {

    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("results")
    @Expose
    private List<TrailerMovie> mTrailerMovies = null;

    public int getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public List<TrailerMovie> getTrailerMovies() {
        return mTrailerMovies;
    }

    public void setTrailerMovies(List<TrailerMovie> trailerMovies) {
        mTrailerMovies = trailerMovies;
    }
}

