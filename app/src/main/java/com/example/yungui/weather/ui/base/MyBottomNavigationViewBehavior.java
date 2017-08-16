package com.example.yungui.weather.ui.base;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yungui on 2017/8/9.
 */

public class MyBottomNavigationViewBehavior extends CoordinatorLayout.Behavior<View>{

    public MyBottomNavigationViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        //child依赖于AppBarLayout
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        //获取dependencyView d的移动距离，然后child作出对应的移动
        float translateY = Math.abs(dependency.getTop());
        child.setTranslationY(translateY);
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
