package com.example.yungui.weather.modle;

/**
 * Created by yungui on 2017/6/23.
 */

public class WeatherBean {

    private String code;
    private String cname;
    private String ename;
    private String icon;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "code='" + code + '\'' +
                ", cname='" + cname + '\'' +
                ", ename='" + ename + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
