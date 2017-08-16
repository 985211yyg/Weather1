package com.example.yungui.weather.ui.nh.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


public class MyContentRecyclerViewAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public MyContentRecyclerViewAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}


