package com.domain.foodshop;

import android.content.Context;

import com.domain.foodshop.di.ApplicationModule;
import com.domain.foodshop.di.BusModule;
import com.domain.foodshop.di.ExecutorModule;
import com.domain.foodshop.di.ImageModule;
import com.domain.foodshop.di.ServiceModule;
import com.ongtonnesoup.foodshop.browse.net.APIService;
import com.ongtonnesoup.foodshop.core.event.UseCaseResultBus;
import com.ongtonnesoup.foodshop.core.executor.ThreadExecutor;
import com.squareup.otto.Bus;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {ApplicationModule.class, BusModule.class, ExecutorModule.class, ImageModule.class, ServiceModule.class})
public interface FoodShopComponent {

    Context context();

    Bus bus();

    UseCaseResultBus postExecutionBus();

    ThreadExecutor threadExecutor();

    Picasso picasso();

    Retrofit retrofit();

}
