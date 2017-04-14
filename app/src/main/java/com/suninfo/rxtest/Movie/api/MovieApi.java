package com.suninfo.rxtest.Movie.api;

import com.suninfo.rxtest.Movie.model.MovieInfo;
import com.suninfo.rxtest.Movie.model.TestInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author: zh on 2017/3/23.
 */

public interface MovieApi {

    //代码中使用的这个API
    @GET("output/channels_topics_timeline.json")
    Observable<List<MovieInfo>> getData(@Query("id")int id, @Query("topic_name")String name);

    //用于测试响应头是否添加成功
    @GET("output/channels_topics_timeline.json")
    Call<List<MovieInfo>> getDataRetrofit(@Query("id")int id, @Query("topic_name")String name);

    //这个接口是自己写的tomcat接口，
    @GET("test.json")
    Call<TestInfo> getInfo();

}
