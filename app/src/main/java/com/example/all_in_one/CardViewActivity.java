package com.example.all_in_one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;

public class CardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        CardView cardView = findViewById(R.id.card_view);
        cardView.setBackgroundColor(getResources().getColor(R.color.red));
    }
}