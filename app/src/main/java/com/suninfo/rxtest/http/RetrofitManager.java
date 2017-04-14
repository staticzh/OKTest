package com.suninfo.rxtest.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.suninfo.rxtest.RxApplication;
import com.suninfo.rxtest.http.interceptor.MyCacheInterceptor;
import com.suninfo.rxtest.http.interceptor.NetInterceptor;
import com.suninfo.rxtest.http.interceptor.NoNetInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author: zh on 2017/3/24.
 */

public class RetrofitManager {

    //超时时间
    private static final long DUFAULT_TIME_OUT = 5;
    //基础接口
   private static String BASE_URL = "http://newapi.meipai.com/";
    //private static String BASE_URL = "http://news-at.zhihu.com/api/4/version/";
    //private static String BASE_URL = "http://192.168.230.122:8080/";


    private Retrofit mRetrofit;
    private static RetrofitManager sManager = new RetrofitManager();

    private RetrofitManager() {
        createRetrofit();
    }

    /**
     * 使用默认的BaseUrl
     */
    public static RetrofitManager getInstance() {
        return sManager;
    }


    private void createRetrofit() {
        File file = new File(RxApplication.getContext().getCacheDir(), "rxCache");
        //缓存大小10M
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(file, cacheSize);
        //合成的网络缓存拦截器
        MyCacheInterceptor cacheInterceptor = new MyCacheInterceptor();

        OkHttpClient client = new OkHttpClient.Builder()

                .cache(cache)
                .addInterceptor(new NoNetInterceptor())
                .addNetworkInterceptor(new NetInterceptor())
                //.addInterceptor(cacheInterceptor)
                //.addNetworkInterceptor(cacheInterceptor)
                .connectTimeout(DUFAULT_TIME_OUT, TimeUnit.SECONDS) //连接超时
                .writeTimeout(DUFAULT_TIME_OUT, TimeUnit.SECONDS)   //写入超时
                .readTimeout(DUFAULT_TIME_OUT, TimeUnit.SECONDS)  //读取超时
                .build();

      

        mRetrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 获取对应的接口示例
     *
     * @param c
     * @param <T>
     * @return
     */
    public <T> T createApi(Class<T> c) {
        return mRetrofit.create(c);
    }


}
