package com.yennguyen.yen.moviedb_27.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MovieDetail implements Serializable {
    @SerializedName("id")
    private int mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("poster_path")
    private String mPosterPath;
    @SerializedName("backdrop_path")
    private String mBackdropPath;
    @SerializedName("overview")
    private String mOverview;
    @SerializedName("vote_average")
    private float mVoteAverage;
    @SerializedName("release_date")
    private String mReleaseDate;
    @SerializedName("genres")
    private List<Genre> mGenres;
    @SerializedName("production_companies")
    private List<ProductionCompany> mCompanies;
    @SerializedName("videos")
    private TrailerMoviesResult mTrailerMovieResult;
    @SerializedName("credits")
    private CastsResult mCastResult;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        mBackdropPath = backdropPath;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public float getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public List<Genre> getGenres() {
        return mGenres;
    }

    public void setGenres(List<Genre> genres) {
        mGenres = genres;
    }

    public List<ProductionCompany> getCompanies() {
        return mCompanies;
    }

    public void setCompanies(List<ProductionCompany> companies) {
        mCompanies = companies;
    }

    public TrailerMoviesResult getTrailerMovieResult() {
        return mTrailerMovieResult;
    }

    public void setTrailerMovieResult(TrailerMoviesResult trailerMovieResult) {
        mTrailerMovieResult = trailerMovieResult;
    }

    public CastsResult getCastResult() {
        return mCastResult;
    }

    public void setCastResult(CastsResult castResult) {
        mCastResult = castResult;
    }
}
