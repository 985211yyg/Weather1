package com.example.yungui.weather.location;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.example.yungui.weather.App;
import com.example.yungui.weather.Listener.AMapLocationListener;
import com.tbruyelle.rxpermissions.RxPermissions;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observables.SyncOnSubscribe;


/**
 * Created by yungui on 2017/6/22.
 */

public class RxLocation {

    public static final String TAG = RxLocation.class.getName();
    //私有的静态实例
    private static RxLocation instance = new RxLocation();

    //私有的构造方法
    private RxLocation() {
    }

    //返回实例
    public static RxLocation getInstance() {
        return instance;
    }

    public Observable<AMapLocation> locate(final Activity context) {
        Log.e(TAG, "locate: " );
        return Observable.unsafeCreate(new LocationObservable_OnSubscribe(context));
    }
    /**
     * 获取上次定位过的位置
     *
     * @param context
     * @return
     */
    public Observable<AMapLocation> locateLastKnown(Context context) {

        return Observable.unsafeCreate(new LocationLastKnownObservable_OnSubscribe(context));
    }
}
