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

public class AdapterDriver1 extends RecyclerView.Adapter<AdapterDriver1.ViewHolder> {
    private Context context;
    private ArrayList<String> driver1_name, driver1_email, driver1_mobile, driver1_city;
    private DBHelper DB;
    String useremail;

    public AdapterDriver1(Context context, ArrayList<String> driver1_name, ArrayList<String> driver1_email, ArrayList<String> driver1_mobile, ArrayList<String> driver1_city,String useremail) {
        this.context = context;
        this.driver1_name = driver1_name;
        this.driver1_email = driver1_email;
        this.driver1_mobile = driver1_mobile;
        this.driver1_city = driver1_city;
        this.useremail = useremail;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.driverdata1, parent, false);
        return new ViewHolder(convertview);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.deleteDriverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                boolean success = DB.deleteDriver(email);

                if (success) {
                    Toast.makeText(context, "Driver Deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return driver1_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button deleteDriverButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.driverlist1_name);
            mobileTextView = itemView.findViewById(R.id.driverlist1_mobile);
            emailTextView = itemView.findViewById(R.id.driverlist1_email);
            cityTextView = itemView.findViewById(R.id.driverlist1_city);
            deleteDriverButton = itemView.findViewById(R.id.deletedriverfromlist1);
        }

        public void bindData(int position) {
            nameTextView.setText(driver1_name.get(position));
            emailTextView.setText(driver1_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(driver1_email.get(position));
            cityTextView.setText(driver1_city.get(position));

            deleteDriverButton.setTag(driver1_mobile.get(position));
        }
    }
}




