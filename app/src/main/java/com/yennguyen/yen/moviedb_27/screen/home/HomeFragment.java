package com.yennguyen.yen.moviedb_27.screen.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yennguyen.yen.moviedb_27.R;
import com.yennguyen.yen.moviedb_27.data.repository.MovieRepository;
import com.yennguyen.yen.moviedb_27.data.resource.local.MovieLocalDataSource;
import com.yennguyen.yen.moviedb_27.data.resource.remote.MovieRemoteDataSource;
import com.yennguyen.yen.moviedb_27.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding mHomeBinding;
    private HomeFragmentViewModel mHomeFragmentViewModel;
    private MovieRepository mMovieRepository;

    public HomeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        mMovieRepository = MovieRepository.getInstants(MovieLocalDataSource.getInstance(getContext()),
                MovieRemoteDataSource.getInstance());
        mHomeFragmentViewModel = new HomeFragmentViewModel(mMovieRepository);
        return mHomeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
