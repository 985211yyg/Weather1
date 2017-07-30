package com.example.yungui.weather.modle.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yungui on 2017/7/23.
 */

public class VideoBean {


    /**
     * type : video
     * data : {"dataType":"VideoBeanForClient","id":37936,"title":"涓�涓コ浜烘媿浜嗚嚜鎷嶇収鍚庘��","slogan":null,"description":"涓嶈鐩镐俊缃戠粶鐨勭編濂宠嚜鎷嶏紝浣犲彲鑳戒細琚獥寰楀緢鎯紝缈昏瘧锛氳彍绮ョ播锛屽井鍗氾細娉癴ashion_鑿滅播绮ヂ�","provider":{"name":"PGC","alias":"PGC","icon":""},"category":"骞垮憡","author":{"id":764,"icon":"http://img.kaiyanapp.com/15c80ec5a88389d271798b9a0865f221.png?imageMogr2/quality/60/format/jpg","name":"娉癴ashion_鑿滅播绮�","description":"娉拌涓撲笟姣曚笟鐨勯噹鐢熻弻缈昏瘧涓�鏋� 涓撴敞娉扮炕鍙婃洿鏂版嘲鍥界儹闂ㄨ棰戉笂喔粪箞喔箘喔椸涪喙勦笧喔ム复喔權笝喔班竸喔�","link":"","latestReleaseTime":1500783751000,"videoNum":60,"adTrack":null,"follow":{"itemType":"author","itemId":764,"followed":false},"shield":{"itemType":"author","itemId":764,"shielded":false},"approvedNotReadyVideoCount":0},"cover":{"feed":"http://img.kaiyanapp.com/09b096bc2925a628b14f7c25f6c9f152.png?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/09b096bc2925a628b14f7c25f6c9f152.png?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/ff37d47984bf21fd4227395a0c4d953f.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=default&source=qcloud","thumbPlayUrl":null,"duration":19,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=37936","forWeibo":"http://wandou.im/3nvqb2"},"releaseTime":1500783751000,"library":"DEFAULT","playInfo":[{"height":480,"width":854,"urlList":[{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=normal&source=qcloud","size":1316933},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=normal&source=ucloud","size":1316933}],"name":"鏍囨竻","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=normal&source=qcloud"},{"height":720,"width":1280,"urlList":[{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=high&source=qcloud","size":2020979},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=high&source=ucloud","size":2020979}],"name":"楂樻竻","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=high&source=qcloud"}],"consumption":{"collectionCount":6,"shareCount":16,"replyCount":1},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[],"type":"NORMAL","titlePgc":"涓�涓コ浜烘媿浜嗚嚜鎷嶇収鍚庘��","descriptionPgc":"涓嶈鐩镐俊缃戠粶鐨勭編濂宠嚜鎷嶏紝浣犲彲鑳戒細琚獥寰楀緢鎯紝缈昏瘧锛氳彍绮ョ播锛屽井鍗氾細娉癴ashion_鑿滅播绮ヂ�","remark":"","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1500783751000,"promotion":null,"label":null,"labelList":[],"descriptionEditor":"","collected":false,"played":false,"subtitles":[],"lastViewTime":null}
     * tag : null
     */

    private String type;
    private DataBean data;
    private Object tag;

    public static VideoBean objectFromData(String str) {

        return new Gson().fromJson(str, VideoBean.class);
    }

    public static VideoBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), VideoBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<VideoBean> arrayVideoBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<VideoBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<VideoBean> arrayVideoBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<VideoBean>>() {
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

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public static class DataBean {
        /**
         * dataType : VideoBeanForClient
         * id : 37936
         * title : 涓�涓コ浜烘媿浜嗚嚜鎷嶇収鍚庘��
         * slogan : null
         * description : 涓嶈鐩镐俊缃戠粶鐨勭編濂宠嚜鎷嶏紝浣犲彲鑳戒細琚獥寰楀緢鎯紝缈昏瘧锛氳彍绮ョ播锛屽井鍗氾細娉癴ashion_鑿滅播绮ヂ�
         * provider : {"name":"PGC","alias":"PGC","icon":""}
         * category : 骞垮憡
         * author : {"id":764,"icon":"http://img.kaiyanapp.com/15c80ec5a88389d271798b9a0865f221.png?imageMogr2/quality/60/format/jpg","name":"娉癴ashion_鑿滅播绮�","description":"娉拌涓撲笟姣曚笟鐨勯噹鐢熻弻缈昏瘧涓�鏋� 涓撴敞娉扮炕鍙婃洿鏂版嘲鍥界儹闂ㄨ棰戉笂喔粪箞喔箘喔椸涪喙勦笧喔ム复喔權笝喔班竸喔�","link":"","latestReleaseTime":1500783751000,"videoNum":60,"adTrack":null,"follow":{"itemType":"author","itemId":764,"followed":false},"shield":{"itemType":"author","itemId":764,"shielded":false},"approvedNotReadyVideoCount":0}
         * cover : {"feed":"http://img.kaiyanapp.com/09b096bc2925a628b14f7c25f6c9f152.png?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/09b096bc2925a628b14f7c25f6c9f152.png?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/ff37d47984bf21fd4227395a0c4d953f.jpeg?imageMogr2/quality/60/format/jpg","sharing":null,"homepage":null}
         * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=default&source=qcloud
         * thumbPlayUrl : null
         * duration : 19
         * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=37936","forWeibo":"http://wandou.im/3nvqb2"}
         * releaseTime : 1500783751000
         * library : DEFAULT
         * playInfo : [{"height":480,"width":854,"urlList":[{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=normal&source=qcloud","size":1316933},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=normal&source=ucloud","size":1316933}],"name":"鏍囨竻","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=normal&source=qcloud"},{"height":720,"width":1280,"urlList":[{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=high&source=qcloud","size":2020979},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=high&source=ucloud","size":2020979}],"name":"楂樻竻","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=high&source=qcloud"}]
         * consumption : {"collectionCount":6,"shareCount":16,"replyCount":1}
         * campaign : null
         * waterMarks : null
         * adTrack : null
         * tags : []
         * type : NORMAL
         * titlePgc : 涓�涓コ浜烘媿浜嗚嚜鎷嶇収鍚庘��
         * descriptionPgc : 涓嶈鐩镐俊缃戠粶鐨勭編濂宠嚜鎷嶏紝浣犲彲鑳戒細琚獥寰楀緢鎯紝缈昏瘧锛氳彍绮ョ播锛屽井鍗氾細娉癴ashion_鑿滅播绮ヂ�
         * remark :
         * idx : 0
         * shareAdTrack : null
         * favoriteAdTrack : null
         * webAdTrack : null
         * date : 1500783751000
         * promotion : null
         * label : null
         * labelList : []
         * descriptionEditor :
         * collected : false
         * played : false
         * subtitles : []
         * lastViewTime : null
         */

        private String dataType;
        private int id;
        private String title;
        private Object slogan;
        private String description;
        private ProviderBean provider;
        private String category;
        private AuthorBean author;
        private CoverBean cover;
        private String playUrl;
        private Object thumbPlayUrl;
        private int duration;
        private WebUrlBean webUrl;
        private long releaseTime;
        private String library;
        private ConsumptionBean consumption;
        private Object campaign;
        private Object waterMarks;
        private Object adTrack;
        private String type;
        private String titlePgc;
        private String descriptionPgc;
        private String remark;
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
        private List<?> tags;
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

        public Object getSlogan() {
            return slogan;
        }

        public void setSlogan(Object slogan) {
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

        public Object getThumbPlayUrl() {
            return thumbPlayUrl;
        }

        public void setThumbPlayUrl(Object thumbPlayUrl) {
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

        public String getTitlePgc() {
            return titlePgc;
        }

        public void setTitlePgc(String titlePgc) {
            this.titlePgc = titlePgc;
        }

        public String getDescriptionPgc() {
            return descriptionPgc;
        }

        public void setDescriptionPgc(String descriptionPgc) {
            this.descriptionPgc = descriptionPgc;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
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

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
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
             * name : PGC
             * alias : PGC
             * icon :
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
             * id : 764
             * icon : http://img.kaiyanapp.com/15c80ec5a88389d271798b9a0865f221.png?imageMogr2/quality/60/format/jpg
             * name : 娉癴ashion_鑿滅播绮�
             * description : 娉拌涓撲笟姣曚笟鐨勯噹鐢熻弻缈昏瘧涓�鏋� 涓撴敞娉扮炕鍙婃洿鏂版嘲鍥界儹闂ㄨ棰戉笂喔粪箞喔箘喔椸涪喙勦笧喔ム复喔權笝喔班竸喔�
             * link :
             * latestReleaseTime : 1500783751000
             * videoNum : 60
             * adTrack : null
             * follow : {"itemType":"author","itemId":764,"followed":false}
             * shield : {"itemType":"author","itemId":764,"shielded":false}
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
                 * itemId : 764
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
                 * itemId : 764
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
             * feed : http://img.kaiyanapp.com/09b096bc2925a628b14f7c25f6c9f152.png?imageMogr2/quality/60/format/jpg
             * detail : http://img.kaiyanapp.com/09b096bc2925a628b14f7c25f6c9f152.png?imageMogr2/quality/60/format/jpg
             * blurred : http://img.kaiyanapp.com/ff37d47984bf21fd4227395a0c4d953f.jpeg?imageMogr2/quality/60/format/jpg
             * sharing : null
             * homepage : null
             */

            private String feed;
            private String detail;
            private String blurred;
            private Object sharing;
            private Object homepage;

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

            public Object getHomepage() {
                return homepage;
            }

            public void setHomepage(Object homepage) {
                this.homepage = homepage;
            }
        }

        public static class WebUrlBean {
            /**
             * raw : http://www.eyepetizer.net/detail.html?vid=37936
             * forWeibo : http://wandou.im/3nvqb2
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
             * collectionCount : 6
             * shareCount : 16
             * replyCount : 1
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
             * urlList : [{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=normal&source=qcloud","size":1316933},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=normal&source=ucloud","size":1316933}]
             * name : 鏍囨竻
             * type : normal
             * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=normal&source=qcloud
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
                 * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=37936&editionType=normal&source=qcloud
                 * size : 1316933
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
    }
}
