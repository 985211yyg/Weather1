package com.example.yungui.weather.anim;

import android.app.Activity;
import android.content.Context;

import com.example.yungui.weather.ui.nh.fragment.NHFirstFragment;
import com.sdsmdg.harjot.vectormaster.VectorMasterView;
import com.sdsmdg.harjot.vectormaster.models.ClipPathModel;
import com.sdsmdg.harjot.vectormaster.models.GroupModel;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yungui on 2017/8/17.
 */

public class Animation {

    int state = 0;
    float translationY = -24;
    float rotation = 0;
    /**
     * 加载动画
     * @param activity
     */
    public  void animateHourglass(final Activity activity, VectorMasterView hourglassView) {
        final GroupModel frame = hourglassView.getGroupModelByName("hourglass_frame");
        final GroupModel fillOutlines = hourglassView.getGroupModelByName("fill_outlines");
        final GroupModel fillOutlinesPivot = hourglassView.getGroupModelByName("fill_outlines_pivot");
        final GroupModel group_fill_path = hourglassView.getGroupModelByName("group_fill_path");

        ClipPathModel mask = hourglassView.getClipPathModelByName("mask_1");

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (state == 0) {    // Slide the clip-path down by changing translationY of parent group
                    translationY += 0.3f;
                    fillOutlinesPivot.setTranslateY(translationY);
                    group_fill_path.setTranslateY(-1 * translationY);
                    if (translationY >= -12) {
                        state = 1;
                    }
                } else if (state == 1) {    // Rotate the groups by 180 degress
                    rotation += 3f;
                    frame.setRotation(rotation);
                    fillOutlines.setRotation(rotation);
                    if (rotation == 180) {
                        state = 2;
                    }
                } else if (state == 2) {    // Slide the clip-path up by changing translationY of parent group
                    translationY -= 0.3f;
                    fillOutlinesPivot.setTranslateY(translationY);
                    group_fill_path.setTranslateY(-1 * translationY);
                    if (translationY <= -24) {
                        state = 3;
                    }
                } else if (state == 3) {    // Rotate the groups by 180 degress
                    rotation += 3f;
                    frame.setRotation(rotation);
                    fillOutlines.setRotation(rotation);
                    if (rotation == 360) {
                        rotation = 0;
                        state = 0;
                    }
                }
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        hourglassView.update();        // Update the view from the UI thread
                    }
                });
            }
        }, 500, 1000 / 60);
    }
}
