package com.example.yungui.weather.widgets;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.blankj.utilcode.util.EncodeUtils;
import com.example.yungui.weather.modle.nh.HtmlBean;

/**
 * Created by yungui on 2017/8/21.
 */

public class FakeWebView extends WebView {
    public static final int WHITE_MODE = 0;
    public static final int BLACK_MODE = 1;
    private boolean isFirstLoad;

    private int Mode = 0;
    private WebView webView;
    private String content,shareUrl;

    public FakeWebView(Context context) {
        this(context, null);
    }

    public FakeWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FakeWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public FakeWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        webView = this;

    }

    public int getMode() {
        return Mode;
    }

    public void setMode(int mode) {
        Mode = mode;
        updateWebView();
    }

    public void loadData(HtmlBean bean) {
        webView.loadUrl("file:///android_asset/JianShu.html");
        Log.e(this.getClass().getName(), "loadData: " + bean);
        assembleData(bean);
        updateWebView();

    }

    private void assembleData(HtmlBean bean) {
        final String data = bean.getContent();
        final String title = bean.getTitle();
        final String author = bean.getAuthor();
        final String publishTime = bean.getPublishTime();
        String Title = "<h2>" + title + "</h2>";
        String Footer = "<p>" + author + "</p><p>" + publishTime + "</p>";
        content = Title + data + Footer;
        Log.e(this.getClass().getName(), "assembleData: " + content);

    }

    public void updateWebView() {
        Log.e("updateWebView", ">>>>>>>>>>>>>>>>>updateWebView: " );
        if (Mode == WHITE_MODE) {
            webView.setBackgroundColor(Color.WHITE);
        } else {
            webView.setBackgroundColor(Color.parseColor("#263238"));
            content = "<div style=\"color: gray;display: inline;\">" + content + "</div>";
            Log.e(this.getClass().getName(), "updateWebView: " + content);
        }
        webView.loadUrl("javascript:changeContent(\"" + content.replace("\n", "\\n").replace("\"", "\\\"").replace("'", "\\'") + "\")");
    }
}
