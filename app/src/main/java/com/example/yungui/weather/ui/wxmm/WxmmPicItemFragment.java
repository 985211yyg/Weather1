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
//        count.setText(position+"/"+totalCount);

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

//        float alpha = 255 - Math.abs(translateY) / 2;
//        if (alpha < 0) {
//            alpha = 0;
//        } else if (alpha > 255) {
//            alpha = 255;
//        }
//        //0-255
//        window = getActivity().getWindow();
//        WindowManager.LayoutParams layoutParams = window.getAttributes();
//        layoutParams.alpha = alpha;
//        window.setAttributes(layoutParams);
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
