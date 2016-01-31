package com.ongtonnesoup.foodshop.browse.data;

import com.ongtonnesoup.foodshop.browse.data.models.Ingredient;
import com.ongtonnesoup.foodshop.browse.data.models.Meal;
import com.ongtonnesoup.foodshop.browse.net.APIService;
import com.ongtonnesoup.foodshop.core.repository.DataStore;
import com.ongtonnesoup.foodshop.core.repository.Result;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class CloudDataStore implements DataStore<Meal> {

    private APIService mService;

    private List<Meal> mMeals = Arrays.asList(
            new Meal("Stew",
                    "http://i.imgur.com/5MHACOq.png",
                    Arrays.asList(new Ingredient("Beef"), new Ingredient("Vegetables"), new Ingredient("Dumplings"))));

    public CloudDataStore(APIService service) {
        mService = service;
    }

    @Override
    public List<Meal> getAll(Result callback) {
        Call<List<Meal>> call = mService.getMeals();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Meal> meals = null;
        try {
            meals = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        callback.onResult(meals);
        return null;
    }

    @Override
    public Meal get(String id, Result callback) {
        callback.onResult(null);
        return null;
    }

    @Override
    public boolean isAsync() {
        return true;
    }
}
