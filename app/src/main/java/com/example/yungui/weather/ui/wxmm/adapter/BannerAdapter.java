package com.example.yungui.weather.ui.wxmm.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.yungui.weather.ui.welfare.adapter.ViewPagerAdapter;
import com.example.yungui.weather.ui.wxmm.BannerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yungui on 2017/7/31.
 */

public class BannerAdapter extends FragmentPagerAdapter{
    private List<String> bannerUrls=new ArrayList<>();
    private List<String> bannerDesc=new ArrayList<>();

    public BannerAdapter(FragmentManager fm, List<String> bannerUrls,List<String> bannerDesc) {
        super(fm);
        this.bannerUrls = bannerUrls;
        this.bannerDesc=bannerDesc;
//        Log.e("BannerAdapter", "BannerAdapter: "+bannerUrls.toString());
    }
    @Override
    public Fragment getItem(int position) {
        return BannerFragment.newInstance(bannerUrls.get(position),bannerDesc.get(position));
    }
    @Override
    public int getCount() {
        return bannerUrls.size();
    }

}
