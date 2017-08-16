package com.example.yungui.weather.modle.nh;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yungui on 2017/8/10.
 */

public class NH_IDList {

    /**
     * res : 0
     * data : ["3528","3520","3519","3517","3516","3515","3514","3513","3476","3505"]
     */

    private int res;
    private List<String> data;

    public static NH_IDList objectFromData(String str) {

        return new Gson().fromJson(str, NH_IDList.class);
    }

    public static NH_IDList objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), NH_IDList.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<NH_IDList> arrayNH_IDListFromData(String str) {

        Type listType = new TypeToken<ArrayList<NH_IDList>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public static List<NH_IDList> arrayNH_IDListFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<NH_IDList>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
