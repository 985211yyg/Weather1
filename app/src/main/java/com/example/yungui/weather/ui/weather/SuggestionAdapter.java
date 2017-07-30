package com.example.yungui.weather.ui.weather;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yungui.weather.App;
import com.example.yungui.weather.R;
import com.example.yungui.weather.modle.HeWeather5;

import java.util.List;

/**
 * Created by yungui on 2017/6/23.
 */

public class SuggestionAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {

    public SuggestionAdapter(int layoutResId, @Nullable List<Object> data) {
        super(layoutResId, data);
    }

    public static int getScreenWidth() {
        WindowManager windowManager = (WindowManager) App.getContext().getSystemService(Context.WINDOW_SERVICE);
        //创建一个显示屏
        DisplayMetrics displayMetrics = new DisplayMetrics();
        //获取手机屏幕的尺寸并赋值个给新建的显示屏
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        //返回显示屏的宽度
        return displayMetrics.widthPixels;
    }

    @Override
    protected void convert(BaseViewHolder holder, Object item) {
        int Width = getScreenWidth() / 4;
        //设置itemView的布局参数
        holder.itemView.setLayoutParams(new LinearLayout.LayoutParams(Width, Width));
        //根据数据的类型，为itemView的子view设置值
        if (item instanceof HeWeather5.SuggestionBean.ComfBean) {
            holder.setText(R.id.tv_name, "舒适度");
            holder.setText(R.id.tv_message, ((HeWeather5.SuggestionBean.ComfBean) item).getBrf());
        } else if (item instanceof HeWeather5.SuggestionBean.CwBean) {
            holder.setText(R.id.tv_name, "洗车");
            holder.setText(R.id.tv_message, ((HeWeather5.SuggestionBean.CwBean) item).getBrf());
        }else if (item instanceof HeWeather5.SuggestionBean.DrsgBean) {
            holder.setText(R.id.tv_name, "穿衣");
            holder.setText(R.id.tv_message, ((HeWeather5.SuggestionBean.DrsgBean) item).getBrf());
        }else if (item instanceof HeWeather5.SuggestionBean.FluBean) {
            holder.setText(R.id.tv_name, "感冒");
            holder.setText(R.id.tv_message, ((HeWeather5.SuggestionBean.FluBean) item).getBrf());
        } else if (item instanceof HeWeather5.SuggestionBean.SportBean) {
            holder.setText(R.id.tv_name, "运动");
            holder.setText(R.id.tv_message, ((HeWeather5.SuggestionBean.SportBean) item).getBrf());
        } else if (item instanceof HeWeather5.SuggestionBean.TravBean) {
            holder.setText(R.id.tv_name, "旅游");
            holder.setText(R.id.tv_message, ((HeWeather5.SuggestionBean.TravBean) item).getBrf());
        } else if (item instanceof HeWeather5.SuggestionBean.UvBean) {
            holder.setText(R.id.tv_name, "紫外线");
            holder.setText(R.id.tv_message, ((HeWeather5.SuggestionBean.UvBean) item).getBrf());
        } else if (item instanceof HeWeather5.AqiBean) {
            holder.setText(R.id.tv_name, "空气指数");
            holder.setText(R.id.tv_message, ((HeWeather5.AqiBean) item).getCity().getAqi());
        }
    }
}
