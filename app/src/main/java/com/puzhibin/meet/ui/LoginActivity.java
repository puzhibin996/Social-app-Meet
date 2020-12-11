package com.puzhibin.meet.ui;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.puzhibin.meet.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * <p>Class: com.puzhibin.meet.ui.LoginActivity</p>
 * <p>Description: </p>
 * <pre>
 *登录页
 * </pre>
 *
 * @author pu zhibin
 * @date 2020/12/11/13:55
 */


public class LoginActivity extends AppCompatActivity  {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_login);
    }
}
