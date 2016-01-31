package com.domain.foodshop.di;

import com.ongtonnesoup.foodshop.core.executor.JobExecutor;
import com.ongtonnesoup.foodshop.core.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Joshua on 30/01/2016.
 */
@Module
public class ExecutorModule {

    @Singleton
    @Provides
    ThreadExecutor providesThreadExecutor() {
        return new JobExecutor();
    }


}
