package com.example.yungui.weather.widgets;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by yungui on 2017/8/2.
 */

public class mNestedScrollView extends NestedScrollView {

    public mNestedScrollView(Context context) {
        super(context);
    }

    public mNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public mNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //拦截事件
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.e("onInterceptTouchEvent",""+getTop());
                //如果滑动到顶端则不拦截事件
                if (getTop() <= 24) {
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
