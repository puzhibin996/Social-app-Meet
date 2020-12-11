package com.puzhibin.framework.base;

import android.os.Bundle;

import com.puzhibin.framework.utils.SystemUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * <p>Class: com.puzhibin.framework.base.BaseUIActivity</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author pu zhibin
 * @date 2020/12/10/13:44
 */


public class BaseUIActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SystemUtils.fixSystemUI(this);
    }
}
