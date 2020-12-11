package com.puzhibin.framework.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;

/**
 * <p>Class: com.puzhibin.framework.utils.SystemUtils</p>
 * <p>Description: </p>
 * <pre>
 * 沉浸式状态栏实现
 * </pre>
 *
 * @author pu zhibin
 * @date 2020/12/10/13:40
 */


public class SystemUtils {

    public static void fixSystemUI(Activity mActivity) {
        //android 5.0适配
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //获取最顶层的view
            mActivity.getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            mActivity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
