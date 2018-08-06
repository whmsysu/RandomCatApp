package com.application.haominwu.randomcatapplication.presenter;

import com.application.haominwu.randomcatapplication.view.CatImageDisplayView;
import com.application.haominwu.randomcatapplication.callback.GetACatCallback;
import com.application.haominwu.randomcatapplication.model.Cat;

public class BasePresenter {

    private Cat cat;
    private CatImageDisplayView baseView;

    public void createPresenter(CatImageDisplayView baseView) {
        this.baseView = baseView;
    }

    public void onDestroy() {
        this.baseView = null;
    }

    /**
     * Fetch a random cat
     */
    public void fetchRandomCat(){
        Cat.fetchCat(new GetACatCallback() {
            @Override
            public void onResponse(Cat nowCat) {
                cat = nowCat;
                if (baseView != null) baseView.updateImage(cat.getFile());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
