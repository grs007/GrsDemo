package com.grs.my.net;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by snail on 16/11/8.
 */
public class ApiClient {
    private static final int DEFAULT_TIMEOUT = 10000;
    private static Retrofit retrofit;
    private static IMyApi mMyApi;
    private static String BASE_URL = "http://182.92.224.182:9521";

    private ApiClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
//                .addInterceptor(new AddCookiesInterceptor());
        okHttpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mMyApi = retrofit.create(IMyApi.class);
    }

    //在访问IChineseStudyApi时创建单例
    private static class SingletonHolder {
        private static final ApiClient INSTANCE = new ApiClient();
    }

    //获取单例
    public static ApiClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public IMyApi getMApiy() {
        return mMyApi;
    }
}
