package com.application.haominwu.randomcatapplication.util;

import android.app.Activity;

import java.util.HashSet;
import java.util.Set;

public class ActivityCollector {

    private static Set<Activity> activities = new HashSet<>();

    /**
     *
     * @param activity
     */
    public static void pushActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     *
     * @param activity
     */
    public static void popActivity(Activity activity) {
       activities.remove(activity);
    }

    /**
     *
     */
    public static void clearAllActivities() {
       activities.clear();
    }

}
