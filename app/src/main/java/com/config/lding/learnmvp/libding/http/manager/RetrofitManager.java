package com.config.lding.learnmvp.libding.http.manager;

import com.config.lding.learnmvp.libding.entity.GetListRsp;
import com.config.lding.learnmvp.libding.http.ApiService;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import static com.config.lding.learnmvp.libding.http.ApiService.APP_HOST;

public class RetrofitManager {

    private static final int DEFAULT_TIMEOUT=5;
    private Retrofit retrofit;
    private ApiService mGithubService;
    private static final RetrofitManager INSTANCE=new RetrofitManager();
    private RetrofitManager(){

        OkHttpClient.Builder httpClientBuilder=new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit=new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(APP_HOST)
                .build();
        mGithubService=retrofit.create(ApiService.class);
    }
    //获取单例
    public static RetrofitManager getInstance(){
        return INSTANCE;
    }
    public void getGetListRsp(Subscriber<GetListRsp> subscriber, Map<String, String> params){
        mGithubService.getGetListRsp(params)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
