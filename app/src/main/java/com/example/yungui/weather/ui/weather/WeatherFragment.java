package com.example.yungui.weather.ui.weather;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.yungui.weather.R;
import com.example.yungui.weather.http.ApiFactory;
import com.example.yungui.weather.http.response.BaseWeatherResponse;
import com.example.yungui.weather.location.RxLocation;
import com.example.yungui.weather.modle.HeWeather5;
import com.example.yungui.weather.tts.TTS;
import com.example.yungui.weather.ui.MainActivity;
import com.example.yungui.weather.ui.base.BaseFragment;
import com.example.yungui.weather.ui.weather.adapter.DailyForecastAdapter;
import com.example.yungui.weather.ui.weather.adapter.SuggestionAdapter;
import com.example.yungui.weather.utils.ACache;
import com.example.yungui.weather.utils.ThemeUtil;
import com.example.yungui.weather.utils.TimeUtils;
import com.example.yungui.weather.utils.WeatherUtil;
import com.example.yungui.weather.widgets.WeatherChartView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yungui on 2017/6/19.
 */

public class WeatherFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,
        Toolbar.OnMenuItemClickListener {
    public static final String CACHE_WEATHER = "weather_cache";
    private Toolbar toolbar;
    private TextView city, weather, temp, time, aqi;
    //缓存
    private ACache cache;
    //天气数据
    private HeWeather5 heWeather5;
    private Subscription subscription;
    private Observable<HeWeather5> heWeather5Observable;
    private LinearLayout hourlyForecastRelativeLayout;
    private RecyclerView dailyForecast;
    private RecyclerView rvSuggestion;
    private SuggestionAdapter suggestionAdapter;
    private DailyForecastAdapter dailyForecastAdapter;
    private SwipeRefreshLayout refreshLayout;

    private TTS tts;
    private StringBuilder stringBuilder;

    public static final String TAG = WeatherFragment.class.getName();

    @Override

    protected int getLayoutID() {
        return R.layout.fragment_weather;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView() {
        toolbar = findView(R.id.weather_toolbar);
        ((MainActivity) getActivity()).initToolbar(toolbar);
        toolbar.inflateMenu(R.menu.weather);
        toolbar.setOnMenuItemClickListener(this);
        tts = TTS.getInstance(mContext);
        stringBuilder = new StringBuilder();

        //获取缓存
        cache = ACache.get(getActivity());

        city = findView(R.id.tv_city);
        weather = findView(R.id.tv_rain);
        temp = findView(R.id.tv_temp);
        aqi = findView(R.id.tv_air);
        time = findView(R.id.tv_update_time);
        hourlyForecastRelativeLayout = findView(R.id.hourly_forecast);
        refreshLayout = findView(R.id.refreshLayout);
        //设置刷新控件的颜色和当前的主题颜色一样
        refreshLayout.setColorSchemeColors(ThemeUtil.getCurrentColorPrimary(getContext()));
        refreshLayout.setOnRefreshListener(this);
        rvSuggestion = findView(R.id.forecast_recyclerView);

        dailyForecast = findView(R.id.daily_forecast);
        new PagerSnapHelper().attachToRecyclerView(dailyForecast);
        dailyForecast.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        dailyForecastAdapter = new DailyForecastAdapter(R.layout.fragment_weather_dailyforecast, null);
        dailyForecastAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        dailyForecast.setAdapter(dailyForecastAdapter);


        suggestionAdapter = new SuggestionAdapter(R.layout.fragment_weather_suggsetion, null);
        suggestionAdapter.setDuration(1000);
        suggestionAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        rvSuggestion.setLayoutManager(new GridLayoutManager(getContext(), 4));
        //设置分割线
        rvSuggestion.setAdapter(suggestionAdapter);

        dailyForecast.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    protected void lazyFetchData() {
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(true);
            }
        });

        //分别从缓存和网络中获取数据，
        subscription = Observable
                .concat(getLocalCache(),getFromNetWork())
                .first()
                //在主线程中更新
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HeWeather5>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "onCompleted: ");
                        //停止刷新
                        setRefresh(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: " + e.toString());
                        //停止刷新
                        setRefresh(false);
                        //提示错误
                        Snackbar.make(findView(R.id.parentPanel), "加载出错...", Snackbar.LENGTH_LONG).setAction("重试", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //重新获取数据
                                lazyFetchData();
                            }
                        }).show();

                    }
                    @Override
                    public void onNext(HeWeather5 heWeather5) {
                        showWeather(heWeather5);
                    }
                });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main,menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    /**
     * 从网络中获取数据
     *
     * @return
     */
    private Observable<HeWeather5> getFromNetWork() {
        return RxLocation
                .getInstance()
                .locate(getActivity())
                .flatMap(new Func1<AMapLocation, Observable<BaseWeatherResponse<HeWeather5>>>() {
                    @Override
                    public Observable<BaseWeatherResponse<HeWeather5>> call(AMapLocation aMapLocation) {
                        Log.e(TAG, "call: "+aMapLocation.getCity());
                        String city = TextUtils.isEmpty(aMapLocation.getCity()) ?
                                "昆明" : aMapLocation.getCity().replace("市", "");
                        return WeatherUtil
                                .getInstance()
                                .getWeatherKey()
                                .flatMap(new Func1<String, Observable<BaseWeatherResponse<HeWeather5>>>() {
                                    @Override
                                    public Observable<BaseWeatherResponse<HeWeather5>> call(String key) {
                                        Log.e(TAG, "call: key"+key );
                                        return ApiFactory
                                                .getWeatherController()
                                                .getWeather(key, city)
                                                .subscribeOn(Schedulers.io());
                                    }
                                });
                    }
                })
                .map(new Func1<BaseWeatherResponse<HeWeather5>, HeWeather5>() {
                    @Override
                    public HeWeather5 call(BaseWeatherResponse<HeWeather5> response) {
                        HeWeather5 heWeather5 = response.HeWeather5.get(0);
                        cache.put(CACHE_WEATHER, heWeather5, 30 * 60);
                        WeatherUtil.getInstance().saveDailyHistory(heWeather5);
                        return heWeather5;
                    }
                });
    }

    /**
     * 从缓存中加载数据
     *
     * @return
     */
    private Observable<HeWeather5> getLocalCache() {
        return Observable
                .unsafeCreate(new Observable.OnSubscribe<HeWeather5>() {
                    @Override
                    public void call(Subscriber<? super HeWeather5> subscriber) {
                        HeWeather5 cacheWeather = (HeWeather5) cache.getAsObject(CACHE_WEATHER);
                        if (cacheWeather != null) {
                            //结束订阅
                            subscriber.onNext(cacheWeather);
                        }
                        subscriber.onCompleted();

                    }
                });

    }

    private void showWeather(HeWeather5 heWeather5) {
        this.heWeather5 = heWeather5;
        city.setText(heWeather5.getBasic().getCity());
        weather.setText(heWeather5.getNow().getCond().getTxt());
        aqi.setText(heWeather5.getAqi() == null ? " " : ("   空气·" + heWeather5.getAqi().getCity().getQlty()));
        temp.setText(String.format("%s℃", heWeather5.getNow().getTmp()));
        String updateTime = TimeUtils.string2String(heWeather5.getBasic().getUpdate().getLoc(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()),
                new SimpleDateFormat("hh:mm", Locale.getDefault()));
        time.setText("截至 " + updateTime); 
        stringBuilder.append("截至北京时间:" + updateTime);
        stringBuilder.append(heWeather5.getBasic().getCity());
        stringBuilder.append("\n天气  "+heWeather5.getNow().getCond().getTxt());
        stringBuilder.append("\n温度  " + heWeather5.getNow().getTmp() + "摄氏度");
        stringBuilder.append("\n空气质量  " + heWeather5.getAqi().getCity().getQlty());

        List<Object> suggestion = new ArrayList<>();
        suggestion.add(heWeather5.getSuggestion().getComf());
        suggestion.add(heWeather5.getSuggestion().getAir());
        suggestion.add(heWeather5.getSuggestion().getCw());
        suggestion.add(heWeather5.getSuggestion().getDrsg());
        suggestion.add(heWeather5.getSuggestion().getFlu());
        suggestion.add(heWeather5.getSuggestion().getSport());
        suggestion.add(heWeather5.getSuggestion().getTrav());
        suggestion.add(heWeather5.getSuggestion().getUv());

        //去除空元素
        for (int i = 0; i < suggestion.size(); i++) {
            if (suggestion.get(i) == null) {
                suggestion.remove(i);
            }
        }
        suggestionAdapter.setNewData(suggestion);

        if (heWeather5.getDaily_forecast().size() != 0) {
            dailyForecastAdapter.addData(heWeather5.getDaily_forecast());
            dailyForecastAdapter.notifyDataSetChanged();
        }

        hourlyForecastRelativeLayout.removeAllViews();
        hourlyForecastRelativeLayout.addView(getChartView(heWeather5));
    }

    private WeatherChartView getChartView(HeWeather5 heWeather5) {
        WeatherChartView chartView = new WeatherChartView(getContext());
        chartView.setWeather5(heWeather5);
        return chartView;
    }


    @Override
    public void onRefresh() {
        refreshLayout.setRefreshing(false);

    }

    public void setRefresh(boolean refreshing) {
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(refreshing);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        tts.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消订阅
        if (subscription != null && subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        tts.stop();
        tts = null;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item_tts:
                if (!TextUtils.isEmpty(stringBuilder)) {
                    tts.speak(stringBuilder.toString());
                } else {
                    tts.speak("内容是空的");
                }
                break;
            case R.id.item_share:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, stringBuilder.toString());
                intent.setType("text/plain");
                startActivity(intent);
                break;


        }
        return false;
    }
}
