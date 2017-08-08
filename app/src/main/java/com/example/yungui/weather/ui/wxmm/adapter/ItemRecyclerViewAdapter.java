package com.example.yungui.weather.ui.wxmm.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yungui.weather.R;
import com.example.yungui.weather.modle.bean.WxMMBean;

import java.util.List;

public class ItemRecyclerViewAdapter extends BaseQuickAdapter<WxMMBean,BaseViewHolder> {

    public ItemRecyclerViewAdapter(int layoutResId, @Nullable List<WxMMBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, WxMMBean item) {
        ImageView imageView = helper.getView(R.id.mm_cover);
        LinearLayout linearLayout = helper.getView(R.id.mm_linearLayout);
        linearLayout.setBackground(null);
        helper.setText(R.id.mm_title, item.getTitle());
        helper.setText(R.id.mm_des, item.getDesc());
        Glide.with(mContext)
                .load(item.getCoverUrl())
                .into(imageView);

    }
}
