package com.application.haominwu.randomcatapplication.activity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;
import com.application.haominwu.randomcatapplication.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void init() {
        super.init();
        LottieAnimationView animationView = findViewById(R.id.animation_view);
        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                //通过Intent打开最终真正的主界面Main这个Activity
                SplashActivity.this.startActivity(i);    //启动Main界面
                SplashActivity.this.finish();    //关闭自己这个开场屏
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
