package com.application.haominwu.randomcatapplication.model;

import com.application.haominwu.randomcatapplication.callback.GetACatCallback;
import com.application.haominwu.randomcatapplication.callback.HttpJSONCallback;
import com.application.haominwu.randomcatapplication.util.HttpUtil;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;

import org.json.JSONObject;

public class Cat {

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @SerializedName("file")
    private String file;


    /**
     * Fetch a cat api call
     */
    public static void fetchCat(final GetACatCallback getACatCallback){
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
