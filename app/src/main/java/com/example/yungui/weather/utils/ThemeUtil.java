package com.example.yungui.weather.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;

import com.example.yungui.weather.R;

/**
 * 多主题切换工具
 * Created by yungui on 2017/6/20.
 */

public class ThemeUtil {
    //获取指定属性的颜色值
    public static int getThemeColor(Context context, int attrRes) {
        //根据属性名获取获取当前主题的颜色
        TypedArray typedArray = context.obtainStyledAttributes(new int[]{attrRes});
        //获取第一个颜色值，也就是目标颜色值，
        int color = typedArray.getColor(0, 0xffffff);
        typedArray.recycle();
        return color;
    }

    /**
     * 获取当前主题的颜色
     *
     * @param context
     * @return
     */
    public static int getCurrentColorPrimary(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        return typedValue.resourceId;
    }
}
