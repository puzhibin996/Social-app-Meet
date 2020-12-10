package com.puzhibin.framework.utils;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.puzhibin.framework.BuildConfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Class: com.puzhibin.framework.utils.LogUtils</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author pu zhibin
 * @date 2020/12/9/15:08
 */


public class LogUtils {
    /**
     * log不光作为日志的打印，还可以记录日志 --》file
     */
    private static SimpleDateFormat sSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void i(String text) {
        if (BuildConfig.LOG_DEBUG) {
            if (!TextUtils.isEmpty(text)) {
                Log.i(BuildConfig.LOG_TAG, text);
                writeToFile(text);
            }
        }
    }

    public static void e(String text) {
        if (BuildConfig.LOG_DEBUG) {
            if (!TextUtils.isEmpty(text)) {
                Log.e(BuildConfig.LOG_TAG, text);
                writeToFile(text);
            }
        }
    }

    //写入内存卡里面
    public static void writeToFile(String text) {
        //开始写入
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        //文件路径
        String fileRoot = Environment.getExternalStorageDirectory().getParent() + "/Meet/";
        String fileName = "/sdcard/Meet/Meet.log";
        //时间+ 内容
        String log = sSimpleDateFormat.format(new Date()) + "" + text+"\n";
        //检查父路径
        File fileGroup = new File("/sdcard/Meet/");
        if (!fileGroup.exists()) {
            fileGroup.mkdirs();
        }
        try {
            fileOutputStream = new FileOutputStream(fileName, true);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, Charset.forName("GBK")));
            bufferedWriter.write(log);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //创建根布局

        //创建文件

        //编码问题 gbk 正确的存入中文


    }
}
