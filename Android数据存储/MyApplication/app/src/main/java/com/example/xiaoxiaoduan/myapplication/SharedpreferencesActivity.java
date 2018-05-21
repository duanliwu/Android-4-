package com.example.xiaoxiaoduan.myapplication;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class SharedpreferencesActivity extends AppCompatActivity {


    /**使用SharedPreferences 来储存与读取数据**/
    SharedPreferences mShared = null;

    /**程序中可以同时存在多个SharedPreferences数据， 根据SharedPreferences的名称就可以拿到对象**/
    String SHARED_MAIN = "main";

    /**SharedPreferences中储存数据的Key名称**/
    String KEY_NAME = "name";
    String KEY_NUMBER = "number";

    /**SharedPreferences中储存数据的路径**/
    String DATA_URL = "/data/data/";
    String SHARED_MAIN_XML = "main.xml";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferences);

        /**拿到名称是SHARED_MAIN 的SharedPreferences对象**/
        mShared = getSharedPreferences(SHARED_MAIN, Context.MODE_PRIVATE);
        String name = mShared.getString(KEY_NAME,"数据库中没有存储姓名");
        String number = mShared.getString(KEY_NUMBER,"数据库中没有存储号码");

        final EditText editText = findViewById(R.id.spEt);
        final EditText editText1 = findViewById(R.id.spEtTwo);
        editText.setHint("上次输入的姓名为【"+name+"】");
        editText1.setHint("上次输入的号码为【"+number+"】");

        Button button =findViewById(R.id.btnOne);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**拿到用户输入的信息**/
                String name = editText.getText().toString();
                String number = editText1.getText().toString();
                /**开始保存入SharedPreferences**/
                SharedPreferences.Editor editor = mShared.edit();
                editor.putString(KEY_NAME,name);
                editor.putString(KEY_NUMBER,number);
                /**put完毕必需要commit()否则无法保存**/
                editor.commit();
                Toast.makeText(SharedpreferencesActivity.this, "保存SharedPreferences成功", Toast.LENGTH_SHORT).show();
                //返回上一个页面；只需要结束当前的activity
                finish();
            }
        });
        Button button1 = findViewById(R.id.btnTwo);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**开始清除SharedPreferences中保存的内容**/
                SharedPreferences.Editor editor = mShared.edit();
                editor.remove(KEY_NAME);
                editor.remove(KEY_NUMBER);
                editor.commit();
                ShowDialog("清除SharedPreferences数据成功");
            }
        });
        Button button2 = findViewById(R.id.btnthree);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** 删除SharedPreferences文件 **/
                File file = new File(DATA_URL + getPackageName().toString() + "/shared_prefs",SHARED_MAIN_XML);
                if (file.exists())
                {
                    file.delete();
                }
                ShowDialog("删除SharedPreferences文件成功");
            }
        });
    }

    public void  ShowDialog(String string){
        AlertDialog.Builder builder = new AlertDialog.Builder(SharedpreferencesActivity.this);
        builder.setIcon(R.drawable.in);
        builder.setTitle(string);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.show();
    }
}
