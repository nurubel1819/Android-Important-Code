package com.example.all_in_one;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleContactAdapter extends RecyclerView.Adapter<RecycleContactAdapter.my_view_holder> {

    Context context;
    ArrayList<Contact_model> arr_contact;
    RecycleContactAdapter(Context context,ArrayList<Contact_model> arr_contact)
    {
        this.context = context;
        this.arr_contact = arr_contact;
    }

    @NonNull
    @Override
    public my_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        my_view_holder view_holder = new my_view_holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull my_view_holder holder, int position) {
        holder.contact_img.setImageResource(arr_contact.get(position).img);
        holder.contact_name.setText(arr_contact.get(position).name);
        holder.contact_number.setText(arr_contact.get(position).number);
        holder.contact_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.daylog_contact);

                TextView operation_name = dialog.findViewById(R.id.id_operation_name);
                EditText contact_name = dialog.findViewById(R.id.id_contact_name);
                EditText contact_number = dialog.findViewById(R.id.id_contact_number);
                Button update = dialog.findViewById(R.id.id_update);

                operation_name.setText("Update contact information");
                contact_name.setText(arr_contact.get(position).name);
                contact_number.setText(arr_contact.get(position).number);
                update.setText("Update");

                int img = arr_contact.get(position).img;

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = contact_name.getText().toString();
                        String number = contact_number.getText().toString();

                        if(name.equals(""))
                        {
                            Toast.makeText(context,"Enter contact name",Toast.LENGTH_SHORT).show();
                        }
                        else if(number.equals(""))
                        {
                            Toast.makeText(context,"Enter contact number",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            arr_contact.set(position,new Contact_model(img,name,number));
                            notifyItemChanged(position);
                            dialog.dismiss();
                        }
                    }
                });
                dialog.show();
            }
        });

        holder.contact_info.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete confirmation")
                        .setMessage("Are your sure want to delete")
                        .setIcon(R.drawable.delete_icon)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arr_contact.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();
                return true;
            }
        });
        set_my_animation(holder.itemView,position);

    }

    @Override
    public int getItemCount() {
        return arr_contact.size();
    }

    public class my_view_holder extends RecyclerView.ViewHolder {
        ImageView contact_img;
        TextView contact_name,contact_number;
        LinearLayout contact_info;
        public my_view_holder(@NonNull View itemView) {
            super(itemView);
            contact_img = itemView.findViewById(R.id.id_contact_image);
            contact_name = itemView.findViewById(R.id.id_contact_name);
            contact_number = itemView.findViewById(R.id.id_contact_number);
            contact_info = itemView.findViewById(R.id.id_contact_info);
        }
    }
    private int last_position = -1;
    private void set_my_animation(View view,int position)
    {
        if(position>last_position)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            view.startAnimation(animation);
            last_position = position;
        }
    }
}
