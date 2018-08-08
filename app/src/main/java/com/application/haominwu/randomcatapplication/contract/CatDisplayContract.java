package com.application.haominwu.randomcatapplication.contract;

import com.application.haominwu.randomcatapplication.presenter.BasePresenter;
import com.application.haominwu.randomcatapplication.view.BaseView;

public interface CatDisplayContract {

    interface View extends BaseView {
        void updateImage(String url);
        void showLoading();
    }

    interface Presenter extends BasePresenter<View> {
        void fetchARandomCat();
    }
}
