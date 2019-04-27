package com.zhang.myapplication.http;

import okhttp3.Response;

/**
 * author:Created by WangZhiQiang on 2019/4/27.
 */
public interface IApiListener {
    void succeed(Response response);
    void failure(String e);
}
