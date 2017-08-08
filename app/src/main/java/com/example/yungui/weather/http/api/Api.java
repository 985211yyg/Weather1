package com.example.yungui.weather.http.api;

/**
 * Created by yungui on 2017/7/19.
 */

public class Api {
    //每日推荐
    public static final String DAILY = "http://baobab.wandoujia.com/api/v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83";
    //发现更多
    public static final String FIND_MORE = "http://baobab.wandoujia.com/api/v2/categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83";
    //发现更多详情接口
    public static final String FIND_DETAIL = "http://baobab.wandoujia.com/api/v3/videos?categoryName=%s&strategy=%s&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83";
    //火热频道
    public static final String HOT_STRATEGY = "http://baobab.wandoujia.com/api/v3/ranklist?num=10&strategy=%s&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83";
    //搜索
    public static final String SEARCH_RELATED = "http://baobab.kaiyanapp.com/api/v1/search?num=10&query=%E4%BD%A0&start=10";
    //发现更多下一页
    public static final String nextPageUrl = "http://baobab.kaiyanapp.com/api/v3/videos?start=10&num=10&categoryName=%E5%B9%BF%E5%91%8A&strategy=date";


    //妹子图微星公众号
    public static final String WX_MM = "http://mp.weixin.qq.com/mp/homepage?__biz=MzA3MjQyNjkwMw==&hid=1&sn=fea772ab11ce84eaa2f0409ba0a9e73b#wechat_redirect";
}
