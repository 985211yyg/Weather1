package com.example.yungui.weather.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.yungui.weather.R;
import com.example.yungui.weather.event.GirlsEvent;
import com.example.yungui.weather.modle.Girls;
import com.example.yungui.weather.ui.welfare.PicAlbumActivity;
import com.example.yungui.weather.ui.welfare.PicDetailActivity;
import com.example.yungui.weather.ui.welfare.adapter.GirlsAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Created by yungui on 2017/6/29.
 */

public abstract class BaseGirlsListFragment extends BaseContentFragment {
    protected RecyclerView recyclerView;
    protected int currentPage = 1;
    protected GirlsAdapter girlsAdapter;
    //发送的数量
    protected int sendCount = 0;
    //j接收到是的数据
    protected int receivedCount = 0;
    protected boolean isLoading = false;

    protected Subscription subscription;
    private Bundle data;

    //是否是相册
    boolean isFromGank_JD = false;


    private shareResult shareResult;

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_recycleview;
    }

    @Override
    protected void initView() {
        super.initView();
        //设置一个新的适配器，不填充任何数据
        recyclerView = findView(R.id.gank_recycleView);
        girlsAdapter = new GirlsAdapter(R.layout.fragment_welfare_item, null);
        girlsAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        girlsAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                currentPage++;
                getGirlsFormServer();
            }
        }, recyclerView);

        girlsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                data = new Bundle();
                data.putParcelableArrayList("list", (ArrayList<? extends Parcelable>) adapter.getData());
                data.putInt("position",position);
                Intent intent = new Intent(getActivity(), PicDetailActivity.class);
                Intent intent2 = new Intent(getActivity(), PicAlbumActivity.class);
                intent.putExtras(data);
                intent2.putExtras(data);

                if (((Girls) adapter.getData().get(position)).getLink() != null) {
                    getActivity().startActivity(intent2);

                } else {
                    getActivity().startActivity(intent);
                }
            }
        });
        //瀑布流，两列
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
        //添加滚动监听器
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //如果不能数值方向滚动并且没有在加载数据
                if (!recyclerView.canScrollVertically(1) && !isLoading) {
                    //加载数据
                    isLoading = true;
                    getGirlsFormServer();
                }
            }
        });
        Log.e(TAG, "数据集合>>>>>>>>>>>>"+girlsAdapter.getData().size());
        recyclerView.setAdapter(girlsAdapter);
    }

    @Override
    protected void lazyFetchData() {
        showRefreshing(true);
        currentPage = 1;
        girlsAdapter.setNewData(null);
        getGirlsFormServer();
    }

    /**
     * 加载数据
     */
    protected abstract void getGirlsFormServer();

    /**
     * 绑定要监听的对象,数据有变化的时候自动调用   此处针对gank和煎蛋 ·    Y
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void GirlsIsComing(GirlsEvent event) {
        Log.e(TAG, "接收到事件！");
        //如果规定的订阅者
        if (!(event.getFrom().equals(this.getClass().getName()))) {
            return;
        }
        showRefreshing(false);

        //如果没有数据局或者数据我空的话
        if (girlsAdapter.getData() == null || girlsAdapter.getData().size() == 0) {
            //整体填充数据
            girlsAdapter.setNewData(event.getGirlsList());
        } else {
            //增加新的数据
            girlsAdapter.addData(girlsAdapter.getData().size(), event.getGirls());
        }
        receivedCount++;
        //接受到所有数据不再加载
        if (receivedCount == sendCount) {
            isLoading = false;
        }

    }

    /**
     * 注册Eventbus
     */
    @Override
    public void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    /**
     * 解绑EventBus
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        //解绑被观察者
        if (subscription != null && subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
//        GirlServer.stop(getActivity());
    }

    public interface shareResult {
        void share(List<Girls> girlsData);
    }

}
