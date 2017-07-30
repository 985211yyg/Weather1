package com.example.yungui.weather.http.api;

import com.example.yungui.weather.http.response.BaseGankResponse;
import com.example.yungui.weather.http.response.BaseJianDanResponse;
import com.example.yungui.weather.modle.Gank;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yungui on 2017/6/28.
 */

public interface GirlsController {
    @GET("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/{page}")
    Observable<BaseGankResponse<List<Gank>>> getGank(@Path("page") String page);

    @GET("http://i.jandan.net/?oxwlxojflwblxbsapi=jandan.get_ooxx_comments")
    Observable<BaseJianDanResponse> getXXOO(@Query("page") int page);

//    @GET("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/{page}")
//    Observable<BaseGankResponse<List<Gank>>> getGank(@Path("page") String page);
//
//
//    @GET("http://i.jandan.net/?oxwlxojflwblxbsapi=jandan.get_ooxx_comments")
//    Observable<BaseJianDanResponse> getXXOO(@Query("page") int page);

}
