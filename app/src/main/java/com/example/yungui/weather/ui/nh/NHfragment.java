package com.example.yungui.weather.ui.nh;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.example.yungui.weather.AppGlobal;
import com.example.yungui.weather.R;
import com.example.yungui.weather.ui.MainActivity;
import com.example.yungui.weather.ui.base.BaseFragment;
import com.example.yungui.weather.ui.nh.adapter.NHViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yungui on 2017/8/9.
 */

public class NHfragment extends BaseFragment implements
        BottomNavigationView.OnNavigationItemSelectedListener,
        ItemListDialogFragment.Listener, ViewPager.OnPageChangeListener {
    private android.support.v7.widget.Toolbar toolbar;
    private BottomNavigationView navigation;
    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private NHViewPagerAdapter viewPagerAdapter;
    private NHReadFragment readFragment;
    private NHFirstFragment firstFragment;

    public static final String MAIN = "main";
    public static final String READ = "read";
    public static final String MUSIC = "music";
    public static final String MOVIE = "movie";

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_nh;
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
        viewPagerAdapter = new NHViewPagerAdapter(getFragmentManager());
        viewPagerAdapter.addFragment(NHFirstFragment.newInstance(1), null);
        viewPagerAdapter.addFragment(NHFirstFragment.newInstance(1), null);
        viewPagerAdapter.addFragment(NHReadFragment.newInstance(null, null), null);
        viewPagerAdapter.addFragment(NHReadFragment.newInstance(null, null), null);

        viewPager = findView(R.id.nh_viewPager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(this);

        navigation = findView(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

    }

    @Override
    protected void lazyFetchData() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                viewPager.setCurrentItem(0);
                return true;

            case R.id.navigation_read:
                viewPager.setCurrentItem(1);

                return true;

            case R.id.navigation_music:
                viewPager.setCurrentItem(2);


                return true;
            case R.id.navigation_video:
                viewPager.setCurrentItem(3);

                return true;

        }
        return false;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //设置bottomsheet对应的item为选中状态
        navigation.getMenu().getItem(position).setChecked(true);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 状态发生改变时，保存页面状态
     *
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onItemClicked(int position) {

    }
}
