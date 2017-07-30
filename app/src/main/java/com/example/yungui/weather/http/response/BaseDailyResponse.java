package com.example.yungui.weather.http.response;

import com.example.yungui.weather.modle.bean.IssueBean;

import java.util.List;

/**
 * Created by yungui on 2017/7/21.
 */

public class BaseDailyResponse {
    private String nextPageUrl;
    private long nextPublishTime;
    private String newsIssueType;
    private String dialog;
    //发布的视频
    private List<IssueBean> issueListItems;

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public long getNextPublishTime() {
        return nextPublishTime;
    }

    public void setNextPublishTime(long nextPublishTime) {
        this.nextPublishTime = nextPublishTime;
    }

    public String getNewsIssueType() {
        return newsIssueType;
    }

    public void setNewsIssueType(String newsIssueType) {
        this.newsIssueType = newsIssueType;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public List<IssueBean> getIssueListItems() {
        return issueListItems;
    }

    public void setIssueListItems(List<IssueBean> issueListItems) {
        this.issueListItems = issueListItems;
    }

    @Override
    public String toString() {
        return "BaseDailyIssueResponse{" +
                "nextPageUrl='" + nextPageUrl + '\'' +
                ", nextPublishTime=" + nextPublishTime +
                ", newsIssueType='" + newsIssueType + '\'' +
                ", dialog='" + dialog + '\'' +
                ", issueListItems=" + issueListItems +
                '}';
    }
}
