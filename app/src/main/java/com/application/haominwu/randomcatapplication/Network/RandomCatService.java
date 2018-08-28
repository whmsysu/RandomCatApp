package com.application.haominwu.randomcatapplication.Network;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;


public interface RandomCatService {

    @GET("meow")
    Observable<ResponseBody> randomACat();
}
