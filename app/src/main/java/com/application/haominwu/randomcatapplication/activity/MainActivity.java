package com.application.haominwu.randomcatapplication.activity;

import androidx.annotation.LayoutRes;
import hugo.weaving.DebugLog;

import com.application.haominwu.randomcatapplication.R;
import com.application.haominwu.randomcatapplication.di.component.DaggerCatDisplayComponent;
import com.application.haominwu.randomcatapplication.presenter.CatDisplayPresenter;
import com.application.haominwu.randomcatapplication.view.CatDisplayView;
import javax.inject.Inject;


public class MainActivity extends BaseActivity {

    @Inject
    CatDisplayPresenter catDisplayPresenter;

    @Inject
    CatDisplayView catDisplayView;

    @Override
    @DebugLog
    protected void init() {
        super.init();
        DaggerCatDisplayComponent.builder().rootView(findViewById(android.R.id.content)).build().inject(this);
        catDisplayPresenter.attachView(catDisplayView);
        catDisplayView.setPresenter(catDisplayPresenter);
    }


    @Override
    public @LayoutRes int getLayoutResId() {
        return R.layout.activity_main;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        catDisplayPresenter.detachView();
    }
}
