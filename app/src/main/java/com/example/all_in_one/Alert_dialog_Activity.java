package com.example.all_in_one;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Alert_dialog_Activity extends AppCompatActivity {

    Button two_button,three_button,custom_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        two_button = findViewById(R.id.id_two_button);
        three_button = findViewById(R.id.id_three_button);
        custom_dialog = findViewById(R.id.id_custom_dialog);

        two_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder two_alert = new AlertDialog.Builder(Alert_dialog_Activity.this);
                two_alert.setTitle("Delete");
                two_alert.setIcon(R.drawable.delete_icon);
                two_alert.setMessage("Are you sre want to delete it");

                two_alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Alert_dialog_Activity.this,"Yes second button",Toast.LENGTH_SHORT).show();
                    }
                });

                two_alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Alert_dialog_Activity.this,"NO second button",Toast.LENGTH_SHORT).show();
                    }
                });

                two_alert.show();
            }
        });

        custom_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(Alert_dialog_Activity.this);
                dialog.setContentView(R.layout.custom_dialog);
                Button ok_button = dialog.findViewById(R.id.id_ok);
                dialog.setCancelable(false);
                ok_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        three_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder three_alert = new AlertDialog.Builder(Alert_dialog_Activity.this);

        three_alert.setTitle("Exit?");
        three_alert.setMessage("Are you sure want to exit ?");
        three_alert.setIcon(R.drawable.exit);

        three_alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Alert_dialog_Activity.super.onBackPressed();
            }
        });

        three_alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Alert_dialog_Activity.this, "Welcome agian", Toast.LENGTH_SHORT).show();
            }
        });

        three_alert.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Alert_dialog_Activity.this, "Operation cancelled", Toast.LENGTH_SHORT).show();
            }
        });

        three_alert.show();
    }
}