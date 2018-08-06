package com.application.haominwu.randomcatapplication.util;

import com.application.haominwu.randomcatapplication.callback.GetACatCallback;
import com.application.haominwu.randomcatapplication.callback.HttpJSONCallback;
import com.application.haominwu.randomcatapplication.model.Cat;
import com.google.gson.Gson;

import org.json.JSONObject;

public class DataAgent {
    private static final DataAgent ourInstance = new DataAgent();

    public static DataAgent getInstance() {
        return ourInstance;
    }

    private DataAgent() {
    }

    /**
     * Fetch a cat api call
     */
    public static void fetchACat(final GetACatCallback getACatCallback){
        HttpUtil.getInstance().fetchCatApiCall(new HttpJSONCallback() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Gson gson = new Gson();
                Cat cat = gson.fromJson(jsonObject.toString(), Cat.class);
                getACatCallback.onResponse(cat);
            }

            @Override
            public void onFailure(Exception e) {
                getACatCallback.onFailure(e);
            }
        });
    }

}
