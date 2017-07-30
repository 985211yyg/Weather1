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
import com.example.yungui.weather.utils.SettingUtil;

/**
 * Created by yungui on 2017/6/20.
 */

public class SettingFragment extends PreferenceFragment implements PreferenceScreen.OnPreferenceChangeListener, PreferenceScreen.OnPreferenceClickListener {
    private ListPreference weather, bus , tts;
    private Preference clear, theme;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.seting);

        weather = (ListPreference) findPreference("weather_share");
        bus = (ListPreference) findPreference("bus_refresh");
        tts = (ListPreference) findPreference("tts");
        theme = (Preference) findPreference("theme_color");
        clear = (Preference) findPreference("clear");

        weather.setOnPreferenceChangeListener(this);
        bus.setOnPreferenceChangeListener(this);
        tts.setOnPreferenceChangeListener(this);
        theme.setOnPreferenceClickListener(this);
        clear.setOnPreferenceClickListener(this);

        //设置选项变化之后的summary
        weather.setSummary(weather.getValue());
//        bus.setSummary(bus.getValue());
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
            case "bus_refresh":
//                bus.setSummary((String) newValue);
                SettingUtil.setBusRefreshTime(String.format("%s 秒，长按『刷新』按钮即可开启自动模式。", newValue));
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
                        .allowUserColorInput(false)
                        .allowUserColorInputAlpha(false)
                        .show();
                break;

        }


        return true;
    }
}
