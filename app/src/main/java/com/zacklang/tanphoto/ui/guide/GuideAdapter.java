package com.zacklang.tanphoto.ui.guide;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.zacklang.tanphoto.R;

import java.util.List;

public class GuideAdapter extends PagerAdapter {
    private List<ImageView> mImageViewList;

    public GuideAdapter(List<ImageView> imageViewList) {
        this.mImageViewList = imageViewList;
    }

    @Override
    public int getCount() {
        return mImageViewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mImageViewList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mImageViewList.get(position);
        container.addView(view);
        return view;
    }
}
