package com.example.yungui.weather.utils;

import rx.Subscriber;

public abstract class SimpleSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
    }
}
