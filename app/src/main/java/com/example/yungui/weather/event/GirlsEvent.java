package com.example.yungui.weather.event;

import android.util.Log;

import com.example.yungui.weather.modle.Girls;

import java.util.ArrayList;
import java.util.List;

/**   存储数据，配合EventBus，精测数据的变化
 * Created by yungui on 2017/6/29.
 */

public class GirlsEvent {
    public static final String TAG = GirlsEvent.class.getSimpleName();
    private Girls girls;
    private List<Girls> girlsList=new ArrayList<>();
    private String from;

    /**
     * 构造方法
     * @param girlsList
     * @param from
     */
    public GirlsEvent(List<Girls> girlsList, String from) {
        this.girlsList = girlsList;
        this.from = from;
        Log.e(TAG, "GirlsEvent: ");
    }
    /*

     构造方法
     */
    public GirlsEvent(Girls girls, String from) {
        this.girls = girls;
        this.from = from;
        this.girlsList.add(girls);
    }

    public Girls getGirls() {
        return girls;
    }

    public void setGirls(Girls girls) {
        this.girls = girls;
    }

    public List<Girls> getGirlsList() {
        return girlsList;
    }

    public void setGirlsList(List<Girls> girlsList) {
        this.girlsList = girlsList;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
