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

/**
 * Created by yungui on 2017/7/30.
 */

public class PicAlbumAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public PicAlbumAdapter(int layoutResId, @Nullable List<String> url) {
        super(layoutResId, url);
    }

    @Override
    protected void convert(BaseViewHolder helper, String url) {
        Log.e(TAG, ">>>>>>>>>convert: "+url );
        ImageView imageView = helper.getView(R.id.album_imageView);
        Glide.with(mContext)
                .load("http://e.hiphotos.baidu.com/image/h%3D220/sign=a9afcc287bf082023292963d7bfafb8a/f3d3572c11dfa9ec8ef77e1c6ad0f703908fc1db.jpg")
                .placeholder(R.drawable.image)
                .error(R.drawable.broken_image)
                .into(imageView);
    }
}
