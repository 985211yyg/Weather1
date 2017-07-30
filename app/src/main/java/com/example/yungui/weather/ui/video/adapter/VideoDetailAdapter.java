package com.example.yungui.weather.ui.video.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yungui.weather.Listener.VideoSimpleListener;
import com.example.yungui.weather.R;
import com.example.yungui.weather.modle.bean.FindVideoBean;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import java.util.List;

/**
 * Created by yungui on 2017/7/23.
 */

public class VideoDetailAdapter extends BaseQuickAdapter<FindVideoBean.ItemListBean, BaseViewHolder> {
    public static final String TAG = VideoDetailAdapter.TAG;
    public VideoDetailAdapter(int layoutResId, @Nullable List<FindVideoBean.ItemListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FindVideoBean.ItemListBean item) {

        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setAdjustViewBounds(true);
//        imageView.setImageResource(R.mipmap.meinv);
        Glide.with(mContext)
                .load(item.getData().getCover().getFeed())
//                .placeholder(R.drawable.video_image)
                .centerCrop()
                .into(imageView);
        StandardGSYVideoPlayer standardGSYVideoPlayer = helper.getView(R.id.StandardGSYVideoPlayer);
        //自动全屏
        standardGSYVideoPlayer.setRotateViewAuto(true);
        //增加封面
        standardGSYVideoPlayer.setThumbImageView(imageView);
        //去除非全屏状态返回按钮
        standardGSYVideoPlayer.getBackButton().setVisibility(View.GONE);
        //设置全屏播放
        standardGSYVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                standardGSYVideoPlayer.startWindowFullscreen(mContext, true, true);
            }
        });
        //设置标题
        standardGSYVideoPlayer.setUp(item.getData().getPlayUrl(), true, item.getData().getTitle());
        //设置标签
        standardGSYVideoPlayer.setTag(TAG);
        //设置播放位置
        standardGSYVideoPlayer.setPlayPosition(helper.getAdapterPosition());
        //设置全屏播放的动画
        standardGSYVideoPlayer.setShowFullAnimation(true);
        standardGSYVideoPlayer.setBackgroundResource(R.drawable.video_image);
        //设置播放回调
        standardGSYVideoPlayer.setStandardVideoAllCallBack(new VideoSimpleListener() {
            @Override
            public void onPrepared(String url, Object... objects) {
                super.onPrepared(url, objects);
                if (!standardGSYVideoPlayer.isIfCurrentIsFullscreen()) {
                    //静音
//                    GSYVideoManager.instance().setNeedMute(true);
                }
            }

            @Override
            public void onQuitFullscreen(String url, Object... objects) {
                super.onQuitFullscreen(url, objects);
                //全屏不静音
//                GSYVideoManager.instance().setNeedMute(true);
            }

            @Override
            public void onEnterSmallWidget(String url, Object... objects) {
                super.onEnterSmallWidget(url, objects);
                GSYVideoManager.instance().setNeedMute(false);
            }
        });

        Log.e(TAG, "convert: " + item.getType() + item.getData().getPlayUrl() + item.getData().getTitle());
    }
}
