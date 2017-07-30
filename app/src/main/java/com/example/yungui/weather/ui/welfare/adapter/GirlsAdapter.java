package com.example.yungui.weather.ui.welfare.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yungui.weather.R;
import com.example.yungui.weather.modle.Girls;
import com.example.yungui.weather.widgets.RatioImageView;

import java.util.List;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by yungui on 2017/6/29.
 */

public class GirlsAdapter extends BaseQuickAdapter<Girls, BaseViewHolder> {
    private String url;
    public GirlsAdapter(int layoutResId, @Nullable List<Girls> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Girls item) {
        RatioImageView imageView = helper.getView(R.id.welfare_imageView);
        if (item.getHeight() > 0) {
            imageView.setOriginalSize(item.getWidth(), item.getHeight());
        } else {
            imageView.setOriginalSize(250,360);
        }
        Glide.with(mContext)
                .load(item.getUrl())
                .placeholder(R.drawable.image)
                .error(R.drawable.broken_image)
                .into(imageView);

    }

}
