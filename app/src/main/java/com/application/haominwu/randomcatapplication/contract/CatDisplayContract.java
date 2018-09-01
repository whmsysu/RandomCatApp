package com.application.haominwu.randomcatapplication.contract;

import com.application.haominwu.randomcatapplication.presenter.BasePresenter;
import com.application.haominwu.randomcatapplication.view.BaseView;

public interface CatDisplayContract {

    interface IView extends BaseView {
        void updateCatImage(String url);
        void showLoading();
    }

    interface IPresenter extends BasePresenter<IView> {
        void fetchARandomCatOneByOne();
        void fetchARandomCatByTwoApiCall();
    }
}
