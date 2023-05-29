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

public class AdapterGardening extends RecyclerView.Adapter<AdapterGardening.ViewHolder> {
    private Context context;
    private ArrayList<String> gardening_name, gardening_email, gardening_mobile, gardening_city;
    private DBHelper DB;
    String useremail;

    public AdapterGardening(Context context, ArrayList<String> gardening_name, ArrayList<String> gardening_email, ArrayList<String> gardening_mobile, ArrayList<String> gardening_city,String useremail) {
        this.context = context;
        this.gardening_name = gardening_name;
        this.gardening_email = gardening_email;
        this.gardening_mobile = gardening_mobile;
        this.gardening_city = gardening_city;
        this.useremail = useremail;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.gardeningdata, parent, false);
        return new ViewHolder(convertview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.bookGardeningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                boolean success = DB.updateGardeningStatus(useremail,email);
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
        return gardening_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button bookGardeningButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.gardeninglist_name);
            mobileTextView = itemView.findViewById(R.id.gardeninglist_mobile);
            emailTextView = itemView.findViewById(R.id.gardeninglist_email);
            cityTextView = itemView.findViewById(R.id.gardeninglist_city);
            bookGardeningButton = itemView.findViewById(R.id.bookgardeningfromlist);
        }

        public void bindData(int position) {
            nameTextView.setText(gardening_name.get(position));
            emailTextView.setText(gardening_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(gardening_email.get(position));
            cityTextView.setText(gardening_city.get(position));

            bookGardeningButton.setTag(gardening_mobile.get(position));
        }
    }
}




