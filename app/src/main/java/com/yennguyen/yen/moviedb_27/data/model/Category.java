package com.yennguyen.yen.moviedb_27.data.model;

import java.io.Serializable;

public class Category implements Serializable {
    private String mName;
    private String mKey;

    public Category() {
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getKey() {
        return mKey;
    }

    public void setKey(String key) {
        mKey = key;
    }
}
