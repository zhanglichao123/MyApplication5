package com.zhang.myapplication;

import android.app.Application;

import com.zhang.myapplication.http.OkhttpC;

/**
 * author:Created by WangZhiQiang on 2019/4/27.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkhttpC.initOkhttpC();
    }
}
