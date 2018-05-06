package com.example.yungui.weather.ui.nh;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.blankj.utilcode.util.ToastUtils;
import com.example.yungui.weather.R;
import com.example.yungui.weather.modle.nh.HtmlBean;
import com.example.yungui.weather.ui.base.BaseActivity;
import com.google.android.exoplayer.C;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

public class PicShareActivity extends BaseActivity {
    private Toolbar toolbar;
    private String content, title;
    private WebView fakeWebView;
    private WebSettings webSettings;
    private RadioGroup radioGroup;
    private RadioButton white;
    private HtmlBean htmlBean;

    private MaterialDialog materialDialog;
    private MaterialDialog.Builder builder;

    private Uri shareUri;
    private boolean isShare = false;

    public static final int WHITE_MODE = 0;
    public static final int BLACK_MODE = 1;
    private int Mode = 0;

    private LinearLayout share, download;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pic_share;
    }

    @Override
    protected int getMenuId() {
        return 0;
    }

    @Override
    protected void onMenuItemClick(int itemId) {

    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void initView(Bundle savedInstanceState) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        htmlBean = (HtmlBean) getIntent().getSerializableExtra("htmlBean");
//        Log.e(TAG, "initView: "+htmlBean.toString() );
        share = (LinearLayout) findViewById(R.id.share_lin);
        download = (LinearLayout) findViewById(R.id.download_lin);
        fakeWebView = (WebView) findViewById(R.id.fakeWebView);
        fakeWebView.setDrawingCacheEnabled(true);
        fakeWebView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        webSettings = fakeWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        fakeWebView.loadUrl("file:///android_asset/JianShu.html");
        assembleData(htmlBean);
        fakeWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    updateWebView();
                }
            }
        });

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.white:
                        Mode = WHITE_MODE;
                        updateWebView();
                        break;
                    case R.id.black:
                        Mode = BLACK_MODE;
                        updateWebView();
                        break;
                }
            }
        });
        builder = new MaterialDialog.Builder(this).backgroundColor(android.R.color.transparent)
                .progress(true, 0)
                .itemsGravity(GravityEnum.END);


    }

    private void assembleData(HtmlBean htmlBean) {
        final String data = htmlBean.getContent();
        final String title = htmlBean.getTitle();
        final String author = htmlBean.getAuthor();
        final String publishTime = htmlBean.getPublishTime();
        String Title = "<h2>" + title + "</h2>";
        String Footer = "<p>" + author + "</p><p>" + publishTime + "</p>";
        content = Title + data + Footer;
        Log.e(this.getClass().getName(), "assembleData: " + content);
    }

    /**
     * 获取webview屏幕截图
     *
     * @return
     */
    private Bitmap getScreenView(WebView view) {

        if (view == null)
            return null;
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        int measureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(measureSpec, measureSpec);
        if (view.getMeasuredWidth()<=0 || view.getMeasuredHeight()<=0) {
            return null;
        }

        Bitmap longImage;
        try {
            longImage = Bitmap.createBitmap(view.getMeasuredWidth(),
                    view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(longImage);  // 画布的宽高和 WebView 的网页保持一致
            Paint paint = new Paint();
            canvas.drawBitmap(longImage, 0, view.getMeasuredHeight(), paint);
            view.draw(canvas);
            return longImage;
        } catch (OutOfMemoryError outOfMemoryError) {
            System.gc();
            longImage = Bitmap.createBitmap(view.getMeasuredWidth(),
                    view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(longImage);  // 画布的宽高和 WebView 的网页保持一致
            Paint paint = new Paint();
            canvas.drawBitmap(longImage, 0, view.getMeasuredHeight(), paint);
            view.draw(canvas);
            return longImage;
        }

    }

    private Uri compressAndSaveBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            Toast.makeText(this, "图片为空", Toast.LENGTH_SHORT).show();
            return null;
        }

        //此处范围的所谓外部存储是手机的自带内存32G,64G，并不是SD卡，是否有访问权限
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File newFileDir = new File(Environment.getExternalStorageDirectory(), "one");
            if (!newFileDir.exists()) {
                newFileDir.mkdir();
            }
            File file = new File(newFileDir, System.currentTimeMillis() + ".jpg");
            Log.e(TAG, "根目录里面的所有目录：" + newFileDir.exists());
            //打开文件输出流
            FileOutputStream os = null;
            try {
                os = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, os);
                os.flush();
                os.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            bitmap.recycle();
            //保存完成
//            Toast.makeText(PicShareActivity.this, "保存完成", Toast.LENGTH_SHORT).show();
            //通知相册有新图片加入
            MediaScannerConnection.scanFile(this,
                    new String[]{file.toString()},
                    null, new MediaScannerConnection.OnScanCompletedListener() {
                        @Override
                        public void onScanCompleted(String path, Uri uri) {
                            materialDialog.dismiss();
                            Log.e(TAG, ">>>>>>>>>>>>onScanCompleted: " + uri.toString());
                            if (isShare) {
                                Intent shareIntent = new Intent();
                                shareIntent.setAction(Intent.ACTION_SEND);
                                //Intent.EXTRA_STREAM 标配 Intent.ACTION_SEND)
                                shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                                shareIntent.setType("image/*");
                                startActivity(Intent.createChooser(shareIntent, "分享图片"));
                                isShare = false;
                            }
                        }
                    });

        }
        Log.e(TAG, "compressAndSaveBitmap: " + shareUri);
        return shareUri;
    }


    @Override
    protected void loadData() {

    }

    @SuppressLint("ResourceAsColor")
    public void onShare(View view) {
        isShare = true;

        compressAndSaveBitmap(getScreenView(fakeWebView));

    }
    @SuppressLint("ResourceAsColor")
    public void onDownload(View view) {
        materialDialog = builder.show();
        compressAndSaveBitmap(getScreenView(fakeWebView));

    }

    public void updateWebView() {
        if (Mode == WHITE_MODE) {
            fakeWebView.setBackgroundColor(Color.WHITE);
        } else {
            fakeWebView.setBackgroundColor(Color.parseColor("#263238"));
            content = "<div style=\"color: gray;display: inline;\">" + content + "</div>";
            Log.e(this.getClass().getName(), "updateWebView: " + content);
        }
        fakeWebView.loadUrl("javascript:changeContent(\"" + content.replace("\n", "\\n").replace("\"", "\\\"").replace("'", "\\'") + "\")");
    }


}
