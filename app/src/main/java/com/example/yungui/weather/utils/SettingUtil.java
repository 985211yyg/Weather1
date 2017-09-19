package com.example.yungui.weather.utils;

import com.example.yungui.weather.App;
import com.example.yungui.weather.R;
import com.example.yungui.weather.http.api.Api;

/**
 * Created by yungui on 2017/6/18.
 */

public class SettingUtil {
    public static final String THEME = "theme";
    public static final String WEATHER_SHARE_TYPE = "weather_share_type";
    public static final String TTS_TYPE = "tts_type";
    public static final String DAY_NIGHT_MODE = "day_night_mode";
    public static final String WEATHER_KEY = "weather_key";
    public static final String LOGIN_FLAG = "login_flag";
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

    /**
     * 人声类型
     * @return
     */
    public static String getTtsType() {
        return (String) SPUtil.get(App.getContext(), TTS_TYPE,
                App.getContext().getResources().getStringArray(R.array.list_preference_tts_values)[0]);
    }
    public static void setTtsType(String type) {
        SPUtil.put(App.getContext(), TTS_TYPE, type);
    }

    /**
     * 白天夜间模式
     * @return
     */
    public static String getDayAndNightMode() {
        return (String) SPUtil.get(App.getContext(), DAY_NIGHT_MODE, "day");
    }
    public static void setDayAndNightMode(String mode) {
        SPUtil.put(App.getContext(), DAY_NIGHT_MODE, mode);
    }

     /*
     将weatherKey存储在sharepreference中
      */
    public static String getWeatherKey() {
        return Api.WEATHER_KEY;

//        return (String) SPUtil.get(App.getContext(), WEATHER_KEY, "36af2fa44706456c998958d1f11a64bf");
    }

    public static void setWeatherKey(String key) {
        SPUtil.put(App.getContext(), WEATHER_KEY, key);
    }

    /**
     * 保存本地登陆信息
     */
    public static boolean getLoginFlag() {
        return (boolean) SPUtil.get(App.getContext(),LOGIN_FLAG,false);
    }

    public static void setLoginFlag(boolean loginFlag) {
        SPUtil.put(App.getContext(),LOGIN_FLAG,loginFlag);
    }

}
