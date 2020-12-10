package com.puzhibin.meet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.puzhibin.framework.utils.LogUtils;
import com.puzhibin.framework.utils.TiemUtils;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        long timeMillis = System.currentTimeMillis();
        LogUtils.i(TiemUtils.convertDayOfWeek("",timeMillis));
    }
}