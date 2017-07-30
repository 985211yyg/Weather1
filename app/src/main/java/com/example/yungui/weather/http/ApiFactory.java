package com.example.yungui.weather.http;

import com.example.yungui.weather.http.api.AppController;
import com.example.yungui.weather.http.api.GirlsController;
import com.example.yungui.weather.http.api.VideoController;
import com.example.yungui.weather.http.api.WeatherController;

/**
 * Created by yungui on 2017/6/27.
 */

public class ApiFactory {
    public static final Object monitor = new Object();
    public static AppController appController;
    public static WeatherController weatherController;
    public static GirlsController girlsController;
    public static VideoController videoController;

    public static AppController getAppController() {
        if (appController == null) {
            synchronized (monitor) {
                appController = RetrofitManager.getInstance().Create(AppController.class);
            }
        }
        return appController;
    }

    public static WeatherController getWeatherController() {
        if (weatherController == null) {
            synchronized (monitor) {
                weatherController = RetrofitManager
                        .getInstance()
                        .Create(WeatherController.class);
            }
        }
        return weatherController;
    }
    public static GirlsController getGirlsController() {
        if (girlsController == null) {
            synchronized (monitor) {
                //将请求借口和retrofit结合组成请求工具
                girlsController = RetrofitManager.getInstance().Create(GirlsController.class);
            }
        }
        return girlsController;
    }

    public static VideoController getVideoController() {
        if (videoController == null) {
            synchronized (monitor) {
                //组合请求的工具
                videoController = RetrofitManager.getInstance().Create(VideoController.class);
            }
        }
        return videoController;
    }


}
