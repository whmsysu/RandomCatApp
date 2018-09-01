package com.application.haominwu.randomcatapplication.di.module;

import android.view.View;

import com.application.haominwu.randomcatapplication.di.qualifier.RootViewAnnotation;
import com.application.haominwu.randomcatapplication.presenter.CatDisplayPresenter;
import com.application.haominwu.randomcatapplication.view.CatDisplayView;


import dagger.Module;
import dagger.Provides;

@Module
public class CatDisplayModule {

    @Provides
    CatDisplayView provideCatDisplayView(@RootViewAnnotation View rootView) {
        return new CatDisplayView(rootView);
    }

    @Provides
    CatDisplayPresenter provideCatDisplayPresenter() {
        return new CatDisplayPresenter();
    }
}
