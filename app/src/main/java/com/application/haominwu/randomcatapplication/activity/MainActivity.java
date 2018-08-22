package com.application.haominwu.randomcatapplication.activity;


import com.application.haominwu.randomcatapplication.R;
import com.application.haominwu.randomcatapplication.presenter.CatDisplayPresenter;
import com.application.haominwu.randomcatapplication.view.CatDisplayView;


public class MainActivity extends BaseActivity {

    private CatDisplayView catDisplayView;

    private CatDisplayPresenter catDisplayPresenter;

    @Override
    protected void init() {
        super.init();
        catDisplayView = new CatDisplayView(this, findViewById(R.id.lr_cat_display));
        catDisplayPresenter = new CatDisplayPresenter(catDisplayView);
        catDisplayView.setCatImagePresenter(catDisplayPresenter);
    }


    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        catDisplayPresenter.dropView();
    }
}
