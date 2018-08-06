package com.application.haominwu.randomcatapplication.util;

import com.application.haominwu.randomcatapplication.callback.OnCatRetrieveCallback;
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
    public static void fetchACat(final OnCatRetrieveCallback onCatRetrieveCallback){
        HttpUtil.getInstance().fetchCatApiCall(new HttpJSONCallback() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Gson gson = new Gson();
                Cat cat = gson.fromJson(jsonObject.toString(), Cat.class);
                onCatRetrieveCallback.onResponse(cat);
            }

            @Override
            public void onFailure(Exception e) {
                onCatRetrieveCallback.onFailure(e);
            }
        });
    }

}
