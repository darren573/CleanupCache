package com.example.ewan.cleanupcache.activity;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */

public class ActivityCollector {
    private static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void deleteActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities
                ) {
            if (!activity.isFinishing())
                activity.finish();
        }
    }
}
