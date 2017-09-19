package com.example.yungui.weather.ui.base;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v13.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.yungui.weather.R;
import com.example.yungui.weather.utils.SettingUtil;
import com.example.yungui.weather.utils.ThemeUtil;

/**
 * Created by yungui on 2017/6/18.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected static final String TAG = BaseActivity.class.getName();
    protected android.support.v7.widget.Toolbar toolbar;
    public static final int RequestCode = 0x123;

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


        //----------------请求权限------------------------
        int Permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int PhonePermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        int LocationPermission = android.support.v4.app.ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        //没有权限
        if (Permission == PackageManager.PERMISSION_DENIED &&
                PhonePermission == PackageManager.PERMISSION_DENIED &&
                LocationPermission == PackageManager.PERMISSION_DENIED) {

            //首先判断是否需要作出解释
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                //解释
            } else {
                //不解释,请求权限
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_PHONE_STATE,
                                Manifest.permission.ACCESS_FINE_LOCATION},
                        RequestCode);
            }

        }
        initToolBar();
        //调用 初始化view
        initView(savedInstanceState);
        //调用 加载数据
        loadData();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == RequestCode) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //权限请求成功

            } else {
                //请求失败,直接退出
                this.finish();
            }

        }
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

    private void initTheme() {
        int themeIndex = SettingUtil.getTheme();
        switch (themeIndex) {
            case 0:
                setTheme(R.style.BlueTheme);
                refreshStatusBar();
                break;
            case 1:
                setTheme(R.style.GreenTheme);
                refreshStatusBar();

                break;
            case 2:
                setTheme(R.style.NiagaraTheme);
                refreshStatusBar();
                break;
            case 3:
                setTheme(R.style.PinkTheme);
                refreshStatusBar();

                break;
            case 4:
                setTheme(R.style.PurpleTheme);
                refreshStatusBar();


                break;
            case 5:
                setTheme(R.style.RedTheme);
                refreshStatusBar();


                break;
            case 6:
                setTheme(R.style.MyTheme);
                refreshStatusBar();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(getMenuId(),menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onMenuItemClick(item.getItemId());
        return true;
    }

    /**
     * 刷新 StatusBar
     */
    private void refreshStatusBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = getTheme();
            theme.resolveAttribute(R.attr.colorPrimary, typedValue, true);
            getWindow().setStatusBarColor(getResources().getColor(typedValue.resourceId));
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

    @Override
    protected void onStart() {
        super.onStart();
//        Log.e(TAG, "onStart: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
//        Log.e(TAG, "onCreate: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
//        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
//        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Log.e(TAG, "onDestroy: ");
    }
}


