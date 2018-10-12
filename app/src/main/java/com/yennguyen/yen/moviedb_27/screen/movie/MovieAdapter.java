package com.yennguyen.yen.moviedb_27.screen.movie;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yennguyen.yen.moviedb_27.R;
import com.yennguyen.yen.moviedb_27.data.model.Movie;
import com.yennguyen.yen.moviedb_27.databinding.ItemMoviesBinding;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private setOnClickListener mListener;
    private setFavoriteClickListener mFavoriteListener;
    private ItemMoviesBinding mBinding;
    private List<Movie> mMovies;

    public MovieAdapter() {
        mMovies = new ArrayList<>();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_movies, parent, false);
        return new MovieViewHolder(mBinding, mListener, mFavoriteListener);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bindData(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies != null ? mMovies.size() : 0;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private ItemMovieViewModel mItemMovieViewModel;
        private ItemMoviesBinding mBinding;

        private MovieViewHolder(ItemMoviesBinding binding, setOnClickListener listener,
                                setFavoriteClickListener favoriteListener) {
            super(binding.getRoot());
            mBinding = binding;
            mItemMovieViewModel = new ItemMovieViewModel(listener, favoriteListener);
            mBinding.setViewModel(mItemMovieViewModel);
        }

        private void bindData(Movie movie) {
            mItemMovieViewModel.setMovies(movie);
        }
    }

    public void setListener(setOnClickListener listener) {
        mListener = listener;
    }

    public void setFavoriteListener(setFavoriteClickListener favoriteListener) {
        mFavoriteListener = mFavoriteListener;
    }

    public void addMovie(List<Movie> movies) {
        if (movies != null) {
            mMovies.addAll(movies);
            notifyDataSetChanged();
        }
    }

    public interface setOnClickListener {
        void onItemClick(Movie movie);
    }

    public interface setFavoriteClickListener {
        void onFavoriteClick(Movie movie);
    }
}
