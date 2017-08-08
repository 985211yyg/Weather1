package com.example.yungui.weather.ui.wxmm;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.yungui.weather.R;
import com.example.yungui.weather.ui.base.BaseFragment;
import com.example.yungui.weather.widgets.DragPhotoView;
import com.example.yungui.weather.widgets.RatioImageView;

public class WxmmPicItemFragment extends BaseFragment implements DragPhotoView.OnExitListener{
    private DragPhotoView dragPhotoView;
    private ProgressBar progressBar;
    private String url;
    private int position;
    private int totalCount;

    public static WxmmPicItemFragment Instance(String url, int position, int totalCount) {
        Bundle data = new Bundle();
        data.putInt("total",totalCount);
        data.putInt("position", position);
        data.putString("url",url);
        WxmmPicItemFragment itemFragment = new WxmmPicItemFragment();
        itemFragment.setArguments(data);
        return itemFragment;
    }


    @Override
    protected int getLayoutID() {
        return R.layout.activity_wxmm_pic_item;
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
        url = getArguments().getString("url");
        position = getArguments().getInt("position");
        totalCount = getArguments().getInt("total");
        dragPhotoView = findView(R.id.img);
        progressBar = findView(R.id.progressBar);
        dragPhotoView.setExitListener(this);
    }

    @Override
    protected void lazyFetchData() {
        progressBar.setVisibility(View.GONE);
        Glide.with(mContext)
                .load(url).
                diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(dragPhotoView);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onExit(DragPhotoView dragPhotoView, float translateX, float translateY, float W, float Y) {

    }
}
