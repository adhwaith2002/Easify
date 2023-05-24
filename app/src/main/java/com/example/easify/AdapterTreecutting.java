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

public class AdapterTreecutting extends RecyclerView.Adapter<AdapterTreecutting.ViewHolder> {
    private Context context;
    private ArrayList<String> treecutting_name, treecutting_email, treecutting_mobile, treecutting_city;
    private DBHelper DB;

    public AdapterTreecutting(Context context, ArrayList<String> treecutting_name, ArrayList<String> treecutting_email, ArrayList<String> treecutting_mobile, ArrayList<String> treecutting_city) {
        this.context = context;
        this.treecutting_name = treecutting_name;
        this.treecutting_email = treecutting_email;
        this.treecutting_mobile = treecutting_mobile;
        this.treecutting_city = treecutting_city;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.treecuttingdata, parent, false);
        return new ViewHolder(convertview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.bookTreecuttingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                Log.d("Email", email);

                // Update the plumber status in the database
                boolean success = DB.updateTreecuttingStatus(email, 1);

                if (success) {
                    Toast.makeText(context, "Treecutting status updated successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to update treecutting status", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return treecutting_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button bookTreecuttingButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.treecuttinglist_name);
            mobileTextView = itemView.findViewById(R.id.treecuttinglist_mobile);
            emailTextView = itemView.findViewById(R.id.treecuttinglist_email);
            cityTextView = itemView.findViewById(R.id.treecuttinglist_city);
            bookTreecuttingButton = itemView.findViewById(R.id.booktreecuttingfromlist);
        }

        public void bindData(int position) {
            nameTextView.setText(treecutting_name.get(position));
            emailTextView.setText(treecutting_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(treecutting_email.get(position));
            cityTextView.setText(treecutting_city.get(position));

            bookTreecuttingButton.setTag(treecutting_mobile.get(position));
        }
    }
}




