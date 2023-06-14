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

public class AdapterElectrician1 extends RecyclerView.Adapter<AdapterElectrician1.ViewHolder> {
    private Context context;
    private ArrayList<String> electrician1_name, electrician1_email, electrician1_mobile, electrician1_city;
    private DBHelper DB;
    String useremail;

    public AdapterElectrician1(Context context, ArrayList<String> electrician1_name, ArrayList<String> electrician1_email, ArrayList<String> electrician1_mobile, ArrayList<String> electrician1_city,String useremail) {
        this.context = context;
        this.electrician1_name = electrician1_name;
        this.electrician1_email = electrician1_email;
        this.electrician1_mobile = electrician1_mobile;
        this.electrician1_city = electrician1_city;
        this.useremail = useremail;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.electriciandata1, parent, false);
        return new ViewHolder(convertview);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.deleteElectricianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                boolean success = DB.deleteElectrician(email);

                if (success) {
                    Toast.makeText(context, "Electrician Deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return electrician1_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button deleteElectricianButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.electricianlist1_name);
            mobileTextView = itemView.findViewById(R.id.electricianlist1_mobile);
            emailTextView = itemView.findViewById(R.id.electricianlist1_email);
            cityTextView = itemView.findViewById(R.id.electricianlist1_city);
            deleteElectricianButton = itemView.findViewById(R.id.deleteelectricianfromlist1);
        }

        public void bindData(int position) {
            nameTextView.setText(electrician1_name.get(position));
            emailTextView.setText(electrician1_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(electrician1_email.get(position));
            cityTextView.setText(electrician1_city.get(position));

            deleteElectricianButton.setTag(electrician1_mobile.get(position));
        }
    }
}




