package com.example.yungui.weather.location;

import android.content.Context;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;

import rx.Observable;
import rx.Subscriber;

/**   获取上册的定位，并监听其变化
 * Created by yungui on 2017/6/22.
 */

public class LocationLastKnownOnSubscribe implements Observable.OnSubscribe<BDLocation> {
    private Context context;

    public LocationLastKnownOnSubscribe(Context context) {
        this.context = context;

    }

    @Override
    public void call(Subscriber<? super BDLocation> subscriber) {

        BDLocation lateKnownLocation = MyLocationClient.getInstance(context).getLastKnownLocation();
        //如果从上次的定位中获得了定位数据，则直接发送
        if (lateKnownLocation != null) {
            subscriber.onNext(lateKnownLocation);
            subscriber.onCompleted();
        } else {
            //仪回调接口的方式，重新定位
            MyLocationClient.getInstance(context).locate(new BDLocationListener() {
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

}
