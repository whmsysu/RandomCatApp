package com.application.haominwu.randomcatapplication.presenter;

import com.application.haominwu.randomcatapplication.view.BaseView;

public interface BasePresenter <V extends BaseView>{
    void attachView(V view);
    void dropView();
}
