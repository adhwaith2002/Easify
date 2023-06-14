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

public class AdapterAppliance1 extends RecyclerView.Adapter<AdapterAppliance1.ViewHolder> {
    private Context context;
    private ArrayList<String> appliance1_name, appliance1_email, appliance1_mobile, appliance1_city;
    private DBHelper DB;
    String useremail;

    public AdapterAppliance1(Context context, ArrayList<String> appliance1_name, ArrayList<String> appliance1_email, ArrayList<String> appliance1_mobile, ArrayList<String> appliance1_city,String useremail) {
        this.context = context;
        this.appliance1_name = appliance1_name;
        this.appliance1_email = appliance1_email;
        this.appliance1_mobile = appliance1_mobile;
        this.appliance1_city = appliance1_city;
        this.useremail = useremail;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.appliancedata1, parent, false);
        return new ViewHolder(convertview);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.deleteApplianceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                boolean success = DB.deleteAppliance(email);

                if (success) {
                    Toast.makeText(context, "Appliance repairer Deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return appliance1_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button deleteApplianceButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.appliancelist1_name);
            mobileTextView = itemView.findViewById(R.id.appliancelist1_mobile);
            emailTextView = itemView.findViewById(R.id.appliancelist1_email);
            cityTextView = itemView.findViewById(R.id.appliancelist1_city);
            deleteApplianceButton = itemView.findViewById(R.id.deleteappliancefromlist1);
        }

        public void bindData(int position) {
            nameTextView.setText(appliance1_name.get(position));
            emailTextView.setText(appliance1_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(appliance1_email.get(position));
            cityTextView.setText(appliance1_city.get(position));

            deleteApplianceButton.setTag(appliance1_mobile.get(position));
        }
    }
}




