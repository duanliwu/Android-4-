package com.example.xiaoxiaoduan.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ArrayList mData = new ArrayList();
    SimpleListView simp;
    Map map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn);
        Button button1 = findViewById(R.id.btn1);
        Button button2 =findViewById(R.id.btn2);

          simp = findViewById(R.id.simp);
//简单的
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                new String[]{"姓名：dlw", "年龄：25", "现居住地：上海"}
        );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simp.setAdapter(arrayAdapter);
            }
        });

/******带标题的*****/
        for (int i = 0; i < 15; i++) {
            map = new HashMap<String, Object>();
            map.put("text1", "name" + i);
            map.put("text2", "name2" + i);
            map.put("img",R.drawable.in);
            mData.add(map);
        }
        final SimpleAdapter simpleAdapter = new SimpleAdapter(
                MainActivity.this,
                mData, android.R.layout.simple_list_item_2,
                new String[]{"text1", "text2"},
                new int[]{android.R.id.text1, android.R.id.text2});

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simp.setAdapter(simpleAdapter);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simp.setAdapter(new ButtonImage());

            }
        });

        simp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                Toast.makeText(MainActivity.this, "你选择的内容" + i, Toast.LENGTH_SHORT).show();
            }
        });

        simp.setAdapter(new ButtonImage());
    }


    static class ViewHolder
    {
        public ImageView image;
        public Button btnBotm;
        public TextView text;
        public TextView title;
    }
    public class ButtonImage extends BaseAdapter{

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int i) {
            return mData.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {

            ViewHolder holder = null;
            if (view == null){
                holder = new ViewHolder();
                view =  LayoutInflater.from(MainActivity.this).inflate(R.layout.iconlist,null);
                holder.image = view.findViewById(R.id.image);
                holder.btnBotm = view.findViewById(R.id.btnBotm);
                view.setTag(holder);
        }else
        {
            holder = (ViewHolder) view.getTag();
        }

        final Map map = (Map) mData.get(i);
        holder.image.setImageResource((Integer) map.get("img"));

        holder.btnBotm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, ""+i, Toast.LENGTH_SHORT).show();
                map.put("img",R.drawable.ic_launcher_background);
                notifyDataSetChanged();
            }
        });
                return view;
        }

    }

}
