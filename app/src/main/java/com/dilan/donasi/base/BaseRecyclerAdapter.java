package com.dilan.donasi.base;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Mayburger on 1/11/18.
 */

public class BaseRecyclerAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    @NonNull
    @Override
    public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    public Typeface getFont(Context context, String fontName){
            return Typeface.createFromAsset(context.getAssets(),"fonts/"+fontName+".ttf");
    }

    public void Glide(Context context, String url, ImageView view){
        Glide.with(context).load(url).apply(new RequestOptions().centerCrop()).transition(DrawableTransitionOptions.withCrossFade()).into(view);
    }

    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
