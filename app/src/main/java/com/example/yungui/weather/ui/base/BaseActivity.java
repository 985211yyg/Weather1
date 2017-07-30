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

/**
 * Created by yungui on 2017/6/18.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected static final String TAG = BaseActivity.class.getName();
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

    protected abstract void onMenuItemClick(int itemId);
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
        onMenuItemClick(id);
        return super.onOptionsItemSelected(item);
    }

    private void initTheme() {
        int themeIndex = SettingUtil.getTheme();
        switch (themeIndex) {
            case 0:
                setTheme(R.style.BlueTheme);
                break;
            case 1:
                setTheme(R.style.GreenTheme);
                break;
            case 2:
                setTheme(R.style.NiagaraTheme);

                break;
            case 3:
                setTheme(R.style.PinkTheme);

                break;
            case 4:
                setTheme(R.style.PurpleTheme);

                break;
            case 5:
                setTheme(R.style.RedTheme);

                break;
            case 6:
                setTheme(R.style.AppTheme);
        }

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


