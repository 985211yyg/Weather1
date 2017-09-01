package com.example.yungui.weather.location;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.example.yungui.weather.Listener.AMapLocationListener;

import rx.Observable;
import rx.Subscriber;

/**
 * 注册事件监听，监听 AMapLocation 的变化
 * Created by yungui on 2017/6/22.
 */

public class LocationObservable_OnSubscribe implements Observable.OnSubscribe<AMapLocation> {
    private Context context;

    public LocationObservable_OnSubscribe(Activity context) {
        this.context = context;
    }

    @Override
    public void call(Subscriber<? super AMapLocation> subscriber) {
        //定位
        MyLocationClient
                .getInstance(context.getApplicationContext())
                .locate(new AMapLocationListener() {
                    @Override
                    public void LocationSuccess(AMapLocation aMapLocation) {
                        if (aMapLocation != null) {
                            Log.e("LocationSuccess", "LocationSuccess: "+aMapLocation.toStr());
                            subscriber.onNext(aMapLocation);
                        }
                        subscriber.onCompleted();
                    }

                    @Override
                    public void LocationError(AMapLocation aMapLocation) {
                        subscriber.onError(null);
                    }
                });
    }
}
