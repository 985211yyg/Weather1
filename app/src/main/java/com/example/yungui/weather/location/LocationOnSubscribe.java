package com.example.yungui.weather.location;

import android.app.Activity;
import android.content.Context;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;

import rx.Observable;
import rx.Subscriber;

/**
 * 注册事件监听，监听BDLocation 的变化
 * Created by yungui on 2017/6/22.
 */

public class LocationOnSubscribe implements Observable.OnSubscribe<BDLocation> {
    private Context context;

    public LocationOnSubscribe(Activity context) {
        this.context = context;
    }

    @Override
    public void call(Subscriber<? super BDLocation> subscriber) {
        //定位
        MyLocationClient
                .getInstance(context)
                .locate(new BDLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                subscriber.onNext(bdLocation);
                subscriber.onCompleted();
            }

            @Override
            public void onConnectHotSpotMessage(String s, int i) {

            }
        });
    }
}
