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

public class AdapterPlumber1 extends RecyclerView.Adapter<AdapterPlumber1.ViewHolder> {
    private Context context;
    private ArrayList<String> plumber1_name, plumber1_email, plumber1_mobile, plumber1_city;
    private DBHelper DB;
    String useremail;

    public AdapterPlumber1(Context context, ArrayList<String> plumber1_name, ArrayList<String> plumber1_email, ArrayList<String> plumber1_mobile, ArrayList<String> plumber1_city,String useremail) {
        this.context = context;
        this.plumber1_name = plumber1_name;
        this.plumber1_email = plumber1_email;
        this.plumber1_mobile = plumber1_mobile;
        this.plumber1_city = plumber1_city;
        this.useremail = useremail;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.plumberdata1, parent, false);
        return new ViewHolder(convertview);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.deletePlumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                boolean success = DB.deletePlumber(email);

                if (success) {
                    Toast.makeText(context, "Plumber Deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return plumber1_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button deletePlumberButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.plumberlist1_name);
            mobileTextView = itemView.findViewById(R.id.plumberlist1_mobile);
            emailTextView = itemView.findViewById(R.id.plumberlist1_email);
            cityTextView = itemView.findViewById(R.id.plumberlist1_city);
            deletePlumberButton = itemView.findViewById(R.id.deleteplumberfromlist1);
        }

        public void bindData(int position) {
            nameTextView.setText(plumber1_name.get(position));
            emailTextView.setText(plumber1_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(plumber1_email.get(position));
            cityTextView.setText(plumber1_city.get(position));

            deletePlumberButton.setTag(plumber1_mobile.get(position));
        }
    }
}




