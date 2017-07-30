package com.example.yungui.weather;

import android.app.Application;
import android.content.Context;

import com.example.yungui.weather.BuildConfig;

/**
 * Created by yungui on 2017/6/18.
 */

public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        //获取当前进程的全局的 ，单一的context
        mContext = getApplicationContext();

        //此处初始化litePal数据库工具

        //如果没有处理程序没有bug，手动处理
        if (!BuildConfig.DEBUG) {

        }
    }

    public static Context getContext() {
        return mContext;
    }
}
