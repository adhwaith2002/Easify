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

public class AdapterCarmechanic1 extends RecyclerView.Adapter<AdapterCarmechanic1.ViewHolder> {
    private Context context;
    private ArrayList<String> carmechanic1_name, carmechanic1_email, carmechanic1_mobile, carmechanic1_city;
    private DBHelper DB;
    String useremail;

    public AdapterCarmechanic1(Context context, ArrayList<String> carmechanic1_name, ArrayList<String> carmechanic1_email, ArrayList<String> carmechanic1_mobile, ArrayList<String> carmechanic1_city,String useremail) {
        this.context = context;
        this.carmechanic1_name = carmechanic1_name;
        this.carmechanic1_email = carmechanic1_email;
        this.carmechanic1_mobile = carmechanic1_mobile;
        this.carmechanic1_city = carmechanic1_city;
        this.useremail = useremail;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.carmechanicdata1, parent, false);
        return new ViewHolder(convertview);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.deleteCarmechanicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                boolean success = DB.deleteCarmechanic(email);

                if (success) {
                    Toast.makeText(context, "Car mechanic Deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return carmechanic1_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button deleteCarmechanicButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.carmechaniclist1_name);
            mobileTextView = itemView.findViewById(R.id.carmechaniclist1_mobile);
            emailTextView = itemView.findViewById(R.id.carmechaniclist1_email);
            cityTextView = itemView.findViewById(R.id.carmechaniclist1_city);
            deleteCarmechanicButton = itemView.findViewById(R.id.deletecarmechanicfromlist1);
        }

        public void bindData(int position) {
            nameTextView.setText(carmechanic1_name.get(position));
            emailTextView.setText(carmechanic1_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(carmechanic1_email.get(position));
            cityTextView.setText(carmechanic1_city.get(position));

            deleteCarmechanicButton.setTag(carmechanic1_mobile.get(position));
        }
    }
}




