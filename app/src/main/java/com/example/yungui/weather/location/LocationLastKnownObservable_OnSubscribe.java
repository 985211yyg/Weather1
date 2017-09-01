package com.example.yungui.weather.location;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.example.yungui.weather.Listener.AMapLocationListener;

import rx.Observable;
import rx.Subscriber;

/**
 * 获取上册的定位，并监听其变化
 * Created by yungui on 2017/6/22.
 */

public class LocationLastKnownObservable_OnSubscribe implements Observable.OnSubscribe<AMapLocation> {
    private Context context;

    public LocationLastKnownObservable_OnSubscribe(Context context) {
        this.context = context;

    }

    @Override
    public void call(Subscriber<? super AMapLocation> subscriber) {

        AMapLocation lateKnownLocation = MyLocationClient.getInstance(context).getLastKnownLocation();

        //如果从上次的定位中获得了定位数据，则直接发送
        if (lateKnownLocation != null) {
            //发射数据
            subscriber.onNext(lateKnownLocation);
            subscriber.onCompleted();
        } else {
            //没有数据，开启新的定位
            MyLocationClient.getInstance(context).locate(new AMapLocationListener() {
                @Override
                public void LocationSuccess(AMapLocation aMapLocation) {
                    if (aMapLocation != null) {

                        //发射数据
                        subscriber.onNext(aMapLocation);
                    }
                    subscriber.onCompleted();
                }

                @Override
                public void LocationError(AMapLocation aMapLocation) {
                }
            });
        }
    }

}
