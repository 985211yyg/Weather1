package com.example.yungui.weather.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.example.yungui.weather.event.GirlsEvent;
import com.example.yungui.weather.modle.Girls;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by yungui on 2017/6/29.
 * 通过传递过来的数据，计算出图片的大小，然后给定设置，
 * 之后通过时间的发送通知时间的订阅者
 */

public class GirlServer extends IntentService {
    private static final String KEY_EXTRA_GIRLS_FROM = "from";
    private static final String KEY_EXTRA_GIRLS_GIRLS = "girls";
    public static final String TAG = GirlServer.class.getSimpleName();

    public GirlServer() {
        super("GirlServer");
    }

    /**
     * 对外的方法用于启动服务
     *
     * @param context
     * @param from
     * @param girls
     */
    public static void start(Context context, String from, List<Girls> girls) {
        Intent intent = new Intent(context, GirlServer.class);
        intent.putExtra(KEY_EXTRA_GIRLS_FROM, from);
        //注意此处传递集合数据，需要进行序列化，并且原始数据也要进行序列化
        intent.putExtra(KEY_EXTRA_GIRLS_GIRLS, (Serializable) girls);
        context.startService(intent);
        Log.e(TAG, "服务已经启动");

    }

    /**
     * 停止服务
     *
     * @param context
     */
    public static void stop(Context context) {
        context.stopService(new Intent(context, GirlServer.class));
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String from = intent.getStringExtra(KEY_EXTRA_GIRLS_FROM);
        Log.e(TAG, from);
        List<Girls> mGirls = (List<Girls>) intent.getSerializableExtra(KEY_EXTRA_GIRLS_GIRLS);
        //根据获得数据，计算图片的大小，并设置数据
        Bitmap bitmap = null;
        Log.e(TAG, "开始处理图片,图片数量为：" + mGirls.size() + mGirls.toString());
        for (final Girls girl : mGirls) {
            try {
                bitmap = Glide.with(GirlServer.this)
                        .load(girl.getUrl())
                        .asBitmap()
                        //磁盘缓存
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .get();

            } catch (InterruptedException e) {
                e.printStackTrace();
                Log.e(TAG, "处理图片出错: " + e.toString());
            } catch (ExecutionException e) {
                e.printStackTrace();
                Log.e(TAG, "处理图片出错: " + e.toString());

            }
            //设置图片的大小
            if (bitmap != null) {
                girl.setHeight(bitmap.getHeight());
                girl.setWidth(bitmap.getWidth());
                Log.e(TAG, "图片处理完成！");
            }
//            toGirls.add(girl);
            //通知观察者数据发生改变
            EventBus.getDefault().post(new GirlsEvent(girl, from));
        }
        Log.e(TAG, "已经通知观察者！" + mGirls.toString());

    }
}
