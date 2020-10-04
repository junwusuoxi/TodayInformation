package com.example.todayinformation.splash;

import com.example.todayinformation.mvp.ILifeCircle;
import com.example.todayinformation.mvp.IMvpView;
import com.example.todayinformation.mvp.MvpControler;

public interface ISplashActivityContract {

    interface Iview extends IMvpView {
        void setTvTimer(String timer);
    }

    interface IPresenter extends ILifeCircle {
        void initTime();
    }

    Iview emptyView = new Iview() {
        @Override
        public void setTvTimer(String timer) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };

}
