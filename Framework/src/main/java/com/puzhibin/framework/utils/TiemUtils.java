package com.puzhibin.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
    private static final String TAG = "TimeUtil";


    public static final String FORMAT_DATE_EN = "yyyy-MM-dd";

    public static final String FORMAT_DATE_CN = "yyyy年MM月dd日";


    public static final String FORMAT_TIME_CN = "yyyy年MM月dd HH时mm分ss秒";

    public static final String FORMAT_TIME_CN_2 = "yyyy年MM月dd HH时mm分";

    public static final String FORMAT_TIME_EN = "yyyy-MM-dd HH:mm:ss";

    public static final String FORMAT_TIME_EN_2 = "yyyy-MM-dd HH:mm";


    public static final String FORMAT_DAY_CN = "HH时mm分ss秒";

    public static final String FORMAT_DAY_CN_2 = "HH时mm分";

    public static final String FORMAT_DAY_EN = "HH:mm:ss";

    public static final String FORMAT_DAY_EN_2 = "HH:mm";

    public static final String FORMAT_DAY_EN_3 = "mm:ss";


    private static final SimpleDateFormat SDF = new SimpleDateFormat(FORMAT_TIME_CN, Locale.CHINA);


    /**
     * 在之前
     */

    public static final int TIME_BEFORE = 1;

    /**
     * 在中间
     */

    public static final int TIME_ING = 2;

    /**
     * 在之后
     */

    public static final int TIME_AFTER = 3;

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
        return hours + ":" + minutes + ":" + seconds;
    }

    /**
     * long型时间转换
     *
     * @param longTime 长整型时间
     * @return 2013年7月3日 18:05(星期三)
     */

    public static String convertDayOfWeek(String timeFormat, long longTime) {

        Calendar c = Calendar.getInstance(); // 日历实例

        c.setTime(new Date(longTime));


        int year = c.get(Calendar.YEAR);

        int month = c.get(Calendar.MONTH);

        int date = c.get(Calendar.DATE);

        int hour = c.get(Calendar.HOUR_OF_DAY);

        String h = hour > 9 ? String.valueOf(hour) : "0" + hour;

        int minute = c.get(Calendar.MINUTE);

        String m = minute > 9 ? String.valueOf(minute) : "0" + minute;

        return String.format(Locale.getDefault(), timeFormat, year, month + 1, date, h, m,
                converToWeek(c.get(Calendar.DAY_OF_WEEK)));

    }

    /**
     * 转换数字的星期为字符串的
     *
     * @param w 星期
     * @return 星期x
     */

    private static String converToWeek(int w) {

        String week = null;


        switch (w) {

            case 1:

                week = "星期日";

                break;

            case 2:

                week = "星期一";

                break;

            case 3:

                week = "星期二";

                break;

            case 4:

                week = "星期三";

                break;

            case 5:

                week = "星期四";

                break;

            case 6:

                week = "星期五";

                break;

            case 7:

                week = "星期六";

                break;

        }


        return week;

    }

}
