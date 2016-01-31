package com.ongtonnesoup.foodshop.browse.net;

import com.ongtonnesoup.foodshop.browse.data.models.Meal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("56acf773110000bf2c4468cb")
    Call<List<Meal>> getMeals();

}
