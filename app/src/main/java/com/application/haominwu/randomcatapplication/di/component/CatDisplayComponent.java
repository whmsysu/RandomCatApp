package com.application.haominwu.randomcatapplication.di.component;


import android.view.View;

import com.application.haominwu.randomcatapplication.activity.MainActivity;
import com.application.haominwu.randomcatapplication.di.module.CatDisplayModule;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = CatDisplayModule.class)
public interface CatDisplayComponent {
    void inject(MainActivity activity);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder rootView(View rootView);

        CatDisplayComponent build();
    }
}
