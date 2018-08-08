package com.application.haominwu.randomcatapplication.util;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import okhttp3.Call;
import okhttp3.Callback;
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
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        emitter.onError(e);
                        emitter.onComplete();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        try {
                            JSONObject responseObject=new JSONObject(response.body().string());
                            emitter.onNext(responseObject);
                            emitter.onComplete();
                        } catch (JSONException e) {
                            emitter.onError(e);
                            emitter.onComplete();
                        }
                    }
                });
            }
        });
        return observable;
    }
}
