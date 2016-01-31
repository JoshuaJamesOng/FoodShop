package com.domain.foodshop;

import android.app.Application;

import com.domain.foodshop.di.ApplicationModule;

/**
 * Created by Joshua on 30/01/2016.
 */
public class FoodShopApplication extends Application {

    private FoodShopComponent mFoodShopComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mFoodShopComponent = DaggerFoodShopComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public FoodShopComponent getFoodShopComponent() {
        return mFoodShopComponent;
    }
}
