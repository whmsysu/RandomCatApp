package com.application.haominwu.randomcatapplication.util;

import com.application.haominwu.randomcatapplication.callback.HttpJSONCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

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

    /**
     *
     * @param httpJSONCallback
     */
    public void fetchCatApiCall(final HttpJSONCallback httpJSONCallback){
        Request request = new Request.Builder().url("https://aws.random.cat/meow")
                .get().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                httpJSONCallback.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    JSONObject responseObject=new JSONObject(response.body().string());
                    httpJSONCallback.onResponse(responseObject);
                } catch (JSONException e) {
                    httpJSONCallback.onFailure(e);
                }
            }
        });
    }
}
