package com.example.all_in_one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dynamic_Fragment_Activity extends AppCompatActivity {

    Button first_fragment,second_fragment,third_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        first_fragment = findViewById(R.id.first);
        second_fragment = findViewById(R.id.second);
        third_fragment = findViewById(R.id.third);

        // true/false for check fragment already exist or not
        set_fragment(new Second_Dynamic_Fragment(),false);

        first_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                set_fragment(new First_Dynamic_Fragment(),true);
            }
        });

        second_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                set_fragment(new Second_Dynamic_Fragment(),true);
            }
        });

        third_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                set_fragment(new Third_Dynamic_Fragment(),true);
            }
        });
    }

    public void set_fragment(Fragment fragment,boolean flag)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(flag == false) fragmentTransaction.add(R.id.container,fragment);
        else fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.commit();
    }
}