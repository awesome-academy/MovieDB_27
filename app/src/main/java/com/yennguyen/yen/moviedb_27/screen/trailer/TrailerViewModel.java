package com.yennguyen.yen.moviedb_27.screen.trailer;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.yennguyen.yen.moviedb_27.data.model.TrailerMovie;

public class TrailerViewModel extends BaseObservable {
    public ObservableField<TrailerMovie> mTrailerMovieObservableField = new ObservableField<>();
    public ObservableField<YouTubePlayer.OnInitializedListener> initListener = new ObservableField<>();

    public TrailerViewModel() {
    }

    public void loadTrailer(final TrailerMovie trailerMovie) {
        mTrailerMovieObservableField.set(trailerMovie);
        initListener.set(new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(trailerMovie.getKey());
                youTubePlayer.setShowFullscreenButton(true);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                YouTubeInitializationResult youTubeInitializationResult) {
            }
        });
    }
}
