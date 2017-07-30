package com.example.yungui.weather.http.api;

import com.example.yungui.weather.http.response.BaseAppResponse;
import com.example.yungui.weather.modle.UpdateInfo;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yungui on 2017/6/27.
 */

public interface AppController {

    @GET("http://api.caoliyu.cn/appupdate.json")
    Observable<BaseAppResponse<UpdateInfo>> checkUpdate();

    /**
     * 天气api接口密尺 key=e69b046a9f7142bc82c21b96482eb31c
     * @return
     */
    @GET("http://api.caoliyu.cn/weatherkey.json")
    Observable<BaseAppResponse<String>> getWeatherKey();

}
