package com.example.yungui.weather.ui.video.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yungui.weather.R;

import java.util.List;

/**
 * Created by yungui on 2017/7/25.
 */

public class VideoSearchAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public VideoSearchAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_key, item);
    }
}
