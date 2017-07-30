package com.example.yungui.weather.ui.video;

import android.app.ActivityOptions;
import android.content.Intent;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.yungui.weather.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.yungui.weather.http.ApiFactory;
import com.example.yungui.weather.modle.bean.FindMoreBean;
import com.example.yungui.weather.ui.MainActivity;
import com.example.yungui.weather.ui.base.BaseFragment;
import com.example.yungui.weather.ui.video.adapter.VideoAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yungui on 2017/6/19.
 */

public class VideoFragment extends BaseFragment {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private List<FindMoreBean> findMoreBeanList = new ArrayList<>();
    private VideoAdapter videoAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private boolean isFetchData;


    @Override
    protected int getLayoutID() {
        return R.layout.fragment_video;
    }

    @Override
    protected int getMenuID() {
        return 0;
    }

    @Override
    protected void onMenuItemClick(int id) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_video_search,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initView() {
        swipeRefreshLayout = findView(R.id.video_swipeRefresh);
        swipeRefreshLayout.setRefreshing(true);
        toolbar = findView(R.id.video_toolBar);
        //设置toolbar与drawer联动
        ((MainActivity) getActivity()).initToolbar(toolbar);
        toolbar.setTitle("开眼");
        recyclerView = findView(R.id.video_recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        videoAdapter = new VideoAdapter(R.layout.fragment_video_item, null);
        videoAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        videoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), VideoDetailActivity.class);
                if (adapter.getData().get(position) instanceof FindMoreBean) {
                    intent.putExtra("name", ((FindMoreBean) adapter.getData().get(position)).getName());
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                            view.findViewById(R.id.video_title),
                            "shareView").toBundle());
                }

            }
        });
        recyclerView.setAdapter(videoAdapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);

            }
        });
    }

    @Override
    protected void lazyFetchData() {
        ApiFactory.getVideoController()
                .findMoreData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<FindMoreBean>>() {
                    @Override
                    public void onCompleted() {
                        swipeRefreshLayout.setRefreshing(false);

                    }

                    @Override
                    public void onError(Throwable e) {
                        swipeRefreshLayout.setRefreshing(false);

                    }

                    @Override
                    public void onNext(List<FindMoreBean> findMoreBeans) {
                        findMoreBeanList = findMoreBeans;
                        Log.e(TAG, "请求数据成功！" + findMoreBeanList.size());
                        videoAdapter.setNewData(findMoreBeanList);
                        isFetchData = true;

                    }
                });

    }

}
