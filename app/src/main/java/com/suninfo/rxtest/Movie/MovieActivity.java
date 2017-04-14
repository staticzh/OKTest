package com.suninfo.rxtest.Movie;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.suninfo.rxtest.Movie.api.MovieApi;
import com.suninfo.rxtest.Movie.model.MovieInfo;
import com.suninfo.rxtest.R;
import com.suninfo.rxtest.http.RetrofitManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * author: zh on 2017/3/24.
 */

public class MovieActivity extends AppCompatActivity {
    private final String TAG = "MainActivity_zh";
    private ActionBarDrawerToggle toogle;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        initToolbar();
        mTextView = (TextView) findViewById(R.id.test);


    }

    public void click(View view) {
        /*
       //测试响应头代码
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Call<List<MovieInfo>> call = RetrofitManager.getInstance()
                            .createApi(MovieApi.class)
                           .getDataRetrofit(1,"女神");
                    Response<List<MovieInfo>> execute = call.execute();
                    //获取响应头
                    Headers headers = execute.raw().headers();
                    //获取响应吗
                    int code = execute.code();
                    //获取对应的字段
                    String s = headers.get("Cache-Control");
                    Log.e("zhang", s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/

        //测试网络访问代码
        Call<List<MovieInfo>> call = RetrofitManager.getInstance()
                .createApi(MovieApi.class)
                .getDataRetrofit(1, "女神");
        call.enqueue(new Callback<List<MovieInfo>>() {
            @Override
            public void onResponse(Call<List<MovieInfo>> call, Response<List<MovieInfo>> response) {

                List<MovieInfo> body = response.body();
                String name = body.get(0).getScreen_name();
                mTextView.setText(name);
                Log.e("zhanghe", name);

            }

            @Override
            public void onFailure(Call<List<MovieInfo>> call, Throwable t) {

            }
        });
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        toogle = new ActionBarDrawerToggle(this, drawerLayout, 0, 0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout.setDrawerListener(toogle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        toogle.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

}
