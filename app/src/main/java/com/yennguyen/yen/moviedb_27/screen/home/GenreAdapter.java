package com.yennguyen.yen.moviedb_27.screen.home;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yennguyen.yen.moviedb_27.R;
import com.yennguyen.yen.moviedb_27.data.model.Genre;
import com.yennguyen.yen.moviedb_27.databinding.ItemGenreBinding;

import java.util.ArrayList;
import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.GenreViewHolder> {
    private ItemGenreBinding mBinding;
    private ItemClickListener mListener;
    private List<Genre> mGenres;

    public GenreAdapter(){
        mGenres = new ArrayList<>();
    }
    @Override
    public GenreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_genre,
                parent, false);
        return new GenreViewHolder(mBinding, mListener);
    }

    @Override
    public void onBindViewHolder(GenreViewHolder holder, int position) {
        holder.bindData(mGenres.get(position));
    }

    @Override
    public int getItemCount() {
        return mGenres != null ? mGenres.size() : 0;
    }

    public class GenreViewHolder extends RecyclerView.ViewHolder {
        private ItemGenreBinding mBinding;
        private ItemGenreViewModel mItemGenreViewModel;

        public GenreViewHolder(ItemGenreBinding binding, ItemClickListener listener) {
            super(binding.getRoot());
            mBinding = binding;
            mItemGenreViewModel = new ItemGenreViewModel(listener);
            mBinding.setViewModel(mItemGenreViewModel);
        }

        public void bindData(Genre genre) {
            mItemGenreViewModel.setGenre(genre);
            mBinding.executePendingBindings();
        }
    }
    public void setItemClickListener(ItemClickListener listener){
        mListener = listener;
    }

    public void setGenres(List<Genre> genres){
        mGenres.clear();
        mGenres.addAll(genres);
        notifyDataSetChanged();
    }
    public void setListener(ItemClickListener listener){
        mListener = listener;
    }
    public interface ItemClickListener {
        void onItemClick(Genre genre);
    }
}
