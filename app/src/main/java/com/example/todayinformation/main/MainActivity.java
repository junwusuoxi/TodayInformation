package com.example.todayinformation.main;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.example.todayinformation.R;
import com.example.todayinformation.base.BaseActivity;
import com.example.todayinformation.base.ViewInject;
import com.example.todayinformation.main.tools.MainConstantTool;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainlayoutid = R.layout.activity_main)

public class MainActivity extends BaseActivity implements IMainActivityContract.Iview{

    IMainActivityContract.IPresenter mPresenter = new MainActivityPresenter(this);


    @BindView(R.id.rb_main_shanghai)
    RadioButton rbMainShanghai;
    @BindView(R.id.rb_main_hangzhou)
    RadioButton rbMainHangzhou;
    @BindView(R.id.rg_main_top)
    RadioGroup rgMainTop;
    @BindView(R.id.fl_main_bottom)
    FrameLayout flMainBottom;
    @BindView(R.id.rb_main_beijing)
    RadioButton rbMainBeijing;
    @BindView(R.id.rb_main_shenzhen)
    RadioButton rbMainShenzhen;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;
    @BindView(R.id.fac_main_home)
    FloatingActionButton facMainHome;

    private boolean isChangeTopOrButtom;

    @Override
    public void afterBindView() {
        initHomeFragment();
        changAnima(rgMainBottom, rgMainTop);
        initCheckeListene();
    }

    private void initCheckeListene() {

        rbMainShanghai.setChecked(true);
        rgMainTop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mPresenter.getCurrentCheckedId()) {
                    return;
                }

                switch (checkedId) {
                    case R.id.rb_main_shanghai:
                        mPresenter.replaceFragment(MainConstantTool.SHANGHAI);
                        break;
                    case R.id.rb_main_hangzhou:
                        mPresenter.replaceFragment(MainConstantTool.HANGZHOU);
                        break;
                }
            }
        });

        rgMainBottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mPresenter.getCurrentCheckedId()) {
                    return;
                }

                switch (checkedId) {
                    case R.id.rb_main_beijing:
                        mPresenter.replaceFragment(MainConstantTool.BEIJING);
                        break;
                    case R.id.rb_main_shenzhen:
                        mPresenter.replaceFragment(MainConstantTool.SHENZHEN);
                        break;
                }
            }
        });

    }

    //初始化Fragment
    private void initHomeFragment() {

        mPresenter.initHomeFragment();

    }

    @OnClick(R.id.fac_main_home)
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fac_main_home:
                isChangeTopOrButtom = !isChangeTopOrButtom;

                if (isChangeTopOrButtom) {
                    changAnima(rgMainTop, rgMainBottom);
                    handleTopPostion();
                } else {
                    changAnima(rgMainBottom, rgMainTop);
                    handleBottomPostion();
                }

                break;
        }

    }

    //北京 深圳
    private void handleBottomPostion() {

        if (mPresenter.getTopPostion() != 1) {
            mPresenter.replaceFragment(MainConstantTool.SHANGHAI);
            rbMainShanghai.setChecked(true);
        } else {
            mPresenter.replaceFragment(MainConstantTool.HANGZHOU);
            rbMainHangzhou.setChecked(true);
        }
    }

    //上海 杭州
    private void handleTopPostion() {

        if (mPresenter.getBottomPostion() != 3) {
            mPresenter.replaceFragment(MainConstantTool.BEIJING);
            rbMainBeijing.setChecked(true);
        } else {
            mPresenter.replaceFragment(MainConstantTool.SHENZHEN);
            rbMainShenzhen.setChecked(true);
        }
    }

    private void changAnima(RadioGroup gone, RadioGroup show) {

//        消失的动画
        gone.clearAnimation(); //清除自身动画
        Animation animationGone = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_hide);
        gone.startAnimation(animationGone);
        gone.setVisibility(View.GONE);

//       展示动画
        show.clearAnimation();
        Animation animationShow = AnimationUtils.loadAnimation(this, R.anim.main_tab_translate_show);
        show.startAnimation(animationShow);
        show.setVisibility(View.VISIBLE);
    }

    @Override
    public void showFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().show(mFragment).commit();
    }

    @Override
    public void addFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content, mFragment).commit();
    }

    @Override
    public void hideFragment(Fragment mFragment) {
        getSupportFragmentManager().beginTransaction().hide(mFragment).commit();
    }
}