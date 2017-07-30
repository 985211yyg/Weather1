package com.example.yungui.weather.http.response;

import com.example.yungui.weather.modle.CommentsBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yungui on 2017/6/28.
 */

public class BaseJianDanResponse {
    /**
     * status : ok
     * current_page : 1
     * total_comments : 3824
     * page_count : 153
     * count : 25
     * comments : [{"comment_ID":"3495337","comment_post_ID":"21183","comment_author":"水蜜桃","comment_author_email":"425731617@QQ.com","comment_author_url":"","comment_author_IP":"112.65.190.213","comment_date":"2017-06-30 16:46:35","comment_date_gmt":"2017-06-30 08:46:35","comment_content":"<img src=\"http://ws3.sinaimg.cn/mw600/3ba1ccbagy1fh3bnzrl7rj20q511yaej.jpg\" />","comment_karma":"0","comment_approved":"1","comment_agent":"Jandan Android App V4.3.1.1;eyJzaWduIjoiNDBjNWYwZTMyMWZhNmRhODQ5NThmNDY2ZDllZGUxMDIifQ==","comment_type":"","comment_parent":"0","user_id":"0","comment_subscribe":"N","comment_reply_ID":"0","vote_positive":"21","vote_negative":"3","vote_ip_pool":"","sub_comment_count":"0","text_content":"","pics":["http://ws3.sinaimg.cn/mw600/3ba1ccbagy1fh3bnzrl7rj20q511yaej.jpg"],"videos":[]}]
     */

    private String status;
    private int current_page;
    private int total_comments;
    private int page_count;
    private int count;
    private List<CommentsBean> comments;

    public static BaseJianDanResponse objectFromData(String str) {

        return new Gson().fromJson(str, BaseJianDanResponse.class);
    }

    public static BaseJianDanResponse objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), BaseJianDanResponse.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<BaseJianDanResponse> arrayBaseJianDanResponseFromData(String str) {

        Type listType = new TypeToken<ArrayList<BaseJianDanResponse>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<BaseJianDanResponse> arrayBaseJianDanResponseFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<BaseJianDanResponse>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getTotal_comments() {
        return total_comments;
    }

    public void setTotal_comments(int total_comments) {
        this.total_comments = total_comments;
    }

    public int getPage_count() {
        return page_count;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    //    public String status;
//    public int current_page;
//    public int total_comment;
//    public int page_count;
//    public int count;
//    //主要的数据
//    public List<JianDanOOXX> ooxxs=new ArrayList<>();
//
//    @Override
//    public String toString() {
//        return "BaseJianDanResponse{" +
//                "status='" + status + '\'' +
//                ", current_page=" + current_page +
//                ", total_comment=" + total_comment +
//                ", page_count=" + page_count +
//                ", count=" + count +
//                ", xxoos=" + ooxxs +
//                '}';
//    }

}
