package com.example.yungui.weather.http.api;

import com.example.yungui.weather.http.response.BaseWeatherResponse;
import com.example.yungui.weather.modle.HeWeather5;
import com.example.yungui.weather.modle.WeatherBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yungui on 2017/6/22.
 */

public interface WeatherController {
    /**
     *   天气查询接口
     * @param key
     * @param city
     * @return
     */
    @GET("https://free-api.heweather.com/v5/weather")
    Observable<BaseWeatherResponse<HeWeather5>> getWeather(@Query("key") String key, @Query("city") String city);
}
