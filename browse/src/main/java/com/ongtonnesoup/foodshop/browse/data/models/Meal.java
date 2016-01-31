package com.ongtonnesoup.foodshop.browse.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Meal {

    @SerializedName("name")
    public String mName;

    @SerializedName("ingredients")
    public List<Ingredient> mIngredients;

    @SerializedName("imageUrl")
    public String mImageUrl;

    public Meal() {

    }

    public Meal(String name, String imageUrl, List<Ingredient> ingredients) {
        mName = name;
        mImageUrl = imageUrl;
        mIngredients = ingredients;
    }

}
