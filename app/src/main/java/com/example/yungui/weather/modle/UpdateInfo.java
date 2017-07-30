package com.example.yungui.weather.modle;

/**
 * Created by yungui on 2017/6/27.
 */

public class UpdateInfo {

    private String app;
    private int  versionCode;
    private String updateDate;
    private String information;
    private boolean foreUpdate;
    private String url;

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public boolean isForeUpdate() {
        return foreUpdate;
    }

    public void setForeUpdate(boolean foreUpdate) {
        this.foreUpdate = foreUpdate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
