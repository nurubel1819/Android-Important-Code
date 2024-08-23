package com.example.all_in_one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Notification_Activity extends AppCompatActivity {

    private static String CHANNEL_ID = "My channel";
    private static final int MESSAGE_NOTIFICATION_ID = 100;
    Button btn_message_notification,btn_update_notification;
    Button btn_method_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // This code for permission form upper android version
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        {
            if(ContextCompat.checkSelfPermission(Notification_Activity.this,Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(Notification_Activity.this,new String[]{Manifest.permission.POST_NOTIFICATIONS},101);
            }
        }

        btn_message_notification = findViewById(R.id.id_message_notification);
        btn_update_notification = findViewById(R.id.id_update_notifacation);
        btn_method_notification = findViewById(R.id.id_method_notification);

        // code for convert icon PNG to Bitmap, Because notification must need Bitmap format
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.message_notification,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable)drawable;
        Bitmap notification_message_icon = bitmapDrawable.getBitmap();

        btn_method_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification_Activity.make_notification(Notification_Activity.this,2,"kaka","Move App ber","Go to app ber",notification_message_icon);
            }
        });

        // big picture style
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .setBigContentTitle("Update notification")
                .setSummaryText("Update summary")
                .bigPicture(notification_message_icon)
                .bigLargeIcon(notification_message_icon);

        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification message_notification;
        Notification update_notification;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    message_notification = new Notification.Builder(Notification_Activity.this)
                            .setLargeIcon(notification_message_icon)
                            .setSmallIcon(R.drawable.notification)
                            .setContentText("New message")
                            .setStyle(bigPictureStyle)
                            .setSubText("I Love You")
                            .setChannelId(CHANNEL_ID)
                            .build();
                    nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"Message notification",NotificationManager.IMPORTANCE_HIGH));
        }
        else
        {
            message_notification = new Notification.Builder(Notification_Activity.this)
                    .setLargeIcon(notification_message_icon)
                    .setSmallIcon(R.drawable.notification)
                    .setStyle(bigPictureStyle)
                    .setContentText("New message")
                    .setSubText("I Love You")
                    .build();
        }

        btn_message_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Notification_Activity.this,"click",Toast.LENGTH_SHORT).show();
                nm.notify(MESSAGE_NOTIFICATION_ID,message_notification);
            }
        });

        Intent intent = new Intent(getApplicationContext(),CardViewActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_MUTABLE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            update_notification = new Notification.Builder(Notification_Activity.this)
                    .setSmallIcon(R.drawable.tost_icon)
                    .setContentText("hello kaka")
                    .setSubText(" Uraaa")
                    .setChannelId("Rubel")
                    .setContentIntent(pendingIntent)
                    .setStyle(bigPictureStyle)
                    .setAutoCancel(true)
                    .build();
            nm.createNotificationChannel(new NotificationChannel("Rubel","Update notification",NotificationManager.IMPORTANCE_HIGH));
        }
        else
        {
            update_notification = new Notification.Builder(Notification_Activity.this)
                    .setSmallIcon(R.drawable.tost_icon)
                    .setContentText("hello kaka")
                    .setSubText(" Uraaa")
                    .setContentIntent(pendingIntent)
                    .setStyle(bigPictureStyle)
                    .setAutoCancel(true)
                    .build();
        }

        btn_update_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm.notify(6,update_notification);
            }
        });
    }

    public static void make_notification(Context context,int notification_id,String channel_id,String text,String sub_text,Bitmap bitmap_icon)
    {
        // This code for permission form upper android version
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        {
            if(ContextCompat.checkSelfPermission(context,Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions((Activity)context,new String[]{Manifest.permission.POST_NOTIFICATIONS},101);
            }
        }

        // set style and big picture
        // big picture style
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .setBigContentTitle("Big notification")
                .setSummaryText("Big summary")
                .bigPicture(bitmap_icon)
                .bigLargeIcon(bitmap_icon);


        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        Intent intent = new Intent(context,App_bar_Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,2,intent,PendingIntent.FLAG_MUTABLE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification = new Notification.Builder(context)
                    .setSmallIcon(R.drawable.delete_icon)
                    .setContentText(text)
                    .setSubText(sub_text)
                    .setChannelId(channel_id)
                    .setContentIntent(pendingIntent)
                    .setStyle(bigPictureStyle)
                    .setAutoCancel(true)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel(channel_id,"Rubel",NotificationManager.IMPORTANCE_HIGH));
        }
        else
        {
            notification = new Notification.Builder(context)
                    .setSmallIcon(R.drawable.delete_icon)
                    .setContentText(text)
                    .setSubText(sub_text)
                    .setContentIntent(pendingIntent)
                    .setStyle(bigPictureStyle)
                    .setAutoCancel(true)
                    .build();
        }
        notificationManager.notify(notification_id,notification);
    }
}