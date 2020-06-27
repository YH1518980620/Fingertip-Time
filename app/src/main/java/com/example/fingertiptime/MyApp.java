package com.example.fingertiptime;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 如果未勾选自动登录，则重置userInfo
        SharedPreferences prefs = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        if (!prefs.getBoolean("ISCHECK", true)) {
            prefs.edit().clear().commit();
        }
    }
}