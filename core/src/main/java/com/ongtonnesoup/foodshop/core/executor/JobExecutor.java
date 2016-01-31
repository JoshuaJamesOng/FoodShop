package com.ongtonnesoup.foodshop.core.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JobExecutor implements ThreadExecutor {

    private static final int INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 10;
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private final BlockingQueue<Runnable> mQueue;
    private final ThreadFactory mThreadFactory;
    private final ThreadPoolExecutor mExecutor;

    public JobExecutor() {
        mQueue = new LinkedBlockingQueue<>();
        mThreadFactory = new JobThreadFactory();
        mExecutor = new ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, mQueue, mThreadFactory);
    }

    @Override
    public void execute(Runnable command) {
        mExecutor.execute(command);
    }

    private static class JobThreadFactory implements ThreadFactory {

        private static final String THREAD_NAME = "foodshop_";
        private int mCounter = 0;

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, THREAD_NAME + mCounter++);
        }
    }
}
