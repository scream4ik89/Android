package com.itacademy.presentation.presentation.utils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BindingAdapters {

    @BindingAdapter({"src", "error"})
    public static void loadImage(ImageView view, String url, Drawable err) {
        if (url != null && url.length() > 0) {
            Picasso.with(view.getContext()).load(url).error(err).transform(new CircleTransformation()).into(view);
        }
    }
}
