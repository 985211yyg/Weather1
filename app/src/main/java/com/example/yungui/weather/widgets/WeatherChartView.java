package com.example.yungui.weather.widgets;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.yungui.weather.R;
import com.example.yungui.weather.modle.HeWeather5;
import com.example.yungui.weather.modle.WeatherBean;
import com.example.yungui.weather.utils.SimpleSubscriber;
import com.example.yungui.weather.utils.SizeUtils;
import com.example.yungui.weather.utils.TimeUtils;
import com.example.yungui.weather.utils.WeatherUtil;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;

public class WeatherChartView extends LinearLayout {

    private List<HeWeather5.DailyForecastBean> dailyForecastList = new ArrayList<>();

    LayoutParams cellParams;
    LayoutParams rowParams;
    LayoutParams chartParams;

    LayoutTransition transition = new LayoutTransition();

    public WeatherChartView(Context context) {
        this(context, null);
    }

    public WeatherChartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeatherChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOrientation(VERTICAL);
        transition.enableTransitionType(LayoutTransition.APPEARING);
        this.setLayoutTransition(transition);
        //列布局参数
        rowParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        cellParams = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1);
        //图标布局参数
        chartParams = new LayoutParams(LayoutParams.MATCH_PARENT, SizeUtils.dp2px(getContext(), 200));
    }

    private void letItGo() {
        removeAllViews();
        //上部日期
        final LinearLayout dateTitleView = new LinearLayout(getContext());
        dateTitleView.setLayoutParams(rowParams);
        dateTitleView.setOrientation(HORIZONTAL);
        dateTitleView.setLayoutTransition(transition);
        dateTitleView.removeAllViews();
        //中部图标
        final LinearLayout iconView = new LinearLayout(getContext());
        iconView.setLayoutParams(rowParams);
        iconView.setOrientation(HORIZONTAL);
        iconView.setLayoutTransition(transition);
        iconView.removeAllViews();
        //下部天气
        final LinearLayout weatherStrView = new LinearLayout(getContext());
        weatherStrView.setLayoutParams(rowParams);
        weatherStrView.setOrientation(HORIZONTAL);
        weatherStrView.setLayoutTransition(transition);
        weatherStrView.removeAllViews();
        //最低和最高温度
        List<Integer> minTemp = new ArrayList<>();
        List<Integer> maxTemp = new ArrayList<>();
        //获取存储的昨天的天气
        HeWeather5.DailyForecastBean yesterday = WeatherUtil.getInstance().getYesterday();
        //插入昨天天气
        if (yesterday != null) {
            dailyForecastList.add(0, yesterday);
        }

        for (int i = 0; i < dailyForecastList.size(); i++) {
            //日期
            final TextView tvDate = new TextView(getContext());
            tvDate.setGravity(Gravity.CENTER);
            tvDate.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            tvDate.setTextColor(getResources().getColor(R.color.white));
            tvDate.setVisibility(INVISIBLE);
            //天气
            final TextView tvWeather = new TextView((getContext()));
            tvWeather.setGravity(Gravity.CENTER);
            tvWeather.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
            tvWeather.setTextColor(getResources().getColor(R.color.white));
            tvWeather.setVisibility(INVISIBLE);
            //图标
            final ImageView ivIcon = new ImageView(getContext());
            ivIcon.setAdjustViewBounds(true);
            ivIcon.setScaleType(ImageView.ScaleType.FIT_CENTER);
            //图标的内边距
            int padding = SizeUtils.dp2px(getContext(), 25);
            int paddingTandB = SizeUtils.dp2px(getContext(), 5);
            int width = SizeUtils.getScreenWidth(getContext()) / dailyForecastList.size();
            LayoutParams ivParam = new LayoutParams(width, width);
            ivParam.weight = 1;
            ivIcon.setLayoutParams(ivParam);
            ivIcon.setPadding(padding, paddingTandB, padding, paddingTandB);
            ivIcon.setVisibility(INVISIBLE);

            //设置日期
            if (yesterday != null) {
                if (i == 0) {
                    tvDate.setText("昨天");
                } else if (i == 1) {
                    tvDate.setText("今天");
                    tvDate.setTextColor(Color.DKGRAY);
                } else if (i == 2) {
                    tvDate.setText("明天");
                } else {
                    tvDate.setText(TimeUtils.getWeek(dailyForecastList.get(i).getDate(), TimeUtils.DATE_SDF));
                }
            } else {
                if (i == 0) {
                    tvDate.setText("今天");
                    tvDate.setTextColor(Color.DKGRAY);
                } else if (i == 1) {
                    tvDate.setText("明天");
                } else {
                    tvDate.setText(TimeUtils.getWeek(dailyForecastList.get(i).getDate(), TimeUtils.DATE_SDF));
                }
            }

            tvWeather.setText(dailyForecastList.get(i).getCond().getTxt_d());
            //根据code获取图标url加载图标
            WeatherUtil.getInstance()
                    .getWeatherDict(dailyForecastList.get(i).getCond().getCode_d())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SimpleSubscriber<WeatherBean>() {
                        @Override
                        public void onNext(WeatherBean weatherBean) {
                            Glide.with(getContext())
                                    .load(weatherBean.getIcon())
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .into(ivIcon);
                        }
                    });
            //获取最低最高温度，
            minTemp.add(Integer.valueOf(dailyForecastList.get(i).getTmp().getMin()));
            maxTemp.add(Integer.valueOf(dailyForecastList.get(i).getTmp().getMax()));

            //填充天气设置布局参数
            weatherStrView.addView(tvWeather, cellParams);
            //填充日期设置布局参数
            dateTitleView.addView(tvDate, cellParams);
            //填充图标
            iconView.addView(ivIcon);
            //延时加载
            this.postDelayed(new Runnable() {
                @Override
                public void run() {
                    tvDate.setVisibility(VISIBLE);
                    tvWeather.setVisibility(VISIBLE);
                    ivIcon.setVisibility(VISIBLE);
                }
            }, 200 * i);
        }

        //将上部日期 中部图标  下部天气 添加到总布局中
        addView(dateTitleView);
        addView(iconView);
        addView(weatherStrView);

        //实例化最下部的图表
        final ChartView chartView = new ChartView(getContext());
        chartView.setData(minTemp, maxTemp);
        chartView.setPadding(0, SizeUtils.dp2px(getContext(), 16), 0, SizeUtils.dp2px(getContext(), 16));
        //加入到总布局中
        addView(chartView, chartParams);
    }

    public void setWeather5(HeWeather5 weather5) {
        dailyForecastList.clear();
        dailyForecastList.addAll(weather5.getDaily_forecast());
        letItGo();
    }
}
