package com.example.xiaoxiaoduan.handlist;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {


//    TextView textView = findViewById(R.id.no_text);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        Button button = findViewById(R.id.no_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NotificationManager manager= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( "https://www.baidu.com" ) );
                PendingIntent pendingIntent =PendingIntent.getActivity( NotificationActivity.this,0,intent,0 );
                Notification notification =new NotificationCompat.Builder(NotificationActivity.this,"default")
                        .setContentTitle("测试notification")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.in)
                        .setContentIntent( pendingIntent )
                        .setLargeIcon( BitmapFactory.decodeResource( getResources(),R.drawable.in ))
                        .setWhen( System.currentTimeMillis() )
                        .build();
                manager.notify(1,notification);
            }
        });
    }
}
