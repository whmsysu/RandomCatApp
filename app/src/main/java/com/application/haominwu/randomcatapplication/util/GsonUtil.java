package com.application.haominwu.randomcatapplication.util;

import com.google.gson.Gson;

class GsonUtil {

    private static class GsonHolder{
        private static final Gson INSTANCE = new Gson();
    }


    public static Gson getInstance()
    {
        return GsonHolder.INSTANCE;
    }

}
