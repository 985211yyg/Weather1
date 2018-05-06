package com.example.yungui.weather.ui.JavaScriptInteraction;

import android.webkit.WebView;

/**
 * Created by yungui on 2017/8/7.
 * 向JS中注入调用java的代码
 */

public class JSInject {
    /**
     * 注入 js获取网页主内容
     * @param view
     */
    public static void addJsForPreHtmlSource(WebView view) {

        view.loadUrl("javascript:window.local_obj.getPreSource('<head>'+"
                + "document.getElementsByTagName('html')[0].innerHTML+'</head>');");
    }

    /**
     * 注入JS，获得的页面中获取已加载页面所有图片地址
     *
     * @param view
     */
    public static void addJsForAllImages(WebView view) {

        view.loadUrl("javascript:window.allImages.getImagesFromSource('<head>'+"
                + "document.getElementsByTagName('html')[0].innerHTML+'</head>');");
    }


    /**
     * 注入 js 函数监听，这段 js 函数的功能就是获取webviewd加载完初始页面的htmlshuju
     * 此方法在onpageFish()中值调用一次
     */
    public static void addJsForHtmlSource(WebView view) {

        view.loadUrl("javascript:window.local_obj.showSource('<head>'+"
                + "document.getElementsByTagName('html')[0].innerHTML+'</head>');");
    }
    /*
    注入js获取主要内容
     */

    public static void addJsForTextContent(WebView view) {

        view.loadUrl("javascript:window.local_obj.getTextContent("
                + "document.getElementsByClassName('text-content')[0].innerHTML);");
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
                + "objs[i].onclick=function()  " +
                "    {  "
                + "        window.imageListener.openImage(this.src);  " +
                "    }  " +
                "}" +
                "})()");
    }

    /**
     * 注入js 添加item的点击事件，获取点击的index
     * 此段代码的功能是点击网页item是返回该item的url
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
