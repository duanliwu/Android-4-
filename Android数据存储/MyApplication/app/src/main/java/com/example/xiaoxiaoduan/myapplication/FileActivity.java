package com.example.xiaoxiaoduan.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends AppCompatActivity {

	String FILE_NAME = "a.text";

	/**File中储存数据的路径**/
	String DATA_URL = "/data/data/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.file);

		/***读取内容***/
		String content = loadFile();
		if (content == null){
		    content = "上次没有输入内容";
        }
        String str = "上次输入保存的内容为【"+content+"】";
		final EditText editText = findViewById(R.id.fileedit);
		editText.setHint(str);

		/***监听输入的内容点击保存到file文件中***/
		Button button = findViewById(R.id.filebtn);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				/***拿到用户输入的***/
				String content =editText.getText().toString();
				/***开始存入file***/
				saveFile(content);
                ShowDialog("保存File文件成功");
			}
		});

		/***监听按钮点击后清空file内容***/
		Button button1 = findViewById(R.id.filebtn1);
		button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanFile();
                ShowDialog("清空File文件成功");
            }
        });

        /**监听按钮点击后删除file文件**/
        Button button2 = findViewById(R.id.filebtn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                File file = new File(DATA_URL + getPackageName().toString()
                        + "/files", FILE_NAME);
                if (file.exists()) {
                    file.delete();
                }
                ShowDialog("删除file文件成功");
            }
        });
	}


    /***Java删除文件内容只有一种实现方法，就是把整个文件重写，只是把需要删除的那一条记录去除掉***/
	public void cleanFile(){
	    //如果只需要删除文件中的一部分内容则需要在这里对字符串做一些操作
        String cleanStr = "";
        try {
            FileOutputStream outStream = this.openFileOutput(FILE_NAME,
                    Context.MODE_WORLD_READABLE);
            outStream.write(cleanStr.getBytes());
            outStream.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

	public void saveFile(String str)
	{
		try{
            FileOutputStream outputStream = this.openFileOutput(FILE_NAME, Context.MODE_WORLD_READABLE);
            outputStream.write(str.getBytes());
            outputStream.close();
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String loadFile() {
        try {
            FileInputStream inStream = this.openFileInput(FILE_NAME);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = inStream.read(buffer)) != -1) {
                stream.write(buffer, 0, length);
            }
            stream.close();
            inStream.close();
            return stream.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
        return null;
    }


    public void ShowDialog(String str)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(FileActivity.this);
        builder.setIcon(R.drawable.in);
        builder.setTitle(str);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.show();

    }
}
