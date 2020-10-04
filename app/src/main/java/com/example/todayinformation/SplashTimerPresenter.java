package com.example.todayinformation;

import android.util.Log;

import com.example.todayinformation.mvp.ISplashActivityContract;
import com.example.todayinformation.mvp.base.BaseMvpPresenter;
import com.example.todayinformation.mvp.IMvpView;

public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.Iview> implements ISplashActivityContract.IPresenter {
    private CustomCountDownTimer timer;

    public SplashTimerPresenter(ISplashActivityContract.Iview view) {
        super(view);
    }


    public void initTime() {


        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTvTimer(time + "秒");
            }

            @Override
            public void onFinish() {
                getView().setTvTimer("跳过");
            }


        });

        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
    }

    /*
    防止空指针
     */
    @Override
    protected ISplashActivityContract.Iview getEmptyView() {
        return ISplashActivityContract.emptyView;
    }
}
