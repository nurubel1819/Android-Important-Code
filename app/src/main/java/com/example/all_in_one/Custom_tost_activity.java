package com.example.all_in_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Custom_tost_activity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tost);
        button = findViewById(R.id.id_tost_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(getApplicationContext());
                View view = getLayoutInflater().inflate(R.layout.cust_tost,(ViewGroup)findViewById(R.id.id_tost_view));
                toast.setView(view);
                TextView textView = view.findViewById(R.id.id_tost_text);
                textView.setText("you click and update");
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}