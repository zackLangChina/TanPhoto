package com.zacklang.tanphoto.viewmodel;

import android.net.Uri;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zacklang.tanphoto.data.beans.GetPhotos;
import com.zacklang.tanphoto.data.repository.DataRepository;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class BrowseViewModel extends ViewModel {
    private final String TAG = "BrowseViewModel";
    public MutableLiveData<Uri> picUri = new MutableLiveData<>();

    public BrowseViewModel() {
        //从网络获取图片
        requestPhoto();
    }

    public LiveData<Uri> getImgUri() {
        return picUri;
    }

    private void requestPhoto() {
        DataRepository.getRandomPics(1, new Observer<GetPhotos>() {
            @Override
            public void onSubscribe(Disposable d) {
                picUri.postValue(null);
            }

            @Override
            public void onNext(GetPhotos getPhotos) {
                picUri.postValue(Uri.parse(getPhotos.getResults().get(0).getUrl()));
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,e.toString());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
