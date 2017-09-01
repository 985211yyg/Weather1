package com.example.yungui.weather.location;

import android.content.Context;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

/**
 * Created by yungui on 2017/6/22.
 */

public class MyLocationClient {

    private AMapLocationClient realLocationClient;
    //创建实例并保存在主内存中
    //代理定位客户端
    private static volatile MyLocationClient proxyClient;

    /**
     * 私有的构造方法，构造代理类实例化真正的定位客户端，并设置各种参数
     *
     * @param context
     */
    private MyLocationClient(Context context) {
        realLocationClient = new AMapLocationClient(context);
        AMapLocationClientOption clientOption = new AMapLocationClientOption();
        //配置参数
        clientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//高精度定位
        //使用单次定位，省电
        clientOption.setOnceLocation(true);
        //获取最近3s内精度最高的定位
        clientOption.setOnceLocationLatest(true);
        //设置返回地址描述
        clientOption.setNeedAddress(true);
        //设置定位超时时间 30S
        clientOption.setHttpTimeOut(30000);
        //开启定位缓存,缓存网络定位
        clientOption.setLocationCacheEnable(true);
        //设置参数
        realLocationClient.setLocationOption(clientOption);
        //启动定位
        realLocationClient.startLocation();

    }

    //公开的方法
    public static MyLocationClient getInstance(Context context) {
        if (proxyClient == null) {
            //单例模式
            synchronized (AMapLocationClient.class) {
                if (proxyClient == null) {
                    proxyClient = new MyLocationClient(context.getApplicationContext());
                }

            }
        }
        return proxyClient;
    }

    //定位方法
    public void locate(final com.example.yungui.weather.Listener.AMapLocationListener aMapLocationListener) {
        //注册定位监听
        realLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {

                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        //可在其中解析amapLocation获取相应内容。
                        aMapLocationListener.LocationSuccess(aMapLocation);
                        //停止定位后，本地定位服务并不会被销毁
                        realLocationClient.stopLocation();

                    } else {
                        aMapLocationListener.LocationError(aMapLocation);
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError", "location Error, ErrCode:"
                                + aMapLocation.getErrorCode() + ", errInfo:"
                                + aMapLocation.getErrorInfo());
                    }
                }

            }
        });


        if (realLocationClient.isStarted()) {
            realLocationClient.stopLocation();
        }
    }

    //返回最后的定位
    public AMapLocation getLastKnownLocation() {
        return realLocationClient.getLastKnownLocation();
    }
}

