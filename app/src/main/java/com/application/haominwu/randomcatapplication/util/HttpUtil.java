package com.application.haominwu.randomcatapplication.util;


import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class HttpUtil {
    private static final HttpUtil ourInstance = new HttpUtil();

    public static final String BASE_URL = "https://aws.random.cat/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    private static RandomCatService randomCatService = retrofit.create(RandomCatService.class);


    public static HttpUtil getInstance() {
        return ourInstance;
    }

    private HttpUtil() {

    }

    public Observable<ResponseBody> fetchACatApiCall(){
        return randomCatService.randomACat().subscribeOn(Schedulers.io());
    }
}
