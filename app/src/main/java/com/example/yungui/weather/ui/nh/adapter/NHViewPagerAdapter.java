package com.example.yungui.weather.ui.nh.adapter;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.yungui.weather.ui.welfare.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yungui on 2017/8/9.
 */

public class NHViewPagerAdapter extends ViewPagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();

    public NHViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    @Override
    public void addFragment(Fragment fragment, String title) {
        super.addFragment(fragment, title);
        fragments.add(fragment);
    }
}
