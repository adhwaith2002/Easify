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

public class AdapterTreecutting1 extends RecyclerView.Adapter<AdapterTreecutting1.ViewHolder> {
    private Context context;
    private ArrayList<String> treecutting1_name, treecutting1_email, treecutting1_mobile, treecutting1_city;
    private DBHelper DB;
    String useremail;

    public AdapterTreecutting1(Context context, ArrayList<String> treecutting1_name, ArrayList<String> treecutting1_email, ArrayList<String> treecutting1_mobile, ArrayList<String> treecutting1_city,String useremail) {
        this.context = context;
        this.treecutting1_name = treecutting1_name;
        this.treecutting1_email = treecutting1_email;
        this.treecutting1_mobile = treecutting1_mobile;
        this.treecutting1_city = treecutting1_city;
        this.useremail = useremail;
        DB = new DBHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertview = LayoutInflater.from(context).inflate(R.layout.treecuttingdata1, parent, false);
        return new ViewHolder(convertview);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(position);
        holder.deleteTreecuttingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = (String) v.getTag();
                boolean success = DB.deleteTreecutting(email);

                if (success) {
                    Toast.makeText(context, "Tree cutter Deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return treecutting1_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, mobileTextView, emailTextView, cityTextView;
        Button deleteTreecuttingButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.treecuttinglist1_name);
            mobileTextView = itemView.findViewById(R.id.treecuttinglist1_mobile);
            emailTextView = itemView.findViewById(R.id.treecuttinglist1_email);
            cityTextView = itemView.findViewById(R.id.treecuttinglist1_city);
            deleteTreecuttingButton = itemView.findViewById(R.id.deletetreecuttingfromlist1);
        }

        public void bindData(int position) {
            nameTextView.setText(treecutting1_name.get(position));
            emailTextView.setText(treecutting1_mobile.get(position)); //plumber_mobile and plumber_email are interchanged
            mobileTextView.setText(treecutting1_email.get(position));
            cityTextView.setText(treecutting1_city.get(position));

            deleteTreecuttingButton.setTag(treecutting1_mobile.get(position));
        }
    }
}




