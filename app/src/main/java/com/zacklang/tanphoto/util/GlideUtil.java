package com.zacklang.tanphoto.util;

import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideUtil {
    public static void imgUriIntoImageView(ImageView view, Uri uri) {
        Glide.with(view).load(uri).into(view);
    }
}
