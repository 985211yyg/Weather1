package com.example.yungui.weather.ui.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Toolbar;

import com.example.yungui.weather.R;
import com.example.yungui.weather.utils.ThemeUtil;

/**  下拉刷新组件的初始化 和 刷新的监听事件进行封装
 * Created by yungui on 2017/6/29.
 */

public abstract class BaseContentFragment extends BaseFragment {
    public static final String TAG = BaseContentFragment.class.getName();
    //刷新
    protected SwipeRefreshLayout swipeRefreshLayout;
    protected Toolbar toolbar;

    @Override
    protected void initView() {
        initRefreshLayout();
        showRefreshing(true);
    }

    protected void showRefreshing(boolean refresh) {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(refresh);
            }
        });

    }
    private void initRefreshLayout() {
        swipeRefreshLayout = findView(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //刷新的时候加载数据
                lazyFetchData();
            }
        });
    }
}
