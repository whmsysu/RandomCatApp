package com.application.haominwu.randomcatapplication.module;

import com.application.haominwu.randomcatapplication.contract.CatDisplayContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private final CatDisplayContract.View mView;

    public MainModule(CatDisplayContract.View view) {
        mView = view;
    }

    @Provides
    CatDisplayContract.View provideMainView() {
        return mView;
    }
}

