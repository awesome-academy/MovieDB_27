package com.yennguyen.yen.moviedb_27.data.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Movie implements Serializable {

    @SerializedName("backdrop_path")
    @Expose
    private String mBackdropPath;
    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("overview")
    @Expose
    private String mOverview;
    @SerializedName("poster_path")
    @Expose
    private String mPosterPath;
    @SerializedName("release_date")
    @Expose
    private String mReleaseDate;
    @SerializedName("revenue")
    @Expose
    private int mRevenue;
    @SerializedName("title")
    @Expose
    private String mTitle;
    @SerializedName("vote_average")
    @Expose
    private double mVoteAverage;
    @SerializedName("vote_count")
    @Expose
    private int mVoteCount;

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        mBackdropPath = backdropPath;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public int getRevenue() {
        return mRevenue;
    }

    public void setRevenue(int revenue) {
        mRevenue = revenue;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public double getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        mVoteAverage = voteAverage;
    }

    public int getVoteCount() {
        return mVoteCount;
    }

    public void setVoteCount(Integer voteCount) {
        mVoteCount = voteCount;
    }
}
