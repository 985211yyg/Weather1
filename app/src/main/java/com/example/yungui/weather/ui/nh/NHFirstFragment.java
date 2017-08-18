package com.example.yungui.weather.ui.nh;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.yungui.weather.R;
import com.example.yungui.weather.http.ApiFactory;
import com.example.yungui.weather.modle.nh.NH_DataBean;
import com.example.yungui.weather.modle.nh.NH_IDList;
import com.example.yungui.weather.ui.MainActivity;
import com.example.yungui.weather.ui.base.BaseFragment;
import com.example.yungui.weather.ui.nh.adapter.FirstRecyclerViewAdapter;
import com.sdsmdg.harjot.vectormaster.VectorMasterView;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NHFirstFragment extends BaseFragment {
    private Toolbar toolbar;
    private VectorMasterView hourglassView;
    private static final String ARG_COLUMN_COUNT = "IDList-count";
    private int mColumnCount = 1;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private FirstRecyclerViewAdapter firstRecyclerViewAdapter;

    private Subscription subscription, subscription1;
    private List<String> idList = new ArrayList<>();
    private List<NH_DataBean.DataBean.ContentListBean> contentListBeans = new ArrayList<>();
    private int initLoadCount = 2;

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
    protected int getMenuID() {
        return 0;
    }

    @Override
    protected void onMenuItemClick(int id) {

    }

    @Override
    protected void initView() {
        toolbar = findView(R.id.toolbar);
        toolbar.setTitle("首页");
        ((MainActivity) getActivity()).initToolbar(toolbar);
        hourglassView = findView(R.id.hourglassView);
        //开启加载动画
//        new Animation().animateHourglass(this, hourglassView);
        refreshLayout = findView(R.id.first_refresh);
        recyclerView = findView(R.id.first_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        firstRecyclerViewAdapter = new FirstRecyclerViewAdapter(null);
        recyclerView.setAdapter(firstRecyclerViewAdapter);
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
                                            refreshLayout.setRefreshing(false);

                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                            Log.e(TAG, "onError: " + e.toString());
                                        }

                                        @Override
                                        public void onNext(NH_DataBean nh_dataBean) {
                                            int i = 1;
                                            Log.e(TAG, "onNext: "+i + ">>>>>"+nh_dataBean.getData().getContent_list());
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
