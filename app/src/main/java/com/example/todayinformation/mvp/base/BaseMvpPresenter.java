package com.example.todayinformation.mvp.base;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.todayinformation.mvp.IMvpView;
import com.example.todayinformation.mvp.presenter.LifeCircleMvpPresenter;

/*
p层中间类
 */

public abstract class BaseMvpPresenter<T extends IMvpView> extends LifeCircleMvpPresenter<T> {

    public BaseMvpPresenter(T view) {
        super(view);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, Intent intent, Bundle getArgument) {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState, Intent intent, Bundle getArgument) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void destroyView() {

    }

    @Override
    public void onViewDestroy() {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {

    }
}
