package com.example.yungui.weather.ui.JavaScriptInteraction;

import android.content.Intent;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.example.yungui.weather.ui.wxmm.WXmmPicActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yungui on 2017/8/7.
 */

public class JSInterface {
    OnJSInterface onJSInterface;
    public JSInterface(OnJSInterface onJSInterface) {
        this.onJSInterface = onJSInterface;
    }

    /**
     * 返回整个页面的HTML数据
     *
     * @param html
     */
    @android.webkit.JavascriptInterface
    public void showSource(String html) {
        //从 HTML 文件中提取页面所有图片对应的地址对象
        onJSInterface.showSource(html);
    }

    /**
     * item点击回调，返回点击的item的URL
     *
     * @param url
     */
    @android.webkit.JavascriptInterface
    public void getItemUrl(String url) {
        onJSInterface.getItemUrl(url);

    }
    /**
     * 显示提示框
     */
    @JavascriptInterface
    public void showToast() {
        onJSInterface.showToast();

    }

    /**
     * 点击图片启动新的 ShowImageFromWebActivity，并传入点击图片对应的 url
     * 和页面所有图片对应的 url
     *
     * @param url 点击图片对应的 url
     */
    @android.webkit.JavascriptInterface
    public void openImage(String url) {
        onJSInterface.openImage(url);

    }

    /**
     * 获取预加载数据
     *
     * @param html
     */
    @JavascriptInterface
    public void getPreSource(String html) {
        onJSInterface.getPreSource(html);
    }



    public interface OnJSInterface {
        void getItemUrl(String url);
        void showSource(String html);
        void getPreSource(String html);
        void openImage(String url);
        void showToast();
    }


}
