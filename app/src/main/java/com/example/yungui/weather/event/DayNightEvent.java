package com.example.yungui.weather.event;

/**
 * Created by yungui on 2017/9/7.
 */

public class DayNightEvent {
    private String DayAndNight;

    public DayNightEvent(String mode) {
        DayAndNight = mode;

    }

    public void setDayAndNight(String dayAndNight) {
        DayAndNight = dayAndNight;
    }

    public String getDayAndNight() {
        return DayAndNight;
    }
}
