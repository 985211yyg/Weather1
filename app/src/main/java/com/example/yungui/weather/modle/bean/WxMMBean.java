package com.example.yungui.weather.modle.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yungui on 2017/8/1.
 */

public class WxMMBean implements Parcelable{
    private String coverUrl;
    private String DetailUrl;
    private String title;
    private String desc;

    public WxMMBean() {
    }

    protected WxMMBean(Parcel in) {
        coverUrl = in.readString();
        DetailUrl = in.readString();
        title = in.readString();
        desc = in.readString();
    }

    public static final Creator<WxMMBean> CREATOR = new Creator<WxMMBean>() {
        @Override
        public WxMMBean createFromParcel(Parcel in) {
            return new WxMMBean(in);
        }

        @Override
        public WxMMBean[] newArray(int size) {
            return new WxMMBean[size];
        }
    };

    @Override
    public String toString() {
        return "WxMMBean{" +
                "coverUrl='" + coverUrl + '\'' +
                ", DetailUrl='" + DetailUrl + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getDetailUrl() {
        return DetailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        DetailUrl = detailUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(coverUrl);
        dest.writeString(DetailUrl);
        dest.writeString(title);
        dest.writeString(desc);
    }

}
