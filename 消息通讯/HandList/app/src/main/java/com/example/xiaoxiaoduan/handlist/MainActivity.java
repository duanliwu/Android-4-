package com.example.xiaoxiaoduan.handlist;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Context mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        /**使用Handler传递消息**/
        Button button = findViewById(R.id.home_btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,HandActivity.class);
                startActivity(intent);
            }
        });

        /***Notification传递消息***/
        Button button1 = findViewById(R.id.home_btn2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(mContext,NotificationActivity.class);
                startActivity(intent);
            }
        });

        /***activity传值***/
        Button button3 = findViewById(R.id.home_btn3);
        button3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,ShowActivity.class);
                //使用intent.putExtra()直接传递
                intent.putExtra("name","DLw");
                intent.putExtra("age",25);
                intent.putExtra("boy",true);

                /***把数值放进bundle 然后再把整个bundle通过intent.putExtra()传递***/
                Bundle bundle = new Bundle();
                bundle.putString("w_name","wm");
                bundle.putInt("w_age",24);
                bundle.putBoolean("w_boy",false);

                //这里把整个bundle 放进intent中
                intent.putExtras(bundle);
                //开启一个新的 activity 将intent传递过去
                startActivity(intent);

            }
        } );

    }
}
