package com.ongtonnesoup.foodshop.core.repository;

import java.util.List;

public interface DataStore<T> {

    List<T> getAll(Result callback);

    T get(String id, Result callback);

    boolean isAsync();

}
