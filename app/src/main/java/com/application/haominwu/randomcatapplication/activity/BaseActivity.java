package com.application.haominwu.randomcatapplication.activity;

import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.application.haominwu.randomcatapplication.util.ActivityManager;
import com.noober.background.BackgroundLibrary;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        BackgroundLibrary.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        init();
        ActivityManager.pushActivity(this);

    }

    /**
     * Public function
     */
    protected void init(){

    }


    public abstract @LayoutRes int getLayoutResId();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.popActivity(this);
    }
}
