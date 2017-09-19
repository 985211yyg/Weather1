package com.example.yungui.weather.ui.welfare;

import android.support.design.widget.Snackbar;
import android.util.Log;

import com.example.yungui.weather.R;
import com.example.yungui.weather.http.ApiFactory;
import com.example.yungui.weather.http.response.BaseJianDanResponse;
import com.example.yungui.weather.modle.CommentsBean;
import com.example.yungui.weather.modle.Girls;
import com.example.yungui.weather.modle.JianDanOOXX;
import com.example.yungui.weather.modle.JianDanXXOO;
import com.example.yungui.weather.service.GirlServer;
import com.example.yungui.weather.ui.base.BaseGirlsListFragment;
import com.example.yungui.weather.utils.ConstUtils;
import com.example.yungui.weather.utils.ThemeUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yungui on 2017/6/30.
 */

public class JianDanFragment extends BaseGirlsListFragment {

    @Override
    protected void getGirlsFormServer() {
        subscription = ApiFactory
                //获取请求工具，并调用数据回调接口
                .getGirlsController()
                //回调获取数据，作为被观察对象
                .getXXOO(currentPage)
                //在io线程中活动
                .subscribeOn(Schedulers.io())
                //在主线程中订阅观察
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseJianDanResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //停止更新
                        showRefreshing(false);
                        isLoading = false;
                        Snackbar.make(getView(), R.string.load_error,Snackbar.LENGTH_LONG)
                                .setActionTextColor(ThemeUtil.getCurrentColorPrimary(getActivity()))
                                .show();
                        Log.e(TAG, e+e.toString());

                    }

                    /**
                     * 对数据进行处理，然后开启服务计算数据，之后由服务通知订阅者数据的变化，之后进行ui更新
                     * @param baseJianDanResponse
                     */
                    @Override
                    public void onNext(BaseJianDanResponse baseJianDanResponse) {
                        currentPage++;
                        Log.e(TAG, "onNext: ------------" +baseJianDanResponse.getComments().size());
                        List<Girls> girls = new ArrayList<>();
                        for (CommentsBean bean : baseJianDanResponse.getComments()) {
                            for (String url : bean.getPics()) {
                                //暂时过滤动图
                                if (!url.toLowerCase().endsWith("gif")) {
                                    girls.add(new Girls(url));
                                }
                            }
                        }
                        sendCount = girls.size();
                        receivedCount = 0;
                        //开启服务
                        Log.e(TAG, "开启服务" );
                        GirlServer.start(getActivity(), JianDanFragment.this.getClass().getName(),girls);
                    }
                });

    }


}
