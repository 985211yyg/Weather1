package com.example.yungui.weather.modle.nh;

import java.io.Serializable;

/**
 * Created by yungui on 2017/8/21.
 */

public class HtmlBean implements Serializable {
    private String title;
    private String author;
    private String content;
    private String publishTime;
    private String shareUrl;

    @Override
    public String toString() {
        return "HtmlBean{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", publishTime='" + publishTime + '\'' +
                '}';
    }

    public HtmlBean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public void setshareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getShareUrl() {
        return shareUrl;
    }
}
