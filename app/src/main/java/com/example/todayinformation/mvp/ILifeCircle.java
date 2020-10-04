package com.example.todayinformation.mvp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

public interface ILifeCircle {

    void onCreate(@Nullable Bundle savedInstanceState, Intent intent, Bundle getArgument);

    void onActivityCreated(@Nullable Bundle savedInstanceState, Intent intent, Bundle getArgument);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void destroyView();

    void onViewDestroy();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onSaveInstanceState(Bundle bundle);

    void attachView(IMvpView iMvpView);

}
