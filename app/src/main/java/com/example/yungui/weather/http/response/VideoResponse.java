package com.example.yungui.weather.http.response;

/**
 * Created by yungui on 2017/7/23.
 */

public class VideoResponse<T> {
    public T videos;

    public int count;

    public int total;
    public String nextPagerUrl;

    public T getVideos() {
        return videos;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setVideos(T videos) {
        this.videos = videos;
    }


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNextPagerUrl() {
        return nextPagerUrl;
    }

    public void setNextPagerUrl(String nextPagerUrl) {
        this.nextPagerUrl = nextPagerUrl;
    }

    @Override
    public String toString() {
        return "VideoResponse{" +
                "videos=" + videos +
                ", count=" + count +
                ", total=" + total +
                ", nextPagerUrl='" + nextPagerUrl + '\'' +
                '}';
    }
}
