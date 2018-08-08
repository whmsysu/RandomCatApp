package com.application.haominwu.randomcatapplication.util;


import org.json.JSONObject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {
    private static final HttpUtil ourInstance = new HttpUtil();

    private static final OkHttpClient okHttpClient = new OkHttpClient();

    public static HttpUtil getInstance() {
        return ourInstance;
    }

    private HttpUtil() {

    }

    public Observable fetchACatApiCall(){
        Observable observable = Observable.create(new ObservableOnSubscribe<JSONObject>(){
            @Override
            public void subscribe(final ObservableEmitter<JSONObject> emitter) throws Exception {
                Request request = new Request.Builder().url("https://aws.random.cat/meow")
                        .get().build();
                Call call = okHttpClient.newCall(request);
                Response response = call.execute();
                JSONObject responseObject=new JSONObject(response.body().string());
                emitter.onNext(responseObject);
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.newThread());
        return observable;
    }
}
