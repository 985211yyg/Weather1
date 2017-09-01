package com.example.yungui.weather.ui.nh.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yungui.weather.R;
import com.example.yungui.weather.modle.nh.NH_MusicList;
import com.example.yungui.weather.modle.nh.NH_ReadingList;

import java.util.List;

public class NHMusicRecyclerViewAdapter extends BaseQuickAdapter<NH_MusicList.DataBean,BaseViewHolder> {


    public NHMusicRecyclerViewAdapter(int layoutResId, @Nullable List<NH_MusicList.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NH_MusicList.DataBean item) {
        Log.e(TAG, "convert:>>>>>>>>> " );
        helper.setText(R.id.music_content, item.getForward());
        helper.setText(R.id.music_time, item.getPost_date().substring(0, 10));
        helper.setText(R.id.music_type, "- 音乐 -");
        helper.setText(R.id.music_author, "· 文|" + item.getAuthor().getUser_name());
        helper.setText(R.id.music_desc, item.getSubtitle());
        helper.setText(R.id.music_title, item.getTitle());

        Glide.with(mContext)
                .load(item.getImg_url())
                .into((ImageView) helper.getView(R.id.img));
    }
}
