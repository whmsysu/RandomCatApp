package com.application.haominwu.randomcatapplication.util;

import com.application.haominwu.randomcatapplication.model.Cat;
import com.google.gson.Gson;

import org.json.JSONObject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DataAgent {
    private static final DataAgent ourInstance = new DataAgent();

    public static DataAgent getInstance() {
        return ourInstance;
    }

    private DataAgent() {
    }

    public Observable getACat(){

        Observable observable = Observable.create(new ObservableOnSubscribe<Cat>(){
            @Override
            public void subscribe(final ObservableEmitter<Cat> emitter) throws Exception {
                HttpUtil.getInstance().fetchACatApiCall().subscribe(new Observer<JSONObject>(){
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JSONObject jsonObject) {
                        Gson gson = new Gson();
                        Cat cat = gson.fromJson(jsonObject.toString(), Cat.class);
                        emitter.onNext(cat);
                        emitter.onComplete();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
            }
        });
        return observable;
    }
}
