package com.example.yungui.weather.modle;

import android.graphics.Path;

/**
 * Created by yungui on 2017/6/28.
 */

public class Gank {
//    {
//            "_id": "591264ce421aa90c7a8b2aec",
//            "createdAt": "2017-05-10T08:54:38.531Z",
//            "desc": "5-10",
//            "publishedAt": "2017-05-10T11:56:10.18Z",
//            "source": "chrome",
//            "type": "\u798f\u5229",
//            "url": "http://7xi8d6.com1.z0.glb.clouddn.com/2017-05-10-18382517_1955528334668679_3605707761767153664_n.jpg",
//            "used": true,
//            "who": "\u5e26\u9a6c\u7532"
//    }
    private int ID;
    private String createAt;
    private String desc;
    private String publisheAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;

    //图片的宽高
    private int girlsHeight;
    private int girlsWidth;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublisheAt() {
        return publisheAt;
    }

    public void setPublisheAt(String publisheAt) {
        this.publisheAt = publisheAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public int getGirlsHeight() {
        return girlsHeight;
    }

    public void setGirlsHeight(int girlsHeight) {
        this.girlsHeight = girlsHeight;
    }

    public int getGirlsWidth() {
        return girlsWidth;
    }

    public void setGirlsWidth(int girlsWidth) {
        this.girlsWidth = girlsWidth;
    }

    @Override
    public String toString() {
        return "Gank{" +
                "ID=" + ID +
                ", createAt='" + createAt + '\'' +
                ", desc='" + desc + '\'' +
                ", publisheAt='" + publisheAt + '\'' +
                ", source='" + source + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", used=" + used +
                ", who='" + who + '\'' +
                ", girlsHeight=" + girlsHeight +
                ", girlsWidth=" + girlsWidth +
                '}';
    }

}
