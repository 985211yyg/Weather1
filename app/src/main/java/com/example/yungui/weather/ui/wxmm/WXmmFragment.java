package com.example.yungui.weather.ui.wxmm;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.circleindicator.CircleIndicator;
import com.example.yungui.weather.R;
import com.example.yungui.weather.http.api.Api;
import com.example.yungui.weather.ui.JavaScriptInteraction.JSInject;
import com.example.yungui.weather.ui.JavaScriptInteraction.JSInterfaceHelper;
import com.example.yungui.weather.ui.MainActivity;
import com.example.yungui.weather.ui.base.BaseFragment;
import com.example.yungui.weather.ui.wxmm.adapter.BannerAdapter;
import com.example.yungui.weather.widgets.mWebView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yungui on 2017/6/19.
 */

public class WXmmFragment extends BaseFragment implements JSInterfaceHelper.OnJSInterface {
    private Toolbar toolbar;
    private BannerAdapter bannerAdapter;
    private CircleIndicator circleIndicator;
    private ViewPager viewPager;
    private Subscription subscription;
    private ProgressBar progressBar;

    private List<String> bannerUrls = new ArrayList<>();
    private List<String> bannerDecs = new ArrayList<>();

    private List<String> imgUrls = new ArrayList<>();

    private String data;
    private String longClickUrl;
    private mWebView webView;
    private WebView preWebView;
    private WebSettings webSettings, preWebViewSetting;

    //是否清除图片数据
    private boolean isClearPicData = false;

    private int loadCount = 0;
    private TextView HtmlTV;
    //锚定popupmenu
    private Button anchor;

    //用于标记是否点击了item，点击之后才能动态注入 图片点击事件JS
    private boolean isClickItem = false;
    // 获取 img 标签正则
    private static final String IMAGE_URL_TAG = "<img.*src=(.*?)[^>]*?>";
    // 获取 src 路径的正则
    private static final String IMAGE_URL_CONTENT = "http:\"?(.*?)(\"|>|\\s+)";


    @Override
    protected int getLayoutID() {
        return R.layout.fragment_wx_mm;
    }

    @Override
    protected int getMenuID() {
        return 0;
    }

    @Override
    protected void onMenuItemClick(int id) {

    }

    @Override
    protected void initView() {
        toolbar = findView(R.id.toolbar);
        ((MainActivity) getActivity()).initToolbar(toolbar);

        viewPager = findView(R.id.banner_viewPager);
        circleIndicator = findView(R.id.circleIndicator);

        preWebView = findView(R.id.preWebView);
        anchor = findView(R.id.anchor);

        webView = findView(R.id.webView);
        webView.canGoBack();
        webSettings = webView.getSettings();
        //开启js交互
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);

        preWebViewSetting = preWebView.getSettings();
        preWebViewSetting.setUseWideViewPort(true);
        preWebViewSetting.setJavaScriptEnabled(true);

        preWebView.addJavascriptInterface(new JSInterfaceHelper(this), "local_obj");
        preWebView.addJavascriptInterface(new JSInterfaceHelper(this), "imageListener");

        //注入HTML获取去js
        webView.addJavascriptInterface(new JSInterfaceHelper(this), "local_obj");
        //注入item点击监听js
        webView.addJavascriptInterface(new JSInterfaceHelper(this), "itemListener");
        //注入图片店家监听js
        webView.addJavascriptInterface(new JSInterfaceHelper(this), "imageListener");

        //回调事件
        webView.setWebViewClient(new WebViewClient() {
            /**
             * 此方法值调用一次，如果入到上拉加载的页面无法获取相关信息
             * @param view
             * @param url
             */
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //注入js，获取原数,
//                JSInject.addJsForHtmlSource(view);
                JSInject.addItemClickListener(view);

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;

            }

            /**
             * 该方法在每次加载资源的时候都会调用
             * @param view
             * @param url
             */
            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
//                Log.e(TAG, ">>>>>>>>>>>>>>>>onLoadResource: " + webView.ifRefresh());
                //注入js代码，获取所有html数据
//                addJsForHtmlSource(view);
                JSInject.addItemClickListener(view);
                JSInject.addImageClickListener(view);
            }

        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.e(TAG, "onReceivedTitle: " + title);
            }
        });
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                    webView.goBack();
                    imgUrls.clear();
                    return true;
                }
                return false;
            }
        });

        webView.setOnLongClickListener(new View.OnLongClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, "长按", Toast.LENGTH_SHORT).show();
                responseWebLongClick(v);
                return true;
            }
        });

        preWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //注入js
                Log.e(TAG, "onPageFinished: 注入JS！！！");
                JSInject.addJsForPreHtmlSource(view);
//                JSInject.addImageClickListener(view);
            }
        });

    }


    @Override
    protected void lazyFetchData() {
        subscription = Observable
                .just(Api.WX_MM)
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String url) {
                        try {
                            Document document = Jsoup.connect(url).timeout(1500).get();
                            Elements as = document.select(".swiper").select("a[href]");
//                            Log.e(TAG, "a: " + as.toString());
                            int i = 0;
                            for (Element a : as) {
                                String imgUrl = a.select("div").attr("style");
                                String desc = a.select("p").text();
                                bannerDecs.add(desc);
                                int startIndex = imgUrl.indexOf("(") + 2;
                                int endIndex = imgUrl.lastIndexOf(")") - 1;
                                String bannerUrl = imgUrl.substring(startIndex, endIndex);
                                bannerUrls.add(bannerUrl);
//                                Log.e(TAG, " "+imgUrl+"startIndex"+startIndex+"endIndex"+endIndex+"bannerUrl:"+bannerUrl);
                            }
//                            Log.e(TAG, "bannerUrls" + bannerUrls.toString());
                            //去除html banner
                            document.select("#namespace_0").remove();
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
                        webView.loadDataWithBaseURL(Api.WX_MM, s, "text/html", "utf-8", null);
                        bannerAdapter = new BannerAdapter(getFragmentManager(), bannerUrls, bannerDecs);
                        viewPager.setAdapter(bannerAdapter);
                        circleIndicator.setUpWithViewPager(viewPager);
                    }
                });

    }

    /**
     * 响应图片长按事件，处理点击对象的信息
     *
     * @param v
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    private void responseWebLongClick(View v) {
        if (v instanceof WebView) {
            WebView.HitTestResult result = ((WebView) v).getHitTestResult();
            //获得了点击处数据
            if (result != null) {
                int type = result.getType();
                //如果长安的是图片
                if (type == WebView.HitTestResult.IMAGE_TYPE || type == WebView.HitTestResult.SRC_IMAGE_ANCHOR_TYPE) {
                    longClickUrl = result.getExtra();
                    //弹出菜单
                    Log.e(TAG, "responseWebLongClick: " + longClickUrl);
                    showDialog(longClickUrl, v);
                }
            }
        }

    }

    /**
     * 展示弹框
     *
     * @param Url
     * @param v
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    public void showDialog(String Url, View v) {
        PopupWindow popupWindow = new PopupWindow(800, 200);
        //进出动画
        popupWindow.setAnimationStyle(R.style.popupWindow_toast_anim);
        //布局
        popupWindow.setContentView(getActivity().getLayoutInflater().inflate(R.layout.popupwindow, null));
        popupWindow.setElevation(2);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        //更新状态
        popupWindow.update();
        popupWindow.showAtLocation(webView, Gravity.CENTER, 0, 0);

    }

    /**
     * 下载图片
     *
     * @param url
     */
    public void downloadImg(String url) {
        Toast.makeText(mContext, "保存完成！", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void getItemUrl(String url) {
        Log.e(TAG, ">>>>>>>getItemIndex: " + url);
        //可以开始获取万文章详情进行图片
        Observable.just(url)
                .subscribeOn(Schedulers.io())
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
                        preWebView.loadUrl(s);

                    }
                });

    }

    @Override
    public void showSource(String html) {

    }

    @Override
    public void getPreSource(String html) {
        getAllImageUrlFromHtml(html);

    }

    @Override
    public void openImage(String url) {
        //处理URL
        String newUrl = url.replace("640", "0").substring(0, url.lastIndexOf("jpeg") + 2);
        int index = imgUrls.indexOf(newUrl);
        Intent intent = new Intent(mContext, WXmmPicActivity.class);
        intent.putExtra("position", index);
        intent.putStringArrayListExtra("imgs", (ArrayList<String>) imgUrls);
        startActivity(intent);
    }

    @Override
    public void getAllImages(List<String> imageList) {

    }


    @Override
    public void showToast() {
        Log.e(TAG, ">>>>>>>showToast: ");
    }

    @Override
    public void getTextContent(String content) {

    }

    /**
     * /
     * /***
     * 获取页面所有图片对应的地址对象，
     * 例如 <img src="http://sc1.hao123img.com/data/f44d0aab7bc35b8767de3c48706d429e" />
     *
     * @param html WebView 加载的 HTML 文本
     * @return
     */
    private List<String> getAllImageUrlFromHtml(String html) {
        Matcher matcher = Pattern.compile(IMAGE_URL_TAG).matcher(html);
        List<String> preImgUrls = new ArrayList<>();
        while (matcher.find()) {
            preImgUrls.add(matcher.group());
        }
        //解析正确地址
        getAllImageUrlFormSrcObject(preImgUrls);
        return preImgUrls;

    }

    /***
     * 从图片对应的地址对象中解析出 src 标签对应的内容，即 url
     * 例如 "http://sc1.hao123img.com/data/f44d0aab7bc35b8767de3c48706d429e"
     * @param listImageUrl 图片地址对象例如 ：
     *<img src="http://sc1.hao123img.com/data/f44daab" />
     */
    private List<String> getAllImageUrlFormSrcObject(List<String> listImageUrl) {
        if (isClearPicData) {
            imgUrls.clear();
        }
        for (String image : listImageUrl) {
            Matcher matcher = Pattern.compile(IMAGE_URL_CONTENT).matcher(image);
            while (matcher.find()) {
                imgUrls.add(matcher.group().substring(0, matcher.group().length() - 1));
            }
        }
        Log.e(TAG, "getAllImageUrlFormSrcObject: " + imgUrls.size() + imgUrls.toString());
        return imgUrls;
    }

    /**
     * 注册Eventbus
     */
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (subscription != null || !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
            subscription = null;
        }
        //解绑被观察者
        if (subscription != null && subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        if (webView != null) {
            webView.loadUrl(null);
            webView = null;
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        webView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        webView.onResume();
    }
}
