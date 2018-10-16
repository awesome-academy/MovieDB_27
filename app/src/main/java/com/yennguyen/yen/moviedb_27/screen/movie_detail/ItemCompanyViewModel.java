package com.yennguyen.yen.moviedb_27.screen.movie_detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;

import com.yennguyen.yen.moviedb_27.data.model.ProductionCompany;
import com.yennguyen.yen.moviedb_27.screen.movie.MovieActivity;
import com.yennguyen.yen.moviedb_27.utils.Constants;

public class ItemCompanyViewModel extends BaseObservable {
    public ObservableField<ProductionCompany> mCompanyObservableField = new ObservableField<>();
    private CompanyAdapter mAdapter;
    public ItemCompanyViewModel(){
        mAdapter = new CompanyAdapter();
    }
    public void setCompany(ProductionCompany productionCompany){
        mCompanyObservableField.set(productionCompany);
    }
    public void onItemClick(View view){
        view.getContext().startActivity(getIntent(view.getContext(), mCompanyObservableField.get()));
    }
    public static Intent getIntent(Context context, ProductionCompany company){
        Intent intent = new Intent(context, MovieActivity.class);
        intent.putExtra(Constants.EXTRA_COMPANY, company);
        return intent;
    }
}
