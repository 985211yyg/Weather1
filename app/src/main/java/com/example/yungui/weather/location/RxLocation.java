package com.example.yungui.weather.location;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.baidu.location.BDLocation;
import com.example.yungui.weather.modle.HeWeather5;
import com.tbruyelle.rxpermissions.RxPermissions;

import rx.Observable;
import rx.functions.Func1;


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

    public Observable<BDLocation> locate(final Activity context) {
        //请求权限
        return new RxPermissions(context)
                .request(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.READ_PHONE_STATE)
                .flatMap(new Func1<Boolean, Observable<BDLocation>>() {
                    //权限请求成功的话
                    @Override
                    public Observable<BDLocation> call(Boolean aBoolean) {
                        if (aBoolean) {
                            Log.e(TAG, "请求权限成功");
                            return Observable
                                    .unsafeCreate(new LocationOnSubscribe(context));
                        }
                        return null;
                    }
                });
    }

    /**
     * 获取上次定位过的位置
     * @param context
     * @return
     */
    public Observable<BDLocation> locateLastKnown(Context context) {
        return Observable.unsafeCreate(new LocationLastKnownOnSubscribe(context));
    }
}
