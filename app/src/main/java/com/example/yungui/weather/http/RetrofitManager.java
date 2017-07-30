package com.example.yungui.weather.http;

import com.example.yungui.weather.App;
import com.example.yungui.weather.utils.FileUtil;
import com.example.yungui.weather.utils.NetUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 网络工具
 * Created by yungui on 2017/6/26.
 */

public class RetrofitManager {

    private static RetrofitManager retrofitManager;
    private static Retrofit retrofit;
    private static Gson gson;
    private static String cookie = "";

    /**
     * 私有的构造方法
     */
    private RetrofitManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://liyuyu.cn/")
                .client(httpClient())
                //支持对定义的api接口返回的gson数据进行解析
                .addConverterFactory(GsonConverterFactory.create(gson()))
                //支持rxjava
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }

    //单例模式
    public static RetrofitManager getInstance() {
        if (retrofitManager == null) {
            synchronized (RetrofitManager.class) {
                retrofitManager = new RetrofitManager();
            }
        }
        return retrofitManager;
    }

    //重置
    public static void reset() {
        retrofitManager = null;
    }

    /**
     *
     * @param service
     * @param <T>
     * @return
     */
    public <T> T Create(Class<T> service) {
        return retrofit.create(service);
    }

    /**
     * 返回不知接收gson的Gson
     *
     * @return
     */
    public static Gson gson() {
        if (gson == null) {
            //同步锁
            synchronized (RetrofitManager.class) {
                gson = new GsonBuilder().setLenient().create();
            }
        }
        return gson;
    }

    /**
     * 设置自定义的okhttpclient
     * @return
     */
    private static OkHttpClient httpClient() {
        //新建缓存目录
        File cacheFile = new File(FileUtil.getAppCacheDir(App.getContext()), "/HttpCache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100);
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //如果网络不可用
                if (!NetUtils.isNetWorkReachable(App.getContext())) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                //如果网络通畅
                if (NetUtils.isNetWorkReachable(App.getContext())) {
                    //设置超时事件为0
                    int maxAge = 0;
                    response.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .build();
                } else {
                    //无网络是设置超时未一周
                    int maxStable = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStable)
                            .build();
                }
                return response;
            }
        };
        return new OkHttpClient.Builder()
                .cache(cache).addInterceptor(interceptor)
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

    }
}
