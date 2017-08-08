package com.example.yungui.weather.ui.JavaScriptInteraction;

import android.webkit.WebView;

/**
 * Created by yungui on 2017/8/7.
 */

public class JSInject {
    /**
     * 注入 js 函数监听 获取预加载数据
     *
     * @param view
     */
    public static void addJsForPreHtmlSource(WebView view) {

        view.loadUrl("javascript:window.local_obj.getPreSource('<head>'+"
                + "document.getElementsByTagName('html')[0].innerHTML+'</head>');");
    }


    /**
     * 注入 js 函数监听，这段 js 函数的功能就是获取webviewd加载完初始页面的htmlshuju
     * 此方法在onpageFish()中值调用一次
     */
    private static void addJsForHtmlSource(WebView view) {

        view.loadUrl("javascript:window.local_obj.showSource('<head>'+"
                + "document.getElementsByTagName('html')[0].innerHTML+'</head>');");
    }

    /**
     * PicWebView
     * 注入 js 函数监听，这段 js 函数的功能就是，遍历所有的图片，并添加 onclick 函数，
     * 实现点击事件，
     * 函数的功能是在图片点击的时候调用本地 java 接口并传递点击图片对应的 url 过去
     */
    public static void addImageClickListener(WebView view) {
        view.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName(\"img\"); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                +      "var j=i;"
                +     "objs[i].onclick=function()  " +
                "    {  "
                + "        window.imageListener.openImage(this.src,j);  " +
                "    }  " +
                "}" +
                "})()");
    }

    /**
     * 注入js 添加item的点击事件，获取点击的index
     */
    public static void addItemClickListener(WebView view) {
        view.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByClassName(\"list_item\");" +
//                "window.itemListener.showToast();"+
//                "var objs = document.getElementsByTagName(\"a\"); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "    objs[i].onclick=function()  " +
                "    {  "
                + "       window.itemListener.getItemUrl(this.href);  " +

                "    }  " +
                "}" +
                "})()");
    }

}
