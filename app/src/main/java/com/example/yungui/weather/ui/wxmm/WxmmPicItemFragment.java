package com.example.yungui.weather.ui.wxmm;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.yungui.weather.R;
import com.example.yungui.weather.ui.base.BaseFragment;
import com.example.yungui.weather.widgets.DragPhotoView;
import com.example.yungui.weather.widgets.RatioImageView;

public class WxmmPicItemFragment extends BaseFragment implements DragPhotoView.OnExitListener {
    private DragPhotoView dragPhotoView;
    private ProgressBar progressBar;

    private String url;

    private FrameLayout frameLayout;
    private Window window;

    public static WxmmPicItemFragment Instance(String url, int position, int totalCount) {
        Bundle data = new Bundle();
        data.putString("url", url);
        WxmmPicItemFragment itemFragment = new WxmmPicItemFragment();
        itemFragment.setArguments(data);
        return itemFragment;
    }


    @Override
    protected int getLayoutID() {
        return R.layout.activity_wxmm_pic_item;
    }

    @Override
    protected void initView() {
        frameLayout = findView(R.id.img_background);
        url = getArguments().getString("url");
        dragPhotoView = findView(R.id.img);
        progressBar = findView(R.id.progressBar);
        dragPhotoView.setExitListener(this);
    }

    @Override
    protected void lazyFetchData() {
        progressBar.setVisibility(View.GONE);
        Glide.with(mContext)
                .load(url)
                .into(dragPhotoView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.gc();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.gc();

    }

    @Override
    public void onExit(DragPhotoView dragPhotoView, float translateX, float translateY, float W, float Y) {

        if (translateY> 500) {
            getActivity().finish();
            getActivity().overridePendingTransition(0,R.transition.explode);
        }
        if (translateY < -500) {
            getActivity().finish();
            getActivity().overridePendingTransition(0,R.transition.explode);
        }


    }
}
