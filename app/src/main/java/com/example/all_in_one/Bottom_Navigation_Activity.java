package com.example.all_in_one;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Bottom_Navigation_Activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        bottomNavigationView = findViewById(R.id.id_bottom_navigation_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int item_id = item.getItemId();
                if(item_id == R.id.bottom_home)
                {
                    set_fragment(new Third_Dynamic_Fragment(),false);
                }
                else if(item_id == R.id.bottom_friends)
                {
                    set_fragment(new Second_Dynamic_Fragment(),false);
                }
                else if(item_id == R.id.bottom_upload)
                {
                    set_fragment(new First_Dynamic_Fragment(),false);
                }
                else if(item_id == R.id.id_inbox)
                {
                    set_fragment(new Static_A_Fragment(),false);
                }
                else
                {
                    set_fragment(new Static_B_Fragment(),true);
                }
                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.bottom_profile);
    }
    private void set_fragment(Fragment fragment,boolean flag)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(flag)
        {
            fragmentTransaction.replace(R.id.id_container,fragment);
        }
        else
        {
            fragmentTransaction.add(R.id.id_container,fragment);
        }
        fragmentTransaction.commit();
    }
}