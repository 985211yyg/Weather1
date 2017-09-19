package com.example.yungui.weather.ui.welfare;

import android.util.Log;

import com.example.yungui.weather.modle.Girls;
import com.example.yungui.weather.service.GirlServer;
import com.example.yungui.weather.ui.base.BaseGirlsListFragment;
import com.example.yungui.weather.utils.ConstUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yungui on 2017/7/6.
 */

public class GirlsFragment extends BaseGirlsListFragment {
    @Override
    protected void getGirlsFormServer() {
        showRefreshing(true);
        String url = getArguments().getString("url") + "/page/" + currentPage;
        subscription = Observable
                //转换一个或者多个object为多个observable对象
                .just(url)
                //转换将string转换为List<Girls>
                .map(new Func1<String, List<Girls>>() {
                    @Override
                    public List<Girls> call(String url) {
                        List<Girls> girlsList = new ArrayList<>();
                        try {
                            Document document = Jsoup.connect(url).timeout(1500).get();
                            Elements total = document.select("div.postlist");
                            Elements items = total.select("li");
                            for (Element li : items) {
                                //获取封面连接
                                // <a href="http://www.mzitu.com/98346"
                                // target="_blank"><img width="236" height="354"
                                // class="lazy" alt="火辣到喷鼻血 性感美女林熙解放翘臀,婀娜姿态勾勒出迷人S曲线"
                                // src="http://i.meizitu.net/thumbs/2017/07/98346_21b43_236.jpg"
                                // data-original="http://i.meizitu.net/thumbs/2017/07/98346_21b43_236.jpg"
                                // style="display: inline;">
                                // </a>
                                Girls girls = new Girls(li.select("img.lazy").first().attr("data-original"));
                                //获取图集
                                girls.setLink(li.select("a[href]").first().attr("href"));
                                Log.e(TAG, "解析到的数据："+ li.select("a[href]").attr("href"));
                                Log.e(TAG, "解析到的数据model:"+girls.toString() );
                                girlsList.add(girls);

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return girlsList;
                    }
                })
                //在输入输出流中订阅
                .subscribeOn(Schedulers.io())
                //在主线程中观察
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Girls>>() {
                    @Override
                    public void onCompleted() {
                        isLoading = false;

                    }

                    @Override
                    public void onError(Throwable e) {
                        isLoading = false;
                        showRefreshing(false);
                    }

                    @Override
                    public void onNext(List<Girls> girls) {
                        currentPage++;
                        showRefreshing(false);
                        Log.e(TAG, "解析到的数据model集合数量: "+girls.size() );
                        //首次添加数据
                        if (girlsAdapter.getData() == null && girlsAdapter.getData().size() == 0) {
                            girlsAdapter.setNewData(girls);
                        } else {
                            //逐渐增加数
                            girlsAdapter.addData(girlsAdapter.getData().size(),girls);
                        }
                        girlsAdapter.notifyDataSetChanged();
//                        GirlServer.start(getActivity(), GirlsFragment.this.getClass().getName(), girls);
                    }
                });

    }


}
