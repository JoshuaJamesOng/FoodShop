package com.domain.foodshop.di;

import com.domain.foodshop.FoodShopComponent;
import com.domain.foodshop.browse.BrowseFragment;
import com.ongtonnesoup.foodshop.browse.BrowseModule;
import com.ongtonnesoup.foodshop.browse.BrowseScope;

import dagger.Component;

/**
 * Created by Joshua on 30/01/2016.
 */
@BrowseScope
@Component(dependencies = FoodShopComponent.class, modules = BrowseModule.class)
public interface BrowseComponent {

    void inject(BrowseFragment fragment);

}
