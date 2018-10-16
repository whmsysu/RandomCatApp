package com.application.haominwu.randomcatapplication.activity;

import android.content.Intent;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;
import com.application.haominwu.randomcatapplication.R;

public class SplashActivity extends BaseActivity {

    private Handler handler = new Handler();

    @Override
    protected void init() {
        super.init();

        // 为了减少代码使用匿名Handler创建一个延时的调用
        handler.postDelayed(() -> {
            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            //通过Intent打开最终真正的主界面Main这个Activity
            SplashActivity.this.startActivity(i);    //启动Main界面
            SplashActivity.this.finish();    //关闭自己这个开场屏
        }, 5000);   //5秒，够用了吧
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
