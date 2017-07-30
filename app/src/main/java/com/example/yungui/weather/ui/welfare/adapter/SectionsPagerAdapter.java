package com.example.yungui.weather.ui.welfare.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.yungui.weather.modle.Girls;
import com.example.yungui.weather.ui.welfare.PlaceholderFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private List<Girls> girls = new ArrayList<>();
    private int CurrentPosition;

    public SectionsPagerAdapter(FragmentManager fm, ArrayList<Girls> girls, int currentPosition) {
        super(fm);
        this.girls = girls;
        this.CurrentPosition = currentPosition;
    }

    @Override
    public Fragment getItem(int position) {
        return PlaceholderFragment.newInstance(girls.get(position).getUrl(), position);
    }

    @Override
    public int getCount() {
        return girls.size();
    }
    public String getCurrentPage() {
        return CurrentPosition+"/"+girls.size();
    }


}
