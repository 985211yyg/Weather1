package com.example.yungui.weather.http.api;

/**
 * Created by yungui on 2017/7/19.
 */

public class Api {
    //天气key
    public static final String WEATHER_KEY = "36af2fa44706456c998958d1f11a64bf";
    //定位key
    public static final String LOCATION_KEY = "db8e3e6ee731d6338bcf13f459e2d0fe";
    //天气
    public static final String WEATHER = "https://free-api.heweather.com/v5/weather?city=yourcity&key=36af2fa44706456c998958d1f11a64bf";

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

    //======================one一个=====================================
    //所有的数据拼接id
    public static final String ID_LIST = "http://v3.wufazhuce.com:8000/api/onelist/idlist/?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";
    //oneList之后拼接id
    public static final String ONELIST = "http://v3.wufazhuce.com:8000/api/onelist/3528/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";


    //===============================================
    /**
     * ONELIST 中 content_list 是一个链表，size 是5，这五个信息不属于同一个类别
     * <p>
     * 图片：没啥需要扩展的
     * <p>
     * 一周语文：我们需要使用该 json 字段中的 item_id 获取该一周语文的详细信息
     * <p>
     * Essay：我们需要使用该 json 字段中的 item_id 获取该 Essay 的详细信息
     * <p>
     * 音乐：我们需要使用该 json 字段中的 item_id 获取该音乐的详细信息
     * <p>
     * 影视：我们需要使用该 json 字段中的 item_id 获取该影视的详细信息
     */
    //图片
    public static final String PICTURE = "";
    //一周语文,从oneList中获取item_id拼接
    public static final String ONE_WEEK = "http://v3.wufazhuce.com:8000/api/essay/ + item_id +?channel=wdj&source=summary&source_id=9261&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";
    //Essay 详细信息  从oneList中获取item_id拼接
    public static final String Essay =    "http://v3.wufazhuce.com:8000/api/essay/ + item_id + ?channel=wdj&source=summary&source_id=9245&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";
    //影视详情   从oneList中获取item_id拼接  通下面影视详情
    public static final String MOVIE_1 = "同movie";

    public static final String MUSIC_1 = "同music";


    //=========================================

    //获取最新 musiclist
    //http://v3.wufazhuce.com:8000/api/channel/music/more/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    public static final String MUSICLIST = "http://v3.wufazhuce.com:8000/api/channel/music/more/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";
    //音乐详情
    public static final String MUSIC = "http://v3.wufazhuce.com:8000/api/music/detail/ + item_id + ?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";




    //======================================================
    //获取最movielist
    public static final String MOVIELIST = "http://v3.wufazhuce.com:8000/api/channel/movie/more/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";
    //影视详细信息 http://v3.wufazhuce.com:8000/api/movie/detail/ + item_id + ?channel=wdj&source=channel_movie&source_id=9240&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    // 根据获取最movielis中的item_id
    public static final String Movie = "http://v3.wufazhuce.com:8000/api/movie/detail/item_id?channel=wdj&source=channel_movie&source_id=9240&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";
    //更多影视
    // 根据获取最movielis中的id来替换
    public static final String MORE_MOVIE = "http://v3.wufazhuce.com:8000/api/channel/movie/more/ + id + ?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";



    //==============================
    //获取最新 readinglist   1-9 阅读  10 问答
    //url：http://v3.wufazhuce.com:8000/api/channel/reading/more/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
    public static final String READING_LIST = "http://v3.wufazhuce.com:8000/api/channel/reading/more/0?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";

    //单个article或者问答
    /**
     * 阅读详细信息
     * 内容信息 url：http://v3.wufazhuce.com:8000/api/essay/ + item_id + ?channel=wdj&source=channel_reading&source_id=9264&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
     *
     * 需要获取阅读列表中的item——id替换连接中的对应位置
     */
    public static final String ARTICLE = "http://v3.wufazhuce.com:8000/api/essay/ + item_id + ?channel=wdj&source=channel_reading&source_id=9264&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";
    public static final String QA = "http://v3.wufazhuce.com:8000/api/question/ + item_id + ?channel=wdj&source=channel_reading&source_id=9254&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";

    /**
     * 获取特定日期的 one 信息
     * <p>
     * 首页：http://v3.wufazhuce.com:8000/api/hp/bymonth/ + yyyy-MM-dd + %2000:00:00?
     * channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android
     */
    public static final String One_Day = "http://v3.wufazhuce.com:8000/api/hp/bymonth/ + yyyy-MM-dd + %2000:00:00?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android";
}
