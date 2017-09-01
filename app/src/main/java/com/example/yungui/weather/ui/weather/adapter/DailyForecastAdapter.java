package com.example.yungui.weather.ui.weather.adapter;

import android.support.annotation.Nullable;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.yungui.weather.R;
import com.example.yungui.weather.modle.HeWeather5;
import com.example.yungui.weather.utils.FileUtil;
import com.example.yungui.weather.utils.TimeUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by yungui on 2017/8/29.
 */

public class DailyForecastAdapter extends BaseQuickAdapter<HeWeather5.DailyForecastBean, BaseViewHolder> {

    public DailyForecastAdapter(int layoutResId, @Nullable List<HeWeather5.DailyForecastBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HeWeather5.DailyForecastBean item) {
        Log.e(TAG, "convert: " +item.toString());
        helper.setText(R.id.date, item.getDate());
        helper.setText(R.id.weather_day, item.getCond().getTxt_d());
        helper.setImageBitmap(R.id.icon_day, FileUtil.getImageFromAssetsFile(item.getCond().getCode_d()+".png", mContext));
        helper.setText(R.id.weather_night, item.getCond().getTxt_n());
        helper.setImageBitmap(R.id.icon_night, FileUtil.getImageFromAssetsFile(item.getCond().getCode_n() + ".png", mContext));
        helper.setText(R.id.weather_hum, "湿度"+item.getHum()+"%");
        helper.setText(R.id.weather_pop, "降雨"+item.getPop());
        helper.setText(R.id.weather_sc, item.getWind().getSc());
    }
}
