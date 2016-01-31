package com.ongtonnesoup.foodshop.browse.view;

import android.view.View;

import com.squareup.picasso.Picasso;

public class BrowseViewHolderFactory {

    private Picasso mPicasso;

    public BrowseViewHolderFactory(Picasso picasso) {
        mPicasso = picasso;
    }

    public BrowseViewHolder getViewHolder(View view) {
        return new BrowseViewHolder(view, mPicasso);
    }
}
