package com.zhang.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.zhang.myapplication.http.IApiListener;
import com.zhang.myapplication.http.TextApi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
static Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);

    }
};
    private WeakReference<MainActivity> abcWeakRef;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        img = findViewById(R.id.tt);
        new TextApi().get(new IApiListener() {
            @Override
            public void succeed(Response response) {
                InputStream inputStream = response.body().byteStream();
                final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                abcWeakRef = new WeakReference<MainActivity>(MainActivity.this);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity mainActivity = abcWeakRef.get();
                        mainActivity.img.setImageBitmap(bitmap);
                    }
                });
                File file = new File(Environment.getExternalStorageDirectory(), "bbb.jpg");
                Log.e("图片地址",file.getPath());
                if (!file.exists()){
                }
                    try {
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        byte[] bytes=new byte[1024*1024*8];
                        int len=-1;
                        while ((len=inputStream.read(bytes))!=-1){
                            fileOutputStream.write(bytes,0,len);
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        Log.e("成功","asdas");
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.e("成功!!","asdas");
                    }



            }

            @Override
            public void failure(String e) {
                Log.e("失败",e);
            }
        });
    }

}
