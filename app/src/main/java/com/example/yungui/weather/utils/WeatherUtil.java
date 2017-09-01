package com.example.yungui.weather.utils;

import android.text.TextUtils;

import com.example.yungui.weather.App;
import com.example.yungui.weather.http.ApiFactory;
import com.example.yungui.weather.http.response.BaseAppResponse;
import com.example.yungui.weather.http.RetrofitManager;
import com.example.yungui.weather.modle.HeWeather5;
import com.example.yungui.weather.modle.WeatherBean;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yungui on 2017/6/26.
 */

public class WeatherUtil {

    private static WeatherUtil instance;
    //存储天不同的天气
    private Map<String, WeatherBean> weatherBeanMap;

    private WeatherUtil() {

        weatherBeanMap = new HashMap<>();
        //将本地资源解析成数据model
        List<WeatherBean> weatherBeans = RetrofitManager.gson()
                .fromJson(readFromAssets(), new TypeToken<List<WeatherBean>>() {
                }.getType());
        //讲获得的数据以键值对的形式存储
        for (WeatherBean bean : weatherBeans) {

            weatherBeanMap.put(bean.getCode(), bean);
        }
    }

    /**
     * 从assets中获取资源,返回资源字符串
     */
    private String readFromAssets() {

        try {
            InputStream inputStream = App.getContext().getAssets().open("weather1.json");
            //获取steam有效的字节数
            int size = inputStream.available();
            //创建一个size长度的字节数组
            byte[] buffer = new byte[size];
            //一字节的形式读取获取的asset资源
            inputStream.read(buffer);
            inputStream.close();
            //将字节转换为字符串
            return new String(buffer, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }

    public static WeatherUtil getInstance() {
        if (instance == null) {
            //同步锁
            synchronized (WeatherUtil.class) {
                instance = new WeatherUtil();
            }
        }
        return instance;
    }

    /**
     * 根据code的不同发送不同的WeatherBean
     *
     * @param code
     * @return
     */
    public Observable<WeatherBean> getWeatherDict(final String code) {
        return Observable.unsafeCreate(new Observable.OnSubscribe<WeatherBean>() {
            @Override
            public void call(Subscriber<? super WeatherBean> subscriber) {
                //发射数据
                subscriber.onNext(WeatherUtil.getInstance().weatherBeanMap.get(code));
                subscriber.onCompleted();
            }

        }).subscribeOn(Schedulers.io());
    }

    public Observable<String> getWeatherKey() {
        //获取本地key
        Observable<String> localKey = Observable.unsafeCreate(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                //获取存储的weatherkey
                String key = SettingUtil.getWeatherKey();
                if (TextUtils.isEmpty(key)) {
                    subscriber.onCompleted();
                } else {
                    //发布事件
                    subscriber.onNext(key);
                }
            }
        });


        //获取网路key
        Observable<String> netKey = ApiFactory
                .getAppController()
                .getWeatherKey()
                .flatMap(new Func1<BaseAppResponse<String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(BaseAppResponse<String> response) {
                        if (TextUtils.isEmpty(response.results)) {
                            SettingUtil.setWeatherKey(response.results);
                        }
                        //返回第一个数据
                        return Observable.just(response.results);
                    }
                });

        //链接两个可用，然后返回
        return Observable
                //拼接
                .concat(localKey, netKey)
                .first()
                .subscribeOn(Schedulers.io());
    }

    /**
     * 缓存天气数据
     *
     * @param heWeather5
     */
    public void saveDailyHistory(HeWeather5 heWeather5) {
        //转换heWeather5为observable对像发送，然后惊醒过滤名将空值过滤除去
        Observable
                .just(heWeather5)
                .filter(new Func1<HeWeather5, Boolean>() {
                    @Override
                    public Boolean call(HeWeather5 heWeather5) {
                        return heWeather5 != null;
                    }
                    //进行变换
                })
                .map(new Func1<HeWeather5, Boolean>() {
                    @Override
                    public Boolean call(HeWeather5 heWeather5) {
                        //缓存g工具
                        ACache cache = ACache.get(App.getContext());
                        //缓存
                        for (HeWeather5.DailyForecastBean dailyForecastBean : heWeather5.getDaily_forecast()) {
                            //缓存七天
                            cache.put(dailyForecastBean.getDate(), dailyForecastBean, 7 * 24 * 60 * 60);
                        }
                        //缓存完成
                        return true;
                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    /**
     * 获取前一天的数据
     */
    public HeWeather5.DailyForecastBean getYesterday() {
        return (HeWeather5.DailyForecastBean) ACache.get(App.getContext()).getAsObject(TimeUtils.getPreviousDay(TimeUtils.getCurTimeString(TimeUtils.DATE_SDF), 1));
    }

    /**
     * 获取分享的天气信息
     *
     * @param weather 分享的天气
     * @return
     */
    public String getShareMessage(HeWeather5 weather) {
        StringBuffer message = new StringBuffer();
        message.append(weather.getBasic().getCity());
        message.append("天气：");
        message.append("\r\n");
        message.append(weather.getBasic().getUpdate().getLoc());
        message.append(" 发布：");
        message.append("\r\n");
        message.append(weather.getNow().getCond().getTxt());
        message.append("，");
        message.append(weather.getNow().getTmp()).append("℃");
        message.append("。");
        message.append("\r\n");
        message.append("PM2.5：").append(weather.getAqi().getCity().getPm25());
        message.append("，");
        message.append(weather.getAqi().getCity().getQlty());
        message.append("。");
        message.append("\r\n");
        message.append("今天：");
        message.append(weather.getDaily_forecast().get(0).getTmp().getMin()).append("℃-");
        message.append(weather.getDaily_forecast().get(0).getTmp().getMax()).append("℃");
        message.append("，");
        message.append(weather.getDaily_forecast().get(0).getCond().getTxt_d());
        message.append("，");
        message.append(weather.getDaily_forecast().get(0).getWind().getDir());
        message.append(weather.getDaily_forecast().get(0).getWind().getSc());
        message.append("级。");
        message.append("\r\n");
        message.append("明天：");
        message.append(weather.getDaily_forecast().get(1).getTmp().getMin()).append("℃-");
        message.append(weather.getDaily_forecast().get(1).getTmp().getMax()).append("℃");
        message.append("，");
        message.append(weather.getDaily_forecast().get(1).getCond().getTxt_d());
        message.append("，");
        message.append(weather.getDaily_forecast().get(1).getWind().getDir());
        message.append(weather.getDaily_forecast().get(1).getWind().getSc());
        message.append("级。");

        return message.toString();

    }

}
