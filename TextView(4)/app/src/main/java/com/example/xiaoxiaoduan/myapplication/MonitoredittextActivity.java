package com.example.xiaoxiaoduan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MonitoredittextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monitoredittext);

        EditText editText = (EditText)findViewById(R.id.monitor_edit_text0);
        final TextView textView0 = (TextView)findViewById(R.id.monitor_text0);
        final TextView textView1 = (TextView)findViewById(R.id.monitor_text1);
        final TextView textView2 = (TextView)findViewById(R.id.monitor_text2);

        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                //text  输入框中改变后的字符串信息
                //start 输入框中改变后的字符串的起始位置
                //before 输入框中改变前的字符串的位置 默认为0
                //count 输入框中改变后的一共输入字符串的数量
                textView1.setText("输入后字符串 [ " + text.toString() + " ] 起始光标 [ " + start + " ] 输入数量 [ " + count+" ]");

            }

            @Override
            public void beforeTextChanged(CharSequence text, int start, int count,int after) {
                //text  输入框中改变前的字符串信息
                //start 输入框中改变前的字符串的起始位置
                //count 输入框中改变前后的字符串改变数量一般为0
                //after 输入框中改变后的字符串与起始位置的偏移量
                System.out.println(text.toString());
                textView0.setText("输入前字符串 [ " + text.toString() + " ]起始光标 [ " + start + " ]结束偏移量  [" + after + " ]");
            }

            @Override
            public void afterTextChanged(Editable edit) {
                //edit  输入结束呈现在输入框中的信息
                textView2.setText("输入结束后的内容为 [" + edit.toString()+" ] 即将显示在屏幕上");
            }
        });
    }
}
