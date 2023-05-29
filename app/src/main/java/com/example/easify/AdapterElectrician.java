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

public class AdapterElectrician extends RecyclerView.Adapter<AdapterElectrician.ViewHolder> {
    private Context context;
    private ArrayList<String> electrician_name, electrician_email, electrician_mobile, electrician_city;
    private DBHelper DB;
    String useremail;

    public AdapterElectrician(Context context, ArrayList<String> electrician_name, ArrayList<String> electrician_email, ArrayList<String> electrician_mobile, ArrayList<String> electrician_city,String useremail) {
        this.context = context;
        this.electrician_name = electrician_name;
        this.electrician_email = electrician_email;
        this.electrician_mobile = electrician_mobile;
        this.electrician_city = electrician_city;
        this.useremail = useremail;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.electriciandata, parent, false);
        return new ViewHolder(convertview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.bookElectricianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                boolean success = DB.updateElectricianStatus(useremail,email);
                if (success) {
                    Toast.makeText(context, "Booked sucessfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to book", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return electrician_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button bookElectricianButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.electricianlist_name);
            mobileTextView = itemView.findViewById(R.id.electricianlist_mobile);
            emailTextView = itemView.findViewById(R.id.electricianlist_email);
            cityTextView = itemView.findViewById(R.id.electricianlist_city);
            bookElectricianButton = itemView.findViewById(R.id.bookelectricianfromlist);
        }

        public void bindData(int position) {
            nameTextView.setText(electrician_name.get(position));
            emailTextView.setText(electrician_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(electrician_email.get(position));
            cityTextView.setText(electrician_city.get(position));

            bookElectricianButton.setTag(electrician_mobile.get(position));
        }
    }
}




