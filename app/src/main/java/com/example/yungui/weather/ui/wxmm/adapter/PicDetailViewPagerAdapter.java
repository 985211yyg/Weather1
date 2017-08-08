package com.example.yungui.weather.ui.wxmm.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.yungui.weather.ui.welfare.adapter.ViewPagerAdapter;
import com.example.yungui.weather.ui.wxmm.WxmmPicItemFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yungui on 2017/8/5.
 */

public class PicDetailViewPagerAdapter extends ViewPagerAdapter {
    private List<String> imgUrls = new ArrayList<>();

    public PicDetailViewPagerAdapter(FragmentManager fragmentManager,List<String> imgUrls) {
        super(fragmentManager);
        this.imgUrls = imgUrls;
    }

    @Override
    public Fragment getItem(int position) {
        return WxmmPicItemFragment.Instance(imgUrls.get(position),position,imgUrls.size());
    }

    @Override
    public int getCount() {
        return imgUrls.size();
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
