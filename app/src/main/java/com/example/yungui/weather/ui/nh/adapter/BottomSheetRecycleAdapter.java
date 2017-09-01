package com.example.yungui.weather.ui.nh.adapter;

import android.animation.Animator;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yungui.weather.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yungui on 2017/8/20.
 */

public class BottomSheetRecycleAdapter extends BaseQuickAdapter<Integer,BaseViewHolder> {


    public BottomSheetRecycleAdapter(int layoutResId, @Nullable List<Integer> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
        if (item != -1) {
            helper.setImageResource(R.id.imageView, item);
        } else {
            helper.setText(R.id.text, "生成图片分享");
        }

    }
}
