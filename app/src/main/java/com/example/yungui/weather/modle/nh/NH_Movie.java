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

public class NH_Movie {

    /**
     * res : 0
     * data : {"id":"243","title":"将来的事","indexcover":"","detailcover":"http://image.wufazhuce.com/Flxh36MDPRjjY3M74LW0YGiQWnbM","video":"http://music.wufazhuce.com/lutrSFGb2tAHlehp3I30tq3o5Hxd","verse":"","verse_en":"","score":null,"revisedscore":"0","review":"","keywords":"影后于佩尔;中老年危机;柏林银熊;张力十足;生活的哲学","movie_id":"","info":"导演: 米娅·汉森-洛夫\r\n编剧: 米娅·汉森-洛夫\r\n主演: 伊莎贝尔·于佩尔 / 安德烈·马尔孔 / 罗曼·科兰卡 / 爱迪丝·斯考博 / 伊莉斯·洛蒙\r\n类型: 剧情\r\n制片国家/地区: 法国","officialstory":"Nathalie Chazeaux（Isabelle Huppert饰）是巴黎一所中学的哲学课老师，她对工作充满热情，享受在生活中思考的乐趣；她丈夫Heinz（André Marcon饰）也是一位教师，她还有一双儿女Chloé（Sarah Le Picard饰）和 Johann（Solal Forte饰）。一直以来，Nathalie的生活都围着这一家四口、她占有欲极强的母亲Yvette（Edith Scob饰）和自己的得意门生Fabien（Roman Kolinka饰）展开。 \r\n然而有一天，丈夫告诉Nathalie他要为另一个女人与她分居，一贯任性胡来的母亲在养老院里遽然去世，自己编写的教材也被出版社告知将停止再版\u2026\u2026前所未有的巨大自由突然降临在Nathalie面前，她必须重塑自己的生活。","hide_flag":"0","charge_edt":"责任编辑：高梦苒","web_url":"http://m.wufazhuce.com/movie/243","praisenum":20,"sort":"0","releasetime":"0000-00-00 00:00:00","scoretime":"0000-00-00 00:00:00","maketime":"2010-01-01 01:05:00","last_update_date":"2017-01-06 14:43:59","read_num":"2100","directors":"米娅·汉森-洛夫","editor_email":"mengran@wufazhuce.com","related":"","directors_id":"","start_video":"","media_type":"2","poster":"http://image.wufazhuce.com/Fit81aKGJpJBjcB4TkuXvQZcwuvh","photo":["http://image.wufazhuce.com/Fg2MVLiQqcRHffRiX3P07dKDwMhH","http://image.wufazhuce.com/FndfiVAZsR13hPPG2gvptADnvZIF","http://image.wufazhuce.com/Fo6LUga_InAOq5Lr80V3tJTv2FeG"],"next_id":"238","previous_id":"235","sharenum":6,"commentnum":5,"servertime":1483856460}
     */

    private int res;
    private DataBean data;

    public static NH_Movie objectFromData(String str) {

        return new Gson().fromJson(str, NH_Movie.class);
    }

    public static NH_Movie objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), NH_Movie.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<NH_Movie> arrayNH_MovieFromData(String str) {

        Type listType = new TypeToken<ArrayList<NH_Movie>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<NH_Movie> arrayNH_MovieFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<NH_Movie>>() {
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 243
         * title : 将来的事
         * indexcover :
         * detailcover : http://image.wufazhuce.com/Flxh36MDPRjjY3M74LW0YGiQWnbM
         * video : http://music.wufazhuce.com/lutrSFGb2tAHlehp3I30tq3o5Hxd
         * verse :
         * verse_en :
         * score : null
         * revisedscore : 0
         * review :
         * keywords : 影后于佩尔;中老年危机;柏林银熊;张力十足;生活的哲学
         * movie_id :
         * info : 导演: 米娅·汉森-洛夫
         编剧: 米娅·汉森-洛夫
         主演: 伊莎贝尔·于佩尔 / 安德烈·马尔孔 / 罗曼·科兰卡 / 爱迪丝·斯考博 / 伊莉斯·洛蒙
         类型: 剧情
         制片国家/地区: 法国
         * officialstory : Nathalie Chazeaux（Isabelle Huppert饰）是巴黎一所中学的哲学课老师，她对工作充满热情，享受在生活中思考的乐趣；她丈夫Heinz（André Marcon饰）也是一位教师，她还有一双儿女Chloé（Sarah Le Picard饰）和 Johann（Solal Forte饰）。一直以来，Nathalie的生活都围着这一家四口、她占有欲极强的母亲Yvette（Edith Scob饰）和自己的得意门生Fabien（Roman Kolinka饰）展开。
         然而有一天，丈夫告诉Nathalie他要为另一个女人与她分居，一贯任性胡来的母亲在养老院里遽然去世，自己编写的教材也被出版社告知将停止再版……前所未有的巨大自由突然降临在Nathalie面前，她必须重塑自己的生活。
         * hide_flag : 0
         * charge_edt : 责任编辑：高梦苒
         * web_url : http://m.wufazhuce.com/movie/243
         * praisenum : 20
         * sort : 0
         * releasetime : 0000-00-00 00:00:00
         * scoretime : 0000-00-00 00:00:00
         * maketime : 2010-01-01 01:05:00
         * last_update_date : 2017-01-06 14:43:59
         * read_num : 2100
         * directors : 米娅·汉森-洛夫
         * editor_email : mengran@wufazhuce.com
         * related :
         * directors_id :
         * start_video :
         * media_type : 2
         * poster : http://image.wufazhuce.com/Fit81aKGJpJBjcB4TkuXvQZcwuvh
         * photo : ["http://image.wufazhuce.com/Fg2MVLiQqcRHffRiX3P07dKDwMhH","http://image.wufazhuce.com/FndfiVAZsR13hPPG2gvptADnvZIF","http://image.wufazhuce.com/Fo6LUga_InAOq5Lr80V3tJTv2FeG"]
         * next_id : 238
         * previous_id : 235
         * sharenum : 6
         * commentnum : 5
         * servertime : 1483856460
         */

        private String id;
        private String title;
        private String indexcover;
        private String detailcover;
        private String video;
        private String verse;
        private String verse_en;
        private Object score;
        private String revisedscore;
        private String review;
        private String keywords;
        private String movie_id;
        private String info;
        private String officialstory;
        private String hide_flag;
        private String charge_edt;
        private String web_url;
        private int praisenum;
        private String sort;
        private String releasetime;
        private String scoretime;
        private String maketime;
        private String last_update_date;
        private String read_num;
        private String directors;
        private String editor_email;
        private String related;
        private String directors_id;
        private String start_video;
        private String media_type;
        private String poster;
        private String next_id;
        private String previous_id;
        private int sharenum;
        private int commentnum;
        private int servertime;
        private List<String> photo;

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIndexcover() {
            return indexcover;
        }

        public void setIndexcover(String indexcover) {
            this.indexcover = indexcover;
        }

        public String getDetailcover() {
            return detailcover;
        }

        public void setDetailcover(String detailcover) {
            this.detailcover = detailcover;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getVerse() {
            return verse;
        }

        public void setVerse(String verse) {
            this.verse = verse;
        }

        public String getVerse_en() {
            return verse_en;
        }

        public void setVerse_en(String verse_en) {
            this.verse_en = verse_en;
        }

        public Object getScore() {
            return score;
        }

        public void setScore(Object score) {
            this.score = score;
        }

        public String getRevisedscore() {
            return revisedscore;
        }

        public void setRevisedscore(String revisedscore) {
            this.revisedscore = revisedscore;
        }

        public String getReview() {
            return review;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getMovie_id() {
            return movie_id;
        }

        public void setMovie_id(String movie_id) {
            this.movie_id = movie_id;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getOfficialstory() {
            return officialstory;
        }

        public void setOfficialstory(String officialstory) {
            this.officialstory = officialstory;
        }

        public String getHide_flag() {
            return hide_flag;
        }

        public void setHide_flag(String hide_flag) {
            this.hide_flag = hide_flag;
        }

        public String getCharge_edt() {
            return charge_edt;
        }

        public void setCharge_edt(String charge_edt) {
            this.charge_edt = charge_edt;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        public int getPraisenum() {
            return praisenum;
        }

        public void setPraisenum(int praisenum) {
            this.praisenum = praisenum;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getReleasetime() {
            return releasetime;
        }

        public void setReleasetime(String releasetime) {
            this.releasetime = releasetime;
        }

        public String getScoretime() {
            return scoretime;
        }

        public void setScoretime(String scoretime) {
            this.scoretime = scoretime;
        }

        public String getMaketime() {
            return maketime;
        }

        public void setMaketime(String maketime) {
            this.maketime = maketime;
        }

        public String getLast_update_date() {
            return last_update_date;
        }

        public void setLast_update_date(String last_update_date) {
            this.last_update_date = last_update_date;
        }

        public String getRead_num() {
            return read_num;
        }

        public void setRead_num(String read_num) {
            this.read_num = read_num;
        }

        public String getDirectors() {
            return directors;
        }

        public void setDirectors(String directors) {
            this.directors = directors;
        }

        public String getEditor_email() {
            return editor_email;
        }

        public void setEditor_email(String editor_email) {
            this.editor_email = editor_email;
        }

        public String getRelated() {
            return related;
        }

        public void setRelated(String related) {
            this.related = related;
        }

        public String getDirectors_id() {
            return directors_id;
        }

        public void setDirectors_id(String directors_id) {
            this.directors_id = directors_id;
        }

        public String getStart_video() {
            return start_video;
        }

        public void setStart_video(String start_video) {
            this.start_video = start_video;
        }

        public String getMedia_type() {
            return media_type;
        }

        public void setMedia_type(String media_type) {
            this.media_type = media_type;
        }

        public String getPoster() {
            return poster;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }

        public String getNext_id() {
            return next_id;
        }

        public void setNext_id(String next_id) {
            this.next_id = next_id;
        }

        public String getPrevious_id() {
            return previous_id;
        }

        public void setPrevious_id(String previous_id) {
            this.previous_id = previous_id;
        }

        public int getSharenum() {
            return sharenum;
        }

        public void setSharenum(int sharenum) {
            this.sharenum = sharenum;
        }

        public int getCommentnum() {
            return commentnum;
        }

        public void setCommentnum(int commentnum) {
            this.commentnum = commentnum;
        }

        public int getServertime() {
            return servertime;
        }

        public void setServertime(int servertime) {
            this.servertime = servertime;
        }

        public List<String> getPhoto() {
            return photo;
        }

        public void setPhoto(List<String> photo) {
            this.photo = photo;
        }
    }
}
