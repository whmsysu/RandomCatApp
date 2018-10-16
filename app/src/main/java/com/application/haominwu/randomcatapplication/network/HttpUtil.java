package com.application.haominwu.randomcatapplication.network;


import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class HttpUtil {
    private static final HttpUtil ourInstance = new HttpUtil();

    public static final String BASE_URL = "https://aws.random.cat/";

    private static Retrofit retrofit;

    private static RandomCatService randomCatService;


    public static HttpUtil getInstance() {
        return ourInstance;
    }

    private HttpUtil() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        // add your other interceptors …

        // add logging as last interceptor
        httpClientBuilder.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClientBuilder.build())
                .build();

        randomCatService = retrofit.create(RandomCatService.class);

    }

    public Observable<ResponseBody> fetchACatApiCall(){
        return randomCatService.randomACat().subscribeOn(Schedulers.io());
    }
}
