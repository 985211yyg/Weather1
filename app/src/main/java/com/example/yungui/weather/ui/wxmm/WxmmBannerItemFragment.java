package com.example.yungui.weather.ui.wxmm;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.yungui.weather.http.api.Api;
import com.example.yungui.weather.modle.bean.WxMMBean;
import com.example.yungui.weather.ui.base.BaseFragment;
import com.example.yungui.weather.ui.wxmm.adapter.ItemRecyclerViewAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class WxmmBannerItemFragment extends BaseFragment {
    private ItemRecyclerViewAdapter itemRecyclerViewAdapter;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private List<WxMMBean> hotMMBeans = new ArrayList<>();
    private List<WxMMBean> freshMMBeans = new ArrayList<>();
    private List<WxMMBean> godMMBeans = new ArrayList<>();
    private Subscription subscription;
    private int tag;

    private WebView webView;
    private WebSettings webSettings;

    private String data1;


    public static WxmmBannerItemFragment Instance(int tag) {
        Bundle data = new Bundle();
        data.putInt("tag", tag);
        WxmmBannerItemFragment itemFragment = new WxmmBannerItemFragment();
        itemFragment.setArguments(data);
        return itemFragment;
    }


    @Override
    protected int getLayoutID() {
        return 0;
    }


    @Override
    protected void initView() {
//        tag = getArguments().getInt("tag");
//        refreshLayout = findView(R.id.mm_refresh);
//        refreshLayout.setRefreshing(true);

//        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                refreshLayout.setRefreshing(false);
//            }
//        });





    }

    @Override
    protected void lazyFetchData() {
        subscription = Observable
                .just(Api.WX_MM)
                .map(new Func1<String, List<WxMMBean>>() {
                    @Override
                    public List<WxMMBean> call(String url) {
                        try {
                            Document document = Jsoup.connect(url).timeout(1500).get();
                            //删除网页banner
                            document.select("#namespace_0").remove();
                            //删除网页tab
                            data1 = document.toString();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<WxMMBean>>() {
                    @Override
                    public void onCompleted() {
//                        refreshLayout.setRefreshing(false);

                    }

                    @Override
                    public void onError(Throwable e) {
//                        refreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onNext(List<WxMMBean> mmBeans) {
//                        refreshLayout.setRefreshing(false);

//                        if (itemRecyclerViewAdapter.getData() == null
//                                || itemRecyclerViewAdapter.getData().size() == 0) {
//                            itemRecyclerViewAdapter.setNewData(mmBeans);
//                        } else {
//                            itemRecyclerViewAdapter.addData(itemRecyclerViewAdapter.getData().size(), mmBeans);
//                        }
//                        itemRecyclerViewAdapter.notifyDataSetChanged();
//                        webView.loadDataWithBaseURL(Api.WX_MM, data1, "text/html", "utf-8", null);
                    }
                });

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }


}
