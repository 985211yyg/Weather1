package com.example.yungui.weather.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.yungui.weather.R;
import com.example.yungui.weather.utils.SettingUtil;

import static com.example.yungui.weather.utils.SettingUtil.setTheme;

/**
 * Created by yungui on 2017/7/4.
 */

public abstract class BasePicActivity extends AppCompatActivity {
    protected android.support.v7.widget.Toolbar toolbar;

    //==========子类继承是需要实现的抽象方法=============
    /*
    获取布局ID
     */
    protected abstract
    @LayoutRes
    int getLayoutId();

    /*
   获取菜单布局
     */
    protected abstract
    @MenuRes
    int getMenuId();

    /*
    初始化布局,在activity创建时调用，将参数传出去
     */
    protected abstract void initView(Bundle savedInstanceState);

    /*
    加载数据
     */
    protected abstract void loadData();

    /*
    初始化模块,支持矢量动画
     */
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化主题
        initTheme();
        //加载布局
        setContentView(getLayoutId());
        initToolBar();
        //调用 初始化view
        initView(savedInstanceState);
        //调用 加载数据
        loadData();
    }

    private void initToolBar() {
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    protected void setDisplayHomeAsUpEnabled(boolean enable) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(enable);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getMenuId() != 0) {
            //调用getMenuId
            getMenuInflater().inflate(getMenuId(), menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initTheme() {
        setTheme(R.style.PicTheme);

    }

    /*
    查看图片是全屏
     */
    protected void hideSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    /*
     恢复系统UI界面
     */
    protected void showSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        );
    }
}
