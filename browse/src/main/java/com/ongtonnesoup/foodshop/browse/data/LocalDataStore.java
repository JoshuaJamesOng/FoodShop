package com.ongtonnesoup.foodshop.browse.data;

import com.ongtonnesoup.foodshop.browse.data.models.Ingredient;
import com.ongtonnesoup.foodshop.browse.data.models.Meal;
import com.ongtonnesoup.foodshop.core.repository.DataStore;
import com.ongtonnesoup.foodshop.core.repository.Result;

import java.util.Arrays;
import java.util.List;

public class LocalDataStore implements DataStore<Meal> {

    private List<Meal> mMeals = Arrays.asList(
            new Meal("Stew",
                    "http://i.imgur.com/5MHACOq.png",
                    Arrays.asList(new Ingredient("Beef"), new Ingredient("Vegetables"), new Ingredient("Dumplings"))));

    @Override
    public List<Meal> getAll(Result callback) {
        return mMeals;
    }

    @Override
    public Meal get(String id, Result callback) {
        return null;
    }

    @Override
    public boolean isAsync() {
        return false;
    }

}
