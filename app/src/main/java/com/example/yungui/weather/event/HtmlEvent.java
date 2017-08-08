package com.example.yungui.weather.event;

import java.util.ArrayList;
import java.util.List;

/** 储数据，配合EventBus，精测数据的变化
 * Created by yungui on 2017/8/2.
 */

public class HtmlEvent {
    public static final String TAG = HtmlEvent.class.getName();
    private List<String> htmlData = new ArrayList<>();
    private String html;
    private String from;

    public HtmlEvent(List<String> htmlData, String from) {
        this.htmlData = htmlData;
        this.html = html;
        this.from = from;
    }

    public HtmlEvent(String html, String from) {
        this.html = html;
        this.htmlData.add(html);
        this.from = from;
    }

    public List<String> getHtmlData() {
        return htmlData;
    }

    public void setHtmlData(List<String> htmlData) {
        this.htmlData = htmlData;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString() {
        return "HtmlEvent{" +
                "htmlData=" + htmlData +
                ", html='" + html + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
