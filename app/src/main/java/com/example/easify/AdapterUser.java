package com.example.easify;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder> {
    private Context context;
    private ArrayList<String> user_name, user_email, user_mobile, user_address ,user_city;
    private DBHelper DB;
    String table,serviceprovider_email;

    public AdapterUser(Context context, ArrayList<String> user_name, ArrayList<String> user_email, ArrayList<String> user_mobile, ArrayList<String> user_address , ArrayList<String> user_city,String table,String serviceprovider_email) {
        this.context = context;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_mobile = user_mobile;
        this.user_city = user_city;
        this.user_address = user_address;
        this.table = table;
        this.serviceprovider_email = serviceprovider_email;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.userdata, parent, false);
        return new ViewHolder(convertview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
       holder.DoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) holder.DoneButton.getTag();

                if(table.equals("plumber")){
                    Boolean rowsDeleted = DB.deleteRowsByEmail1(email,serviceprovider_email);
                    if (rowsDeleted) {
                        Toast.makeText(context, "Job completed successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(table.equals("painter")){
                    Boolean rowsDeleted = DB.deleteRowsByEmail2(email,serviceprovider_email);
                    if (rowsDeleted) {
                        Toast.makeText(context, "Job completed successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(table.equals("carmechanic")){
                    Boolean rowsDeleted = DB.deleteRowsByEmail3(email,serviceprovider_email);
                    if (rowsDeleted) {
                        Toast.makeText(context, "Job completed successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(table.equals("electrician")){
                    Boolean rowsDeleted = DB.deleteRowsByEmail4(email,serviceprovider_email);
                    if (rowsDeleted) {
                        Toast.makeText(context, "Job completed successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(table.equals("housecleaner")){
                    Boolean rowsDeleted = DB.deleteRowsByEmail5(email,serviceprovider_email);
                    if (rowsDeleted) {
                        Toast.makeText(context, "Job completed successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(table.equals("appliancerepair")){
                    Boolean rowsDeleted = DB.deleteRowsByEmail6(email,serviceprovider_email);
                    if (rowsDeleted) {
                        Toast.makeText(context, "Job completed successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(table.equals("treecutter")){
                    Boolean rowsDeleted = DB.deleteRowsByEmail7(email,serviceprovider_email);
                    if (rowsDeleted) {
                        Toast.makeText(context, "Job completed successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(table.equals("gardener")){
                    Boolean rowsDeleted = DB.deleteRowsByEmail8(email,serviceprovider_email);
                    if (rowsDeleted) {
                        Toast.makeText(context, "Job completed successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(table.equals("cook")){
                    Boolean rowsDeleted = DB.deleteRowsByEmail9(email,serviceprovider_email);
                    if (rowsDeleted) {
                        Toast.makeText(context, "Job completed successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(table.equals("driver")){
                    Boolean rowsDeleted = DB.deleteRowsByEmail10(email,serviceprovider_email);
                    if (rowsDeleted) {
                        Toast.makeText(context, "Job completed successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return user_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView,addressTextView, cityTextView;
        Button DoneButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.userlist_name);
            mobileTextView = itemView.findViewById(R.id.userlist_mobile);
            emailTextView = itemView.findViewById(R.id.userlist_email);
            addressTextView = itemView.findViewById(R.id.userlist_address);
            cityTextView = itemView.findViewById(R.id.userlist_city);
            DoneButton = itemView.findViewById(R.id.doneuserfromlist);
        }

        public void bindData(int position) {
            nameTextView.setText(user_name.get(position));
            emailTextView.setText(user_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(user_email.get(position));
            addressTextView.setText(user_address.get(position));
            cityTextView.setText(user_city.get(position));

            DoneButton.setTag(user_mobile.get(position));
        }
    }
}




