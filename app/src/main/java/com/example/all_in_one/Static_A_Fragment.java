package com.example.all_in_one;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Static_A_Fragment extends Fragment {


    public Static_A_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_static__a_, container, false);
        TextView textView = view.findViewById(R.id.text_A);
        textView.setText("B Fragment");
        return view;
    }
}