package com.application.haominwu.randomcatapplication.callback;

import org.json.JSONObject;

public interface HttpJSONCallback {
    void onResponse(JSONObject jsonObject);
    void onFailure(Exception e);
}
