package com.example.xiaoxiaoduan.handlist;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandActivity extends AppCompatActivity implements Runnable{

    /***更新时间***/
    public final static int UPDATE_TIME = 0;

    /*** 更新时间成功***/
    public final static int UPDATE_COMPLETED = 1;

    /***记录时间超过十秒就结束线程***/
    int mShowNumber = 0;

    /***标示线程开关***/
    boolean mRunning = true;

    //获取对象
    TextView textView = null;
    Button button = null;
    Thread thread;

    Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TIME:
                    textView.setText("正在更新时间" + msg.obj);
                    break;
                case UPDATE_COMPLETED:
                    textView.setText("更新完毕");
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hand);

        button = findViewById(R.id.handbtn);
        textView = findViewById(R.id.textview);
        textView.setText("点击按钮开始更新时间");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           mRunning = true;
                thread=new Thread(HandActivity.this);
                thread.start();
            }
        });
    }

    @Override
    public void run() {

        while (mRunning){
            mShowNumber++;
            Message message = new Message();
            if (mShowNumber <= 10){
                message.what = UPDATE_TIME;
            }else
            {
                mShowNumber =0;
                mRunning =false;
                message.what = UPDATE_COMPLETED;
            }
            message.obj = mShowNumber;
            handler.sendMessage(message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
