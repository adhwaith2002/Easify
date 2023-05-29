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

public class AdapterPainter extends RecyclerView.Adapter<AdapterPainter.ViewHolder> {
    private Context context;
    private ArrayList<String> painter_name, painter_email, painter_mobile, painter_city;
    private DBHelper DB;
    String useremail;

    public AdapterPainter(Context context, ArrayList<String> painter_name, ArrayList<String> painter_email, ArrayList<String> painter_mobile, ArrayList<String> painter_city,String useremail) {
        this.context = context;
        this.painter_name = painter_name;
        this.painter_email = painter_email;
        this.painter_mobile = painter_mobile;
        this.painter_city = painter_city;
        this.useremail = useremail;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.painterdata, parent, false);
        return new ViewHolder(convertview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.bookPainterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                boolean success = DB.updatePainterStatus(useremail,email);

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
        return painter_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button bookPainterButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.painterlist_name);
            mobileTextView = itemView.findViewById(R.id.painterlist_mobile);
            emailTextView = itemView.findViewById(R.id.painterlist_email);
            cityTextView = itemView.findViewById(R.id.painterlist_city);
            bookPainterButton = itemView.findViewById(R.id.bookpainterfromlist);
        }

        public void bindData(int position) {
            nameTextView.setText(painter_name.get(position));
            emailTextView.setText(painter_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(painter_email.get(position));
            cityTextView.setText(painter_city.get(position));

            bookPainterButton.setTag(painter_mobile.get(position));
        }
    }
}




