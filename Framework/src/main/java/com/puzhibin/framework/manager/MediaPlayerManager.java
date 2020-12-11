package com.puzhibin.framework.manager;

import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;

import com.puzhibin.framework.utils.LogUtils;

import java.io.IOException;

import androidx.annotation.NonNull;

/**
 * <p>Class: com.puzhibin.framework.manager.MediaPlayerManager</p>
 * <p>Description: </p>
 * <pre>
 *  媒体播放器
 * </pre>
 *
 * @author pu zhibin
 * @date 2020/12/10/13:55
 */


public class MediaPlayerManager {
    //播放
    public static final int MEDIA_STATUS_PLAY = 0;
    //暂停
    public static final int MEDIA_STATUS_PAUSE = 1;
    //停止
    public static final int MEDIA_STATUS_STOP = 2;
    public static  int MEDIA_STATUS = MEDIA_STATUS_STOP;
    private MediaPlayer mMediaPlayer;
    private OnMusicProgressListener mOnMusicProgressListener;
    private static final int H_PROGRESS = 1000;
    /**
     *1.计算歌曲时长进度：
     * 2.开始播放的时候就开启循环计算时长
     * 3.将进度条计算结果对外抛出
     */
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage( Message msg) {
            switch (msg.what) {
                case H_PROGRESS:
                    if (mOnMusicProgressListener != null) {
                        //拿到当前时长
                        int currentPosition = getCurrentPosition();
                        int pos = (int) (((float) currentPosition) / ((float) getDuration()) * 100);
                        mOnMusicProgressListener.OnProgress(currentPosition,pos);
                        mHandler.sendEmptyMessageDelayed(H_PROGRESS, 1000);
                    }
            }
            return false;
        }
    });
    public MediaPlayerManager(){
        mMediaPlayer = new MediaPlayer();
    }
    public boolean isPlaying(){
        return mMediaPlayer.isPlaying();
    }
    /**
     * 播放
     * @param path
     */
    public void startPlay(AssetFileDescriptor path){
        try {
            mMediaPlayer.reset();
            mMediaPlayer.setDataSource(path);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
            MEDIA_STATUS = MEDIA_STATUS_PLAY;
            mHandler.sendEmptyMessage(H_PROGRESS);
        } catch (IOException e) {
            LogUtils.e(e.toString());
            e.printStackTrace();
        }
    }

    /**
     * 播放
     * @param path
     */
    public void startPlay(String path){
        try {
            mMediaPlayer.reset();
            mMediaPlayer.setDataSource(path);
            mMediaPlayer.prepare();
            mMediaPlayer.start();
            MEDIA_STATUS = MEDIA_STATUS_PLAY;
            mHandler.sendEmptyMessage(H_PROGRESS);
        } catch (IOException e) {
            LogUtils.e(e.toString());
            e.printStackTrace();
        }
    }

    //暂停播放
    public void pausePlay(){
        if (isPlaying()) {
            mMediaPlayer.pause();
            MEDIA_STATUS=MEDIA_STATUS_PAUSE;
            mHandler.removeMessages(H_PROGRESS);
        }
    }
    //继续播放
    public void continuePlay(){
        mMediaPlayer.start();
        MEDIA_STATUS=MEDIA_STATUS_PLAY;
        mHandler.sendEmptyMessage(H_PROGRESS);
    }
    //停止播放
    public void stopPlay(){
        mMediaPlayer.start();
        MEDIA_STATUS=MEDIA_STATUS_STOP;
        mHandler.removeMessages(H_PROGRESS);

    }

    /**
     * 获取播放内容的当前播放位置
     * @return
     */
    public int getCurrentPosition(){
        return mMediaPlayer.getCurrentPosition();
    }

    /**
     * 获取播放内容时长
     * @return
     */
    public int getDuration(){
        return mMediaPlayer.getDuration();
    }

    /**
     * 是否循环
     * @param isLooping
     */
    public void setLooping(boolean isLooping){
        mMediaPlayer.setLooping(isLooping);
    }

    /**
     * 跳转进度
     * @param ms
     */
    public void seekTo(int ms) {
        mMediaPlayer.seekTo(ms);
    }
    /**
     * 播放结束
     * @param listener
     */
    public void setOnComplteionListener(MediaPlayer.OnCompletionListener listener) {
        mMediaPlayer.setOnCompletionListener(listener);
    }

    /**
     * 播放错误
     * @param listener
     */
    public void setOnErrorListener(MediaPlayer.OnCompletionListener listener) {
        mMediaPlayer.setOnCompletionListener(listener);
    }

    /**
     * 播放结束
     * @param listener
     */
    public void setOnProgressListener(OnMusicProgressListener listener) {
        mOnMusicProgressListener = listener;
    }
    public interface OnMusicProgressListener{
        void OnProgress(int progress,int pos);
    }
}
