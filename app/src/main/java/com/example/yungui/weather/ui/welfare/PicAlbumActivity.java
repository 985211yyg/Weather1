package com.example.yungui.weather.ui.welfare;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.yungui.weather.R;
import com.example.yungui.weather.modle.Girls;
import com.example.yungui.weather.ui.base.BaseActivity;
import com.example.yungui.weather.ui.welfare.adapter.GirlsAdapter;
import com.example.yungui.weather.ui.welfare.adapter.PicAlbumAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import rx.Emitter;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yungui on 2017/7/28.
 */

public class PicAlbumActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private PicAlbumAdapter picAlbumAdapter;
    private List<Girls> girlsList = new ArrayList<>();
    private List<String> imgURls = new ArrayList<>();
    private List<String> baseUrls = new ArrayList<>();

    private String baseUrl;
    private String img_url;
    private int position;
    private Subscription subscription;

    private int loadCount = 20;

    @Override
    protected int getLayoutId() {
        return R.layout.acticity_album;
    }

    @Override
    protected int getMenuId() {
        return 0;
    }

    @Override
    protected void onMenuItemClick(int itemId) {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //传过来的数据  只有link能用，还需要对其连接进行解析
        girlsList = getIntent().getParcelableArrayListExtra("list");
        position = getIntent().getIntExtra("position", 0);
//        Log.e(TAG, "传过来的数据" + girlsList.toString() + girlsList.size());

        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.album_refresh);
        refreshLayout.setRefreshing(true);
        recyclerView = (RecyclerView) findViewById(R.id.album_recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        picAlbumAdapter = new PicAlbumAdapter(R.layout.fragment_pic_album_item, null);
        recyclerView.setAdapter(picAlbumAdapter);
        picAlbumAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (adapter.getData().get(position) instanceof Girls) {
                    Log.e(TAG, "onItemClick: " + ((Girls) adapter.getData().get(position)).getUrl());
                }

            }
        });

    }

    @Override
    protected void loadData() {
        for (int i = 1; i < loadCount; i++) {
            baseUrl = girlsList.get(position).getLink()+"/" + i;
            baseUrls.add(baseUrl);
        }
        subscription = Observable
                .from(baseUrls)
                .delay(100, TimeUnit.MICROSECONDS)
                .map(new Func1<String, List<String>>() {
                    @Override
                    public List<String> call(String url) {
                        Log.e(TAG, "call: " + url);
                        try {
                            Document document = Jsoup.connect(url).timeout(1500).get();
                            Elements div = document.select("div.main-image");
                            img_url = div.select("img[src]").first().attr("src");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Log.e(TAG, "call:img_url " + img_url);
                        imgURls.add(img_url);
                        return imgURls;
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<String>>() {
                    @Override
                    public void onCompleted() {
                        refreshLayout.setRefreshing(false);

                    }

                    @Override
                    public void onError(Throwable e) {
                        refreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onNext(List<String> stringList) {
                        picAlbumAdapter.setNewData(stringList);
                    }
                });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
