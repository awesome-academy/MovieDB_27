package com.yennguyen.yen.moviedb_27.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProductionCompany implements Serializable {

    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("logo_path")
    @Expose
    private String mLogoPath;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("origin_country")
    @Expose
    private String mOriginCountry;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getLogoPath() {
        return mLogoPath;
    }

    public void setLogoPath(String logoPath) {
        mLogoPath = logoPath;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getOriginCountry() {
        return mOriginCountry;
    }

    public void setOriginCountry(String originCountry) {
        mOriginCountry = originCountry;
    }
}
