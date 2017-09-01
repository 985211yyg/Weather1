package com.example.yungui.weather.Listener;

import com.amap.api.location.AMapLocation;

/**
 * Created by yungui on 2017/8/28.
 */

public interface AMapLocationListener {
    //定位成功
    void LocationSuccess(AMapLocation aMapLocation);
    //定位失败
    void LocationError(AMapLocation aMapLocation);
}
