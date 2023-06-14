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

public class AdapterHousecleaning1 extends RecyclerView.Adapter<AdapterHousecleaning1.ViewHolder> {
    private Context context;
    private ArrayList<String> housecleaning1_name, housecleaning1_email, housecleaning1_mobile, housecleaning1_city;
    private DBHelper DB;
    String useremail;

    public AdapterHousecleaning1(Context context, ArrayList<String> housecleaning1_name, ArrayList<String> housecleaning1_email, ArrayList<String> housecleaning1_mobile, ArrayList<String> housecleaning1_city,String useremail) {
        this.context = context;
        this.housecleaning1_name = housecleaning1_name;
        this.housecleaning1_email = housecleaning1_email;
        this.housecleaning1_mobile = housecleaning1_mobile;
        this.housecleaning1_city = housecleaning1_city;
        this.useremail = useremail;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.housecleaningdata1, parent, false);
        return new ViewHolder(convertview);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.deleteHousecleaningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                boolean success = DB.deleteHousecleaning(email);

                if (success) {
                    Toast.makeText(context, "House cleaner Deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return housecleaning1_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button deleteHousecleaningButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.housecleaninglist1_name);
            mobileTextView = itemView.findViewById(R.id.housecleaninglist1_mobile);
            emailTextView = itemView.findViewById(R.id.housecleaninglist1_email);
            cityTextView = itemView.findViewById(R.id.housecleaninglist1_city);
            deleteHousecleaningButton = itemView.findViewById(R.id.deletehousecleaningfromlist1);
        }

        public void bindData(int position) {
            nameTextView.setText(housecleaning1_name.get(position));
            emailTextView.setText(housecleaning1_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(housecleaning1_email.get(position));
            cityTextView.setText(housecleaning1_city.get(position));

            deleteHousecleaningButton.setTag(housecleaning1_mobile.get(position));
        }
    }
}




