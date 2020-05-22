package com.zacklang.tanphoto;

import android.app.Application;
import android.content.Context;

public class AppApplication extends Application {

    private static AppApplication mApplication;
    protected static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        mContext = getApplicationContext();
    }

    public static synchronized AppApplication getInstance() {
        return mApplication;
    }

    public static AppApplication getmApplication() {
        return mApplication;
    }

    public static Context getmContext() {
        return mContext;
    }

}
