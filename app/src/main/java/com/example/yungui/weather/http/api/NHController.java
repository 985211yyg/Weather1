package com.example.yungui.weather.http.api;

import com.example.yungui.weather.modle.nh.NH_DataBean;
import com.example.yungui.weather.modle.nh.NH_IDList;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by yungui on 2017/8/12.
 */

public interface NHController {
    //获取首页获取id列表
    @GET(Api.ID_LIST)
    Observable<NH_IDList> getIDList();

    /**http://v3.wufazhuce.com:8000/api/essay/ + item_id +?channel=wdj&source=summary
     * &source_id=9261&version=4.0.2
     * &uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
     *
     获取首页的列表item
     */
    @GET("http://v3.wufazhuce.com:8000/api/onelist/{item_id}/0?channel=wdj&version=4.0.2" +
            "&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    Observable<NH_DataBean> getIDListItem(@Path("item_id") String item_id);

}
