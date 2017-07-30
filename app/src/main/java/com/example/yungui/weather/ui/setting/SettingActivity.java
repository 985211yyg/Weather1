package com.example.yungui.weather.ui.setting;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.example.yungui.weather.R;
import com.example.yungui.weather.event.ThemeChangeEvent;
import com.example.yungui.weather.ui.base.BaseActivity;
import com.example.yungui.weather.utils.SettingUtil;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by yungui on 2017/6/20.
 */

public class SettingActivity extends BaseActivity implements ColorChooserDialog.ColorCallback {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected int getMenuId() {
        return 0;
    }

    @Override
    protected void onMenuItemClick(int itemId) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void loadData() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.setting_container, new SettingFragment())
                .commit();

    }

    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, int selectedColor) {
//        //获取主题的颜色值，如果选择的颜色与当前主题的颜色一致，则直接退出，不做任何改变
//        if (selectedColor == ThemeUtil.getThemeColor(this, R.attr.colorPrimary)) {
//            return;
//        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //设状态栏的颜色
            getWindow().setStatusBarColor(selectedColor);
        }
        if (selectedColor == getResources().getColor(R.color.blue)) {
            setTheme(R.style.BlueTheme);
            SettingUtil.setTheme(0);
        } else if (selectedColor == getResources().getColor(R.color.green)) {
            setTheme(R.style.GreenTheme);
            SettingUtil.setTheme(1);
        } else if (selectedColor == getResources().getColor(R.color.niagara)) {
            setTheme(R.style.NiagaraTheme);
            SettingUtil.setTheme(2);
        } else if (selectedColor == getResources().getColor(R.color.pink)) {
            setTheme(R.style.PinkTheme);
            SettingUtil.setTheme(3);
        } else if (selectedColor == getResources().getColor(R.color.purple)) {
            setTheme(R.style.PurpleTheme);
            SettingUtil.setTheme(4);
        } else if (selectedColor == getResources().getColor(R.color.red)) {
            setTheme(R.style.RedTheme);
            SettingUtil.setTheme(5);
        } else if (selectedColor == getResources().getColor(R.color.colorPrimary)) {
            setTheme(R.style.AppTheme);
            SettingUtil.setTheme(6);
        }
        this.recreate();
        //发送事件
        EventBus.getDefault().post(new ThemeChangeEvent(selectedColor));
    }

    @Override
    public void onColorChooserDismissed(@NonNull ColorChooserDialog dialog) {

    }
}
