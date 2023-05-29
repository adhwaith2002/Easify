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

public class AdapterCook extends RecyclerView.Adapter<AdapterCook.ViewHolder> {
    private Context context;
    private ArrayList<String> cook_name, cook_email, cook_mobile, cook_city;
    private DBHelper DB;
    String useremail;

    public AdapterCook(Context context, ArrayList<String> cook_name, ArrayList<String> cook_email, ArrayList<String> cook_mobile, ArrayList<String> cook_city,String useremail) {
        this.context = context;
        this.cook_name = cook_name;
        this.cook_email = cook_email;
        this.cook_mobile = cook_mobile;
        this.cook_city = cook_city;
        this.useremail = useremail;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.cookdata, parent, false);
        return new ViewHolder(convertview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.bookCookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                boolean success = DB.updateCookStatus(useremail,email);
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
        return cook_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button bookCookButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.cooklist_name);
            mobileTextView = itemView.findViewById(R.id.cooklist_mobile);
            emailTextView = itemView.findViewById(R.id.cooklist_email);
            cityTextView = itemView.findViewById(R.id.cooklist_city);
            bookCookButton = itemView.findViewById(R.id.bookcookfromlist);
        }

        public void bindData(int position) {
            nameTextView.setText(cook_name.get(position));
            emailTextView.setText(cook_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(cook_email.get(position));
            cityTextView.setText(cook_city.get(position));

            bookCookButton.setTag(cook_mobile.get(position));
        }
    }
}




