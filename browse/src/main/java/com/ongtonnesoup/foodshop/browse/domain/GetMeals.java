package com.ongtonnesoup.foodshop.browse.domain;

import com.ongtonnesoup.foodshop.browse.data.MealRepository;
import com.ongtonnesoup.foodshop.core.executor.ThreadExecutor;
import com.ongtonnesoup.foodshop.core.interactor.UseCase;

public class GetMeals extends UseCase {

    private MealRepository mRepository;

    public GetMeals(MealRepository repository, ThreadExecutor threadExecutor) {
        super(threadExecutor);
        mRepository = repository;
    }

    @Override
    protected Runnable getTask() {
        return new Runnable() {
            @Override
            public void run() {
                mRepository.getAll();
            }
        };
    }
}
