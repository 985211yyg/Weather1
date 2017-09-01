package com.example.yungui.weather.location;

import android.support.annotation.NonNull;

import com.amap.api.location.AMapLocation;
import com.baidu.location.BDLocation;

import org.greenrobot.eventbus.Subscribe;

import rx.Subscriber;

/**
 * Created by yungui on 2017/6/22.
 */

public abstract class LocationSubscriber extends Subscriber<AMapLocation> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        onLocaedFail(null);

    }

    @Override
    public void onNext(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            onLocatedSuccess(aMapLocation);
        } else {
            onLocaedFail(aMapLocation);
        }
    }

    public abstract void onLocatedSuccess(@NonNull AMapLocation aMapLocation);

    public abstract void onLocaedFail(AMapLocation aMapLocation);
}
