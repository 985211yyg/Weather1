package com.example.yungui.weather.modle;

/**
 * Created by yungui on 2017/6/23.
 */

public class WeatherBean {

    private String code;//天气类型编号
    private String cname;//天气名称
    private String ename;//对应英文
    private String icon;//对应图标链接

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
