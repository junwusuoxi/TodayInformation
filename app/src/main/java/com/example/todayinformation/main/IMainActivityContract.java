package com.example.todayinformation.main;

import androidx.fragment.app.Fragment;

import com.example.todayinformation.mvp.ILifeCircle;
import com.example.todayinformation.mvp.IMvpView;
import com.example.todayinformation.mvp.MvpControler;

public interface IMainActivityContract {

    interface Iview extends IMvpView {

        void showFragment(Fragment mFragment);

        void addFragment(Fragment mFragment);

        void hideFragment(Fragment mFragment);
    }

    interface IPresenter extends ILifeCircle {

        void initHomeFragment();
        int getCurrentCheckedId();
        int getCurrentCheckedIndex();
        void replaceFragment(int mCurrentFragmentIndex);
        int getTopPostion();
        int getBottomPostion();

    }

    Iview emptyView = new Iview() {


        @Override
        public void showFragment(Fragment mFragment) {

        }

        @Override
        public void addFragment(Fragment mFragment) {

        }

        @Override
        public void hideFragment(Fragment mFragment) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };

}
