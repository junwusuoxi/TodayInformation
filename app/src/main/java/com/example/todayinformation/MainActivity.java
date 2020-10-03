package com.example.todayinformation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainlayoutid = R.layout.activity_main)

public class MainActivity extends BaseActivity {


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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changAnima(rgMainBottom, rgMainTop);

    }

    @OnClick(R.id.fac_main_home)
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.fac_main_home:
                isChangeTopOrButtom = !isChangeTopOrButtom;

                if (isChangeTopOrButtom) {
                    changAnima(rgMainTop, rgMainBottom);
                } else {
                    changAnima(rgMainBottom, rgMainTop);
                }

                break;
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
}