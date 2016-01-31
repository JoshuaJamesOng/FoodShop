package com.ongtonnesoup.foodshop.browse.domain;

import com.ongtonnesoup.foodshop.browse.data.models.Meal;
import com.ongtonnesoup.foodshop.core.event.UseCaseResultEvent;

import java.util.List;

public class BrowseEvent extends UseCaseResultEvent {
    private List<Meal> mMeals;

    public BrowseEvent(List<Meal> meals) {
        mMeals = meals;
    }

    public List<Meal> getMeals() {
        return mMeals;
    }
}
