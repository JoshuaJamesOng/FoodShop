package com.ongtonnesoup.foodshop.browse.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ongtonnesoup.foodshop.browse.R;
import com.ongtonnesoup.foodshop.browse.data.models.Meal;
import com.squareup.picasso.Picasso;

public class BrowseViewHolder extends RecyclerView.ViewHolder {

    private final TextView mName;
    private final ImageView mImage;

    private Picasso mPicasso;

    public BrowseViewHolder(View itemView, Picasso picasso) {
        super(itemView);
        mPicasso = picasso;
        mName = (TextView) itemView.findViewById(R.id.row_browse_name);
        mImage = (ImageView) itemView.findViewById(R.id.row_browse_image);
    }

    public void bind(Meal meal) {
        mName.setText(meal.mName);
        mPicasso.load(meal.mImageUrl).into(mImage);
    }

    public void reset() {
        mName.setText("");
        mPicasso.cancelRequest(mImage);
    }

}
