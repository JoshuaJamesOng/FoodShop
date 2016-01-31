package com.domain.foodshop.browse;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.domain.foodshop.FoodShopApplication;
import com.domain.foodshop.FoodShopComponent;
import com.domain.foodshop.R;
import com.domain.foodshop.di.BrowseComponent;
import com.domain.foodshop.di.DaggerBrowseComponent;
import com.ongtonnesoup.foodshop.browse.BrowseModule;
import com.ongtonnesoup.foodshop.browse.data.models.Meal;
import com.ongtonnesoup.foodshop.browse.presenter.BrowsePresenter;
import com.ongtonnesoup.foodshop.browse.view.BrowseAdapter;
import com.ongtonnesoup.foodshop.browse.view.BrowseView;
import com.squareup.otto.Bus;

import java.util.List;

import javax.inject.Inject;

public class BrowseFragment extends Fragment implements BrowseView {

    @Inject
    Bus mBus;
    @Inject
    BrowsePresenter mPresenter;
    @Inject
    BrowseAdapter mAdapter;
    @Inject
    RecyclerView.LayoutManager mLayoutManager;

    private BrowseComponent mBrowseComponent;
    private RecyclerView mRecyclerView;

    public BrowseFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FoodShopComponent foodShopComponent = ((FoodShopApplication) getActivity().getApplication()).getFoodShopComponent();
        mBrowseComponent = DaggerBrowseComponent.builder()
                .foodShopComponent(foodShopComponent)
                .browseModule(new BrowseModule())
                .build();

        mBrowseComponent.inject(this);

        mPresenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_browse, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.browse_recycler_view);
        mRecyclerView.setLayoutManager(mLayoutManager);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mBus.register(mPresenter);
        mPresenter.getData();
    }

    @Override
    public void onPause() {
        mBus.unregister(mPresenter);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mBrowseComponent = null;
        super.onDestroy();
    }

    @Override
    public void showData(List<Meal> data) {
        mAdapter.setData(data);
        mRecyclerView.setAdapter(mAdapter);
    }
}
