package com.example.yungui.weather.ui.wxmm;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.blankj.utilcode.util.BarUtils;
import com.example.yungui.weather.R;
import com.example.yungui.weather.ui.base.BaseActivity;
import com.example.yungui.weather.ui.base.BasePicActivity;
import com.example.yungui.weather.ui.wxmm.adapter.PicDetailViewPagerAdapter;
import com.example.yungui.weather.widgets.mViewPager;

import java.util.ArrayList;
import java.util.List;

public class WXmmPicActivity extends BasePicActivity {
    private List<String> imgUrls = new ArrayList<>();
    private int position;
    private ViewPager viewPager;
    private PicDetailViewPagerAdapter viewPagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_wxmm_pic;
    }

    @Override
    protected int getMenuId() {
        return 0;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        position = getIntent().getIntExtra("position", 0);
        Log.e("接受到的position", " "+position );
        imgUrls = getIntent().getStringArrayListExtra("imgs");
        Log.e("接受到的urls", ""+imgUrls.toString() );
        viewPager = (ViewPager) findViewById(R.id.mm_pic_viewPager);
        viewPagerAdapter = new PicDetailViewPagerAdapter(getSupportFragmentManager(), imgUrls);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
