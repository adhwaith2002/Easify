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

public class AdapterHousecleaning extends RecyclerView.Adapter<AdapterHousecleaning.ViewHolder> {
    private Context context;
    private ArrayList<String> housecleaning_name, housecleaning_email, housecleaning_mobile, housecleaning_city;
    private DBHelper DB;

    public AdapterHousecleaning(Context context, ArrayList<String> housecleaning_name, ArrayList<String> housecleaning_email, ArrayList<String> housecleaning_mobile, ArrayList<String> housecleaning_city) {
        this.context = context;
        this.housecleaning_name = housecleaning_name;
        this.housecleaning_email = housecleaning_email;
        this.housecleaning_mobile = housecleaning_mobile;
        this.housecleaning_city = housecleaning_city;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.housecleaningdata, parent, false);
        return new ViewHolder(convertview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.bookHousecleaningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                Log.d("Email", email);

                // Update the plumber status in the database
                boolean success = DB.updateHousecleaningStatus(email, 1);

                if (success) {
                    Toast.makeText(context, "Housecleaning status updated successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to update housecleaning status", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return housecleaning_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button bookHousecleaningButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.housecleaninglist_name);
            mobileTextView = itemView.findViewById(R.id.housecleaninglist_mobile);
            emailTextView = itemView.findViewById(R.id.housecleaninglist_email);
            cityTextView = itemView.findViewById(R.id.housecleaninglist_city);
            bookHousecleaningButton = itemView.findViewById(R.id.bookhousecleaningfromlist);
        }

        public void bindData(int position) {
            nameTextView.setText(housecleaning_name.get(position));
            emailTextView.setText(housecleaning_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(housecleaning_email.get(position));
            cityTextView.setText(housecleaning_city.get(position));

            bookHousecleaningButton.setTag(housecleaning_mobile.get(position));
        }
    }
}




