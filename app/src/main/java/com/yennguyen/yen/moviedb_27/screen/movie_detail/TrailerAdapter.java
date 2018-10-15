package com.yennguyen.yen.moviedb_27.screen.movie_detail;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yennguyen.yen.moviedb_27.R;
import com.yennguyen.yen.moviedb_27.data.model.TrailerMovie;
import com.yennguyen.yen.moviedb_27.databinding.ItemTrailerMovieBinding;

import java.util.ArrayList;
import java.util.List;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder> {
    private List<TrailerMovie> mTrailerMovies;
    private ItemTrailerMovieBinding mBinding;
    private setOnItemClick mListener;

    public TrailerAdapter() {
        mTrailerMovies = new ArrayList<>();
    }

    public void setListener(setOnItemClick listener) {
        mListener = listener;
    }

    @Override
    public TrailerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_trailer_movie, parent, false);
        return new TrailerViewHolder(mBinding, mListener);
    }

    @Override
    public void onBindViewHolder(TrailerViewHolder holder, int position) {
        holder.bindData(mTrailerMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mTrailerMovies != null ? mTrailerMovies.size() : 0;
    }

    public class TrailerViewHolder extends RecyclerView.ViewHolder {
        private ItemTrailerMovieBinding mBinding;
        private ItemTrailerViewModel mViewModel;

        public TrailerViewHolder(ItemTrailerMovieBinding binding, setOnItemClick listener) {
            super(binding.getRoot());
            mBinding = binding;
            mViewModel = new ItemTrailerViewModel(listener);
            mBinding.setViewModel(mViewModel);
        }

        public void bindData(TrailerMovie trailerMovie) {
            mViewModel.setTrailer(trailerMovie);
            mBinding.executePendingBindings();
        }
    }

    public void addTrailer(List<TrailerMovie> trailerMovies) {
        mTrailerMovies.clear();
        mTrailerMovies.addAll(trailerMovies);
        notifyDataSetChanged();
    }

    public interface setOnItemClick {
        void onItemClick(TrailerMovie trailerMovie);
    }
}
