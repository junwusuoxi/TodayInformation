package com.example.todayinformation.splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.example.todayinformation.base.BaseActivity;
import com.example.todayinformation.main.MainActivity;
import com.example.todayinformation.R;
import com.example.todayinformation.base.ViewInject;

import java.io.File;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.activity_splash)

public class SplashActivity extends BaseActivity implements ISplashActivityContract.Iview {


    @BindView(R.id.vv_play)
    FullScreenVideoView mVideoView;
    @BindView(R.id.tv_splash_timer)
    TextView mTvTimer;

    private ISplashActivityContract.IPresenter timerPresennter;

    @Override
    public void afterBindView() {

        initTimePresenter();

        initLitener();
        initVideo();
    }

    private void initTimePresenter() {

        timerPresennter = new SplashTimerPresenter(this);
        timerPresennter.initTime();

    }

    private void initVideo() {
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

    }

    private void initLitener() {

        mTvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        });

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

    }

    @Override
    public void setTvTimer(String s) {
        mTvTimer.setText(s);
    }
}
