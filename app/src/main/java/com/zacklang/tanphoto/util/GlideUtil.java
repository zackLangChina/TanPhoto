package com.zacklang.tanphoto.util;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class GlideUtil {
    public static void imgUriIntoImageView(ImageView view, Uri uri, RequestListener<Drawable> listener) {
        Glide.with(view).load(uri).listener(listener).into(view);
    }
}
