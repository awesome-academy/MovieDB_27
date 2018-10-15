package com.yennguyen.yen.moviedb_27.utils;

public class StringUtils {
    public static String getUrl(String postPath){
        return String.format("%s%s", Constants.BASE_URL_IMAGE, postPath);
    }
    public static String appendToResponse() {
        return String.format("%s%s%s", Constants.APPEND_CREDITS,
                Constants.COMMA, Constants.APPEND_VIDEOS);
    }
    public static String getImageUrlYoutube(String key){
        StringBuilder s = new StringBuilder(Constants.BASE_IMAGE_URL_YOUTUBE);
        s.append(key).append(Constants.IMAGE_QUALITY);
        return s.toString();
    }
}
