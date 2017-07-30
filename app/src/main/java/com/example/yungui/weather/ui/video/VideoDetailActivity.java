package com.example.yungui.weather.ui.video;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.yungui.weather.R;
import com.example.yungui.weather.http.ApiFactory;
import com.example.yungui.weather.http.api.Api;
import com.example.yungui.weather.http.response.VideoResponse;
import com.example.yungui.weather.modle.bean.FindMoreBean;
import com.example.yungui.weather.modle.bean.FindVideoBean;
import com.example.yungui.weather.modle.bean.VideoBean;
import com.example.yungui.weather.ui.base.BaseActivity;
import com.example.yungui.weather.ui.video.adapter.VideoDetailAdapter;
import com.example.yungui.weather.widgets.MyItemDecoration;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.utils.ListVideoUtil;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VideoDetailActivity extends BaseActivity {
    private TextView title;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private FloatingActionButton searchActionButton;
    private VideoDetailAdapter videoDetailAdapter;
    private LinearLayoutManager linearLayoutManager;

    private int firstVisibleItem;
    private int lastVisibleItem;
    private ListVideoUtil listVideoUtil;
    private boolean isFull = false;

    private String categoryName;
    private int start = 20;
    private String nextPagerUrl;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_detail;
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
        categoryName = getIntent().getStringExtra("name");
        searchActionButton = (FloatingActionButton) findViewById(R.id.fab);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.video_detail_swipeRefresh);
        recyclerView = (RecyclerView) findViewById(R.id.video_detail_recycleView);
        recyclerView.addItemDecoration(new MyItemDecoration(Color.GRAY, 0));
        linearLayoutManager = new LinearLayoutManager(VideoDetailActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        videoDetailAdapter = new VideoDetailAdapter(R.layout.fragment_video_item_detail, null);
        title = (TextView) findViewById(R.id.toolbar_title);
        title.setText(getIntent().getStringExtra("name"));
        setDisplayHomeAsUpEnabled(true);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);

            }
        });
        videoDetailAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        videoDetailAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMoreData();
                start += 10;
                Log.e(TAG, "loadMoreData: "+start);
            }
        }, recyclerView);

        recyclerView.setAdapter(videoDetailAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                //说明有视屏播放
                if (GSYVideoManager.instance().getPlayPosition() >= 0) {
                    //获取当前的播放位置
                    int position = GSYVideoManager.instance().getPlayPosition();
                    //如果播放标签一直，并且当前播放的位置被移除屏幕可见方位
                    if (GSYVideoManager.instance().getPlayTag() == VideoDetailAdapter.TAG
                            && (position < firstVisibleItem || position > lastVisibleItem)) {
                        if (!isFull) {
                            //当播放位置没有位于屏幕上是停止播放
                            GSYVideoPlayer.releaseAllVideos();
                            //通知适配器数据发生改变
                            videoDetailAdapter.notifyDataSetChanged();
                            Log.e(TAG, "onScrolled: 停止播放");
                        }

                    }
                }

            }
        });
        searchActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new VideoSearchFragment().show(getFragmentManager(),"search");
            }
        });
    }

    private void loadMoreData() {
        Log.e(TAG, "loadMoreData: "+start);
        ApiFactory.getVideoController()
                .findMoreVideoDetail(start,
                        10,
                        categoryName,
                        "date")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindVideoBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(FindVideoBean findVideoBean) {
                        videoDetailAdapter.addData(videoDetailAdapter.getData().size(),
                                findVideoBean.getItemList());
                        videoDetailAdapter.notifyDataSetChanged();
                    }
                });


    }

    @Override
    protected void loadData() {
        ApiFactory
                .getVideoController()
                .findVideoDetail(categoryName,
                        "date",
                        "26868b32e808498db32fd51fb422d00175e179df",
                        83)
                .subscribeOn(Schedulers.io())
                .delay(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindVideoBean>() {
                    @Override
                    public void onCompleted() {
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onNext(FindVideoBean findVideoBean) {
                        nextPagerUrl = findVideoBean.getNextPageUrl();
                        Log.e(TAG, "nextPagerUrl: "+nextPagerUrl);
                        videoDetailAdapter.addData(findVideoBean.getItemList());
                    }
                });
    }

    //系统设置发生改变时
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //发生旋转，则去全屏
        if (newConfig.orientation != ActivityInfo.SCREEN_ORIENTATION_USER) {
            isFull = false;
        } else {
            isFull = true;
        }
    }

    //按下返回键
    @Override
    public void onBackPressed() {
        //从全屏返回
        if (GSYVideoPlayer.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
    }

    //重启
    @Override
    protected void onResume() {
        super.onResume();
        GSYVideoManager.onResume();
    }

    //暂停播放
    @Override
    protected void onPause() {
        super.onPause();
        GSYVideoManager.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    //释放所有的视屏
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放所有的视屏
        GSYVideoPlayer.releaseAllVideos();
    }

}
