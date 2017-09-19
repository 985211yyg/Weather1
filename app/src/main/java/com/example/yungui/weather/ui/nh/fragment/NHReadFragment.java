package com.example.yungui.weather.ui.nh.fragment;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.yungui.weather.R;
import com.example.yungui.weather.http.ApiFactory;
import com.example.yungui.weather.modle.nh.NH_ReadingList;
import com.example.yungui.weather.ui.MainActivity;
import com.example.yungui.weather.ui.base.BaseFragment;
import com.example.yungui.weather.ui.nh.NHDetailActivity;
import com.example.yungui.weather.ui.nh.adapter.NHReadRecyclerViewAdapter;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class NHReadFragment extends BaseFragment {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private NHReadRecyclerViewAdapter readRecyclerViewAdapter;

    private Subscription subscription;

    public NHReadFragment() {
    }

    public static NHReadFragment newInstance(String param1, String param2) {
        NHReadFragment fragment = new NHReadFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_nh_read;
    }


    @Override
    protected void initView() {
        toolbar = findView(R.id.toolbar);
        toolbar.setTitle("阅读");
        ((MainActivity) getActivity()).initToolbar(toolbar);

        recyclerView = findView(R.id.read_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        swipeRefreshLayout = findView(R.id.read_refresh);
        swipeRefreshLayout.setRefreshing(true);

        readRecyclerViewAdapter = new NHReadRecyclerViewAdapter(R.layout.nh_item_text, null);
        recyclerView.setAdapter(readRecyclerViewAdapter);
        readRecyclerViewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, NHDetailActivity.class);
                intent.putExtra("tag", "read");
                intent.putExtra("title", ((NH_ReadingList.DataBean) adapter.getData().get(position)).getTitle());
                intent.putExtra("url", ((NH_ReadingList.DataBean) adapter.getData().get(position)).getShare_url());
                intent.putExtra("img", ((NH_ReadingList.DataBean) adapter.getData().get(position)).getImg_url());
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                        view.findViewById(R.id.img), "shareImg").toBundle());

            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    @Override
    protected void lazyFetchData() {
        subscription = ApiFactory
                .getNhController()
                .getReadingList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NH_ReadingList>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG, "onCompleted: ");
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: ");

                    }

                    @Override
                    public void onNext(NH_ReadingList nh_readingList) {
                        Log.e(TAG, "onNext: " + nh_readingList.getData().size());
                        if (readRecyclerViewAdapter.getData() == null || readRecyclerViewAdapter.getData().size() == 0) {
                            readRecyclerViewAdapter.setNewData(nh_readingList.getData());
                            Log.e(TAG, "readRecyclerViewAdapter: ");
                        } else {
                            readRecyclerViewAdapter.addData(readRecyclerViewAdapter.getData().size(), nh_readingList.getData());
                        }
                        readRecyclerViewAdapter.notifyDataSetChanged();
                    }
                });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
