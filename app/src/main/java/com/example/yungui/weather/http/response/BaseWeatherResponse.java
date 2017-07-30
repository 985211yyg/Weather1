package com.example.yungui.weather.http.response;

import java.util.List;

/**网络请求返回的数据
 * Created by yungui on 2017/6/22.
 */

public class BaseWeatherResponse<T> {
    //定义集合，装载天气数据
    public List<T> HeWeather5;
}
