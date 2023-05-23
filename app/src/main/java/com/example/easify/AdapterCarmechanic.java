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

public class AdapterCarmechanic extends RecyclerView.Adapter<AdapterCarmechanic.ViewHolder> {
    private Context context;
    private ArrayList<String> carmechanic_name, carmechanic_email, carmechanic_mobile, carmechanic_city;
    private DBHelper DB;

    public AdapterCarmechanic(Context context, ArrayList<String> carmechanic_name, ArrayList<String> carmechanic_email, ArrayList<String> carmechanic_mobile, ArrayList<String> carmechanic_city) {
        this.context = context;
        this.carmechanic_name = carmechanic_name;
        this.carmechanic_email = carmechanic_email;
        this.carmechanic_mobile = carmechanic_mobile;
        this.carmechanic_city = carmechanic_city;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.carmechanicdata, parent, false);
        return new ViewHolder(convertview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.bookCarmechanicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                Log.d("Email", email);

                // Update the plumber status in the database
                boolean success = DB.updateCarmechanicStatus(email, 1);

                if (success) {
                    Toast.makeText(context, "Car mechanic status updated successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to update car mechanic status", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return carmechanic_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button bookCarmechanicButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.carmechaniclist_name);
            mobileTextView = itemView.findViewById(R.id.carmechaniclist_mobile);
            emailTextView = itemView.findViewById(R.id.carmechaniclist_email);
            cityTextView = itemView.findViewById(R.id.carmechaniclist_city);
            bookCarmechanicButton = itemView.findViewById(R.id.bookcarmechanicfromlist);
        }

        public void bindData(int position) {
            nameTextView.setText(carmechanic_name.get(position));
            emailTextView.setText(carmechanic_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(carmechanic_email.get(position));
            cityTextView.setText(carmechanic_city.get(position));

            bookCarmechanicButton.setTag(carmechanic_mobile.get(position));
        }
    }
}




