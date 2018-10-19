package com.application.haominwu.randomcatapplication.network;

import com.application.haominwu.randomcatapplication.model.Cat;
import com.application.haominwu.randomcatapplication.util.GsonUtil;
import com.blankj.utilcode.util.NetworkUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
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
            return HttpUtil.getInstance().fetchACatApiCall().flatMap((Function<ResponseBody, Observable<Cat>>) responseBody -> {
                Cat cat = GsonUtil.getInstance().fromJson(responseBody.string(), Cat.class);
                Cat.saveACat(cat);
                Observable<Cat> observable = Observable.create(emitter -> {
                    emitter.onNext(cat);
                    emitter.onComplete();
                });
                observable.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
                return observable;
            });
        } else {
            return Observable.create(emitter -> {
                emitter.onNext(Cat.getACat());
                emitter.onComplete();
            });
        }
    }
}
