package com.domain.foodshop.di;


import android.os.Handler;
import android.os.Looper;

import com.ongtonnesoup.foodshop.core.event.UseCaseResultBus;
import com.ongtonnesoup.foodshop.core.event.UseCaseResultEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BusModule {

    @Singleton
    @Provides
    Bus providesBus() {
        return new MainThreadBus(ThreadEnforcer.MAIN);
    }

    @Singleton
    @Provides
    UseCaseResultBus providesPostExecutionBus(Bus bus) {
        return new BusProxy(bus);
    }

    private static class BusProxy implements UseCaseResultBus {

        private final Bus mBus;

        public BusProxy(Bus bus) {
            mBus = bus;
        }

        @Override
        public void post(UseCaseResultEvent event) {
            mBus.post(event);
        }
    }

    private static class MainThreadBus extends Bus {
        private final Handler mHandler = new Handler(Looper.getMainLooper());

        public MainThreadBus(ThreadEnforcer main) {
            super(main);
        }

        @Override
        public void post(final Object event) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                super.post(event);
            } else {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        MainThreadBus.super.post(event);
                    }
                });
            }
        }
    }
}
