package com.domain.foodshop.di;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ImageModule {

    @Singleton
    @Provides
    Picasso providesPicasso(Context context) {
        return new Picasso.Builder(context)
                .downloader(new OkHttpDownloader(new OkHttpClient()))
                .listener(new Picasso.Listener() {
                    @Override
                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                        Log.e("Picasso", "Failed to load image:" + uri);
                    }
                })
                .build();
    }

}
