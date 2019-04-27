package com.zhang.myapplication.http;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * author:Created by WangZhiQiang on 2019/4/27.
 */
public abstract class ApiUtil {
    private IApiListener iApiListener=null;

  OkhttpCallBack okhttpCallBack=new OkhttpCallBack() {
      @Override
      public void onSucceed(Call call, Response response) {
          iApiListener.succeed(response);
      }

      @Override
      public void onFailures(Call call, IOException e) {
              iApiListener.failure(e.getMessage());
      }
  };
  public abstract String getUrl();
  public abstract void  getSucceed(IApiListener iApiListener);
  public  void get(IApiListener iApiListener){
     this. iApiListener=iApiListener;
      OkhttpC.initOkhttpC().setOkhttpGet(getUrl(),okhttpCallBack);
  }

}
