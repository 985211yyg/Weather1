package com.example.yungui.weather.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;

import com.blankj.utilcode.util.ConvertUtils;

/**
 * Created by yungui on 2017/8/1.
 */

public class mWebView extends WebView {
    protected int oldVerticalScrollRange;

    public mWebView(Context context) {
        super(context);
    }

    public mWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public mWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public mWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * 当网页加载之后长度在没有加载更多之前没有变化  在加载更多之后增加但是在滚动过程中不变
     *
     * @return
     */
    @Override
    protected int computeVerticalScrollRange() {

        return super.computeVerticalScrollRange();
    }

    public boolean ifRefresh() {
//        Log.e("oldVerticalScrollRange", oldVerticalScrollRange+"" );
//        Log.e(">>>computeVertical", " " + computeVerticalScrollRange());
//        Log.e(">>>ContentHeight", " " + getContentHeight());
//        Log.e(">>>scrollY", " " + getContentHeight());
//        Log.e(">>ContentHeight+scrollY", ":" + (getContentHeight() + getScrollY()));

        //开始getContentHeight 和computeVerticalScrollRange 是不一样的
        if (oldVerticalScrollRange == computeVerticalScrollRange()){
            return false;
        } else {
            oldVerticalScrollRange = computeVerticalScrollRange();
            return true;
        }
    }

    public void loadMore(boolean loadMore) {
        if (loadMore) {
            this.scrollTo(0,computeVerticalScrollRange());
        }
    }
}
