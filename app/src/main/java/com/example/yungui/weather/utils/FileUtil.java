package com.example.yungui.weather.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.example.yungui.weather.App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 文件工具
 * Created by yungui on 2017/6/26.
 */

public class FileUtil {
    /**
     * 获取当前app的缓存目录
     *
     * @param context 上下写文环境
     * @return
     */
    public static String getAppCacheDir(Context context) {
        String dir = null;
        //获取不可故管理的外部缓存目录
        if (context.getExternalCacheDir() != null && isExistSDCard()) {
            return context.getExternalCacheDir().toString();
        } else {
            //返回可管理的内存缓存目录，当时当程序被卸载时或者运行内存低时会被删除
            return context.getCacheDir().toString();
        }
    }

    private static boolean isExistSDCard() {
        //判断外部存储是否已经挂载
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 获取内部不可管理的缓存目录，动态删除
     *
     * @param context
     * @return
     */
    public static String getInternalCacheDir(Context context) {
        return context.getCacheDir().toString();
    }

    /**
     * 返回不可管理的外部缓存目录
     *
     * @param context
     * @return
     */
    public static String getExternalCacheDir(Context context) {
        if (context.getExternalCacheDir() != null && isExistSDCard()) {
            return context.getExternalCacheDir().toString();
        }
        return null;
    }

    /**
     * 删除给定文件路径的文件
     *
     * @param filePath 文件路径
     * @return boolean 是否已经删除
     */
    public static boolean delete(String filePath) {
        if (filePath != null) {
            return delete(new File(filePath));
        }
        return false;
    }

    /**
     * 删除指定的文件
     *
     * @param file
     * @return
     */
    public static boolean delete(File file) {
        //如给定的文件时单纯文件则直接删除
        if (file.isFile()) {
            return file.delete();
        }
        //如果是文件夹，首先哦判断是不是空文件夹，
        //是的话直接删除，不是的话遍历文件，逐一删除里卖弄的文件
        if (file.isDirectory()) {
            File[] childFiles = file.listFiles();
            //空文件夹，直接删除
            if (childFiles.length == 0 || childFiles == null) {
                file.delete();
            }
            for (File childFile : childFiles) {
                //递归调用，遍历所有文件目录
                delete(childFile);
            }
            return file.delete();
        }
        return false;
    }

    /**
     * 获取文件夹的名字
     *
     * @param filePath 文件路径
     * @return
     */
    public static String getFolderName(String filePath) {
        //如果是空的文件路径则直接返路径
        if (TextUtils.isEmpty(filePath)) {
            return filePath;
        }
        //获取文件分隔符所在的位置,没有文件分割付返回-1
        int filePosition = filePath.indexOf(File.separator);
        //获取文件分隔符之前的文件字符串就是文件夹的名字
        return (filePosition == -1) ? "" : filePath.substring(0, filePosition);
    }

    /**
     * 根据给定的路径创建文件夹
     *
     * @param filepath 文件路径
     * @return
     */
    public static boolean makeDirs(String filepath) {
        //首先获取文件名
        String folderName = getFolderName(filepath);
        //如果为空创建失败
        if (TextUtils.isEmpty(folderName)) {
            return false;
        }
        //如文件夹已经存在直接返回true，否则创建文件夹
        File folder = new File(folderName);
        return (folder.exists() || folder.isDirectory()) ? true : folder.mkdirs();

    }

    /**
     * 写入文件
     *
     * @param filePath 文件的写入路径
     * @param content  需要写入的内容
     * @param append   是否以添加的形式写入文件
     * @return
     */
    public static boolean writeFiles(String filePath, String content, boolean append) {
        //如果写入路径为空则返货false
        if (TextUtils.isEmpty(filePath)) {
            return false;
        }
        FileWriter fileWriter = null;
        //根据路径创建文件
        makeDirs(filePath);
        try {
            fileWriter = new FileWriter(filePath, append);
            fileWriter.write(content);
            fileWriter.write("\r\n");
            fileWriter.write("\r\n");
            fileWriter.close();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("IOException", e.getMessage(), e);
            return false;
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("IOException", e.getMessage(), e);
                }
            }
        }
    }

    /**
     * 读取文件
     *
     * @param filePath 文件路径
     * @return
     */
    public static String readFile(String filePath) {
        //创建文件夹
        File file = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder("");
        //如果文件不是普通的文件则直接返回null
        //文件夹是不能直接读取内容的
        if (!file.isFile()) {
            return null;
        }

        BufferedReader reader = null;
        //获取输入流,以app为中，app从设备获得的内容为输入流read，
        // app从输出到硬件设备的内容为输出流write
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
            //包装成buffereader
            reader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                //如果读取的内容不是 “”则说明里面已经you内容了
                if (!stringBuilder.toString().equals("")) {
                    stringBuilder.append("\r\n");
                }
                //开始写入数据
                stringBuilder.append(line);
            }
            reader.close();
            inputStreamReader.close();
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void writeLogCashContent(String content) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                FileUtil.writeFiles(getFileDir("log") + "crash.log", TimeUtils.getCurTimeString() + content, true);
            }
        }).start();
    }

    public static String getFileDir(String filePath) {
        String dir;
        //如果挂在了外部存储,获取存储根目录
        if (isExistSDCard()) {
            dir = App.getContext().getExternalFilesDir("").getAbsolutePath();

        } else {
            //获取内存存储根目录
            dir = App.getContext().getFilesDir().getAbsolutePath();
        }
        //入如果给出的路径是空的，直接返回存储根目录
        if (TextUtils.isEmpty(filePath))
            return dir;

        //以分隔符来头  File.separator----> " \ "
        if (filePath.startsWith(File.separator)) {
            //根目录+以\开头的文件目录
            dir += filePath;
        } else {
            //根目录+\+个定目录
            dir = File.separator + filePath;
        }
        //创建文件夹
        FileUtil.makeDirs(dir);
        return dir;
    }

    /**
     * 根据图片名字获取图片id
     * @param imageName
     * @param context
     * @return
     */
    public static int getResource(String imageName, Context context) {
        int resId = context.getResources()
                .getIdentifier(imageName, "drawable", context.getPackageName());
        return resId;
    }

    /**
     * 根据名字从Assets中读取图片
     * @param fileName
     * @return
     */
    public static Bitmap getImageFromAssetsFile(String fileName,Context context )
    {
        Bitmap image = null;
        AssetManager am =context.getResources().getAssets();
        try
        {
            InputStream is = am.open(fileName);
            image = BitmapFactory.decodeStream(is);
            is.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return image;

    }

}




