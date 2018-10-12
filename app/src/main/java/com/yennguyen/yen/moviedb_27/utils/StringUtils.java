package com.yennguyen.yen.moviedb_27.utils;

public class StringUtils {
    public static String getUrl(String postPath){
        return String.format("%s%s", Constants.BASE_URL_IMAGE, postPath);
    }
}
