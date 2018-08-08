package com.application.haominwu.randomcatapplication.presenter;

import com.application.haominwu.randomcatapplication.model.Cat;
import com.application.haominwu.randomcatapplication.util.DataAgent;
import com.application.haominwu.randomcatapplication.view.CatImageDisplayView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class CatImagePresenter {

    private Cat cat;
    private CatImageDisplayView baseView;

    public CatImagePresenter(CatImageDisplayView baseView) {
        this.baseView = baseView;
    }

    public void onDestroy() {
        this.baseView = null;
    }

    /**
     * Fetch a random cat
     */
    public void fetchARandomCat(){
        this.baseView.showLoading();
        Observer<Cat> observer = new Observer<Cat>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Cat nowCat) {
                cat = nowCat;
                if (baseView != null) baseView.updateImage(cat.getFile());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        DataAgent.getInstance().getACat().subscribe(observer);
    }
}
