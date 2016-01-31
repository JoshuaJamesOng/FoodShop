package com.ongtonnesoup.foodshop.browse.data;

import com.ongtonnesoup.foodshop.browse.data.models.Meal;
import com.ongtonnesoup.foodshop.browse.domain.BrowseEvent;
import com.ongtonnesoup.foodshop.core.event.UseCaseResultBus;
import com.ongtonnesoup.foodshop.core.repository.DataStore;
import com.ongtonnesoup.foodshop.core.repository.Repository;
import com.ongtonnesoup.foodshop.core.repository.Result;

import java.util.List;

public class MealRepository implements Repository {

    private final List<DataStore<Meal>> mDataStores;
    private final UseCaseResultBus mBus;

    public MealRepository(List<DataStore<Meal>> dataStores, UseCaseResultBus bus) {
        mDataStores = dataStores;
        mBus = bus;
    }

    @Override
    public void getAll() {
        List<Meal> result = null;

        for (DataStore<Meal> dataStore : mDataStores) {
            Result callback = null;
            if (dataStore.isAsync()) {
                callback = new Result() {
                    @Override
                    public void onResult(Object result) {
                        if (result != null) {
                            mBus.post(new BrowseEvent((List<Meal>) result));
                        }
                    }
                };
            }

            result = dataStore.getAll(callback);

            if (dataStore.isAsync()) {
                break;
            } else if (result != null) {
                mBus.post(new BrowseEvent(result));
            }
        }
    }


    @Override
    public void get(String id) {

    }


}
