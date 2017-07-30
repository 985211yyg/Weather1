package com.example.yungui.weather.ui;

import android.support.v4.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import com.example.yungui.weather.AppGlobal;
import com.example.yungui.weather.R;
import com.example.yungui.weather.event.ThemeChangeEvent;
import com.example.yungui.weather.ui.base.BaseActivity;
import com.example.yungui.weather.ui.wxmm.BusFragment;
import com.example.yungui.weather.ui.video.VideoFragment;
import com.example.yungui.weather.ui.setting.SettingActivity;
import com.example.yungui.weather.ui.weather.WeatherFragment;
import com.example.yungui.weather.ui.welfare.WelfareFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * https://github.com/afollestad/material-dialogs.git
 */
public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    public static final String FRAGMENT_TAG_WEATHER = "weather";
    public static final String FRAGMENT_TAG_BUS = "bus";
    public static final String FRAGMENT_TAG_VIDEO = "video";
    public static final String FRAGMENT_TAG_WELFARE = "welfare";
    private String Current_Fragment_Tag;

    private android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getMenuId() {
        return 0;
    }

    @Override
    protected void onMenuItemClick(int itemId) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initDrawer();
        fragmentManager = getSupportFragmentManager();
        initFragment(savedInstanceState);
        initNavigationView();
    }

    private void initDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    private void initNavigationView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /**
     * 初始化fragment，将第首页设置为天气
     *
     * @param savedInstanceState
     */
    private void initFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {

            switchContent(FRAGMENT_TAG_WEATHER);

        } else {
            //不为空，获取保存的标签
            Current_Fragment_Tag = savedInstanceState.getString(AppGlobal.CURRENT_INDEX);
            //展示保存的fragment
            switchContent(Current_Fragment_Tag);
        }

    }

    public void initToolbar(android.support.v7.widget.Toolbar toolbar) {
        if (toolbar != null) {
            setDisplayHomeAsUpEnabled(true);
            toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            toggle.syncState();
            drawerLayout.addDrawerListener(toggle);
        }

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_weather) {
            switchContent(FRAGMENT_TAG_WEATHER);

        } else if (id == R.id.nav_bus) {
            switchContent(FRAGMENT_TAG_BUS);

        } else if (id == R.id.nav_read) {
            switchContent(FRAGMENT_TAG_VIDEO);

        } else if (id == R.id.nav_welfare) {
            switchContent(FRAGMENT_TAG_WELFARE);

        } else if (id == R.id.nav_setting) {
            this.startActivity(new Intent(MainActivity.this, SettingActivity.class));
        } else if (id == R.id.nav_about) {

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * 根据标签的不同来切换片段
     *
     * @param fragmentName
     */
    private void switchContent(String fragmentName) {

        //如果标签为空或者标签没有变化
        if (Current_Fragment_Tag!=null&& Current_Fragment_Tag.equals(fragmentName)) {
            //直接退出
            return;
        }
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        //将原有的fragment从stack中移除
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        //查找当前fragment
        Fragment CurrentFragment = fragmentManager.findFragmentByTag(Current_Fragment_Tag);
        if (CurrentFragment != null) {
            ///隐藏当前的fragment
            transaction.hide(CurrentFragment);
        }

        //查找即将添加进来的fragment
        Fragment FoundFragment = fragmentManager.findFragmentByTag(fragmentName);

        //实例化fragment
        if (FoundFragment == null) {
            switch (fragmentName) {
                case FRAGMENT_TAG_BUS:
                    FoundFragment = new BusFragment();
                    break;
                case FRAGMENT_TAG_WEATHER:
                    FoundFragment = new WeatherFragment();
                    break;
                case FRAGMENT_TAG_VIDEO:
                    FoundFragment = new VideoFragment();
                    break;
                case FRAGMENT_TAG_WELFARE:
                    FoundFragment = new WelfareFragment();
                    break;
            }
        }
        //如果fragment已经被添加，则直接展示，
        if (FoundFragment.isAdded()) {
            transaction.show(FoundFragment);
        } else {
            //如果没有被添加过，则首次添加
            transaction.add(R.id.contentLayout, FoundFragment, fragmentName);
        }
        //提交
        transaction.commit();
        //设置当前的标签
        Current_Fragment_Tag = fragmentName;
        /*
        Declare that the options menu has changed, so should be recreated.
        The onCreateOptionsMenu(Menu) method will be called the next time it needs to be displayed.
         */
        invalidateOptionsMenu();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(AppGlobal.CURRENT_INDEX, Current_Fragment_Tag);
    }

    /*
    注册事件观察者
     */
    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onThemeChanged(ThemeChangeEvent changeEvent) {
        this.recreate();
    }

    @Override
    protected void onDestroy() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();
    }
}
