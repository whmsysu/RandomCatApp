package com.application.haominwu.randomcatapplication.component;

import com.application.haominwu.randomcatapplication.activity.MainActivity;
import com.application.haominwu.randomcatapplication.module.MainModule;

import dagger.Component;

@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
