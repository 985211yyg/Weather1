package com.example.yungui.weather.ui.weather;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.yungui.weather.R;
import com.example.yungui.weather.http.ApiFactory;
import com.example.yungui.weather.http.response.BaseWeatherResponse;
import com.example.yungui.weather.location.RxLocation;
import com.example.yungui.weather.modle.HeWeather5;
import com.example.yungui.weather.ui.MainActivity;
import com.example.yungui.weather.ui.base.BaseFragment;
import com.example.yungui.weather.utils.ACache;
import com.example.yungui.weather.utils.ThemeUtil;
import com.example.yungui.weather.utils.WeatherUtil;

import java.text.SimpleDateFormat;
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

public class WeatherFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {
    public static final String CACHE_WEATHER_MANE = "weather_cache";

    private android.support.v7.widget.Toolbar toolbar;
    private TextView city, weather, temp, time, aqi;
    //缓存
    private ACache cache;
    //天气数据
    private HeWeather5 heWeather5;
    private Subscription subscription;

    private LinearLayout dailyForecast;
    private RecyclerView rvSuggestion;
    private SuggestionAdapter suggestionAdapter;
    private SwipeRefreshLayout refreshLayout;

    public static final String TAG = WeatherFragment.class.getName();

    @Override

    protected int getLayoutID() {
        return R.layout.fragment_weather;
    }

    @Override
    protected int getMenuID() {
        return 0;
    }

    @Override
    protected void onMenuItemClick(int id) {

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView() {
        setHasOptionsMenu(true);
        cache = ACache.get(getActivity());
        toolbar = findView(R.id.weather_toolbar);
        toolbar.setTitle("Weather");

        ((MainActivity) getActivity()).initToolbar(toolbar);
        city = findView(R.id.tv_city);
        weather = findView(R.id.tv_rain);
        temp = findView(R.id.tv_temp);
        aqi = findView(R.id.tv_air);
        time = findView(R.id.tv_update_time);

        refreshLayout = findView(R.id.refreshLayout);
        //设置刷新控件的颜色和当前的主题颜色一样
        refreshLayout.setColorSchemeColors(ThemeUtil.getCurrentColorPrimary(getContext()));
        dailyForecast = findView(R.id.forecast_linearLayout);
        rvSuggestion = findView(R.id.forecast_recyclerView);

        suggestionAdapter = new SuggestionAdapter(R.layout.fragment_weather_suggsetion, null);
        //设置动画时间
        suggestionAdapter.setDuration(1000);
        //设置加载动画
        suggestionAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        //gei recycle view 设置布局
        rvSuggestion.setLayoutManager(new GridLayoutManager(getContext(), 4));
        //设置分割线
        rvSuggestion.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        rvSuggestion.setAdapter(suggestionAdapter);
    }

    @Override
    protected void lazyFetchData() {
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(true);

            }
        });
        Log.e(TAG, "getLocalCache: " + getLocalCache().toString());
        Log.e(TAG, "getFromNetWork: " + getFromNetWork());
        //拼接合并多个observable成新的observable
        subscription = Observable
                .concat(getLocalCache(), getFromNetWork())
                .first()
                //在主线程中更新
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HeWeather5>() {
                    @Override
                    public void onCompleted() {
                        //停止刷新
                        setRefresh(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        //停止刷新
                        setRefresh(false);
                        //提示错误
                        Snackbar.make(getView(), "加载出错...", Snackbar.LENGTH_LONG).setAction("重试", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //重新获取数据
                                lazyFetchData();
                            }
                        }).setActionTextColor(getActivity().getResources().getColor(R.color.colorPrimary)).show();

                    }

                    @Override
                    public void onNext(HeWeather5 heWeather5) {
                        showWeather(heWeather5);

                    }
                });

    }

    private void showWeather(HeWeather5 heWeather5) {
        this.heWeather5 = heWeather5;
        city.setText(heWeather5.getBasic().getCity());
        weather.setText(heWeather5.getNow().getCond().getTxt());
        temp.setText(String.format("%s℃", heWeather5.getNow().getTmp()));
        //空气质量
        aqi.setText(heWeather5.getAqi() == null ? "" : heWeather5.getAqi().getCity().getQlty());
        String updateTime = com.example.yungui.weather.utils.TimeUtils.string2String(heWeather5.getBasic().getUpdate().getLoc(), new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()),
                new SimpleDateFormat("hh:mm", Locale.getDefault()));
        time.setText(updateTime);

    }

    public void setRefresh(boolean refreshing) {
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(refreshing);
            }
        });

    }

    /**
     * 从网络中获取数据
     *
     * @return
     */
    private Observable<HeWeather5> getFromNetWork() {
        Log.e(TAG, "getFromNetWork: "+"从网络获取数据");
        return RxLocation
                .getInstance()
                .locate(getActivity())
                //将定位信息BDLocation转换为多个可观察的observable
                .flatMap(new Func1<BDLocation, Observable<BaseWeatherResponse<HeWeather5>>>() {
                    @Override
                    public Observable<BaseWeatherResponse<HeWeather5>> call(BDLocation bdLocation) {
                        Log.e(TAG, "BDLocation 定位成功" + bdLocation);
                        //获取定位城市，并且将“市”替换了
                        String cityName = TextUtils.isEmpty(bdLocation.getCity()) ? "昆明" : bdLocation.getCity()
                                .replace("市", "");
                        //设置城市
                        city.setText(cityName);
                        return WeatherUtil
                                .getInstance()
                                //获取天气key  返回Observable<BaseAppResponse<String>>
                                .getWeatherKey()
                                //将得到可key转换为 BaseWeatherResponse<HeWeather5>
                                .flatMap(new Func1<String, Observable<BaseWeatherResponse<HeWeather5>>>() {
                                    @Override
                                    public Observable<BaseWeatherResponse<HeWeather5>> call(String key) {
                                        Log.e(TAG, "weather  key " + key);
                                        return ApiFactory
                                                .getWeatherController()
                                                //根据key和城市名字获取天气情况
                                                .getWeather(key, cityName)
                                                //在io现场中监听变化
                                                .subscribeOn(Schedulers.io());
                                    }
                                });
                    }
                })
                //转换，将基础的天气信息转化成可观察的天气bean
                .map(new Func1<BaseWeatherResponse<HeWeather5>, HeWeather5>() {
                    @Override
                    public HeWeather5 call(BaseWeatherResponse<HeWeather5> heWeather5BaseWeatherResponse) {
                        HeWeather5 heWeather5 = heWeather5BaseWeatherResponse.HeWeather5.get(0);
                        //缓存
                        cache.put(CACHE_WEATHER_MANE, heWeather5, 30 * 60);
                        //存储天气
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
        return Observable.unsafeCreate(new Observable.OnSubscribe<HeWeather5>() {
            @Override
            public void call(Subscriber<? super HeWeather5> subscriber) {
                HeWeather5 cacheWeather = (HeWeather5) cache.getAsObject(CACHE_WEATHER_MANE);
                if (cacheWeather == null) {
                    //结束订阅
                    subscriber.onCompleted();
                } else {
                    subscriber.onNext(cacheWeather);
                }
            }
        });

    }

    @Override
    public void onRefresh() {
        lazyFetchData();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.toolbar_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_tts:
                break;
            case R.id.item_share:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消订阅
        if (subscription != null && subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
