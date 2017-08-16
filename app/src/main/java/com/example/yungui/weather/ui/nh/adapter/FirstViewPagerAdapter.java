package com.example.yungui.weather.ui.nh.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.yungui.weather.ui.welfare.adapter.ViewPagerAdapter;

/**
 * Created by yungui on 2017/8/14.
 */

public class FirstViewPagerAdapter extends ViewPagerAdapter {
    public FirstViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    @Override
    public void addFragment(Fragment fragment, String title) {
        super.addFragment(fragment, title);
    }
}
