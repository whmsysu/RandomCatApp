package com.application.haominwu.randomcatapplication.di.module;

import android.view.View;

import com.application.haominwu.randomcatapplication.presenter.CatDisplayPresenter;
import com.application.haominwu.randomcatapplication.view.CatDisplayView;


import dagger.Module;
import dagger.Provides;

@Module
public class CatDisplayModule {

    private View mView;

    public CatDisplayModule(View view) {
        mView = view;
    }

    @Provides
    CatDisplayView provideCatDisplayView() {
        return new CatDisplayView(mView);
    }

    @Provides
    CatDisplayPresenter provideCatDisplayPresenter() {
        return new CatDisplayPresenter();
    }
}
