package com.application.haominwu.randomcatapplication.contract;

import android.support.annotation.UiThread;

import com.application.haominwu.randomcatapplication.presenter.BasePresenter;
import com.application.haominwu.randomcatapplication.view.BaseView;

public interface CatDisplayContract {

    interface View extends BaseView {
        @UiThread
        void updateCatImage(String url);
        @UiThread
        void showLoading();
    }

    interface Presenter extends BasePresenter<CatDisplayContract.View> {
        void fetchARandomCatOneByOne();
        void fetchARandomCatByTwoApiCall();
    }
}
