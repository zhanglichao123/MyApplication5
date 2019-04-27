package com.zhang.myapplication.http;

/**
 * author:Created by WangZhiQiang on 2019/4/27.
 */
public class TextApi extends ApiUtil {
    @Override
    public String getUrl() {
        return "http://g.hiphotos.baidu.com/zhidao/pic/item/1e30e924b899a901da2aece318950a7b0308f5cc.jpg";
    }

    @Override
    public void getSucceed(IApiListener iApiListener) {

    }

}
