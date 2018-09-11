package com.application.haominwu.randomcatapplication.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.application.haominwu.randomcatapplication.util.ActivityCollector;
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
        ActivityCollector.pushActivity(this);

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
        ActivityCollector.popActivity(this);
    }
}
