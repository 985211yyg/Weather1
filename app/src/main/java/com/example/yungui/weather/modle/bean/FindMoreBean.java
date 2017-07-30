package com.example.yungui.weather.modle.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yungui on 2017/7/21.
 */

public class FindMoreBean {

    /**
     * id : 36
     * name : 鐢熸椿
     * alias : null
     * description : 鍖犲績銆佸仴搴枫�佺敓娲绘劅鎮�
     * bgPicture : http://img.kaiyanapp.com/924ebc6780d59925c8a346a5dafc90bb.jpeg
     * bgColor :
     * headerImage : http://img.kaiyanapp.com/a1a1bf7ed3ac906ee4e8925218dd9fbe.png
     */

    private int id;
    //类型名称
    private String name;
    private Object alias;
    private String description;
    private String bgPicture;
    private String bgColor;
    private String headerImage;

    public static FindMoreBean objectFromData(String str) {

        return new Gson().fromJson(str, FindMoreBean.class);
    }

    public static FindMoreBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), FindMoreBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<FindMoreBean> arrayFindMoreBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<FindMoreBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<FindMoreBean> arrayFindMoreBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<FindMoreBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getAlias() {
        return alias;
    }

    public void setAlias(Object alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBgPicture() {
        return bgPicture;
    }

    public void setBgPicture(String bgPicture) {
        this.bgPicture = bgPicture;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    @Override
    public String toString() {
        return "FindMoreBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alias=" + alias +
                ", description='" + description + '\'' +
                ", bgPicture='" + bgPicture + '\'' +
                ", bgColor='" + bgColor + '\'' +
                ", headerImage='" + headerImage + '\'' +
                '}';
    }
}
