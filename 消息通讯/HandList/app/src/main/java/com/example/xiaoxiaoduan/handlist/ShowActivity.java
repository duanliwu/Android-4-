package com.example.xiaoxiaoduan.handlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.show );

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        //第二个参数为默认值 意思就是如果在intent中拿不到的话
        //就用默认值
        int age = intent.getIntExtra("age",0);
        boolean isboy = intent.getBooleanExtra( "boy",false );
        TextView textView = findViewById(R.id.sh_text);
        textView.setText( "姓名"+name + "年龄" + age + "男孩" + isboy);


        Bundle bundle = intent.getExtras();
        name = bundle.getString("w_name");
        //第二个参数为默认值 意思就是如果在bundle中拿不到的话
        //就用默认值
        age = bundle.getInt("w_age",0);
        isboy = bundle.getBoolean( "w_boy",false);
        TextView textView1 = findViewById(R.id.sh_text1);
        textView1.setText("姓名  " + name + "年龄 " + age + "男孩" + isboy);

    }
}
