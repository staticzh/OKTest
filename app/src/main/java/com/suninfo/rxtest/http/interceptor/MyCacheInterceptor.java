package com.suninfo.rxtest.http.interceptor;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.suninfo.rxtest.RxApplication;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by allen on 2017/1/3.
 * <p>
 * 有网络先读缓存，缓存时间过了在访问网络
 * 没有网络的时候读缓存
 */

public class MyCacheInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        //拦截Request对象
        Request request = chain.request();
        //判断有无网络连接
        boolean connected = isNetworkConnected();
        if (!connected) {
            //如果没有网络,从缓存获取数据
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            Log.e("zhanghe", "no network");
        }
        Response response = chain.proceed(request);

        if (connected) {
            //有网络，缓存时间短
            Log.e("zhanghe", "有网络");


            String cacheControl = request.cacheControl().toString();
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control","public, max-age=90")
                    .build();
        } else {
            //没有网络
            Log.e("zhanghe", "没有网络的缓存设置");

            int maxTime = 3600;
            return response.newBuilder()
                    //这里的设置的是我们的没有网络的缓存时间，想设置多少就是多少。
                    .header("Cache-Control", "public, only-if-cached, max-age=" + maxTime)
                    .removeHeader("Pragma")
                    .build();
        }


    }

    /**
     * 判断是否有网络
     *
     * @return 返回值
     */
    public static boolean isNetworkConnected() {
        Context context = RxApplication.getContext();
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();

            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }
}
