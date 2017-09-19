package com.example.yungui.weather.ui.guide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.yungui.weather.R;
import com.example.yungui.weather.ui.MainActivity;
import com.example.yungui.weather.ui.login.LoginActivity;
import com.example.yungui.weather.utils.SettingUtil;
import com.example.yungui.weather.utils.ThemeUtil;

/**
 * 主要用于展示欢迎界面，同时检查是否登陆，如果登陆直接转到主界面，如果没有登陆在煮那道登陆界面
 */
public class FullscreenActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {

    private static final boolean AUTO_HIDE = true;
    private static final int AUTO_HIDE_DELAY_MILLIS = 300;
    private static final int UI_ANIMATION_DELAY = 300;
    private boolean isLogin = false;


    public static final String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504869153180&di=3f6f21a0ebdb99ed76b83ce28bad01f0&imgtype=0&src=http%3A%2F%2Fwww.shejicool.com%2Fuploads%2Fallimg%2F201409%2F1PAR4P-5.gif";
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private ImageView loadingView;
    private boolean mVisible;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
//            hide();
            if (isLogin) {
                startActivity(new Intent(FullscreenActivity.this, MainActivity.class));
            } else {
                startActivity(new Intent(FullscreenActivity.this, LoginActivity.class));
            }
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        mVisible = true;
        mContentView = findViewById(R.id.fullscreen_content);
        loadingView = (ImageView) findViewById(R.id.animate_content);

    }

    /**
     * activity彻底运行起来之后的回调
     *
     * @param savedInstanceState
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //是否已经登录
        isLogin = SettingUtil.getLoginFlag();
        delayedHide(300);
    }

    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mVisible = false;

        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;
        mHideHandler.removeCallbacks(mHidePart2Runnable);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (AUTO_HIDE) {
            delayedHide(AUTO_HIDE_DELAY_MILLIS);
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        toggle();
    }
}
