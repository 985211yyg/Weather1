package com.example.yungui.weather.ui.welfare;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yungui.weather.R;
import com.example.yungui.weather.modle.Girls;
import com.example.yungui.weather.ui.base.BasePicActivity;
import com.example.yungui.weather.ui.welfare.adapter.SectionsPagerAdapter;
import com.example.yungui.weather.widgets.DragPhotoView;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;

public class PicDetailActivity extends BasePicActivity implements View.OnClickListener,
        DragPhotoView.OnExitListener,DragPhotoView.OnTapListener {

    public static final String TAG = PicDetailActivity.class.getName();
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private TextView showCount;
    private Button save;
    private ArrayList<Girls> girls = new ArrayList<>();
    private int CurrentPosition;
    private boolean isFromGakn_JD;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pic_detail;
    }

    @Override
    protected int getMenuId() {
        return R.menu.menu_pic_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        showCount = (TextView) findViewById(R.id.page_tv);
        save = (Button) findViewById(R.id.save_btn);
        //数据集合
        girls=getIntent().getParcelableArrayListExtra("list");
        Log.e(TAG, "传递到详情activity的数据"+girls.size()+girls.toString() );
        //单击的图片的位置
        CurrentPosition = getIntent().getIntExtra("position", 0);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),
                girls,CurrentPosition);

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        //监听view页面的变化
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                showCount.setText(position+1+"/"+mSectionsPagerAdapter.getCount());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        /*
        viewpager跳转到点击的页面
         */
        mViewPager.setCurrentItem(CurrentPosition);
    }

    @Override
    protected void loadData() {
        save.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "图片保存成功！", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onExit(DragPhotoView dragPhotoView, float translateX, float translateY, float W, float Y) {
        if (translateY > 50) {
            this.finish();
        }

    }

    @Override
    public void onTap(DragPhotoView dragPhotoView) {

    }
}
