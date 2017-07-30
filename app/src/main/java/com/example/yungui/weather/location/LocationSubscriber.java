package com.example.yungui.weather.location;

import android.support.annotation.NonNull;

import com.baidu.location.BDLocation;

import org.greenrobot.eventbus.Subscribe;

import rx.Subscriber;

/**
 * Created by yungui on 2017/6/22.
 */

public abstract class LocationSubscriber extends Subscriber<BDLocation> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        onLocaedFail(null);

    }

    @Override
    public void onNext(BDLocation bdLocation) {
        if (bdLocation != null) {
            onLocatedSuccess(bdLocation);
        } else {
            onLocaedFail(bdLocation);
        }
    }

    public abstract void onLocatedSuccess(@NonNull BDLocation bdLocation);

    public abstract void onLocaedFail(BDLocation bdLocation);
}
