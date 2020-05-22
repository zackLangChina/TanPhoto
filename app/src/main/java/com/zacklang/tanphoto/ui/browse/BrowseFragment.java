package com.zacklang.tanphoto.ui.browse;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.zacklang.tanphoto.R;
import com.zacklang.tanphoto.databinding.BrowseFragmentBinding;
import com.zacklang.tanphoto.util.GlideUtil;
import com.zacklang.tanphoto.viewmodel.BrowseViewModel;

public class BrowseFragment extends Fragment {
    public static final String TAG = "BrowseFragment";
    private BrowseFragmentBinding mBinding;
    private BrowseViewModel vm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.browse_fragment,container,false);

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vm = new BrowseViewModel();
        subscribUi(vm.getImgUri());
    }

    //ViewModel中的数据没有通过layout绑定到UI，就需要手动绑定
    private void subscribUi(LiveData<Uri> livedata) {
        livedata.observe(getViewLifecycleOwner(), new Observer<Uri>() {
            @Override
            public void onChanged(Uri uri) {
                if(uri != null) {
                    mBinding.setIsLoading(false);
                    mBinding.imageView.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.about));
                    GlideUtil.imgUriIntoImageView(mBinding.imageView, uri);
                }else {
                    mBinding.setIsLoading(true);
                }
            }
        });
    }
}
