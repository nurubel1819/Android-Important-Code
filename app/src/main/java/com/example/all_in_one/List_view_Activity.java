package com.example.all_in_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class List_view_Activity extends AppCompatActivity {

    Spinner spinner_select;
    AutoCompleteTextView suggest_option;
    ListView listView;
    ArrayList<String> arrayList_all_name = new ArrayList<>();
    ArrayList<String> arr_spinner = new ArrayList<>();
    ArrayList<String> arr_suggest_option = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.list_item);
        spinner_select = findViewById(R.id.id_spinner);
        suggest_option = findViewById(R.id.actv_sugg);

        fill_array();

        ArrayAdapter<String> adapter_spinner = new ArrayAdapter<>(List_view_Activity.this, android.R.layout.simple_spinner_dropdown_item,arr_spinner);
        spinner_select.setAdapter(adapter_spinner);

        ArrayAdapter<String> adapter_suggest_actv = new ArrayAdapter<>(List_view_Activity.this, android.R.layout.simple_list_item_1,arr_suggest_option);
        suggest_option.setAdapter(adapter_suggest_actv);
        suggest_option.setThreshold(1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(List_view_Activity.this, android.R.layout.simple_list_item_1,arrayList_all_name);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 2)
                {
                    Toast.makeText(List_view_Activity.this,"Click 2nd item",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void fill_array()
    {
        arr_spinner.add("CSE");
        arr_spinner.add("EEE");
        arr_spinner.add("ETE");
        arr_spinner.add("ICT");
        arr_spinner.add("MKT");
        arr_spinner.add("STA");
        arr_spinner.add("MAT");

        // auto complite text view
        arr_suggest_option.add("CSE");
        arr_suggest_option.add("EEE");
        arr_suggest_option.add("ETE");
        arr_suggest_option.add("ICT");
        arr_suggest_option.add("MKT");
        arr_suggest_option.add("STA");
        arr_suggest_option.add("MAT");

        for(int i=0;i<100;i++) arrayList_all_name.add("Student "+i);
    }
}