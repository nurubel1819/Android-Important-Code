package com.example.all_in_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URL;

public class Implicit_intent_Activity extends AppCompatActivity {

    Button btn_call,btn_message,btn_email,btn_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        btn_call = findViewById(R.id.id_call);
        btn_message = findViewById(R.id.id_message);
        btn_email = findViewById(R.id.id_email);
        btn_share = findViewById(R.id.id_share);

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_call = new Intent(Intent.ACTION_DIAL);
                intent_call.setData(Uri.parse("tel: 01749402012"));
                startActivity(intent_call);
            }
        });

        btn_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_message = new Intent(Intent.ACTION_SENDTO);
                intent_message.setData(Uri.parse("smsto:"+Uri.encode("01749402012")));
                intent_message.putExtra("sms_body","My name is Rubel");
                startActivity(intent_message);
            }
        });

        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_email = new Intent(Intent.ACTION_SEND);
                intent_email.setType("message/rfc822");
                intent_email.putExtra(Intent.EXTRA_EMAIL,new String[]{"ripon365cse@gmail.com","smanisbns@gmail.com"});
                intent_email.putExtra(Intent.EXTRA_SUBJECT,"Rubel");
                intent_email.putExtra(Intent.EXTRA_TEXT,"Hello Everyone");
                startActivity(Intent.createChooser(intent_email,"Email via"));
            }
        });

        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_share = new Intent(Intent.ACTION_SEND);
                intent_share.setType("text/plain");
                intent_share.putExtra(Intent.EXTRA_TEXT,"https://facebook.com/nu.rubel.7/");
                startActivity(Intent.createChooser(intent_share,"Share via"));
            }
        });
    }
}