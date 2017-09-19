package com.example.yungui.weather.ui.welfare;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.util.Log;

import com.example.yungui.weather.http.ApiFactory;
import com.example.yungui.weather.http.response.BaseGankResponse;
import com.example.yungui.weather.modle.Gank;
import com.example.yungui.weather.modle.Girls;
import com.example.yungui.weather.service.GirlServer;
import com.example.yungui.weather.ui.base.BaseGirlsListFragment;
import com.example.yungui.weather.utils.ConstUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yungui on 2017/6/29.
 */

public class GankFragment extends BaseGirlsListFragment {
    public static final String TAG = GankFragment.class.getSimpleName();

    @Override
    protected void getGirlsFormServer() {
        subscription = ApiFactory
                .getGirlsController()
                .getGank(String.valueOf(currentPage))
                //在io线程中订阅
                .subscribeOn(Schedulers.io())
                //在主线程中观察
                .observeOn(AndroidSchedulers.mainThread())
                //观察结果,并发送事件
                .subscribe(new Observer<BaseGankResponse<List<Gank>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e + e.toString());
                        showRefreshing(false);
                        isLoading = false;
                        Snackbar.make(getView(), "加载出错啦啦...", Snackbar.LENGTH_LONG)
                                .setActionTextColor(Color.RED).show();
                    }

                    @Override
                    public void onNext(BaseGankResponse<List<Gank>> gankResponse) {
                        //一次请求形成一次数据，当前也页面加一
                        currentPage++;
                        List<Girls> girls = new ArrayList<>();
                        for (Gank result : gankResponse.results) {
                            girls.add(new Girls(result.getUrl()));
                        }

                        sendCount = girls.size();
                        Log.e(TAG, "加载的数据数量为：" + sendCount);
                        receivedCount = 0;
                        //启动后台服务,传递数据给后台服务，后台处理之后通过eventbus通知时间的订阅者时间发生改变
                        //然后更新ui
                        Log.e(TAG, "启动服务");
                        GirlServer.start(getActivity(), GankFragment.this.getClass().getName(), girls);
                    }
                });

    }


}
