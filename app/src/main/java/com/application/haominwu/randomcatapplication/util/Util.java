package com.application.haominwu.randomcatapplication.util;

import android.content.Context;

public class Util {

    public static int convertDipOrPx(Context context, int dip) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dip*scale + 0.5f*(dip>=0?1:-1));
    }

    public static int convertPxOrDip(Context context, int px) {

        float scale = context.getResources().getDisplayMetrics().density;

        return (int)(px/scale + 0.5f*(px>=0?1:-1));

    }
}
