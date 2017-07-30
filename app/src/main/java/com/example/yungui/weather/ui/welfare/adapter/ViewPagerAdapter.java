package com.example.yungui.weather.ui.welfare.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yungui on 2017/6/29.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{

    //装在fragment
    private List<Fragment> fragments = new ArrayList<>();
    //装在标题
    private List<String> titles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    /**
     * 添加片段和标题
     * @param fragment
     * @param title
     */
    public void addFragment(Fragment fragment, String title) {
        fragments.add(fragment);
        titles.add(title);

    }
}
