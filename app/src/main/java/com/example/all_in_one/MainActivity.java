package com.example.all_in_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_list_view,btn_theme,btn_card_view,btn_recycle_view,btn_app_bar,btn_custom_button;
    Button btn_custom_tost,btn_alert_dialog,btn_notification,btn_open_another_app,btn_fragments;
    Button btn_bottom_navigation,btn_drawer_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        take_all_id();// take component id
        button_click_work();
    }

    private void take_all_id()
    {
        btn_list_view = findViewById(R.id.btn_list_view);
        btn_theme = findViewById(R.id.btn_theme);
        btn_card_view = findViewById(R.id.card_view);
        btn_recycle_view = findViewById(R.id.btn_recycle_view);
        btn_app_bar = findViewById(R.id.id_app_bar);
        btn_custom_button = findViewById(R.id.id_custom_button);
        btn_custom_tost = findViewById(R.id.id_custom_tost);
        btn_alert_dialog = findViewById(R.id.id_alert_dialog);
        btn_notification = findViewById(R.id.id_notification);
        btn_open_another_app = findViewById(R.id.id_open_another_app);
        btn_fragments = findViewById(R.id.id_fragments);
        btn_bottom_navigation = findViewById(R.id.id_bottom_navigation);
        btn_drawer_layout = findViewById(R.id.drawer_layout);
    }
    private void button_click_work()
    {
        btn_list_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_list_view = new Intent(MainActivity.this,List_view_Activity.class);
                startActivity(intent_list_view);
            }
        });

        btn_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_theme = new Intent(MainActivity.this,ThemeActivity.class);
                startActivity(intent_theme);
            }
        });

        btn_card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_card_view = new Intent(MainActivity.this,CardViewActivity.class);
                startActivity(intent_card_view);
            }
        });

        btn_recycle_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_recycle_view = new Intent(MainActivity.this,Recycle_view_Activity.class);
                startActivity(intent_recycle_view);
            }
        });

        btn_app_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_app_bar = new Intent(MainActivity.this,App_bar_Activity.class);
                startActivity(intent_app_bar);
            }
        });

        btn_custom_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_custom_btn = new Intent(MainActivity.this,Custom_button_Activity.class);
                startActivity(intent_custom_btn);
            }
        });

        btn_custom_tost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_custom_tost = new Intent(getApplicationContext(), Custom_tost_activity.class);
                startActivity(intent_custom_tost);
            }
        });

        btn_alert_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_alert_dialog = new Intent(MainActivity.this,Alert_dialog_Activity.class);
                startActivity(intent_alert_dialog);
            }
        });

        btn_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_notification = new Intent(MainActivity.this,Notification_Activity.class);
                startActivity(intent_notification);
            }
        });

        btn_open_another_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Implicit_intent_Activity.class);
                startActivity(intent);
            }
        });

        btn_fragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,Fragments_Activity.class);
                startActivity(intent);
            }
        });

        btn_bottom_navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Bottom_Navigation_Activity.class);
                startActivity(intent);
            }
        });

        btn_drawer_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Drawer_layout_Activity.class);
                startActivity(intent);
            }
        });
    }
}