package com.example.all_in_one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Recycle_view_Activity extends AppCompatActivity {

    ArrayList<Contact_model> arr_contact = new ArrayList<>();
    RecycleContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(Recycle_view_Activity.this));

        FloatingActionButton btn_floating = findViewById(R.id.id_floating_button);

        btn_floating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(Recycle_view_Activity.this);
                dialog.setContentView(R.layout.daylog_contact);

                EditText contact_name = dialog.findViewById(R.id.id_contact_name);
                EditText contact_number = dialog.findViewById(R.id.id_contact_number);
                Button action_button = dialog.findViewById(R.id.id_update);

                action_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String st_contact_name = contact_name.getText().toString();
                        String st_contact_number = contact_number.getText().toString();
                        if(st_contact_name.equals(""))
                        {
                            Toast.makeText(Recycle_view_Activity.this,"Enter contact name",Toast.LENGTH_SHORT).show();
                        }
                        else if(st_contact_number.equals(""))
                        {
                            Toast.makeText(Recycle_view_Activity.this,"Enter Contact number",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            arr_contact.add(new Contact_model(st_contact_name,st_contact_number));
                            adapter.notifyItemInserted(arr_contact.size()-1);
                            recyclerView.scrollToPosition(arr_contact.size()-1);
                            dialog.dismiss();
                        }
                    }
                });
                dialog.show();
            }
        });

        arr_contact.add(new Contact_model(R.drawable.man,"man","01325698745"));
        arr_contact.add(new Contact_model(R.drawable.woman,"woman","01325698745"));
        arr_contact.add(new Contact_model(R.drawable.apu,"apu","01325698745"));
        arr_contact.add(new Contact_model(R.drawable.rubel,"rubel","01325698745"));
        arr_contact.add(new Contact_model(R.drawable.man,"man","01325698745"));
        arr_contact.add(new Contact_model(R.drawable.woman,"woman","01325698745"));
        arr_contact.add(new Contact_model(R.drawable.rubel,"rubel","01325698745"));
        arr_contact.add(new Contact_model(R.drawable.apu,"apu","01325698745"));

        for(int i=0;i<12;i++)
        {
            arr_contact.add(new Contact_model(R.drawable.apu,"Apu","01753278704"));
        }


        adapter = new RecycleContactAdapter(Recycle_view_Activity.this,arr_contact);
        recyclerView.setAdapter(adapter);
    }
}