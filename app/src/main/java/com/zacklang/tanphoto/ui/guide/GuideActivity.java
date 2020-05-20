package com.zacklang.tanphoto.ui.guide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zacklang.tanphoto.R;

import java.util.List;

public class GuideActivity extends AppCompatActivity {

    private int[] mGuideImages = new int[]{R.mipmap.guide_01,R.mipmap.guide_02};
    private List<ImageView> mImageViewList;
    private GuideAdapter mGuideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这里可以用databinding
        setContentView(R.layout.guide_activity);
    }

    class GuideAdapter extends PagerAdapter {

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
}
