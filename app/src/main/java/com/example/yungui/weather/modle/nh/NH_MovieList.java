package com.example.yungui.weather.modle.nh;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yungui on 2017/8/10.
 */

public class NH_MovieList {

    /**
     * data 是一个链表，size 是 10，我们需要使用该 json 字段中的

     ~item_id 获取该影视的详细信息
     ~id 获取该影视之前的前十个影视
     */

    /**
     * res : 0
     * data : [{"id":"9240","category":"5","display_category":6,"item_id":"243","title":"戛纳影后于佩尔，又演了一部高分电影","forward":"她是我见过的所有身陷人生危机的人里，最美的一个。","img_url":"http://image.wufazhuce.com/Fqml5H7NE2eefzWgaPdL7ZVzdD1Y","like_count":19,"post_date":"2017-01-08 10:00:00","last_update_date":"2017-01-06 14:43:59","author":{"user_id":"7653024","user_name":"不知明月","desc":"格瓦拉小编，游走在世界某个角落。","wb_name":"","is_settled":"0","settled_type":"0","summary":"格瓦拉小编，游走在世界某个角落。","fans_total":"1","web_url":"http://image.wufazhuce.com/FiHau6iShPZd1oxvxiZKrSp8l1Sw"},"video_url":"","audio_url":"","audio_platform":2,"start_video":"","volume":0,"pic_info":"","words_info":"","subtitle":"将来的事","number":0,"serial_id":0,"serial_list":[],"movie_story_id":"3226","ad_id":0,"ad_type":0,"ad_pvurl":"","ad_linkurl":"","ad_makettime":"","ad_closetime":"","ad_share_cnt":"","ad_pvurl_vendor":"","content_id":"243","content_type":"5","content_bgcolor":"#FFFFFF","share_url":"http://m.wufazhuce.com/movie/243","share_info":{"url":"http://m.wufazhuce.com/movie/243","image":"http://image.wufazhuce.com/Fqml5H7NE2eefzWgaPdL7ZVzdD1Y","title":"「一个」电影: 将来的事","content":"《钢琴教师》是小编看过的首部于佩尔作品，最初就是冲着\u201c戛纳影后\u201d的名号来的。意料之外，这部电影给了我前所未有的观感，戏谑、颠覆、疯癫，之后这些元素都成了于佩尔电影的标配。\r\n\r\n这位戛纳历史上第一个全票通过的影后，拥有精湛的演技，加上对剧本一如既往的苛刻要求，已经成了烂片绝缘体。2016对她来说，也是收获满满，因为在《她》中的出色表现，提名金球奖，也成为明年奥斯卡最佳女主的有力竞争者。\r\n \r\n这一次要推荐的是她的热门新片《将来的事》，本片导演米娅·昂桑洛夫借此获得了今年柏林电影节最佳导演银熊奖。电影在烂番茄的新鲜度为100%，作为影迷的你值得拥有。\r\n\r\n一个关于危机的故事\r\n \r\n《将来的事》是于佩尔继代表作《钢琴教师》后，再次饰演一位老师，影片将镜头对准了一位已愈花甲之年的女哲学老师娜塔莉。娜塔莉原本过着平静的生活，直到相守多年的丈夫弃她而去，她不仅需要独立照顾高龄的老母亲，还要和突如其来的疾病斗争。在不断的失去到一无所有中，女主人公看似平静的接受，却也一直艰难地前行。这种不断减法的人生，是否真的获得了内心的自由？这部反映中年危机的电影，看似枯燥无味，却暗藏玄机。\r\n\r\n这是80后导演米娅·昂桑－洛夫导演的第五部作品，是导演阿萨亚斯的妻子。而阿萨亚斯最为中国公众所熟知的身份就是张曼玉的前夫。演员出生的她有着让人过目不忘的面容。转行导演处女作《百无禁忌》，就提名了凯撒奖最佳处女作奖。\r\n\r\n《将来的事》延续了导演以往对不同职业的探索的主题，同时与之前关注时间的流逝不同，这次没有过多的抱怨和激烈的争吵，而是以舒缓流畅的镜头，用自嘲平静的面对失去的一切。影片没有狗血的剧情，配乐也只有四首，导演只想安安静静的讲一个故事。\r\n\r\n平铺直叙下是剧情的张力\r\n\r\n导演处理剧情片功力强大。不得不提的是影片中的三次哭泣，这三次哭泣代表了一个中年女人的面对命运嘲弄的自我反思，导演处理的非常果断。第一个是娜塔莉打包走她所有的物品，彻底结束了婚姻，而生活似乎生活连感伤的时间都没有，因为生病的母亲匆匆赶回巴黎。\r\n\r\n第二次是在母亲葬礼后，那一次车上偶遇前夫与情人私语，泪流满面之后的大笑。\r\n\r\n第三次是面对故步自封的指责与质疑，她不舍的离开庄园。\r\n\r\n这种不停的转移，少了悲伤的意味，让人物显得更加的阳光和愉悦。80后导演对生活的感悟和整体节奏的把握独到，让她成为法国最有潜力的导演之一。\r\n\r\n哲学是生活的支撑也是隐喻\r\n\r\n《将来的事》最有趣的地方在于，用远离生活的哲学贯穿整部电影，与生活互相映射，却最终阐释了彼此。\r\n\r\n导演米娅的父母都是哲学教授，这个成长环境，让她对哲学领域和这份特殊职业的理解更加深刻。这种思辨的思维是导演所有作品中都能看到的，快乐与忧愁、生与死、乐观与悲观相应而生相辅相成。\r\n\r\n伊莎贝尔·于佩尔和导演米娅互相成就了彼此。于佩尔既演出了自己的风格，又有角色的突破，而导演则用细致入微的生活细节，带给人物更加丰满的羽翼。\r\n\r\n奥地利导演哈内克曾评价于佩尔的表演：\u201c既可以极致地表现身心受折磨的困境，同时还保持坚硬的知识分子气质，能把两者结合得这么好的人，我还没见过第二个。\u201d"}}]
     */

    private int res;
    private List<DataBean> data;

    public static NH_MovieList objectFromData(String str) {

        return new Gson().fromJson(str, NH_MovieList.class);
    }

    public static NH_MovieList objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), NH_MovieList.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<NH_MovieList> arrayNH_MovieListFromData(String str) {

        Type listType = new TypeToken<ArrayList<NH_MovieList>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<NH_MovieList> arrayNH_MovieListFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<NH_MovieList>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 9240
         * category : 5
         * display_category : 6
         * item_id : 243
         * title : 戛纳影后于佩尔，又演了一部高分电影
         * forward : 她是我见过的所有身陷人生危机的人里，最美的一个。
         * img_url : http://image.wufazhuce.com/Fqml5H7NE2eefzWgaPdL7ZVzdD1Y
         * like_count : 19
         * post_date : 2017-01-08 10:00:00
         * last_update_date : 2017-01-06 14:43:59
         * author : {"user_id":"7653024","user_name":"不知明月","desc":"格瓦拉小编，游走在世界某个角落。","wb_name":"","is_settled":"0","settled_type":"0","summary":"格瓦拉小编，游走在世界某个角落。","fans_total":"1","web_url":"http://image.wufazhuce.com/FiHau6iShPZd1oxvxiZKrSp8l1Sw"}
         * video_url :
         * audio_url :
         * audio_platform : 2
         * start_video :
         * volume : 0
         * pic_info :
         * words_info :
         * subtitle : 将来的事
         * number : 0
         * serial_id : 0
         * serial_list : []
         * movie_story_id : 3226
         * ad_id : 0
         * ad_type : 0
         * ad_pvurl :
         * ad_linkurl :
         * ad_makettime :
         * ad_closetime :
         * ad_share_cnt :
         * ad_pvurl_vendor :
         * content_id : 243
         * content_type : 5
         * content_bgcolor : #FFFFFF
         * share_url : http://m.wufazhuce.com/movie/243
         * share_info : {"url":"http://m.wufazhuce.com/movie/243","image":"http://image.wufazhuce.com/Fqml5H7NE2eefzWgaPdL7ZVzdD1Y","title":"「一个」电影: 将来的事","content":"《钢琴教师》是小编看过的首部于佩尔作品，最初就是冲着\u201c戛纳影后\u201d的名号来的。意料之外，这部电影给了我前所未有的观感，戏谑、颠覆、疯癫，之后这些元素都成了于佩尔电影的标配。\r\n\r\n这位戛纳历史上第一个全票通过的影后，拥有精湛的演技，加上对剧本一如既往的苛刻要求，已经成了烂片绝缘体。2016对她来说，也是收获满满，因为在《她》中的出色表现，提名金球奖，也成为明年奥斯卡最佳女主的有力竞争者。\r\n \r\n这一次要推荐的是她的热门新片《将来的事》，本片导演米娅·昂桑洛夫借此获得了今年柏林电影节最佳导演银熊奖。电影在烂番茄的新鲜度为100%，作为影迷的你值得拥有。\r\n\r\n一个关于危机的故事\r\n \r\n《将来的事》是于佩尔继代表作《钢琴教师》后，再次饰演一位老师，影片将镜头对准了一位已愈花甲之年的女哲学老师娜塔莉。娜塔莉原本过着平静的生活，直到相守多年的丈夫弃她而去，她不仅需要独立照顾高龄的老母亲，还要和突如其来的疾病斗争。在不断的失去到一无所有中，女主人公看似平静的接受，却也一直艰难地前行。这种不断减法的人生，是否真的获得了内心的自由？这部反映中年危机的电影，看似枯燥无味，却暗藏玄机。\r\n\r\n这是80后导演米娅·昂桑－洛夫导演的第五部作品，是导演阿萨亚斯的妻子。而阿萨亚斯最为中国公众所熟知的身份就是张曼玉的前夫。演员出生的她有着让人过目不忘的面容。转行导演处女作《百无禁忌》，就提名了凯撒奖最佳处女作奖。\r\n\r\n《将来的事》延续了导演以往对不同职业的探索的主题，同时与之前关注时间的流逝不同，这次没有过多的抱怨和激烈的争吵，而是以舒缓流畅的镜头，用自嘲平静的面对失去的一切。影片没有狗血的剧情，配乐也只有四首，导演只想安安静静的讲一个故事。\r\n\r\n平铺直叙下是剧情的张力\r\n\r\n导演处理剧情片功力强大。不得不提的是影片中的三次哭泣，这三次哭泣代表了一个中年女人的面对命运嘲弄的自我反思，导演处理的非常果断。第一个是娜塔莉打包走她所有的物品，彻底结束了婚姻，而生活似乎生活连感伤的时间都没有，因为生病的母亲匆匆赶回巴黎。\r\n\r\n第二次是在母亲葬礼后，那一次车上偶遇前夫与情人私语，泪流满面之后的大笑。\r\n\r\n第三次是面对故步自封的指责与质疑，她不舍的离开庄园。\r\n\r\n这种不停的转移，少了悲伤的意味，让人物显得更加的阳光和愉悦。80后导演对生活的感悟和整体节奏的把握独到，让她成为法国最有潜力的导演之一。\r\n\r\n哲学是生活的支撑也是隐喻\r\n\r\n《将来的事》最有趣的地方在于，用远离生活的哲学贯穿整部电影，与生活互相映射，却最终阐释了彼此。\r\n\r\n导演米娅的父母都是哲学教授，这个成长环境，让她对哲学领域和这份特殊职业的理解更加深刻。这种思辨的思维是导演所有作品中都能看到的，快乐与忧愁、生与死、乐观与悲观相应而生相辅相成。\r\n\r\n伊莎贝尔·于佩尔和导演米娅互相成就了彼此。于佩尔既演出了自己的风格，又有角色的突破，而导演则用细致入微的生活细节，带给人物更加丰满的羽翼。\r\n\r\n奥地利导演哈内克曾评价于佩尔的表演：\u201c既可以极致地表现身心受折磨的困境，同时还保持坚硬的知识分子气质，能把两者结合得这么好的人，我还没见过第二个。\u201d"}
         */

        private String id;
        private String category;
        private int display_category;
        private String item_id;
        private String title;
        private String forward;
        private String img_url;
        private int like_count;
        private String post_date;
        private String last_update_date;
        private AuthorBean author;
        private String video_url;
        private String audio_url;
        private int audio_platform;
        private String start_video;
        private int volume;
        private String pic_info;
        private String words_info;
        private String subtitle;
        private int number;
        private int serial_id;
        private String movie_story_id;
        private int ad_id;
        private int ad_type;
        private String ad_pvurl;
        private String ad_linkurl;
        private String ad_makettime;
        private String ad_closetime;
        private String ad_share_cnt;
        private String ad_pvurl_vendor;
        private String content_id;
        private String content_type;
        private String content_bgcolor;
        private String share_url;
        private ShareInfoBean share_info;
        private List<?> serial_list;

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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getDisplay_category() {
            return display_category;
        }

        public void setDisplay_category(int display_category) {
            this.display_category = display_category;
        }

        public String getItem_id() {
            return item_id;
        }

        public void setItem_id(String item_id) {
            this.item_id = item_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getForward() {
            return forward;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public String getPost_date() {
            return post_date;
        }

        public void setPost_date(String post_date) {
            this.post_date = post_date;
        }

        public String getLast_update_date() {
            return last_update_date;
        }

        public void setLast_update_date(String last_update_date) {
            this.last_update_date = last_update_date;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public String getAudio_url() {
            return audio_url;
        }

        public void setAudio_url(String audio_url) {
            this.audio_url = audio_url;
        }

        public int getAudio_platform() {
            return audio_platform;
        }

        public void setAudio_platform(int audio_platform) {
            this.audio_platform = audio_platform;
        }

        public String getStart_video() {
            return start_video;
        }

        public void setStart_video(String start_video) {
            this.start_video = start_video;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public String getPic_info() {
            return pic_info;
        }

        public void setPic_info(String pic_info) {
            this.pic_info = pic_info;
        }

        public String getWords_info() {
            return words_info;
        }

        public void setWords_info(String words_info) {
            this.words_info = words_info;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getSerial_id() {
            return serial_id;
        }

        public void setSerial_id(int serial_id) {
            this.serial_id = serial_id;
        }

        public String getMovie_story_id() {
            return movie_story_id;
        }

        public void setMovie_story_id(String movie_story_id) {
            this.movie_story_id = movie_story_id;
        }

        public int getAd_id() {
            return ad_id;
        }

        public void setAd_id(int ad_id) {
            this.ad_id = ad_id;
        }

        public int getAd_type() {
            return ad_type;
        }

        public void setAd_type(int ad_type) {
            this.ad_type = ad_type;
        }

        public String getAd_pvurl() {
            return ad_pvurl;
        }

        public void setAd_pvurl(String ad_pvurl) {
            this.ad_pvurl = ad_pvurl;
        }

        public String getAd_linkurl() {
            return ad_linkurl;
        }

        public void setAd_linkurl(String ad_linkurl) {
            this.ad_linkurl = ad_linkurl;
        }

        public String getAd_makettime() {
            return ad_makettime;
        }

        public void setAd_makettime(String ad_makettime) {
            this.ad_makettime = ad_makettime;
        }

        public String getAd_closetime() {
            return ad_closetime;
        }

        public void setAd_closetime(String ad_closetime) {
            this.ad_closetime = ad_closetime;
        }

        public String getAd_share_cnt() {
            return ad_share_cnt;
        }

        public void setAd_share_cnt(String ad_share_cnt) {
            this.ad_share_cnt = ad_share_cnt;
        }

        public String getAd_pvurl_vendor() {
            return ad_pvurl_vendor;
        }

        public void setAd_pvurl_vendor(String ad_pvurl_vendor) {
            this.ad_pvurl_vendor = ad_pvurl_vendor;
        }

        public String getContent_id() {
            return content_id;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }

        public String getContent_type() {
            return content_type;
        }

        public void setContent_type(String content_type) {
            this.content_type = content_type;
        }

        public String getContent_bgcolor() {
            return content_bgcolor;
        }

        public void setContent_bgcolor(String content_bgcolor) {
            this.content_bgcolor = content_bgcolor;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public ShareInfoBean getShare_info() {
            return share_info;
        }

        public void setShare_info(ShareInfoBean share_info) {
            this.share_info = share_info;
        }

        public List<?> getSerial_list() {
            return serial_list;
        }

        public void setSerial_list(List<?> serial_list) {
            this.serial_list = serial_list;
        }

        public static class AuthorBean {
            /**
             * user_id : 7653024
             * user_name : 不知明月
             * desc : 格瓦拉小编，游走在世界某个角落。
             * wb_name :
             * is_settled : 0
             * settled_type : 0
             * summary : 格瓦拉小编，游走在世界某个角落。
             * fans_total : 1
             * web_url : http://image.wufazhuce.com/FiHau6iShPZd1oxvxiZKrSp8l1Sw
             */

            private String user_id;
            private String user_name;
            private String desc;
            private String wb_name;
            private String is_settled;
            private String settled_type;
            private String summary;
            private String fans_total;
            private String web_url;

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

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getWb_name() {
                return wb_name;
            }

            public void setWb_name(String wb_name) {
                this.wb_name = wb_name;
            }

            public String getIs_settled() {
                return is_settled;
            }

            public void setIs_settled(String is_settled) {
                this.is_settled = is_settled;
            }

            public String getSettled_type() {
                return settled_type;
            }

            public void setSettled_type(String settled_type) {
                this.settled_type = settled_type;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getFans_total() {
                return fans_total;
            }

            public void setFans_total(String fans_total) {
                this.fans_total = fans_total;
            }

            public String getWeb_url() {
                return web_url;
            }

            public void setWeb_url(String web_url) {
                this.web_url = web_url;
            }
        }

        public static class ShareInfoBean {
            /**
             * url : http://m.wufazhuce.com/movie/243
             * image : http://image.wufazhuce.com/Fqml5H7NE2eefzWgaPdL7ZVzdD1Y
             * title : 「一个」电影: 将来的事
             * content : 《钢琴教师》是小编看过的首部于佩尔作品，最初就是冲着“戛纳影后”的名号来的。意料之外，这部电影给了我前所未有的观感，戏谑、颠覆、疯癫，之后这些元素都成了于佩尔电影的标配。

             这位戛纳历史上第一个全票通过的影后，拥有精湛的演技，加上对剧本一如既往的苛刻要求，已经成了烂片绝缘体。2016对她来说，也是收获满满，因为在《她》中的出色表现，提名金球奖，也成为明年奥斯卡最佳女主的有力竞争者。

             这一次要推荐的是她的热门新片《将来的事》，本片导演米娅·昂桑洛夫借此获得了今年柏林电影节最佳导演银熊奖。电影在烂番茄的新鲜度为100%，作为影迷的你值得拥有。

             一个关于危机的故事

             《将来的事》是于佩尔继代表作《钢琴教师》后，再次饰演一位老师，影片将镜头对准了一位已愈花甲之年的女哲学老师娜塔莉。娜塔莉原本过着平静的生活，直到相守多年的丈夫弃她而去，她不仅需要独立照顾高龄的老母亲，还要和突如其来的疾病斗争。在不断的失去到一无所有中，女主人公看似平静的接受，却也一直艰难地前行。这种不断减法的人生，是否真的获得了内心的自由？这部反映中年危机的电影，看似枯燥无味，却暗藏玄机。

             这是80后导演米娅·昂桑－洛夫导演的第五部作品，是导演阿萨亚斯的妻子。而阿萨亚斯最为中国公众所熟知的身份就是张曼玉的前夫。演员出生的她有着让人过目不忘的面容。转行导演处女作《百无禁忌》，就提名了凯撒奖最佳处女作奖。

             《将来的事》延续了导演以往对不同职业的探索的主题，同时与之前关注时间的流逝不同，这次没有过多的抱怨和激烈的争吵，而是以舒缓流畅的镜头，用自嘲平静的面对失去的一切。影片没有狗血的剧情，配乐也只有四首，导演只想安安静静的讲一个故事。

             平铺直叙下是剧情的张力

             导演处理剧情片功力强大。不得不提的是影片中的三次哭泣，这三次哭泣代表了一个中年女人的面对命运嘲弄的自我反思，导演处理的非常果断。第一个是娜塔莉打包走她所有的物品，彻底结束了婚姻，而生活似乎生活连感伤的时间都没有，因为生病的母亲匆匆赶回巴黎。

             第二次是在母亲葬礼后，那一次车上偶遇前夫与情人私语，泪流满面之后的大笑。

             第三次是面对故步自封的指责与质疑，她不舍的离开庄园。

             这种不停的转移，少了悲伤的意味，让人物显得更加的阳光和愉悦。80后导演对生活的感悟和整体节奏的把握独到，让她成为法国最有潜力的导演之一。

             哲学是生活的支撑也是隐喻

             《将来的事》最有趣的地方在于，用远离生活的哲学贯穿整部电影，与生活互相映射，却最终阐释了彼此。

             导演米娅的父母都是哲学教授，这个成长环境，让她对哲学领域和这份特殊职业的理解更加深刻。这种思辨的思维是导演所有作品中都能看到的，快乐与忧愁、生与死、乐观与悲观相应而生相辅相成。

             伊莎贝尔·于佩尔和导演米娅互相成就了彼此。于佩尔既演出了自己的风格，又有角色的突破，而导演则用细致入微的生活细节，带给人物更加丰满的羽翼。

             奥地利导演哈内克曾评价于佩尔的表演：“既可以极致地表现身心受折磨的困境，同时还保持坚硬的知识分子气质，能把两者结合得这么好的人，我还没见过第二个。”
             */

            private String url;
            private String image;
            private String title;
            private String content;

            public static ShareInfoBean objectFromData(String str) {

                return new Gson().fromJson(str, ShareInfoBean.class);
            }

            public static ShareInfoBean objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ShareInfoBean.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public static List<ShareInfoBean> arrayShareInfoBeanFromData(String str) {

                Type listType = new TypeToken<ArrayList<ShareInfoBean>>() {
                }.getType();

                return new Gson().fromJson(str, listType);
            }

            public static List<ShareInfoBean> arrayShareInfoBeanFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);
                    Type listType = new TypeToken<ArrayList<ShareInfoBean>>() {
                    }.getType();

                    return new Gson().fromJson(jsonObject.getString(str), listType);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return new ArrayList();


            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }
    }
}
