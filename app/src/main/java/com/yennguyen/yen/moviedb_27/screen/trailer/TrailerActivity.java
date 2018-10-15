package com.yennguyen.yen.moviedb_27.screen.trailer;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.yennguyen.yen.moviedb_27.R;
import com.yennguyen.yen.moviedb_27.data.model.TrailerMovie;
import com.yennguyen.yen.moviedb_27.databinding.ActivityTrailerBinding;
import com.yennguyen.yen.moviedb_27.utils.Constants;

public class TrailerActivity extends YouTubeBaseActivity {
    private ActivityTrailerBinding mBinding;
    private TrailerViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_trailer);
        mViewModel = new TrailerViewModel();
        TrailerMovie trailerMovie = (TrailerMovie) getIntent().getSerializableExtra(Constants.EXTRA_TRAILER);
        mViewModel.loadTrailer(trailerMovie);
        mBinding.setViewModel(mViewModel);
    }
}
