package com.example.yungui.weather.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**  网络工具
 * Created by yungui on 2017/6/26.
 */

public class NetUtils {
    /**
     * 判断网络是否可用
     * @param context
     * @return
     */
    public static boolean isNetWorkReachable(Context context) {
        //获取系统的链接服务
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo == null) {
            return false;
        }
        //返回网络是否可用
        return networkInfo.isAvailable();
    }

}
