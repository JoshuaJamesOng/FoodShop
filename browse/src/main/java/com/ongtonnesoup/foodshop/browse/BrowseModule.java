package com.ongtonnesoup.foodshop.browse;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ongtonnesoup.foodshop.browse.data.CloudDataStore;
import com.ongtonnesoup.foodshop.browse.data.LocalDataStore;
import com.ongtonnesoup.foodshop.browse.data.MealRepository;
import com.ongtonnesoup.foodshop.browse.domain.GetMeals;
import com.ongtonnesoup.foodshop.browse.net.APIService;
import com.ongtonnesoup.foodshop.browse.presenter.BrowsePresenter;
import com.ongtonnesoup.foodshop.browse.view.BrowseAdapter;
import com.ongtonnesoup.foodshop.browse.view.BrowseViewHolderFactory;
import com.ongtonnesoup.foodshop.core.event.UseCaseResultBus;
import com.ongtonnesoup.foodshop.core.executor.ThreadExecutor;
import com.squareup.picasso.Picasso;

import java.util.Arrays;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class BrowseModule {

    @BrowseScope
    @Provides
    BrowseViewHolderFactory providesViewHolderFactory(Picasso picasso) {
        return new BrowseViewHolderFactory(picasso);
    }

    @BrowseScope
    @Provides
    CloudDataStore providesCloudDataSource(Retrofit retrofit) {
        return new CloudDataStore(retrofit.create(APIService.class));
    }

    @BrowseScope
    @Provides
    LocalDataStore providesLocalDataSource() {
        return new LocalDataStore();
    }

    @BrowseScope
    @Provides
    MealRepository providesMealRepository(LocalDataStore localDataStore, CloudDataStore cloudDataStore, UseCaseResultBus bus) {
        return new MealRepository(Arrays.asList(localDataStore, cloudDataStore), bus);
    }

    @BrowseScope
    @Provides
    GetMeals providesInteractor(MealRepository repository, ThreadExecutor executor, UseCaseResultBus bus) {
        return new GetMeals(repository, executor);
    }

    @BrowseScope
    @Provides
    BrowsePresenter providesPresenter(GetMeals interactor) {
        return new BrowsePresenter(interactor);
    }

    @BrowseScope
    @Provides
    BrowseAdapter providesAdapter(BrowseViewHolderFactory factory) {
        return new BrowseAdapter(factory);
    }

    @BrowseScope
    @Provides
    RecyclerView.LayoutManager providesLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

}
