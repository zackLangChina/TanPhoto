package com.zacklang.tanphoto.data.repository;

import com.zacklang.tanphoto.data.api.RandomPhotoApi;
import com.zacklang.tanphoto.data.beans.GetPhotos;
import com.zacklang.tanphoto.data.http.RetrofitFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * 对外暴露数据的类。网络，db等数据均在这里提供接口
 */
public class DataRepository {

    /**
     * 获取指定数量的图片
     * @param picCount 需要获取的图片数量
     * @return response，包含了图片Uri
     */
    public static void getRandomPics(int picCount, Observer<GetPhotos> observer) {
        Observable<GetPhotos> observable = RetrofitFactory.getInstance().crateApi(RandomPhotoApi.HOST,
                RandomPhotoApi.class).getRandomPhotos(picCount);

        //网络请求不能在主线程
        observable.subscribeOn(Schedulers.newThread()).subscribe(observer);
    }
}
