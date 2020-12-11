package com.puzhibin.meet.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.puzhibin.framework.entity.Constants;
import com.puzhibin.framework.utils.SpUtils;
import com.puzhibin.meet.MainActivity;
import com.puzhibin.meet.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * <p>Class: com.puzhibin.meet.ui.IndexActivity</p>
 * <p>Description: </p>
 * <pre>
 * 启动页
 * </pre>
 *
 * @author pu zhibin
 * @date 2020/12/11/13:54
 */


public class IndexActivity extends AppCompatActivity {
    /**
     * 1.启动页全屏
     * 2.延迟进入主页
     * 3.根据具体逻辑进入主页还是引导页还是登录页
     *
     * @param savedInstanceState
     */
    private static final int SKIP_MAIN = 1000;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case SKIP_MAIN:
                    startMain();
                    break;
            }
            return false;
        }
    } );

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        mHandler.sendEmptyMessageDelayed(SKIP_MAIN, 2 * 1000);
    }

    /**
     * 进入主页
     */
    private void startMain() {
        // 判断app是否第一次启动 install --first run
        boolean isFirstApp = SpUtils.getInstance().getBoolean(Constants.SP_IS_FIRST_APP, true);
        Intent intent = new Intent();
        if (isFirstApp) {
            //跳转到引导页
            intent.setClass(this, GuideActivity.class);
            //非第一次启动
            SpUtils.getInstance().putBoolean(Constants.SP_IS_FIRST_APP, false);
        } else {
            //如果非第一次启动，判断是否曾经登陆过
            String token = SpUtils.getInstance().getString(Constants.SP_TOKEN, "");
            if (TextUtils.isEmpty(token)) {
                //跳转登录页
                intent.setClass(this, LoginActivity.class);
            } else {
                //跳转到主页
                intent.setClass(this, MainActivity.class);
            }
        }
        startActivity(intent);
        finish();
    }
}
