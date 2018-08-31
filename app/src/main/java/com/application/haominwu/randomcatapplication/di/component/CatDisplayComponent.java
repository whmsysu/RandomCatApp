package com.application.haominwu.randomcatapplication.di.component;


import com.application.haominwu.randomcatapplication.activity.MainActivity;
import com.application.haominwu.randomcatapplication.di.module.CatDisplayModule;

import dagger.Component;

@Component(modules = CatDisplayModule.class)
public interface CatDisplayComponent {
    void inject(MainActivity activity);
}
