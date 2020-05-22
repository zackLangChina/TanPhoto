package com.zacklang.tanphoto.data.api;

import com.zacklang.tanphoto.data.beans.GetPhotos;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RandomPhotoApi {
    public static final String HOST = "Https://gank.io/";

    @GET("api/random/data/福利/{picCount}")
    Observable<GetPhotos> getRandomPhotos(@Path("picCount") int picCount);
}
