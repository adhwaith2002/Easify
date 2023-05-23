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

public class AdapterPlumber extends RecyclerView.Adapter<AdapterPlumber.ViewHolder> {
     private Context context;
     private ArrayList<String> plumber_name, plumber_email, plumber_mobile, plumber_city;
     private DBHelper DB;

     public AdapterPlumber(Context context, ArrayList<String> plumber_name, ArrayList<String> plumber_email, ArrayList<String> plumber_mobile, ArrayList<String> plumber_city) {
          this.context = context;
          this.plumber_name = plumber_name;
          this.plumber_email = plumber_email;
          this.plumber_mobile = plumber_mobile;
          this.plumber_city = plumber_city;
          DB = new DBHelper(context);
     }

     @NonNull
     @Override
     public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View convertview = LayoutInflater.from(context).inflate(R.layout.plumberdata, parent, false);
          return new ViewHolder(convertview);
     }

     @Override
     public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          holder.bindData(position);
          holder.bookPlumberButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    String email = (String) v.getTag();
                    Log.d("Email", email);

                    // Update the plumber status in the database
                    boolean success = DB.updatePlumberStatus(email, 1);

                    if (success) {
                         Toast.makeText(context, "Plumber status updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                         Toast.makeText(context, "Failed to update plumber status", Toast.LENGTH_SHORT).show();
                    }
               }
          });
     }


     @Override
     public int getItemCount() {
          return plumber_name.size();
     }

     public class ViewHolder extends RecyclerView.ViewHolder {
          TextView nameTextView, mobileTextView, emailTextView, cityTextView;
          Button bookPlumberButton;

          public ViewHolder(@NonNull View itemView) {
               super(itemView);
               nameTextView = itemView.findViewById(R.id.plumberlist_name);
               mobileTextView = itemView.findViewById(R.id.plumberlist_mobile);
               emailTextView = itemView.findViewById(R.id.plumberlist_email);
               cityTextView = itemView.findViewById(R.id.plumberlist_city);
               bookPlumberButton = itemView.findViewById(R.id.bookplumberfromlist);
          }

          public void bindData(int position) {
               nameTextView.setText(plumber_name.get(position));
               emailTextView.setText(plumber_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
               mobileTextView.setText(plumber_email.get(position));
               cityTextView.setText(plumber_city.get(position));

               bookPlumberButton.setTag(plumber_mobile.get(position));
          }
     }
}




