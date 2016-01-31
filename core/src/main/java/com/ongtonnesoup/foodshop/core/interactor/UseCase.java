package com.ongtonnesoup.foodshop.core.interactor;


import com.ongtonnesoup.foodshop.core.event.UseCaseResultBus;
import com.ongtonnesoup.foodshop.core.executor.ThreadExecutor;

/**
 * Created by Joshua on 30/01/2016.
 */
public abstract class UseCase {

    protected final ThreadExecutor mThreadExecutor;

    protected UseCase(ThreadExecutor threadExecutor) {
        mThreadExecutor = threadExecutor;
    }

    public void execute() {
        mThreadExecutor.execute(getTask());
    }

    protected abstract Runnable getTask();
}
