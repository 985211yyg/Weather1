package com.example.yungui.weather.http.api;

import com.example.yungui.weather.http.response.BaseDailyResponse;
import com.example.yungui.weather.http.response.VideoResponse;
import com.example.yungui.weather.modle.bean.FindMoreBean;
import com.example.yungui.weather.modle.bean.FindVideoBean;
import com.example.yungui.weather.modle.bean.VideoBean;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yungui on 2017/7/19.
 */

public interface VideoController {
    //获取首页数据
    @GET("http://baobab.wandoujia.com/api/v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    Observable<BaseDailyResponse> getDailyData();

    //获取首页第一页之后的数据 http://baobab.wandoujia.com/api/v2/feed?date=1499043600000&num=2
    @GET("http://baobab.wandoujia.com/api/v2/feed")
    Observable<BaseDailyResponse> getMoreDailyData(@Query("date") String date, @Query("num") String num);

    //发现更多频道信息
    @GET("http://baobab.wandoujia.com/api/v2/categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    Observable<List<FindMoreBean>> findMoreData();

    //发现更多详情"http://baobab.wandoujia.com/api/v3/videos?categoryName=%s&strategy=%s&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83"
    @GET("http://baobab.wandoujia.com/api/v3/videos")
    Observable<FindVideoBean> findVideoDetail(@Query("categoryName") String categoryName,
                                              @Query("strategy") String strategy,
                                              @Query("udid") String udid,
                                              @Query("vc")int vc);

    //http://baobab.kaiyanapp.com/api/v3/videos?start=20&num=20&categoryName=广告&strategy=date
    @GET("http://baobab.kaiyanapp.com/api/v3/videos")
    Observable<FindVideoBean> findMoreVideoDetail(@Query("start") int start,
                                                 @Query("num") int num,
                                                 @Query("categoryName") String categoryName,
                                                 @Query("strategy") String strategy);
    //http://baobab.kaiyanapp.com/api/v3/videos?start=20&num=20&categoryName=广告&strategy=date
    @GET("http://baobab.kaiyanapp.com/api/v3/videos")
    Observable<FindVideoBean> findMoreVideoDetail2(@Path("nextPagerUrl") String nextPagerUrl);
}
