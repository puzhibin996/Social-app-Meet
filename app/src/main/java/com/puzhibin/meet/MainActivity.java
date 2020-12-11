package com.puzhibin.meet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;

import com.puzhibin.framework.base.BaseUIActivity;
import com.puzhibin.framework.manager.MediaPlayerManager;
import com.puzhibin.framework.utils.LogUtils;
import com.puzhibin.framework.utils.TiemUtils;

public class MainActivity extends BaseUIActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtils.i(TiemUtils.formatDuring(System.currentTimeMillis()));
        final MediaPlayerManager playerManager = new MediaPlayerManager();
        AssetFileDescriptor fileDescriptor = getResources().openRawResourceFd(R.raw.guide);
        playerManager.startPlay(fileDescriptor);
        playerManager.setOnProgressListener(new MediaPlayerManager.OnMusicProgressListener() {
            @Override
            public void OnProgress(int progress,int pos) {
//                LogUtils.e("progress:" + progress + "All:" + playerManager.getDuration());
//                int p = (int) (((float) progress) / ((float) playerManager.getDuration()) * 100);

            }
        });
    }
}