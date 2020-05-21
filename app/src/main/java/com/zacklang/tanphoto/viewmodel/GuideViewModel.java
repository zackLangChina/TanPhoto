package com.zacklang.tanphoto.viewmodel;

import androidx.lifecycle.ViewModel;

import com.zacklang.tanphoto.R;
import com.zacklang.tanphoto.ui.guide.GuideAdapter;

public class GuideViewModel extends ViewModel {
    //数据源。可以设置为通过网络动态获取
    private int[] mGuideImages = new int[]{R.mipmap.guide_01,R.mipmap.guide_02};

    public int[] getmGuideImages() {
        return mGuideImages;
    }}
