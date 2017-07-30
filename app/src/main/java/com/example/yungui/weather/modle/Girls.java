package com.example.yungui.weather.modle;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by yungui on 2017/6/29.
 */

public class Girls  implements Serializable,Parcelable {
    private String url;
    private int width = 0;
    private int height = 0;
    //只有图集的的时候由也由此属性
    private String link;

    public Girls(String url) {
        this.url = url;
    }

    protected Girls(Parcel in) {
        url = in.readString();
        width = in.readInt();
        height = in.readInt();
        link = in.readString();
    }

    public static final Creator<Girls> CREATOR = new Creator<Girls>() {
        @Override
        public Girls createFromParcel(Parcel in) {
            return new Girls(in);
        }

        @Override
        public Girls[] newArray(int size) {
            return new Girls[size];
        }
    };

    /**
     * 构造方法
     *
     * @return
     */

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Girls{" +
                "url='" + url + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", link='" + link + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeInt(width);
        dest.writeInt(height);
        dest.writeString(link);
    }

}
