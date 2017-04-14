package com.suninfo.rxtest;

import android.app.Application;
import android.content.Context;

/**
 * author: zh on 2017/4/12.
 */

public class RxApplication extends Application {
    private static Context context;

    public static Context getContext(){
        return context;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
