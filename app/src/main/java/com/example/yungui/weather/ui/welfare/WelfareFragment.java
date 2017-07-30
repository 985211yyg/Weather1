package com.example.yungui.weather.ui.welfare;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.yungui.weather.R;
import com.example.yungui.weather.ui.MainActivity;
import com.example.yungui.weather.ui.base.BaseContentFragment;
import com.example.yungui.weather.ui.welfare.adapter.ViewPagerAdapter;

/**
 * Created by yungui on 2017/6/19.
 */

public class WelfareFragment extends BaseContentFragment {
    //用来传递参数，比如url
    private GirlsFragment girlsFragment;
    private Bundle data;
    private ViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private android.support.v7.widget.Toolbar toolbar;
    public static final String key = "url";

    public static final String Hot = "http://www.mzitu.com/hot";
    public static final String Janpa = "http://www.mzitu.com/japan";
    public static final String MM = "http://www.mzitu.com/mm";
    public static final String Taiwan = "http://www.mzitu.com/taiwan";
    public static final String XingGan = "http://www.mzitu.com/xinggan/";

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_welfare_viewpager;
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
        //支持toolbar的menu
        setHasOptionsMenu(true);
        tabLayout = findView(R.id.welfare_tabLayout);
        viewPager = findView(R.id.welfare_viewPager);
        viewPager.setOffscreenPageLimit(3);
        toolbar = findView(R.id.welfare_toolBar);
        toolbar.setTitle("福利");
        toolbar.setNavigationIcon(R.drawable.menu);
        //toolbar与drawer联动
        ((MainActivity) getActivity()).initToolbar(toolbar);

        viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());
        //单一图片

        viewPagerAdapter.addFragment(new GankFragment(), "Gank");

        viewPagerAdapter.addFragment(new JianDanFragment(), "煎蛋");


        //图片集
        girlsFragment = new GirlsFragment();
        data = new Bundle();
        data.putString("url",Hot);

        girlsFragment.setArguments(data);
        viewPagerAdapter.addFragment(girlsFragment, "最热");

        girlsFragment = new GirlsFragment();
        data = new Bundle();
        data.putString("url",Janpa);
        girlsFragment.setArguments(data);
        viewPagerAdapter.addFragment(girlsFragment, "日本妹子");

        girlsFragment = new GirlsFragment();
        data = new Bundle();
        data.putString("url",Taiwan);
        girlsFragment.setArguments(data);
        viewPagerAdapter.addFragment(girlsFragment, "台湾妹子");

        girlsFragment = new GirlsFragment();
        data = new Bundle();
        data.putString("url", MM);
        girlsFragment.setArguments(data);
        viewPagerAdapter.addFragment(girlsFragment, "清纯妹子");

        girlsFragment = new GirlsFragment();
        data = new Bundle();
        data.putString("url", XingGan);
        girlsFragment.setArguments(data);
        viewPagerAdapter.addFragment(girlsFragment, "性感妹子");

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(viewPagerAdapter);

    }

    @Override
    protected void lazyFetchData() {

    }

}
