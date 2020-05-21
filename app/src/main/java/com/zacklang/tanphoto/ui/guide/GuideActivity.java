package com.zacklang.tanphoto.ui.guide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.zacklang.tanphoto.R;
import com.zacklang.tanphoto.databinding.GuideActivityBinding;
import com.zacklang.tanphoto.ui.login.LoginActivity;
import com.zacklang.tanphoto.viewmodel.GuideViewModel;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    private List<ImageView> mImageViewList;
    private GuideActivityBinding mBimding;
    private GuideViewModel viewModel;
    private GuideAdapter mGuideAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这里可以用databinding
        //setContentView(R.layout.guide_activity);
        mBimding = DataBindingUtil.setContentView(this,R.layout.guide_activity);
        viewModel = new ViewModelProvider(this).get(GuideViewModel.class);
        initAdapter();
        mBimding.guide.setAdapter(mGuideAdapter);
        mBimding.guide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int pageLength = viewModel.getmGuideImages().length;
                if(position==pageLength-1) {
                    mBimding.setEnterVisiable(View.VISIBLE);
                }else {
                    mBimding.setEnterVisiable(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mBimding.setEnterVisiable(View.GONE);
        mBimding.guide.setOffscreenPageLimit(3);
        mBimding.guide.setPageMargin(15);
    }

    private void initAdapter() {
        int[] imgs = viewModel.getmGuideImages();
        mImageViewList = new ArrayList<>();
        
        for(int i=0;i<imgs.length;i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageDrawable(getResources().getDrawable(imgs[i],null));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mImageViewList.add(imageView);
        }
        mGuideAdapter = new GuideAdapter(mImageViewList);
    }

    public void enterClick(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
