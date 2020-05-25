package com.zacklang.tanphoto.data.http;

import com.zacklang.tanphoto.util.GlideUtil;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    private static RetrofitFactory mRetrofit;
    private OkHttpClient mOKHTTPClient;
    public static final String AVOID_HTTP403_FORBIDDEN = "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";


    private RetrofitFactory() {
        mOKHTTPClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                //.cache(new Cache(new File(AppApplication.getInstance()
                //        .getCacheDir(),""),1024*1024*10))
                .build();
    }

    public static RetrofitFactory getInstance() {
        if(mRetrofit == null) {
            synchronized (GlideUtil.class) {
                if(mRetrofit == null) {
                    mRetrofit = new RetrofitFactory();
                }
            }
        }
        return mRetrofit;
    }

    /**
     * 通过注解API发送网络请求，获取response
     * @param baseUrl 主页
     * @param tClass Retrofit注解api接口
     * @param <T> API接口类型
     * @return API接口代理实现类，可以以此来调用接口中的方法实现网路请求
     */
    public <T> T crateApi(String baseUrl, Class<T> tClass) {
        Retrofit sRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(mOKHTTPClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return sRetrofit.create(tClass);
    }
}
