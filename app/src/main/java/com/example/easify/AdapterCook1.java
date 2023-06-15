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

public class AdapterCook1 extends RecyclerView.Adapter<AdapterCook1.ViewHolder> {
    private Context context;
    private ArrayList<String> cook1_name, cook1_email, cook1_mobile, cook1_city;
    private DBHelper DB;
    String useremail;

    public AdapterCook1(Context context, ArrayList<String> cook1_name, ArrayList<String> cook1_email, ArrayList<String> cook1_mobile, ArrayList<String> cook1_city,String useremail) {
        this.context = context;
        this.cook1_name = cook1_name;
        this.cook1_email = cook1_email;
        this.cook1_mobile = cook1_mobile;
        this.cook1_city = cook1_city;
        this.useremail = useremail;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.cookdata1, parent, false);
        return new ViewHolder(convertview);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.deleteCookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                boolean success = DB.deleteCook(email);

                if (success) {
                    Toast.makeText(context, "Cook Deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return cook1_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button deleteCookButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.cooklist1_name);
            mobileTextView = itemView.findViewById(R.id.cooklist1_mobile);
            emailTextView = itemView.findViewById(R.id.cooklist1_email);
            cityTextView = itemView.findViewById(R.id.cooklist1_city);
            deleteCookButton = itemView.findViewById(R.id.deletecookfromlist1);
        }

        public void bindData(int position) {
            nameTextView.setText(cook1_name.get(position));
            emailTextView.setText(cook1_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(cook1_email.get(position));
            cityTextView.setText(cook1_city.get(position));

            deleteCookButton.setTag(cook1_mobile.get(position));
        }
    }
}




