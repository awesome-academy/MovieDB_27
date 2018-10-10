package com.yennguyen.yen.moviedb_27.data.resource.remote.service;

import android.content.Context;

import com.yennguyen.yen.moviedb_27.utils.Constants;

public class MovieServiceClient extends ServiceClient {
    private static MovieAPI sMovieAPI;

    public static MovieAPI getInstance(Context context) {
        if (sMovieAPI == null) {
            sMovieAPI = createService(context, Constants.BASE_URL, MovieAPI.class);
        }
        return sMovieAPI;
    }
}
