package com.example.yungui.weather.ui.setting;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.example.yungui.weather.R;
import com.example.yungui.weather.event.DayNightEvent;
import com.example.yungui.weather.utils.SettingUtil;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by yungui on 2017/6/20.
 */

public class SettingFragment extends PreferenceFragment implements PreferenceScreen.OnPreferenceChangeListener, PreferenceScreen.OnPreferenceClickListener {
    private ListPreference weather, mode , tts;
    private Preference clear, theme;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.seting);

        weather = (ListPreference) findPreference("weather_share");
        mode = (ListPreference) findPreference("DayAndNight");
        tts = (ListPreference) findPreference("tts");
        theme = (Preference) findPreference("theme_color");
        clear = (Preference) findPreference("clear");

        weather.setOnPreferenceChangeListener(this);
        mode.setOnPreferenceChangeListener(this);
        tts.setOnPreferenceChangeListener(this);
        theme.setOnPreferenceClickListener(this);
        clear.setOnPreferenceClickListener(this);

        //设置选项变化之后的summary
        weather.setSummary(weather.getValue());
        mode.setSummary(mode.getValue());
        tts.setSummary(tts.getValue());

        //获取所有的颜色名字,然后根据colorID来设置summary
        String[] colorName = getActivity().getResources().getStringArray(R.array.colors_name);
        int currentIndex = SettingUtil.getTheme();
        if (colorName.length >7) {
            theme.setSummary("自定义");
        } else {
            theme.setSummary(colorName[currentIndex]);
        }

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        switch (preference.getKey()) {
            case "weather_share":
                weather.setSummary((String) newValue);
                SettingUtil.setWeatherShareType((String) newValue);
                break;
            case "DayAndNight":
                mode.setSummary((String) newValue);
                SettingUtil.setDayAndNightMode((String) newValue);
                //通知白天夜间模式的改变
                EventBus.getDefault().post(new DayNightEvent((String) newValue));

                break;
            case "tts":
                tts.setSummary((String) newValue);
                SettingUtil.setTtsType((String) newValue);
                break;

        }
        return true;
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        switch (preference.getKey()) {
            case "clear":

                break;

            case "theme_color":
                new ColorChooserDialog.Builder((SettingActivity) getActivity(), R.string.theme_chooser)
                        .customColors(R.array.theme_colors, null)
                        .doneButton(R.string.done)
                        .cancelButton(R.string.cancel)
                        .allowUserColorInput(true)
                        .allowUserColorInputAlpha(true)
                        .show();
                break;

        }


        return true;
    }
}
