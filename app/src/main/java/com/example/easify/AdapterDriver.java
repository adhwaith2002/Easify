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

public class AdapterDriver extends RecyclerView.Adapter<AdapterDriver.ViewHolder> {
    private Context context;
    private ArrayList<String> driver_name, driver_email, driver_mobile, driver_city;
    private DBHelper DB;

    public AdapterDriver(Context context, ArrayList<String> driver_name, ArrayList<String> driver_email, ArrayList<String> driver_mobile, ArrayList<String> driver_city) {
        this.context = context;
        this.driver_name = driver_name;
        this.driver_email = driver_email;
        this.driver_mobile = driver_mobile;
        this.driver_city = driver_city;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.driverdata, parent, false);
        return new ViewHolder(convertview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.bookDriverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                Log.d("Email", email);

                // Update the plumber status in the database
                boolean success = DB.updateDriverStatus(email, 1);

                if (success) {
                    Toast.makeText(context, "Driver status updated successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to update driver status", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return driver_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button bookDriverButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.driverlist_name);
            mobileTextView = itemView.findViewById(R.id.driverlist_mobile);
            emailTextView = itemView.findViewById(R.id.driverlist_email);
            cityTextView = itemView.findViewById(R.id.driverlist_city);
            bookDriverButton = itemView.findViewById(R.id.bookdriverfromlist);
        }

        public void bindData(int position) {
            nameTextView.setText(driver_name.get(position));
            emailTextView.setText(driver_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(driver_email.get(position));
            cityTextView.setText(driver_city.get(position));

            bookDriverButton.setTag(driver_mobile.get(position));
        }
    }
}




