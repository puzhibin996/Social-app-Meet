package com.puzhibin.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * <p>Class: com.puzhibin.framework.utils.TiemUtils</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author pu zhibin
 * @date 2020/12/9/17:02
 */


public class TiemUtils {
    /**
     * 转换毫秒格式 HH：mm：ss
     * 1s=1000ms
     * 1m=60s
     * 1h=60m
     * 1h=24h
     * hours   minutes    seconds
     */
    public static String formatDuring(long ms) {
        long hours = (ms % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (ms % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (ms % (1000 * 60)) / 1000;
        String h = hours + "";
        if (hours < 10) {
            h = "0" + h;
        }
        String m = minutes + "";
        if (minutes < 10) {
            m = "0" + m;
        }
        String s = seconds + "";
        if (seconds < 10) {
            s = "0" + s;
        }
        TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
        TimeZone.setDefault(tz);
        return h + ":" + m + ":" + s;
    }

    /**
     * long型时间转换
     *
     * @param longTime 长整型时间
     * @return 2013年7月3日 18:05(星期三)
     */

}
