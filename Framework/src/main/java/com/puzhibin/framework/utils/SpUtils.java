package com.puzhibin.framework.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.puzhibin.framework.BuildConfig;

import cn.bmob.v3.http.bean.Sk;

/**
 * <p>Class: com.puzhibin.framework.utils.SpUtils</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author pu zhibin
 * @date 2020/12/11/14:44
 */


public class SpUtils {
    private SharedPreferences sp;
    private SharedPreferences.Editor mEditor;
    /**
     * key - values  存储方式
     * 它的存储路径：data/data/packageName/shared_prefs/sp_name.xml
     * file存储： /sdcard/读写方式不一样
     * 数据库： litePal
     * get、post ：数据的读写
     */
    private volatile static SpUtils mInstance = null;
    private SpUtils(){

    }
    public static SpUtils getInstance(){
        if (mInstance != null) {
            synchronized (SpUtils.class) {
                if (mInstance == null) {
                    mInstance = new SpUtils();
                }
            }
        }
        return mInstance;
    }

    public void initSp(Context mContext) {
        /**
         * mode_private: 只限于本应用读写
         * mode_world_readable: 支持其它应用读 但是不能写
         * mode_world_writeable: 其它应用可以写
         */
        sp = mContext.getSharedPreferences(BuildConfig.SP_NAME, Context.MODE_PRIVATE);
        mEditor=sp.edit();
    }

    public void putInt(String key, int values) {
        mEditor.putInt(key, values);
        mEditor.commit();
    }
    public int getInt(String key, int defValues) {
        return sp.getInt(key, defValues);
    }
    public void putString(String key, String values) {
        mEditor.putString(key, values);
        mEditor.commit();
    }
    public String getString(String key, String defValues) {
        return sp.getString(key, defValues);
    }
    public void putBoolean(String key, boolean values) {
        mEditor.putBoolean(key, values);
        mEditor.commit();
    }
    public boolean getBoolean(String key, boolean defValues) {
        return sp.getBoolean(key, defValues);
    }
    public void deleteKey(String key) {
        mEditor.remove(key);
        mEditor.commit();
    }
}
