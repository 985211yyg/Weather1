package com.example.yungui.weather.ui.wxmm;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yungui.weather.R;
import com.example.yungui.weather.ui.base.BasePicActivity;
import com.example.yungui.weather.ui.wxmm.adapter.PicDetailViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class WXmmPicActivity extends BasePicActivity {
    private List<String> imgUrls = new ArrayList<>();
    private int position;
    private ViewPager viewPager;
    private PicDetailViewPagerAdapter viewPagerAdapter;

    private Button save;
    private TextView count;

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
        imgUrls = getIntent().getStringArrayListExtra("imgs");
        Log.e("imgUrls", "接受的图片: "+imgUrls);

        save = (Button) findViewById(R.id.mm_save);
        count = (TextView) findViewById(R.id.mm_count);

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
                count.setText(position+1+"/"+imgUrls.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        /**
         * 保存图片
         */
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        viewPager.setCurrentItem(position);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
