package com.zhang.myapplication.http;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * author:Created by WangZhiQiang on 2019/4/27.
 */
public abstract class OkhttpCallBack  implements Callback {
public abstract void  onSucceed(Call call, Response response);
public abstract void onFailures(Call call,IOException e);

    @Override
    public void onFailure(Call call, IOException e) {
        onFailures(call,e);
    }

    @Override
    public void onResponse(Call call, okhttp3.Response response) throws IOException {
        onSucceed(call,response);

    }
}
