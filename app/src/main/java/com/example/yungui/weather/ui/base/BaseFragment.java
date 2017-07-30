package com.example.yungui.weather.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * 根据fragment的可见性以及视图的加载 判断加载数据的时机，
 * 同时对布局以及视图的初始化进行封装，暴露出findview()
 * Created by yungui on 2017/6/19.
 */

public abstract class BaseFragment extends Fragment {
    public static final String TAG = BaseFragment.class.getName();
    //标识fragment已经加载完毕
    private boolean isViewPrepared;
    //标识已经触发懒加载
    private boolean hasFetchData=false;

    //根布局
    protected View rootView;

    //获取布局ID
    protected abstract
    @LayoutRes
    int getLayoutID();

    //获取menu ID
    protected abstract
    @MenuRes
    int getMenuID();

    protected abstract void onMenuItemClick(int id);
    //抽象的视图加载方法
    protected abstract void initView();

    //抽象的数据加载方法
    protected abstract void lazyFetchData();
    /*
    ================================================
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    /**
     * 加载布局
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutID(), container, false);
        initView();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*
       视图加载完毕时进行判断加载
         */
        isViewPrepared = true;
        lazyFetchDataIfPrepared();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Log.e(TAG, "onCreateOptionsMenu: 被调用了" );
        inflater.inflate(getMenuID(),menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onMenuItemClick(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    /**
     *  可见时判断 加载数据
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyFetchDataIfPrepared();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hasFetchData = false;
        isViewPrepared = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }



    @Override
    public void onDetach() {
        super.onDetach();
    }

    /*
    首先判断是否贮备完毕，是则加载数据
     */
    private void lazyFetchDataIfPrepared() {
        //如果fragment对于用户可见，
        // 并且视图已经准备完毕但是还没有加载数据
        //则开始加载数据
        if (getUserVisibleHint() && !hasFetchData && isViewPrepared) {
            hasFetchData = true;
            //准备完毕加载数据
            lazyFetchData();
        }

    }

    /**
     * 获取视图组件
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T findView(@IdRes int id) {
        return (T) rootView.findViewById(id);
    }

}
