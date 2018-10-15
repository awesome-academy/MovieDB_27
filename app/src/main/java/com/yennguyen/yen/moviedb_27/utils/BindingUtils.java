package com.yennguyen.yen.moviedb_27.utils;

import android.databinding.BindingAdapter;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.yennguyen.yen.moviedb_27.BuildConfig;
import com.yennguyen.yen.moviedb_27.screen.movie.EndLessRecyclerOnScrollListener;

public class BindingUtils {
    @BindingAdapter("onNavigationItemSelected")
    public static void onNavigationItemSelectedListener(
            BottomNavigationView view,
            BottomNavigationView.OnNavigationItemSelectedListener listener) {
        view.setOnNavigationItemSelectedListener(listener);
    }

    @BindingAdapter({"recyclerAdapter"})
    public static void setAdapterForRecyclerView(RecyclerView recyclerView,
                                                 RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String postPath) {
        Glide.with(imageView.getContext()).load(StringUtils.getUrl(postPath)).into(imageView);
    }

    @BindingAdapter("onScroll")
    public static void onScrollView(RecyclerView view, EndLessRecyclerOnScrollListener listener) {
        view.addOnScrollListener(listener);
    }

    @BindingAdapter({"imageUrlYoutube"})
    public static void loadImgYoutube(ImageView imageView, String key) {
        Glide.with(imageView.getContext())
                .load(StringUtils.getImageUrlYoutube(key))
                .into(imageView);
    }

    @BindingAdapter("youtubePlayerView")
    public static void setYouTubePlayerView(YouTubePlayerView youTubePlayerView,
                                            YouTubePlayer.OnInitializedListener listener) {
        youTubePlayerView.initialize(BuildConfig.YOUTUBE_KEY, listener);
    }
}
