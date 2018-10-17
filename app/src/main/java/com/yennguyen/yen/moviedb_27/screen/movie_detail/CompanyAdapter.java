package com.yennguyen.yen.moviedb_27.screen.movie_detail;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.yennguyen.yen.moviedb_27.R;
import com.yennguyen.yen.moviedb_27.data.model.ProductionCompany;
import com.yennguyen.yen.moviedb_27.databinding.ItemCompanyBinding;

import java.util.ArrayList;
import java.util.List;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder> {
    private List<ProductionCompany> mCompanyList;
    private ItemCompanyBinding mBinding;
    public CompanyAdapter(){
        mCompanyList = new ArrayList<>();
    }
    @Override
    public CompanyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_company,
                parent, false);
        return new CompanyViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(CompanyViewHolder holder, int position) {
        holder.bindData(mCompanyList.get(position));
    }

    @Override
    public int getItemCount() {
        return mCompanyList != null ? mCompanyList.size() : 0;
    }

    public void getCompany(List<ProductionCompany> companyList){
        if(mCompanyList != null){
            mCompanyList.clear();
            mCompanyList.addAll(companyList);
            notifyDataSetChanged();
        }
    }
    public class CompanyViewHolder extends RecyclerView.ViewHolder {
        private ItemCompanyBinding mBinding;
        private ItemCompanyViewModel mViewModel;
        public CompanyViewHolder(ItemCompanyBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mViewModel = new ItemCompanyViewModel();
            mBinding.setViewModel(mViewModel);
        }
        public void bindData(ProductionCompany company){
            mViewModel.setCompany(company);
            mBinding.executePendingBindings();
        }
    }
}
