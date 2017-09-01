package com.example.yungui.weather.ui.nh.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yungui.weather.R;
import com.example.yungui.weather.modle.nh.NH_MovieList;
import com.example.yungui.weather.modle.nh.NH_ReadingList;

import java.util.List;

public class NHMovieRecyclerViewAdapter extends BaseQuickAdapter<NH_MovieList.DataBean, BaseViewHolder> {


    public NHMovieRecyclerViewAdapter(int layoutResId, @Nullable List<NH_MovieList.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NH_MovieList.DataBean item) {
        Log.e(TAG, "convert:>>>>>>>>> ");
        helper.setText(R.id.movie_content, item.getForward());
        helper.setText(R.id.movie_time, item.getPost_date().substring(0, 10));
        helper.setText(R.id.movie_type, "- 电影 -");
        helper.setText(R.id.movie_author, "· 文|" + item.getAuthor().getUser_name());
        helper.setText(R.id.movie_title, item.getTitle());
        helper.setText(R.id.movie_about, "---关于"+"《"+item.getSubtitle()+"》");

        Glide.with(mContext)
                .load(item.getImg_url())
                .into((ImageView) helper.getView(R.id.img));

    }
}
