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

public class AdapterGardening1 extends RecyclerView.Adapter<AdapterGardening1.ViewHolder> {
    private Context context;
    private ArrayList<String> gardening1_name, gardening1_email, gardening1_mobile, gardening1_city;
    private DBHelper DB;
    String useremail;

    public AdapterGardening1(Context context, ArrayList<String> gardening1_name, ArrayList<String> gardening1_email, ArrayList<String> gardening1_mobile, ArrayList<String> gardening1_city,String useremail) {
        this.context = context;
        this.gardening1_name = gardening1_name;
        this.gardening1_email = gardening1_email;
        this.gardening1_mobile = gardening1_mobile;
        this.gardening1_city = gardening1_city;
        this.useremail = useremail;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.gardeningdata1, parent, false);
        return new ViewHolder(convertview);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.deleteGardeningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                boolean success = DB.deleteGardening(email);

                if (success) {
                    Toast.makeText(context, "Gardener Deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return gardening1_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button deleteGardeningButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.gardeninglist1_name);
            mobileTextView = itemView.findViewById(R.id.gardeninglist1_mobile);
            emailTextView = itemView.findViewById(R.id.gardeninglist1_email);
            cityTextView = itemView.findViewById(R.id.gardeninglist1_city);
            deleteGardeningButton = itemView.findViewById(R.id.deletegardeningfromlist1);
        }

        public void bindData(int position) {
            nameTextView.setText(gardening1_name.get(position));
            emailTextView.setText(gardening1_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(gardening1_email.get(position));
            cityTextView.setText(gardening1_city.get(position));

            deleteGardeningButton.setTag(gardening1_mobile.get(position));
        }
    }
}




