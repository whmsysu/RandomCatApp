package com.application.haominwu.randomcatapplication.network;

import com.application.haominwu.randomcatapplication.model.Cat;
import com.application.haominwu.randomcatapplication.util.GsonUtil;
import com.blankj.utilcode.util.NetworkUtils;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class DataAgent {
    private static final DataAgent ourInstance = new DataAgent();

    public static DataAgent getInstance() {
        return ourInstance;
    }

    private DataAgent() {
    }

    public Observable<Cat> getACat() {
        if (NetworkUtils.isConnected()) {
            Observable observable = Observable.create((ObservableOnSubscribe<Cat>) emitter -> HttpUtil.getInstance().fetchACatApiCall().subscribe(new Observer<ResponseBody>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(ResponseBody responseBody) {
                    try {
                        Cat cat = GsonUtil.getInstance().fromJson(responseBody.string(), Cat.class);
                        Cat.saveACat(cat);
                        emitter.onNext(cat);
                        emitter.onComplete();
                    } catch (IOException e) {
                        emitter.onError(e);
                    }
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            })).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
            return observable;
        } else {
            return Observable.create(emitter -> emitter.onNext(Cat.getACat()));
        }
    }
}
