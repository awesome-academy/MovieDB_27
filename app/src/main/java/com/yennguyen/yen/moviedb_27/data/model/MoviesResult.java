package com.yennguyen.yen.moviedb_27.data.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResult {

    @SerializedName("total_pages")
    @Expose
    private int mTotalPages;

    @SerializedName("results")
    @Expose
    private List<Movie> mMovies = null;

    public int getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(int totalPages) {
        mTotalPages = totalPages;
    }

    public List<Movie> getMovies() {
        return mMovies;
    }

    public void setMovies(List<Movie> movies) {
        mMovies = movies;
    }
}
