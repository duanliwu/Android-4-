package com.example.xiaoxiaoduan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KeyboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyboard);

        EditText editText = findViewById(R.id.txtTest0);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_GO)
                {
                    Toast.makeText(KeyboardActivity.this,"你点击了软键盘'去往'按钮",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        EditText editText1 = findViewById(R.id.txtTest1);
        editText1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        if (i == EditorInfo.IME_ACTION_SEARCH)
                        {
                            Toast.makeText(KeyboardActivity.this,"你点击了软键盘'搜索'按钮",Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
        EditText editText2 = findViewById(R.id.txtTest2);
        editText2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEND)
                {
                    Toast.makeText(KeyboardActivity.this,"你点击了软键盘'发送'按钮",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        EditText editText3 = findViewById(R.id.txtTest3);
        editText3.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_NEXT)
                {
                    Toast.makeText(KeyboardActivity.this,"你点击了软键盘'下一个'按钮",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        EditText editText4 = findViewById(R.id.txtTest4);
        editText4.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE)
                {
                    Toast.makeText(KeyboardActivity.this,"你点击了软键盘'完成'按钮",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        EditText editText5 = findViewById(R.id.txtTest5);
        editText5.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_UNSPECIFIED)
                {
                    Toast.makeText(KeyboardActivity.this,"你点击了软键盘'完成'未指定",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }
}
