package com.yennguyen.yen.moviedb_27.screen.movie_detail;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yennguyen.yen.moviedb_27.R;
import com.yennguyen.yen.moviedb_27.data.model.Cast;
import com.yennguyen.yen.moviedb_27.databinding.ItemCastBinding;

import java.util.ArrayList;
import java.util.List;

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastViewHolder> {
    private ItemCastBinding mBinding;
    private List<Cast> mCasts;

    public CastAdapter() {
        mCasts = new ArrayList<>();
    }

    @Override
    public CastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_cast, parent, false);
        return new CastViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(CastViewHolder holder, int position) {
        holder.bindData(mCasts.get(position));
    }

    @Override
    public int getItemCount() {
        return mCasts != null ? mCasts.size() : 0;
    }

    public class CastViewHolder extends RecyclerView.ViewHolder {
        private ItemCastBinding mBinding;
        private ItemCastViewModel mViewModel;

        public CastViewHolder(ItemCastBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mViewModel = new ItemCastViewModel();
            mBinding.setViewModel(mViewModel);
        }

        public void bindData(Cast cast) {
            mViewModel.setCast(cast);
        }
    }

    public void addCast(List<Cast> casts) {
        mCasts.clear();
        mCasts.addAll(casts);
        notifyDataSetChanged();
    }
}
