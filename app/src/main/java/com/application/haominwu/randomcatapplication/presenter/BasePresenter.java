package com.application.haominwu.randomcatapplication.presenter;

import com.application.haominwu.randomcatapplication.util.DataAgent;
import com.application.haominwu.randomcatapplication.view.CatImageDisplayView;
import com.application.haominwu.randomcatapplication.callback.OnCatRetrieveCallback;
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
    public void fetchARandomCat(){
        DataAgent.getInstance().fetchACat(new OnCatRetrieveCallback() {
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
