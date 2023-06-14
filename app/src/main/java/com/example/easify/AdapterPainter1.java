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

public class AdapterPainter1 extends RecyclerView.Adapter<AdapterPainter1.ViewHolder> {
    private Context context;
    private ArrayList<String> painter1_name, painter1_email, painter1_mobile, painter1_city;
    private DBHelper DB;
    String useremail;

    public AdapterPainter1(Context context, ArrayList<String> painter1_name, ArrayList<String> painter1_email, ArrayList<String> painter1_mobile, ArrayList<String> painter1_city,String useremail) {
        this.context = context;
        this.painter1_name = painter1_name;
        this.painter1_email = painter1_email;
        this.painter1_mobile = painter1_mobile;
        this.painter1_city = painter1_city;
        this.useremail = useremail;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.painterdata1, parent, false);
        return new ViewHolder(convertview);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.deletePainterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                boolean success = DB.deletePainter(email);

                if (success) {
                    Toast.makeText(context, "Painter Deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return painter1_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button deletePainterButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.painterlist1_name);
            mobileTextView = itemView.findViewById(R.id.painterlist1_mobile);
            emailTextView = itemView.findViewById(R.id.painterlist1_email);
            cityTextView = itemView.findViewById(R.id.painterlist1_city);
            deletePainterButton = itemView.findViewById(R.id.deletepainterfromlist1);
        }

        public void bindData(int position) {
            nameTextView.setText(painter1_name.get(position));
            emailTextView.setText(painter1_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(painter1_email.get(position));
            cityTextView.setText(painter1_city.get(position));

            deletePainterButton.setTag(painter1_mobile.get(position));
        }
    }
}




