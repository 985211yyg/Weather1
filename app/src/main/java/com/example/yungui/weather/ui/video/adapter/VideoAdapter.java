package com.example.yungui.weather.ui.video.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yungui.weather.R;
import com.example.yungui.weather.modle.bean.FindMoreBean;
import com.example.yungui.weather.modle.bean.IssueBean;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import java.util.List;

/**
 * Created by yungui on 2017/7/22.
 */

public class VideoAdapter extends BaseQuickAdapter<FindMoreBean, BaseViewHolder> {

    public VideoAdapter(int layoutResId, @Nullable List<FindMoreBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FindMoreBean item) {
        Log.e(TAG, "convert: ");
        helper.setText(R.id.video_title, item.getName());
        helper.setText(R.id.video_desc, item.getDescription());
        ImageView icon = helper.getView(R.id.video_icon);
        Glide.with(mContext)
                .load(item.getBgPicture())
                .error(R.mipmap.meinv)
                .into(icon);
    }
}
