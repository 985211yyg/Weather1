package com.example.yungui.weather.http.api;

import com.example.yungui.weather.modle.nh.NH_Article;
import com.example.yungui.weather.modle.nh.NH_DataBean;
import com.example.yungui.weather.modle.nh.NH_IDList;
import com.example.yungui.weather.modle.nh.NH_Movie;
import com.example.yungui.weather.modle.nh.NH_MovieList;
import com.example.yungui.weather.modle.nh.NH_Music;
import com.example.yungui.weather.modle.nh.NH_MusicList;
import com.example.yungui.weather.modle.nh.NH_ReadingList;

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

    @GET("http://v3.wufazhuce.com:8000/api/onelist/{item_id}/0?channel=wdj&version=4.0.2" +
            "&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    Observable<NH_DataBean> getIDListItem(@Path("item_id") String item_id);

    @GET(Api.READING_LIST)
    Observable<NH_ReadingList> getReadingList();

    @GET("http://v3.wufazhuce.com:8000/api/essay/ {item_id} ?channel=wdj&source=channel_reading" +
            "&source_id=9264&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    Observable<NH_Article> getArticle(@Path("item_id") String item_id);

    @GET(Api.MUSICLIST)
    Observable<NH_MusicList> getMusicList();

    @GET("http://v3.wufazhuce.com:8000/api/music/detail/ {item_id} ?channel=wdj&version=4.0.2" +
            "&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    Observable<NH_Music> getMusic(@Path("item_id") String item_id);

    @GET(Api.MOVIELIST)
    Observable<NH_MovieList> getMovieList();

    @GET("http://v3.wufazhuce.com:8000/api/movie/detail/ {item_id}?channel=wdj&source=channel_movie&source_id=9240&version=4.0.2" +
            "&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
    Observable<NH_Movie> getMovie(@Path("item_id") String item_id);


}
