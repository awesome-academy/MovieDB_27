package com.yennguyen.yen.moviedb_27.data.resource.remote.service;

import android.app.Application;

import com.yennguyen.yen.moviedb_27.utils.Constants;

public class MovieServiceClient extends ServiceClient {
    private static MovieAPI sMovieAPI;

    public static void init(Application application) {
        sMovieAPI = createService(application, Constants.BASE_URL, MovieAPI.class);
    }

    public static MovieAPI getInstance() {
        return sMovieAPI;
    }
}
