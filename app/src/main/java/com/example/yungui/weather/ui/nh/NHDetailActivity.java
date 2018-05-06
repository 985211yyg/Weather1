package com.example.yungui.weather.ui.nh;

import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.yungui.weather.R;
import com.example.yungui.weather.modle.nh.HtmlBean;
import com.example.yungui.weather.ui.JavaScriptInteraction.JSInject;
import com.example.yungui.weather.ui.JavaScriptInteraction.JSInterfaceHelper;
import com.example.yungui.weather.ui.base.BaseActivity;
import com.example.yungui.weather.ui.nh.fragment.BottomSheetDialogFragment;
import com.example.yungui.weather.ui.wxmm.WXmmPicActivity;
import com.example.yungui.weather.widgets.RatioImageView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class NHDetailActivity extends BaseActivity implements
        BottomSheetDialogFragment.Listener, JSInterfaceHelper.OnJSInterface {

    private Toolbar toolbar;
    private ImageView imageView;
    private RatioImageView ratioImageView;
    private String shareUrl, imgUrl, title, tag;
    private WebView webView;
    private WebSettings webSettings;
    private Subscription subscription;
    private String data, content;
    private CoordinatorLayout coordinatorLayout;

    private List<String> imageList = new ArrayList<>();
    private JSInterfaceHelper jsInterfaceHelper;
    private HtmlBean htmlBean;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_nhdetail;
    }

    @Override
    protected int getMenuId() {
        return R.menu.menu_nh_detail;
    }

    @Override
    protected void onMenuItemClick(int itemId) {
        switch (itemId) {
            case R.id.more:
                BottomSheetDialogFragment.newInstance(4, R.layout.bottom_sheet_dialog_item,
                        BottomSheetDialogFragment.IMG).show(getSupportFragmentManager(), "dialog");
                break;
        }
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setDisplayHomeAsUpEnabled(true);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.parent);
        imageView = (ImageView) findViewById(R.id.iv_refresh);
        ratioImageView = (RatioImageView) findViewById(R.id.nh_detail_img);
        AnimatedVectorDrawable vectorDrawable = (AnimatedVectorDrawable) imageView.getDrawable();
        vectorDrawable.start();
        webView = (WebView) findViewById(R.id.nh_detail_webView);
        tag = getIntent().getStringExtra("tag");
        title = getIntent().getStringExtra("title");
        shareUrl = getIntent().getStringExtra("url");
        imgUrl = getIntent().getStringExtra("img");
        htmlBean = new HtmlBean();
        htmlBean.setTitle(title);
        htmlBean.setshareUrl(shareUrl);
        toolbar.setTitle(title);

        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        //开启缓存
        webSettings.setAppCacheEnabled(true);
        //设置缓存目录
        webSettings.setAppCachePath(this.getCacheDir().getAbsolutePath());
        //设置缓存大小
        jsInterfaceHelper = new JSInterfaceHelper(this);
        webView.addJavascriptInterface(jsInterfaceHelper, JSInterfaceHelper.IMG_CLICK);
        webView.addJavascriptInterface(jsInterfaceHelper, JSInterfaceHelper.ALL_IMG);
        webView.addJavascriptInterface(jsInterfaceHelper, JSInterfaceHelper.HTML_SOURCR);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //注入js
                JSInject.addJsForAllImages(view);
                JSInject.addJsForTextContent(view);

                //音乐界面是不注入图片点击监听
                if (!tag.equals("music")) {
                    JSInject.addImageClickListener(view);
                }

            }
        });
        webView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (v instanceof WebView) {
                    WebView.HitTestResult hitTestResult = ((WebView) v).getHitTestResult();
                    if (hitTestResult != null) {
                        int type = hitTestResult.getType();
                        switch (type) {
                            case WebView.HitTestResult.IMAGE_TYPE:
                            case WebView.HitTestResult.SRC_IMAGE_ANCHOR_TYPE:
                                showMyDialog(hitTestResult.getExtra(), "分享图片");
                                break;
                            case WebView.HitTestResult.UNKNOWN_TYPE:
                                showMyDialog(((WebView) v).getOriginalUrl(), "分享长图");
                                break;

                        }
                    }
                }
                return false;
            }
        });

    }

    private void showMyDialog(String originalUrl, String title) {
        BottomSheetDialogFragment.newInstance(1, R.layout.fragment_item_list_dialog_item,
                BottomSheetDialogFragment.TEXT).show(getSupportFragmentManager(), "shareImg");

    }

    @Override
    protected void loadData() {
        Glide.with(this)
                .load(imgUrl)
                .into(ratioImageView);
        subscription = Observable
                .just(shareUrl)
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {

                        try {
                            Document document = Jsoup.connect(s).timeout(3000).get();
                            document.select(".header").remove();
                            document.select("#left-panel").remove();
                            document.select(".download").remove();
                            document.select(".weixinTip").remove();
                            document.select(".weixinBot").remove();
                            document.select("#share-btn-placeholder").remove();
                            document.select(".one-image-popup").remove();
                            document.select(".footer").remove();
                            document.select("#searchPopup_angOne_view-placeholder").remove();
                            document.select("#searchPopup_angOne_view-screen").remove();
                            document.select("#searchPopup_angOne_view-popup").remove();
                            document.select("#searchPopup_angArticle_view-popup").remove();
                            document.select("#share-btn-screen").remove();
                            document.select("#share-btn-popup").remove();
                            document.select("#haloword-lookup").remove();
                            document.select("#noMoreContent-popup").remove();
                            data = document.toString();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return data;
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {


                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        webView.loadDataWithBaseURL(shareUrl, s, "text/html", "utf-8", null);
                    }
                });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        webView.loadUrl(null);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        webView.reload();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null) {
            webView = null;
        }
    }


    @Override
    public void onItemClicked(int position) {
        //生成长图
        if (position == -1) {
            //生成长图
            Intent intent = new Intent(this, PicShareActivity.class);
            intent.putExtra("htmlBean", htmlBean);
            startActivity(intent);
        } else {
            //各自分享模式
        }

    }

    @Override
    public void getItemUrl(String url) {

    }

    @Override
    public void showSource(String html) {

    }

    @Override
    public void getPreSource(String html) {

    }

    //点击了网页图片
    @Override
    public void openImage(String url) {
//        Log.e(TAG, "openImage: " + url);
        Intent intent = new Intent(this, WXmmPicActivity.class);
        if (url != null && imageList != null) {
            int position = imageList.indexOf(url);
            intent.putExtra("position", position);
            intent.putStringArrayListExtra("imgs", (ArrayList<String>) imageList);
            startActivity(intent);
        }
    }

    /**
     * 所有已加载页面中的图片地址
     *
     * @param imageList
     */
    @Override
    public void getAllImages(List<String> imageList) {
//        Log.e(TAG, "getAllImages: " + imageList.size());
        if (imageList != null && imageList.size() != 0) {
            this.imageList = imageList;
        }
    }

    @Override
    public void showToast() {

    }

    /**
     * 获取到的文章的主要文字内容
     *
     * @param content
     */
    @Override
    public void getTextContent(String content) {
        htmlBean.setContent(content);

    }
}
