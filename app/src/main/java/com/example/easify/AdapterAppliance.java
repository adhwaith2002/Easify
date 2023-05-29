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

public class AdapterAppliance extends RecyclerView.Adapter<AdapterAppliance.ViewHolder> {
    private Context context;
    private ArrayList<String> appliance_name, appliance_email, appliance_mobile, appliance_city;
    private DBHelper DB;
    String useremail;

    public AdapterAppliance(Context context, ArrayList<String> appliance_name, ArrayList<String> appliance_email, ArrayList<String> appliance_mobile, ArrayList<String> appliance_city,String useremail) {
        this.context = context;
        this.appliance_name = appliance_name;
        this.appliance_email = appliance_email;
        this.appliance_mobile = appliance_mobile;
        this.appliance_city = appliance_city;
        this.useremail = useremail;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.appliancedata, parent, false);
        return new ViewHolder(convertview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.bookApplianceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                boolean success = DB.updateApplianceStatus(useremail,email);

                if (success) {
                    Toast.makeText(context, "Booked successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to book", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return appliance_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button bookApplianceButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.appliancelist_name);
            mobileTextView = itemView.findViewById(R.id.appliancelist_mobile);
            emailTextView = itemView.findViewById(R.id.appliancelist_email);
            cityTextView = itemView.findViewById(R.id.appliancelist_city);
            bookApplianceButton = itemView.findViewById(R.id.bookappliancefromlist);
        }

        public void bindData(int position) {
            nameTextView.setText(appliance_name.get(position));
            emailTextView.setText(appliance_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(appliance_email.get(position));
            cityTextView.setText(appliance_city.get(position));

            bookApplianceButton.setTag(appliance_mobile.get(position));
        }
    }
}




