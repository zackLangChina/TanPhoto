package com.zacklang.tanphoto.ui.browse;

import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
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

        vm = new ViewModelProvider(this).get(BrowseViewModel.class);
        subscribUi(vm.getImgUri());
    }

    //ViewModel中的数据没有通过layout绑定到UI，就需要手动绑定
    private void subscribUi(LiveData<Uri> livedata) {
        livedata.observe(getViewLifecycleOwner(), new Observer<Uri>() {
            @Override
            public void onChanged(Uri uri) {
                if(uri != null) {
                    GlideUtil.imgUriIntoImageView(mBinding.imageView, uri, new RequestListener<Drawable>() {

                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            Log.e(TAG,e.toString());
                            vm.requestPhoto();
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            mBinding.setIsLoading(false);
                            return false;
                        }
                    });
                }else {
                    mBinding.setIsLoading(true);
                }
            }
        });
    }

    public void requestPhoto() {
        vm.requestPhoto();
    }
}
