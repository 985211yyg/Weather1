package com.example.yungui.weather.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.yungui.weather.R;

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
    protected Context mContext;

    //获取布局ID
    protected abstract
    @LayoutRes
    int getLayoutID();

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
        Log.e(TAG, "onAttach: " );
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Log.e(TAG, "onCreate: " );
    }

    /**
     * 加载布局
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: " );
        rootView = inflater.inflate(getLayoutID(), container, false);
        initView();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated: " );
        //视图加载完毕
        isViewPrepared = true;
        //判断是否记载过数据
        lazyFetchDataIfPrepared();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated: " );
    }

    /**
     *  可见时判断 加载数据
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        Log.e(TAG, "setUserVisibleHint: "+isVisibleToUser );
        if (isVisibleToUser) {
            lazyFetchDataIfPrepared();
        }
    }


    @Override
    public void onStart() {
        super.onStart();
//        Log.e(TAG, "onStart: " );
    }

    @Override
    public void onResume() {
        super.onResume();
//        Log.e(TAG, "onResume: " );
    }

    @Override
    public void onPause() {
        super.onPause();
//        Log.e(TAG, "onPause: " );
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        Log.e(TAG, "onSaveInstanceState: 0" );
    }

    @Override
    public void onStop() {
        super.onStop();
//        Log.e(TAG, "onStop: " );
    }

    /**
     * 销魂视图
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        Log.e(TAG, "onDestroyView: " );
        //销毁后重置懒加载
        hasFetchData = false;
        isViewPrepared = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        Log.e(TAG, "onDestroy: " );
    }



    @Override
    public void onDetach() {
        super.onDetach();
//        Log.e(TAG, "onDetach: " );
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
