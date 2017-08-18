package com.example.yungui.weather.ui.nh.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yungui.weather.R;
import com.example.yungui.weather.modle.nh.NH_DataBean;

import java.util.List;


public class FirstRecyclerViewAdapter extends BaseMultiItemQuickAdapter<NH_DataBean.DataBean.ContentListBean, BaseViewHolder> {

    public FirstRecyclerViewAdapter(@Nullable List<NH_DataBean.DataBean.ContentListBean> data) {
        super(data);
        //绑定视图
        addItemType(NH_DataBean.DataBean.ContentListBean.PIC, R.layout.nh_item_pic_text);
        addItemType(NH_DataBean.DataBean.ContentListBean.ONE_WEEK, R.layout.nh_item_text);
        addItemType(NH_DataBean.DataBean.ContentListBean.ESSAY, R.layout.nh_item_text);
        addItemType(NH_DataBean.DataBean.ContentListBean.READ, R.layout.nh_item_text);
        addItemType(NH_DataBean.DataBean.ContentListBean.MUSIC, R.layout.nh_item_music);
        addItemType(NH_DataBean.DataBean.ContentListBean.MOVIE, R.layout.nh_item_movie);
    }

    @Override
    protected void convert(BaseViewHolder helper, NH_DataBean.DataBean.ContentListBean item) {
        Log.e(TAG, ">>>>>>>>>>>>convert: " + item.getCategory());
        switch (helper.getItemViewType()) {
            case NH_DataBean.DataBean.ContentListBean.PIC:
                helper.setText(R.id.first_content, item.getForward());
                helper.setText(R.id.first_type, "- 摄影 -");
                helper.setText(R.id.first_time, item.getPost_date().substring(0, 10));
                helper.setText(R.id.first_vol, item.getShare_info().getTitle());
                helper.setText(R.id.first_desc, "摄影|" + item.getPic_info());
                Glide.with(mContext)
                        .load(item.getImg_url())
                        .into((ImageView) helper.getView(R.id.first_img));

                break;
            case NH_DataBean.DataBean.ContentListBean.ONE_WEEK:
            case NH_DataBean.DataBean.ContentListBean.ESSAY:
            case NH_DataBean.DataBean.ContentListBean.READ:
                helper.setText(R.id.read_content, item.getForward());
                helper.setText(R.id.read_type, "- 阅读 -");
                helper.setText(R.id.read_time, item.getPost_date().substring(0, 10));
                helper.setText(R.id.read_author, "文|" + item.getAuthor().getUser_name());
                helper.setText(R.id.read_title, item.getTitle());

                Glide.with(mContext)
                        .load(item.getImg_url())
                        .into((ImageView) helper.getView(R.id.read_img));
                break;

            case NH_DataBean.DataBean.ContentListBean.MUSIC:
                helper.setText(R.id.music_content, item.getForward());
                helper.setText(R.id.music_time, item.getPost_date().substring(0, 10));
                helper.setText(R.id.music_type, "- 音乐 -");
                helper.setText(R.id.music_author, "文|" + item.getAuthor().getUser_name());
                helper.setText(R.id.music_desc, item.getSubtitle());
                helper.setText(R.id.music_title, item.getTitle());

                Glide.with(mContext)
                        .load(item.getImg_url())
                        .into((ImageView) helper.getView(R.id.music_img));


                break;
            case NH_DataBean.DataBean.ContentListBean.MOVIE:
                helper.setText(R.id.movie_content, item.getForward());
                helper.setText(R.id.movie_time, item.getPost_date().substring(0, 10));
                helper.setText(R.id.movie_type, "- 电影 -");
                helper.setText(R.id.movie_author, "文|" + item.getAuthor().getUser_name());
                helper.setText(R.id.movie_title, item.getTitle());
                helper.setText(R.id.movie_about, "---关于"+"《"+item.getSubtitle()+"》");

                Glide.with(mContext)
                        .load(item.getImg_url())
                        .into((ImageView) helper.getView(R.id.movie_img));
                break;
        }
    }
}


