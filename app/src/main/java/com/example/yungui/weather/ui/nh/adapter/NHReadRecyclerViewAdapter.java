package com.example.yungui.weather.ui.nh.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yungui.weather.R;
import com.example.yungui.weather.modle.nh.NH_ReadingList;

import java.util.List;

public class NHReadRecyclerViewAdapter extends BaseQuickAdapter<NH_ReadingList.DataBean,BaseViewHolder> {

    public NHReadRecyclerViewAdapter(int layoutResId, @Nullable List<NH_ReadingList.DataBean> data) {
        super(layoutResId, data);
        Log.e(TAG, "NHReadRecyclerViewAdapter: " );
    }

    @Override
    protected void convert(BaseViewHolder helper, NH_ReadingList.DataBean item) {
        Log.e(TAG, "convert:>>>>>>>>> " );
        helper.setText(R.id.read_content, item.getForward());
        helper.setText(R.id.read_type, "- 阅读 -");
        helper.setText(R.id.read_time, item.getPost_date().substring(0, 10));
        helper.setText(R.id.read_author, " ·文|" + item.getAuthor().getUser_name());
        helper.setText(R.id.read_title, item.getTitle());

        Glide.with(mContext)
                .load(item.getImg_url())
                .placeholder(R.mipmap.placeholder)
                .into((ImageView) helper.getView(R.id.img));

    }
}
