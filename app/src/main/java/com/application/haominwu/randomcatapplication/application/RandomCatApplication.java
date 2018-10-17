package com.application.haominwu.randomcatapplication.application;

import android.app.Application;

import com.application.haominwu.randomcatapplication.network.HttpUtil;
import com.blankj.utilcode.util.Utils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

import org.litepal.LitePal;


public class RandomCatApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
        Utils.init(this);
        LitePal.initialize(this);
        if (!LeakCanary.isInAnalyzerProcess(this)) {
            LeakCanary.install(this);
        }
        HttpUtil.init(this);
    }
}
