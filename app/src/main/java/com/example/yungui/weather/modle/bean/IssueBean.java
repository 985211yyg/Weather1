package com.example.yungui.weather.modle.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yungui on 2017/7/21.
 */

public class IssueBean {

    /**
     * releaseTime : 1500598800000
     * type : morning
     * date : 1500598800000
     * publishTime : 1500598800000
     * itemList : [{"type":"video","data":{"dataType":"VideoBeanForClient","id":37250,"title":"鐗规潯涓ㄣ�岀帇鐗岀壒宸� 2锛氶粍閲戝湀銆嶆渶鏂伴鍛�","slogan":"鍙堣兘鑸旂鏋楀彅浜嗗ソ寮�蹇冿紒","description":"銆孠ingsman: The Golden Circle銆嶉鍛婂張鏇濇柊闀滃ご锛佸奖甯濈鏋椔疯垂鏂洖褰掞紒浣滀负鑻辩編鍚堟媿鐨勫姩浣滈棿璋嶅枩鍓э紝杩欓儴婕敼闄や簡 2015 骞淬�岀帇鐗岀壒宸ャ�嶇殑涓绘紨浠锛岃繕鍔犲叆浜嗙編鍥界墰浠旀煡瀹伮峰鍥惧~瀵兼紨渚濇棫鏄┈淇锋矁鎭┿�傜編鍥戒粖骞� 9 鏈� 22 鏃ヤ笂鏄犮��","provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"棰勫憡","author":{"id":366,"icon":"http://img.kaiyanapp.com/c895728c49daadc8e5ef1570a005ab5e.jpeg?imageMogr2/quality/60","name":"浜屽崄涓栫邯绂忓厠鏂數褰卞叕鍙�","description":"浜屽崄涓栫邯绂忓厠鏂數褰卞叕鍙革紙20th Century Fox Film Corporation锛夋槸缇庡浗鏈�涓昏鐨勭數褰便�佺數瑙嗚妭鐩彂琛屽拰鍒朵綔鍏徃涔嬩竴锛屾�婚儴鍧愯惤鍦ㄧ編鍥藉姞宸炴礇鏉夌煻姣斾經鍒╁北搴勮タ渚х殑涓栫邯鍩庛��","link":"","latestReleaseTime":1500609426000,"videoNum":128,"adTrack":null,"follow":{"itemType":"author","itemId":366,"followed":false},"shield":{"itemType":"author","itemId":366,"shielded":false},"approvedNotReadyVideoCount":0},"cover":{"feed":"http://img.kaiyanapp.com/d5aaea0a0152e82cea2b70e254b0041d.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/d5aaea0a0152e82cea2b70e254b0041d.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/f99d4a70ebd7e88bd61ec6e5f050c390.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/d5aaea0a0152e82cea2b70e254b0041d.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=default&source=qcloud","thumbPlayUrl":null,"duration":116,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=37250","forWeibo":"http://www.eyepetizer.net/detail.html?vid=37250"},"releaseTime":1500609426000,"library":"DAILY","playInfo":[{"height":480,"width":854,"urlList":[{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=normal&source=qcloud","size":13136377},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=normal&source=ucloud","size":13136377}],"name":"鏍囨竻","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=normal&source=qcloud"},{"height":720,"width":1280,"urlList":[{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=high&source=qcloud","size":21210782},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=high&source=ucloud","size":21210782}],"name":"楂樻竻","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=high&source=qcloud"}],"consumption":{"collectionCount":112,"shareCount":147,"replyCount":11},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":22,"name":"棰勫憡","actionUrl":"eyepetizer://tag/22/?title=%E9%A2%84%E5%91%8A","adTrack":null},{"id":154,"name":"鍠滃墽","actionUrl":"eyepetizer://tag/154/?title=%E5%96%9C%E5%89%A7","adTrack":null},{"id":130,"name":"鎮枒","actionUrl":"eyepetizer://tag/130/?title=%E6%82%AC%E7%96%91","adTrack":null},{"id":184,"name":"鍔ㄤ綔","actionUrl":"eyepetizer://tag/184/?title=%E5%8A%A8%E4%BD%9C","adTrack":null},{"id":200,"name":"閰风偒","actionUrl":"eyepetizer://tag/200/?title=%E9%85%B7%E7%82%AB","adTrack":null}],"type":"NORMAL","titlePgc":null,"descriptionPgc":null,"remark":null,"idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1500598800000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"銆孠ingsman: The Golden Circle銆嶉鍛婂張鏇濇柊闀滃ご锛佸奖甯濈鏋椔疯垂鏂洖褰掞紒浣滀负鑻辩編鍚堟媿鐨勫姩浣滈棿璋嶅枩鍓э紝杩欓儴婕敼闄や簡 2015 骞淬�岀帇鐗岀壒宸ャ�嶇殑涓绘紨浠锛岃繕鍔犲叆浜嗙編鍥界墰浠旀煡瀹伮峰鍥惧~瀵兼紨渚濇棫鏄┈淇锋矁鎭┿�傜編鍥戒粖骞� 9 鏈� 22 鏃ヤ笂鏄犮��","collected":false,"played":false,"subtitles":[],"lastViewTime":null},"tag":null}]
     */

    private long releaseTime;
    private String type;
    private long date;
    private long publishTime;
    private List<ItemListBean> itemList;

    public static IssueBean objectFromData(String str) {

        return new Gson().fromJson(str, IssueBean.class);
    }

    public static IssueBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), IssueBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<IssueBean> arrayIssueBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<IssueBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<IssueBean> arrayIssueBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<IssueBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public long getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(long releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    /**
     * 发布单个视频
     */
    public static class ItemListBean {
        /**
         * type : video
         * data : {"dataType":"VideoBeanForClient",
         *        "id":37250,
         *        "title":"",
         *        "provider":{
         *                 "name":"YouTube",
         *                 "alias":"youtube",
         *                 "icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"
         *                 },
         *         "category":"棰勫憡",
         *         "author":{
         *                  "id":366,
         *                  "icon":"http://img.kaiyanapp.com/c895728c49daadc8e5ef1570a005ab5e.jpeg?imageMogr2/quality/60",
         *                  "name":"浜屽崄涓栫邯绂忓厠鏂數褰卞叕鍙�",
         *                  "description":"","link":"",
         *                  "latestReleaseTime":1500609426000,
         *                  "videoNum":128,"adTrack":null,
         *                  "follow":{"itemType":"author",
         *                            "itemId":366,
         *                            "followed":false
         *                            },
         *                  "shield":{"itemType":"author",
         *                            "itemId":366,
         *                            "shielded":false
         *                            },
         *                   "approvedNotReadyVideoCount":0
         *                   },
         *          "cover":{"feed":"http://img.kaiyanapp.com/d5aaea0a0152e82cea2b70e254b0041d.jpeg?imageMogr2/quality/60/format/jpg",
         *                  "detail":"http://img.kaiyanapp.com/d5aaea0a0152e82cea2b70e254b0041d.jpeg?imageMogr2/quality/60/format/jpg",
         *                  "blurred":"http://img.kaiyanapp.com/f99d4a70ebd7e88bd61ec6e5f050c390.jpeg?imageMogr2/quality/60/format/jpg",
         *                  "sharing":null,"homepage":"http://img.kaiyanapp.com/d5aaea0a0152e82cea2b70e254b0041d.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"},
         *                  "playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=default&source=qcloud",
         *                  "thumbPlayUrl":null,"duration":116,
         *                  "webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=37250",
         *                  "forWeibo":"http://www.eyepetizer.net/detail.html?vid=37250"
         *                  },
         *           "releaseTime":1500609426000,
         *           "library":"DAILY",
         *           "playInfo":[
         *                    {"height":480,
         *                     "width":854,
         *                     "urlList":[
         *                               {"name":"qcloud",
         *                               "url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=normal&source=qcloud",
         *                               "size":13136377
         *                               },
         *                               {"name":"ucloud",
         *                               "url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=normal&source=ucloud",
         *                               "size":13136377
         *                               }
         *                               ],
         *                      "name":"鏍囨竻",
         *                      "type":"normal",
         *                      "url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=normal&source=qcloud"
         *                      },
         *                     ],
         *         "consumption":{
         *                       "collectionCount":112,
         *                       "shareCount":147,
         *                       "replyCount":11
         *                       },
         *         "campaign":null,
         *         "waterMarks":null,
         *         "adTrack":null,
         *         "tags":[
         *                 {"id":22,"name":"棰勫憡","actionUrl":"eyepetizer://tag/22/?title=%E9%A2%84%E5%91%8A","adTrack":null},
         *                ],
         *         "type":"NORMAL",
         *         "titlePgc":null,
         *         "descriptionPgc":null,
         *         "remark":null,
         *         "idx":0,
         *         "shareAdTrack":null,
         *         "favoriteAdTrack":null,
         *         "webAdTrack":null,
         *         "date":1500598800000,
         *         "promotion":null,
         *         "label":null,
         *         "labelList":[
         *                     ],
         *         "descriptionEditor":" ",
         *         "collected":false,
         *         "played":false,
         *         "subtitles":[
         *                      ],
         *         "lastViewTime":null
         *         }
         * tag : null
         */
        private String type;
        private DataBean data;
        private String  tag;

        public static ItemListBean objectFromData(String str) {

            return new Gson().fromJson(str, ItemListBean.class);
        }

        public static ItemListBean objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ItemListBean.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public static List<ItemListBean> arrayItemListBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<ItemListBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public static List<ItemListBean> arrayItemListBeanFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);
                Type listType = new TypeToken<ArrayList<ItemListBean>>() {
                }.getType();

                return new Gson().fromJson(jsonObject.getString(str), listType);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ArrayList();


        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public static class DataBean {
            /**
             * dataType : VideoBeanForClient
             * id : 37250
             * title : 鐗规潯涓ㄣ�岀帇鐗岀壒宸� 2锛氶粍閲戝湀銆嶆渶鏂伴鍛�
             * slogan : 鍙堣兘鑸旂鏋楀彅浜嗗ソ寮�蹇冿紒
             * description : 銆孠ingsman: The Golden Circle銆嶉鍛婂張鏇濇柊闀滃ご锛佸奖甯濈鏋椔疯垂鏂洖褰掞紒浣滀负鑻辩編鍚堟媿鐨勫姩浣滈棿璋嶅枩鍓э紝杩欓儴婕敼闄や簡 2015 骞淬�岀帇鐗岀壒宸ャ�嶇殑涓绘紨浠锛岃繕鍔犲叆浜嗙編鍥界墰浠旀煡瀹伮峰鍥惧~瀵兼紨渚濇棫鏄┈淇锋矁鎭┿�傜編鍥戒粖骞� 9 鏈� 22 鏃ヤ笂鏄犮��
             * provider : {"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"}
             * category : 棰勫憡
             * author : {"id":366,"icon":"http://img.kaiyanapp.com/c895728c49daadc8e5ef1570a005ab5e.jpeg?imageMogr2/quality/60","name":"浜屽崄涓栫邯绂忓厠鏂數褰卞叕鍙�","description":"浜屽崄涓栫邯绂忓厠鏂數褰卞叕鍙革紙20th Century Fox Film Corporation锛夋槸缇庡浗鏈�涓昏鐨勭數褰便�佺數瑙嗚妭鐩彂琛屽拰鍒朵綔鍏徃涔嬩竴锛屾�婚儴鍧愯惤鍦ㄧ編鍥藉姞宸炴礇鏉夌煻姣斾經鍒╁北搴勮タ渚х殑涓栫邯鍩庛��","link":"","latestReleaseTime":1500609426000,"videoNum":128,"adTrack":null,"follow":{"itemType":"author","itemId":366,"followed":false},"shield":{"itemType":"author","itemId":366,"shielded":false},"approvedNotReadyVideoCount":0}
             * cover : {"feed":"http://img.kaiyanapp.com/d5aaea0a0152e82cea2b70e254b0041d.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/d5aaea0a0152e82cea2b70e254b0041d.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/f99d4a70ebd7e88bd61ec6e5f050c390.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":"http://img.kaiyanapp.com/d5aaea0a0152e82cea2b70e254b0041d.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"}
             * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=default&source=qcloud
             * thumbPlayUrl : null
             * duration : 116
             * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=37250","forWeibo":"http://www.eyepetizer.net/detail.html?vid=37250"}
             * releaseTime : 1500609426000
             * library : DAILY
             * playInfo : [{"height":480,"width":854,"urlList":[{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=normal&source=qcloud","size":13136377},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=normal&source=ucloud","size":13136377}],"name":"鏍囨竻","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=normal&source=qcloud"},{"height":720,"width":1280,"urlList":[{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=high&source=qcloud","size":21210782},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=high&source=ucloud","size":21210782}],"name":"楂樻竻","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=high&source=qcloud"}]
             * consumption : {"collectionCount":112,"shareCount":147,"replyCount":11}
             * campaign : null
             * waterMarks : null
             * adTrack : null
             * tags : [{"id":22,"name":"棰勫憡","actionUrl":"eyepetizer://tag/22/?title=%E9%A2%84%E5%91%8A","adTrack":null},{"id":154,"name":"鍠滃墽","actionUrl":"eyepetizer://tag/154/?title=%E5%96%9C%E5%89%A7","adTrack":null},{"id":130,"name":"鎮枒","actionUrl":"eyepetizer://tag/130/?title=%E6%82%AC%E7%96%91","adTrack":null},{"id":184,"name":"鍔ㄤ綔","actionUrl":"eyepetizer://tag/184/?title=%E5%8A%A8%E4%BD%9C","adTrack":null},{"id":200,"name":"閰风偒","actionUrl":"eyepetizer://tag/200/?title=%E9%85%B7%E7%82%AB","adTrack":null}]
             * type : NORMAL
             * titlePgc : null
             * descriptionPgc : null
             * remark : null
             * idx : 0
             * shareAdTrack : null
             * favoriteAdTrack : null
             * webAdTrack : null
             * date : 1500598800000
             * promotion : null
             * label : null
             * labelList : []
             * descriptionEditor : 銆孠ingsman: The Golden Circle銆嶉鍛婂張鏇濇柊闀滃ご锛佸奖甯濈鏋椔疯垂鏂洖褰掞紒浣滀负鑻辩編鍚堟媿鐨勫姩浣滈棿璋嶅枩鍓э紝杩欓儴婕敼闄や簡 2015 骞淬�岀帇鐗岀壒宸ャ�嶇殑涓绘紨浠锛岃繕鍔犲叆浜嗙編鍥界墰浠旀煡瀹伮峰鍥惧~瀵兼紨渚濇棫鏄┈淇锋矁鎭┿�傜編鍥戒粖骞� 9 鏈� 22 鏃ヤ笂鏄犮��
             * collected : false
             * played : false
             * subtitles : []
             * lastViewTime : null
             */

            private String dataType;
            private int id;
            private String title;
            private String slogan;
            private String description;
            //提供者信息
            private ProviderBean provider;
            private String category;
            //z作者信息
            private AuthorBean author;
            private CoverBean cover;
            private String playUrl;
            private String thumbPlayUrl;
            private int duration;
            private WebUrlBean webUrl;
            private long releaseTime;
            private String library;
            private ConsumptionBean consumption;
            private Object campaign;
            private Object waterMarks;
            private Object adTrack;
            private String type;
            private Object titlePgc;
            private Object descriptionPgc;
            private Object remark;
            private int idx;
            private Object shareAdTrack;
            private Object favoriteAdTrack;
            private Object webAdTrack;
            private long date;
            private Object promotion;
            private Object label;
            private String descriptionEditor;
            private boolean collected;
            private boolean played;
            private Object lastViewTime;
            private List<PlayInfoBean> playInfo;
            private List<TagsBean> tags;
            private List<?> labelList;
            private List<?> subtitles;

            public static DataBean objectFromData(String str) {

                return new Gson().fromJson(str, DataBean.class);
            }

            public static DataBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), DataBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<DataBean> arrayDataBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<DataBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<DataBean> arrayDataBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<DataBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getDataType() {
                return dataType;
            }

            public void setDataType(String dataType) {
                this.dataType = dataType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSlogan() {
                return slogan;
            }

            public void setSlogan(String slogan) {
                this.slogan = slogan;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public ProviderBean getProvider() {
                return provider;
            }

            public void setProvider(ProviderBean provider) {
                this.provider = provider;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public CoverBean getCover() {
                return cover;
            }

            public void setCover(CoverBean cover) {
                this.cover = cover;
            }

            public String getPlayUrl() {
                return playUrl;
            }

            public void setPlayUrl(String playUrl) {
                this.playUrl = playUrl;
            }

            public String getThumbPlayUrl() {
                return thumbPlayUrl;
            }

            public void setThumbPlayUrl(String thumbPlayUrl) {
                this.thumbPlayUrl = thumbPlayUrl;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public WebUrlBean getWebUrl() {
                return webUrl;
            }

            public void setWebUrl(WebUrlBean webUrl) {
                this.webUrl = webUrl;
            }

            public long getReleaseTime() {
                return releaseTime;
            }

            public void setReleaseTime(long releaseTime) {
                this.releaseTime = releaseTime;
            }

            public String getLibrary() {
                return library;
            }

            public void setLibrary(String library) {
                this.library = library;
            }

            public ConsumptionBean getConsumption() {
                return consumption;
            }

            public void setConsumption(ConsumptionBean consumption) {
                this.consumption = consumption;
            }

            public Object getCampaign() {
                return campaign;
            }

            public void setCampaign(Object campaign) {
                this.campaign = campaign;
            }

            public Object getWaterMarks() {
                return waterMarks;
            }

            public void setWaterMarks(Object waterMarks) {
                this.waterMarks = waterMarks;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Object getTitlePgc() {
                return titlePgc;
            }

            public void setTitlePgc(Object titlePgc) {
                this.titlePgc = titlePgc;
            }

            public Object getDescriptionPgc() {
                return descriptionPgc;
            }

            public void setDescriptionPgc(Object descriptionPgc) {
                this.descriptionPgc = descriptionPgc;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public int getIdx() {
                return idx;
            }

            public void setIdx(int idx) {
                this.idx = idx;
            }

            public Object getShareAdTrack() {
                return shareAdTrack;
            }

            public void setShareAdTrack(Object shareAdTrack) {
                this.shareAdTrack = shareAdTrack;
            }

            public Object getFavoriteAdTrack() {
                return favoriteAdTrack;
            }

            public void setFavoriteAdTrack(Object favoriteAdTrack) {
                this.favoriteAdTrack = favoriteAdTrack;
            }

            public Object getWebAdTrack() {
                return webAdTrack;
            }

            public void setWebAdTrack(Object webAdTrack) {
                this.webAdTrack = webAdTrack;
            }

            public long getDate() {
                return date;
            }

            public void setDate(long date) {
                this.date = date;
            }

            public Object getPromotion() {
                return promotion;
            }

            public void setPromotion(Object promotion) {
                this.promotion = promotion;
            }

            public Object getLabel() {
                return label;
            }

            public void setLabel(Object label) {
                this.label = label;
            }

            public String getDescriptionEditor() {
                return descriptionEditor;
            }

            public void setDescriptionEditor(String descriptionEditor) {
                this.descriptionEditor = descriptionEditor;
            }

            public boolean isCollected() {
                return collected;
            }

            public void setCollected(boolean collected) {
                this.collected = collected;
            }

            public boolean isPlayed() {
                return played;
            }

            public void setPlayed(boolean played) {
                this.played = played;
            }

            public Object getLastViewTime() {
                return lastViewTime;
            }

            public void setLastViewTime(Object lastViewTime) {
                this.lastViewTime = lastViewTime;
            }

            public List<PlayInfoBean> getPlayInfo() {
                return playInfo;
            }

            public void setPlayInfo(List<PlayInfoBean> playInfo) {
                this.playInfo = playInfo;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public List<?> getLabelList() {
                return labelList;
            }

            public void setLabelList(List<?> labelList) {
                this.labelList = labelList;
            }

            public List<?> getSubtitles() {
                return subtitles;
            }

            public void setSubtitles(List<?> subtitles) {
                this.subtitles = subtitles;
            }

            public static class ProviderBean {
                /**
                 * name : YouTube
                 * alias : youtube
                 * icon : http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png
                 */

                private String name;
                private String alias;
                private String icon;

                public static ProviderBean objectFromData(String str) {

                    return new Gson().fromJson(str, ProviderBean.class);
                }

                public static ProviderBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), ProviderBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<ProviderBean> arrayProviderBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<ProviderBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<ProviderBean> arrayProviderBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<ProviderBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAlias() {
                    return alias;
                }

                public void setAlias(String alias) {
                    this.alias = alias;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }
            }

            public static class AuthorBean {
                /**
                 * id : 366
                 * icon : http://img.kaiyanapp.com/c895728c49daadc8e5ef1570a005ab5e.jpeg?imageMogr2/quality/60
                 * name : 浜屽崄涓栫邯绂忓厠鏂數褰卞叕鍙�
                 * description : 浜屽崄涓栫邯绂忓厠鏂數褰卞叕鍙革紙20th Century Fox Film Corporation锛夋槸缇庡浗鏈�涓昏鐨勭數褰便�佺數瑙嗚妭鐩彂琛屽拰鍒朵綔鍏徃涔嬩竴锛屾�婚儴鍧愯惤鍦ㄧ編鍥藉姞宸炴礇鏉夌煻姣斾經鍒╁北搴勮タ渚х殑涓栫邯鍩庛��
                 * link :
                 * latestReleaseTime : 1500609426000
                 * videoNum : 128
                 * adTrack : null
                 * follow : {"itemType":"author","itemId":366,"followed":false}
                 * shield : {"itemType":"author","itemId":366,"shielded":false}
                 * approvedNotReadyVideoCount : 0
                 */

                private int id;
                private String icon;
                private String name;
                private String description;
                private String link;
                private long latestReleaseTime;
                private int videoNum;
                private Object adTrack;
                private FollowBean follow;
                private ShieldBean shield;
                private int approvedNotReadyVideoCount;

                public static AuthorBean objectFromData(String str) {

                    return new Gson().fromJson(str, AuthorBean.class);
                }

                public static AuthorBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), AuthorBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<AuthorBean> arrayAuthorBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<AuthorBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<AuthorBean> arrayAuthorBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<AuthorBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public long getLatestReleaseTime() {
                    return latestReleaseTime;
                }

                public void setLatestReleaseTime(long latestReleaseTime) {
                    this.latestReleaseTime = latestReleaseTime;
                }

                public int getVideoNum() {
                    return videoNum;
                }

                public void setVideoNum(int videoNum) {
                    this.videoNum = videoNum;
                }

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }

                public FollowBean getFollow() {
                    return follow;
                }

                public void setFollow(FollowBean follow) {
                    this.follow = follow;
                }

                public ShieldBean getShield() {
                    return shield;
                }

                public void setShield(ShieldBean shield) {
                    this.shield = shield;
                }

                public int getApprovedNotReadyVideoCount() {
                    return approvedNotReadyVideoCount;
                }

                public void setApprovedNotReadyVideoCount(int approvedNotReadyVideoCount) {
                    this.approvedNotReadyVideoCount = approvedNotReadyVideoCount;
                }

                public static class FollowBean {
                    /**
                     * itemType : author
                     * itemId : 366
                     * followed : false
                     */

                    private String itemType;
                    private int itemId;
                    private boolean followed;

                    public static FollowBean objectFromData(String str) {

                        return new Gson().fromJson(str, FollowBean.class);
                    }

                    public static FollowBean objectFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);

                            return new Gson().fromJson(jsonObject.getString(str), FollowBean.class);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    public static List<FollowBean> arrayFollowBeanFromData(String str) {

                        Type listType = new TypeToken<ArrayList<FollowBean>>() {
                        }.getType();

                        return new Gson().fromJson(str, listType);
                    }

                    public static List<FollowBean> arrayFollowBeanFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);
                            Type listType = new TypeToken<ArrayList<FollowBean>>() {
                            }.getType();

                            return new Gson().fromJson(jsonObject.getString(str), listType);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return new ArrayList();


                    }

                    public String getItemType() {
                        return itemType;
                    }

                    public void setItemType(String itemType) {
                        this.itemType = itemType;
                    }

                    public int getItemId() {
                        return itemId;
                    }

                    public void setItemId(int itemId) {
                        this.itemId = itemId;
                    }

                    public boolean isFollowed() {
                        return followed;
                    }

                    public void setFollowed(boolean followed) {
                        this.followed = followed;
                    }
                }

                public static class ShieldBean {
                    /**
                     * itemType : author
                     * itemId : 366
                     * shielded : false
                     */

                    private String itemType;
                    private int itemId;
                    private boolean shielded;

                    public static ShieldBean objectFromData(String str) {

                        return new Gson().fromJson(str, ShieldBean.class);
                    }

                    public static ShieldBean objectFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);

                            return new Gson().fromJson(jsonObject.getString(str), ShieldBean.class);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    public static List<ShieldBean> arrayShieldBeanFromData(String str) {

                        Type listType = new TypeToken<ArrayList<ShieldBean>>() {
                        }.getType();

                        return new Gson().fromJson(str, listType);
                    }

                    public static List<ShieldBean> arrayShieldBeanFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);
                            Type listType = new TypeToken<ArrayList<ShieldBean>>() {
                            }.getType();

                            return new Gson().fromJson(jsonObject.getString(str), listType);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return new ArrayList();


                    }

                    public String getItemType() {
                        return itemType;
                    }

                    public void setItemType(String itemType) {
                        this.itemType = itemType;
                    }

                    public int getItemId() {
                        return itemId;
                    }

                    public void setItemId(int itemId) {
                        this.itemId = itemId;
                    }

                    public boolean isShielded() {
                        return shielded;
                    }

                    public void setShielded(boolean shielded) {
                        this.shielded = shielded;
                    }
                }
            }

            public static class CoverBean {
                /**
                 * feed : http://img.kaiyanapp.com/d5aaea0a0152e82cea2b70e254b0041d.jpeg?imageMogr2/quality/60/format/jpg
                 * detail : http://img.kaiyanapp.com/d5aaea0a0152e82cea2b70e254b0041d.jpeg?imageMogr2/quality/60/format/jpg
                 * blurred : http://img.kaiyanapp.com/f99d4a70ebd7e88bd61ec6e5f050c390.jpeg?imageMogr2/quality/60/format/jpg
                 * sharing : null
                 * homepage : http://img.kaiyanapp.com/d5aaea0a0152e82cea2b70e254b0041d.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
                 */

                private String feed;
                private String detail;
                private String blurred;
                private Object sharing;
                private String homepage;

                public static CoverBean objectFromData(String str) {

                    return new Gson().fromJson(str, CoverBean.class);
                }

                public static CoverBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), CoverBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<CoverBean> arrayCoverBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<CoverBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<CoverBean> arrayCoverBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<CoverBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getFeed() {
                    return feed;
                }

                public void setFeed(String feed) {
                    this.feed = feed;
                }

                public String getDetail() {
                    return detail;
                }

                public void setDetail(String detail) {
                    this.detail = detail;
                }

                public String getBlurred() {
                    return blurred;
                }

                public void setBlurred(String blurred) {
                    this.blurred = blurred;
                }

                public Object getSharing() {
                    return sharing;
                }

                public void setSharing(Object sharing) {
                    this.sharing = sharing;
                }

                public String getHomepage() {
                    return homepage;
                }

                public void setHomepage(String homepage) {
                    this.homepage = homepage;
                }
            }

            public static class WebUrlBean {
                /**
                 * raw : http://www.eyepetizer.net/detail.html?vid=37250
                 * forWeibo : http://www.eyepetizer.net/detail.html?vid=37250
                 */

                private String raw;
                private String forWeibo;

                public static WebUrlBean objectFromData(String str) {

                    return new Gson().fromJson(str, WebUrlBean.class);
                }

                public static WebUrlBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), WebUrlBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<WebUrlBean> arrayWebUrlBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<WebUrlBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<WebUrlBean> arrayWebUrlBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<WebUrlBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public String getRaw() {
                    return raw;
                }

                public void setRaw(String raw) {
                    this.raw = raw;
                }

                public String getForWeibo() {
                    return forWeibo;
                }

                public void setForWeibo(String forWeibo) {
                    this.forWeibo = forWeibo;
                }
            }

            public static class ConsumptionBean {
                /**
                 * collectionCount : 112
                 * shareCount : 147
                 * replyCount : 11
                 */

                private int collectionCount;
                private int shareCount;
                private int replyCount;

                public static ConsumptionBean objectFromData(String str) {

                    return new Gson().fromJson(str, ConsumptionBean.class);
                }

                public static ConsumptionBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), ConsumptionBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<ConsumptionBean> arrayConsumptionBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<ConsumptionBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<ConsumptionBean> arrayConsumptionBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<ConsumptionBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public int getCollectionCount() {
                    return collectionCount;
                }

                public void setCollectionCount(int collectionCount) {
                    this.collectionCount = collectionCount;
                }

                public int getShareCount() {
                    return shareCount;
                }

                public void setShareCount(int shareCount) {
                    this.shareCount = shareCount;
                }

                public int getReplyCount() {
                    return replyCount;
                }

                public void setReplyCount(int replyCount) {
                    this.replyCount = replyCount;
                }
            }

            public static class PlayInfoBean {
                /**
                 * height : 480
                 * width : 854
                 * urlList : [{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=normal&source=qcloud","size":13136377},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=normal&source=ucloud","size":13136377}]
                 * name : 鏍囨竻
                 * type : normal
                 * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=normal&source=qcloud
                 */

                private int height;
                private int width;
                private String name;
                private String type;
                private String url;
                private List<UrlListBean> urlList;

                public static PlayInfoBean objectFromData(String str) {

                    return new Gson().fromJson(str, PlayInfoBean.class);
                }

                public static PlayInfoBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), PlayInfoBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<PlayInfoBean> arrayPlayInfoBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<PlayInfoBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<PlayInfoBean> arrayPlayInfoBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<PlayInfoBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public List<UrlListBean> getUrlList() {
                    return urlList;
                }

                public void setUrlList(List<UrlListBean> urlList) {
                    this.urlList = urlList;
                }

                public static class UrlListBean {
                    /**
                     * name : qcloud
                     * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37250&editionType=normal&source=qcloud
                     * size : 13136377
                     */

                    private String name;
                    private String url;
                    private int size;

                    public static UrlListBean objectFromData(String str) {

                        return new Gson().fromJson(str, UrlListBean.class);
                    }

                    public static UrlListBean objectFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);

                            return new Gson().fromJson(jsonObject.getString(str), UrlListBean.class);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return null;
                    }

                    public static List<UrlListBean> arrayUrlListBeanFromData(String str) {

                        Type listType = new TypeToken<ArrayList<UrlListBean>>() {
                        }.getType();

                        return new Gson().fromJson(str, listType);
                    }

                    public static List<UrlListBean> arrayUrlListBeanFromData(String str, String key) {

                        try {
                            JSONObject jsonObject = new JSONObject(str);
                            Type listType = new TypeToken<ArrayList<UrlListBean>>() {
                            }.getType();

                            return new Gson().fromJson(jsonObject.getString(str), listType);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        return new ArrayList();


                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public int getSize() {
                        return size;
                    }

                    public void setSize(int size) {
                        this.size = size;
                    }
                }
            }

            public static class TagsBean {
                /**
                 * id : 22
                 * name : 棰勫憡
                 * actionUrl : eyepetizer://tag/22/?title=%E9%A2%84%E5%91%8A
                 * adTrack : null
                 */

                private int id;
                private String name;
                private String actionUrl;
                private Object adTrack;

                public static TagsBean objectFromData(String str) {

                    return new Gson().fromJson(str, TagsBean.class);
                }

                public static TagsBean objectFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);

                        return new Gson().fromJson(jsonObject.getString(str), TagsBean.class);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return null;
                }

                public static List<TagsBean> arrayTagsBeanFromData(String str) {

                    Type listType = new TypeToken<ArrayList<TagsBean>>() {
                    }.getType();

                    return new Gson().fromJson(str, listType);
                }

                public static List<TagsBean> arrayTagsBeanFromData(String str, String key) {

                    try {
                        JSONObject jsonObject = new JSONObject(str);
                        Type listType = new TypeToken<ArrayList<TagsBean>>() {
                        }.getType();

                        return new Gson().fromJson(jsonObject.getString(str), listType);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return new ArrayList();


                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getActionUrl() {
                    return actionUrl;
                }

                public void setActionUrl(String actionUrl) {
                    this.actionUrl = actionUrl;
                }

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }
            }
        }
    }
}
