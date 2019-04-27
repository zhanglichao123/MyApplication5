package com.zhang.myapplication.http;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * author:Created by WangZhiQiang on 2019/4/27.
 */
public class OkhttpC {
    private volatile static OkhttpC okhttpC;
    private  OkHttpClient builder;

    private OkhttpC() {

    }

    public static OkhttpC initOkhttpC() {
        if (okhttpC == null) {
            synchronized (OkhttpC.class) {
                if (okhttpC == null) {
                    okhttpC = new OkhttpC();
                }
            }
        }
        return okhttpC;
    }


    public void setOkhttpGet(String url,OkhttpCallBack callBack) {
        try {
            builder = new OkHttpClient.Builder()
                    .readTimeout(10000,TimeUnit.MILLISECONDS)
                    .connectTimeout(10000,TimeUnit.MILLISECONDS)
                    .writeTimeout(10000,TimeUnit.MILLISECONDS)
                    .build();
            Log.e("url",url);
            Request build = new Request.Builder().url(url).
                    build();
            builder.newCall(build).enqueue(callBack);

        }catch (Exception e){

        }

    }




}
