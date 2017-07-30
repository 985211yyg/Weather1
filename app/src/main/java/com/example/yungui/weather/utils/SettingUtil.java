package com.example.yungui.weather.utils;

import com.example.yungui.weather.App;

/**
 * Created by yungui on 2017/6/18.
 */

public class SettingUtil {
    public static final String THEME = "theme";
    public static final String WEATHER_SHARE_TYPE = "weather_share_type";

    public static final String TTS_TYPE = "tts_type";

    public static final String BUS_REFRESH_TIME = "bus_refresh_time";
    public static final String WEATHER_KEY = "weather_key";
    /*
    设置主题
     */
    public static int getTheme() {
        return (int) SPUtil.get(App.getContext(), THEME, 0);
    }

    public static void setTheme(int themeIndex) {
        SPUtil.put(App.getContext(), THEME, themeIndex);
    }

    public static void setWeatherShareType(String type) {
        SPUtil.put(App.getContext(), WEATHER_SHARE_TYPE,type);
    }

    public static void getWeatherShareType() {
        SPUtil.get(App.getContext(), WEATHER_SHARE_TYPE, "文本");
    }

    public static void getTtsType() {
        SPUtil.get(App.getContext(), TTS_TYPE, "小李（男声） 普通话");
    }

    public static void setTtsType(String type) {
        SPUtil.put(App.getContext(), TTS_TYPE, type);
    }

    public static void getBusRefreshTime() {
        SPUtil.get(App.getContext(), BUS_REFRESH_TIME, 6);
    }

    public static void setBusRefreshTime(String time) {
        SPUtil.put(App.getContext(), BUS_REFRESH_TIME, time);
    }
     /*
     将weatherKey存储在sharepreference中
      */
    public static String getWeatherKey() {
        return "36af2fa44706456c998958d1f11a64bf";

//        return (String) SPUtil.get(App.getContext(), WEATHER_KEY, "");
    }

    public static void setWeatherKey(String key) {
        SPUtil.put(App.getContext(), WEATHER_KEY, key);
    }

}
