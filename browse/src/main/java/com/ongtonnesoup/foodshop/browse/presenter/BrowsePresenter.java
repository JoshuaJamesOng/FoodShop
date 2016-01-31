package com.ongtonnesoup.foodshop.browse.presenter;

import com.ongtonnesoup.foodshop.browse.domain.BrowseEvent;
import com.ongtonnesoup.foodshop.browse.domain.GetMeals;
import com.ongtonnesoup.foodshop.browse.view.BrowseView;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

public class BrowsePresenter {

    private final GetMeals mGetMeals;
    private BrowseView mView;

    @Inject
    public BrowsePresenter(GetMeals interactor) {
        mGetMeals = interactor;
    }

    public void setView(BrowseView view) {
        mView = view;
    }

    public void getData() {
        mGetMeals.execute();
    }

    @Subscribe
    public void onDataResult(BrowseEvent event) {
        mView.showData(event.getMeals());
    }
}
