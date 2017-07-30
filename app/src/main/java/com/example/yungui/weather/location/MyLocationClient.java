package com.example.yungui.weather.location;

import android.content.Context;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

/**
 * Created by yungui on 2017/6/22.
 */

public class MyLocationClient {
    private LocationClient realClient;
    //创建实例并保存在主内存中
    private static volatile MyLocationClient proxyClient;

    /**
     * 私有的构造方法，构造代理类实例化真正的定位客户端，并设置各种参数
     *
     * @param context
     */
    private MyLocationClient(Context context) {
        //获取百度定位实例
        realClient = new com.baidu.location.LocationClient(context);
        //设置定位参数
        LocationClientOption locationClientOption = new LocationClientOption();
        //设置定位精度
        locationClientOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        locationClientOption.setCoorType("bd09ll");
        locationClientOption.setIsNeedAddress(true);
        //确定定位参数
        realClient.setLocOption(locationClientOption);

    }

    //公开的方法
    public static MyLocationClient getInstance(Context context) {
        if (proxyClient == null) {
            //单例模式
            synchronized (com.baidu.location.LocationClient.class) {
                if (proxyClient == null) {
                    proxyClient = new MyLocationClient(context.getApplicationContext());
                }

            }
        }
        return proxyClient;
    }

    //定位方法  传递过来一个回调接口实例，然后实例调用接口方法将数据回传传出去
    public void locate(final BDLocationListener bdLocationListener) {
        //注册定位监听
        realClient.registerLocationListener(new BDLocationListener() {
            //定位成功
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                //电泳接口方法回传数据
                bdLocationListener.onReceiveLocation(bdLocation);
                //防止内存溢出，解绑定位监听器
                realClient.unRegisterLocationListener(this);
                realClient.stop();
            }

            @Override
            public void onConnectHotSpotMessage(String s, int i) {

            }
        });

        if (!realClient.isStarted()) {
            realClient.stop();
        }
    }

    //返回最后的定位
    public BDLocation getLastKnownLocation() {
        return realClient.getLastKnownLocation();
    }
}

