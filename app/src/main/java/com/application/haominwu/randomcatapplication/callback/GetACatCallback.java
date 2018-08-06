package com.application.haominwu.randomcatapplication.callback;

import com.application.haominwu.randomcatapplication.model.Cat;

public interface GetACatCallback {
    void onResponse(Cat cat);
    void onFailure(Exception e);
}
