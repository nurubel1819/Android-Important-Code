package com.example.all_in_one;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class App_bar_Activity extends AppCompatActivity {

    Toolbar app_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar);

        app_bar = findViewById(R.id.id_app_bar);

        //step 1
        setSupportActionBar(app_bar);

        //step 2
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("App bar tittle");
        }
        //app_bar.setTitle("App bar tittle");
        app_bar.setSubtitle("App ber sub tittle");
    }
    //step 3

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();
        if(item_id==R.id.id_menu_new)
        {
            Toast.makeText(this,"Click new",Toast.LENGTH_SHORT).show();
        }
        else if(item_id==R.id.id_menu_open)
        {
            Toast.makeText(this,"Click open",Toast.LENGTH_SHORT).show();
        }
        else if(item_id==R.id.id_menu_save)
        {
            Toast.makeText(this,"Click Save",Toast.LENGTH_SHORT).show();
        }
        else if(item_id==android.R.id.home)
        {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}