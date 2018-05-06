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
 * js调用java的方法
 */

public class JSInterfaceHelper {
    public static final String TAG = "JSInterfaceHelper";
    public static final String HTML_SOURCR = "local_obj";
    public static final String IMG_CLICK = "imageListener";
    public static final String ALL_IMG = "allImages";


    // 获取 img 标签正则
    private static final String IMAGE_URL_TAG = "<img.*src=(.*?)[^>]*?>";
    // 获取 src 路径的正则
    private static final String IMAGE_URL_CONTENT = "http:\"?(.*?)(\"|>|\\s+)";

    OnJSInterface onJSInterface;

    public JSInterfaceHelper(OnJSInterface onJSInterface) {
        this.onJSInterface = onJSInterface;
    }

    /**
     * 返回整个页面的HTML数据
     *
     * @param html
     */
    @android.webkit.JavascriptInterface
    public void showSource(String html) {
        //返回HTML数据的回调
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


    /**
     * 获得已加载页面的所有图片地址
     *
     * @param html
     */

    @JavascriptInterface
    public void getImagesFromSource(String html) {
        onJSInterface.getAllImages(getAllImageUrlFromHtml(html));
    }

    @JavascriptInterface
    public void getTextContent(String content) {
        onJSInterface.getTextContent(content);
    }

    /**
     * 回调接口
     */
    public interface OnJSInterface {
        void getItemUrl(String url);

        void showSource(String html);

        void getPreSource(String html);

        void openImage(String url);

        void getAllImages(List<String> imageList);

        void showToast();

        void getTextContent(String content);

    }


    //=========================================

    /**
     * /
     * /***
     * 获取页面所有图片对应的地址对象，
     * 例如 <img src="http://sc1.hao123img.com/data/f44d0aab7bc35b8767de3c48706d429e" />
     *
     * @param html WebView 加载的 HTML 文本
     * @return
     */
    public List<String> getAllImageUrlFromHtml(String html) {
        Matcher matcher = Pattern.compile(IMAGE_URL_TAG).matcher(html);
        List<String> preImgUrls = new ArrayList<>();
        while (matcher.find()) {
            if (!preImgUrls.contains(matcher.group())) {
                preImgUrls.add(matcher.group());
            }
        }
        //解析正确地址
        return getAllImageUrlFormSrcObject(preImgUrls);

    }


    /***
     * 从图片对应的地址对象中解析出 src 标签对应的内容，即 url
     * 例如 "http://sc1.hao123img.com/data/f44d0aab7bc35b8767de3c48706d429e"
     * @param preImageUrls 图片地址对象例如 ：
     *<img src="http://sc1.hao123img.com/data/f44daab" />
     */
    public List<String> getAllImageUrlFormSrcObject(List<String> preImageUrls) {
        List<String> imgUrls = new ArrayList<>();
        imgUrls.clear();
        for (String image : preImageUrls) {
            Matcher matcher = Pattern.compile(IMAGE_URL_CONTENT).matcher(image);
            while (matcher.find()) {
                if (imgUrls.contains(matcher.group().substring(0, matcher.group().length() - 1))) {
                    continue;
                }
                imgUrls.add(matcher.group().substring(0, matcher.group().length() - 1));
            }
        }
        return imgUrls;
    }


}
