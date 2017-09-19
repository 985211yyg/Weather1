package com.example.yungui.weather.ui.nh.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.yungui.weather.R;
import com.example.yungui.weather.http.ApiFactory;
import com.example.yungui.weather.modle.nh.NH_DataBean;
import com.example.yungui.weather.modle.nh.NH_IDList;
import com.example.yungui.weather.ui.MainActivity;
import com.example.yungui.weather.ui.base.BaseFragment;
import com.example.yungui.weather.ui.nh.NHDetailActivity;
import com.example.yungui.weather.ui.nh.adapter.FirstRecyclerViewAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NHFirstFragment extends BaseFragment {
    private Toolbar toolbar;
    private static final String ARG_COLUMN_COUNT = "IDList-count";
    private int mColumnCount = 1;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private FirstRecyclerViewAdapter firstRecyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;

    private Subscription subscription, subscription1;
    private List<String> idList = new ArrayList<>();
    private List<NH_DataBean.DataBean.ContentListBean> contentListBeans = new ArrayList<>();
    private int initLoadCount = 2;

    private TextView suspensionBar;
    private int suspensionHeight;
    private int currentPosition;

    public NHFirstFragment() {

    }

    public static NHFirstFragment newInstance(List<String> idList) {
        NHFirstFragment fragment = new NHFirstFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_COLUMN_COUNT, (ArrayList<String>) idList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_nh_first;
    }


    @Override
    protected void initView() {
        toolbar = findView(R.id.toolbar);
        toolbar.setTitle("one");
        ((MainActivity) getActivity()).initToolbar(toolbar);

        suspensionBar = findView(R.id.suspensionBar);

        refreshLayout = findView(R.id.first_refresh);
        recyclerView = findView(R.id.first_recycleView);
        linearLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(linearLayoutManager);
        firstRecyclerViewAdapter = new FirstRecyclerViewAdapter(null);
        recyclerView.setAdapter(firstRecyclerViewAdapter);
        firstRecyclerViewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, NHDetailActivity.class);
                intent.putExtra("tag", "first");
                intent.putExtra("title", ((NH_DataBean.DataBean.ContentListBean) adapter.getData().get(position)).getTitle());
                intent.putExtra("url", ((NH_DataBean.DataBean.ContentListBean) adapter.getData().get(position)).getShare_url());
                intent.putExtra("img", ((NH_DataBean.DataBean.ContentListBean) adapter.getData().get(position)).getImg_url());
                intent.putExtra("author", ((NH_DataBean.DataBean.ContentListBean) adapter.getData().get(position)).getAuthor().getUser_name());
                intent.putExtra("publishTime", ((NH_DataBean.DataBean.ContentListBean) adapter.getData().get(position)).getPost_date());
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                        view.findViewById(R.id.img), "shareImg").toBundle());
//                startActivity(intent);
            }
        });
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(false);
            }
        });

        //添加滚动监听
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                suspensionHeight = suspensionBar.getHeight();
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentPosition = linearLayoutManager.findFirstVisibleItemPosition();
                //获取第一个可见的item的下一个item
                View view = linearLayoutManager.findViewByPosition(currentPosition + 1);
                if (view != null) {
                    //当item的顶部滚动到悬浮栏的底部时候
                    if (view.getTop() <= suspensionHeight) {
                        //设置悬浮栏的向上偏移
                        suspensionBar.setY(-(suspensionHeight - view.getTop()));
                    } else {
                        //还原悬浮蓝
                        suspensionBar.setY(0);
                        updateSuspensionBar(currentPosition);
                    }
                }

//                //当悬浮蓝被完全顶出屏幕的时候重置悬浮蓝的位置同时更新悬浮蓝的
//                if (currentPosition != linearLayoutManager.findFirstVisibleItemPosition()) {
//                    suspensionBar.setY(0);
//
//                    currentPosition = linearLayoutManager.findFirstVisibleItemPosition();
//                }
            }
        });
    }

    private void updateSuspensionBar(int position) {
        Log.e(TAG, "updateSuspensionBar: "+position );
        int type = firstRecyclerViewAdapter.getItem(position).getCategory();
        switch (type) {
            case 0:
                suspensionBar.setText("- 摄影 -");
                break;
            case 1:
            case 2:
            case 3:
                suspensionBar.setText("- 阅读 -");
                break;
            case 4:
                suspensionBar.setText("- 音乐 -");
                break;
            case 5:
                suspensionBar.setText("- 电影 -");
                break;
        }

    }

    @Override
    protected void lazyFetchData() {
        refreshLayout.setRefreshing(true);
        subscription = ApiFactory
                .getNhController()
                .getIDList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NH_IDList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NH_IDList nh_idList) {

                        for (String s : nh_idList.getData()) {
                            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>" + s);
                            subscription1 = ApiFactory.getNhController()
                                    .getIDListItem(s)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Observer<NH_DataBean>() {
                                        @Override
                                        public void onCompleted() {
                                            Log.e(TAG, "onCompleted: ");
                                            suspensionBar.setVisibility(View.VISIBLE);
                                            refreshLayout.setRefreshing(false);

                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                            Log.e(TAG, "onError: " + e.toString());
                                        }

                                        @Override
                                        public void onNext(NH_DataBean nh_dataBean) {
                                            int i = 1;
//                                            Log.e(TAG, "onNext: "+i + ">>>>>"+nh_dataBean.getData().getContent_list());
                                            if (firstRecyclerViewAdapter.getData() == null || firstRecyclerViewAdapter.getData().size() == 0) {
                                                firstRecyclerViewAdapter.setNewData(nh_dataBean.getData().getContent_list());
                                            } else {
                                                firstRecyclerViewAdapter.addData(firstRecyclerViewAdapter.getData().size(), nh_dataBean.getData().getContent_list());
                                            }
                                            i++;
                                        }
                                    });
                        }

                    }
                });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (subscription != null && subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        if (subscription1 != null && subscription1.isUnsubscribed()) {
            subscription1.unsubscribe();
        }
    }
}
