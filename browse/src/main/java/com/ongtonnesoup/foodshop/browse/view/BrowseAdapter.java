package com.ongtonnesoup.foodshop.browse.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ongtonnesoup.foodshop.browse.R;
import com.ongtonnesoup.foodshop.browse.data.models.Meal;

import java.util.List;

public class BrowseAdapter extends RecyclerView.Adapter {

    private BrowseViewHolderFactory mFactory;
    private List<Meal> mMeals;

    public BrowseAdapter(BrowseViewHolderFactory factory) {
        mFactory = factory;
    }

    public void setData(List<Meal> meals) {
        mMeals = meals;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_browse_meal, parent, false);
        return mFactory.getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BrowseViewHolder vh = (BrowseViewHolder) holder;
        vh.reset();

        if (mMeals != null) {
            Meal item = mMeals.get(position);
            if (item != null) {
                vh.bind(item);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mMeals != null ? mMeals.size() : 0;
    }

}
