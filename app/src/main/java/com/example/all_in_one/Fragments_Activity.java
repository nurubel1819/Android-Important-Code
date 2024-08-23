package com.example.all_in_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fragments_Activity extends AppCompatActivity {
    Button btn_static_fragment,btn_dynamic_fragment,btn_tab_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        btn_static_fragment = findViewById(R.id.static_fragment);
        btn_dynamic_fragment = findViewById(R.id.dynamic_fragment);
        btn_tab_layout = findViewById(R.id.tab_layout);

        btn_static_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fragments_Activity.this,Static_Fragment_Activity.class);
                startActivity(intent);
            }
        });

        btn_dynamic_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fragments_Activity.this,Dynamic_Fragment_Activity.class);
                startActivity(intent);
            }
        });

        btn_tab_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fragments_Activity.this,Tab_Layout_Activity.class);
                startActivity(intent);
            }
        });
    }
}