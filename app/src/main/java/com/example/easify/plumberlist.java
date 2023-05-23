package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class plumberlist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> plumber_name,plumber_mobile,plumber_email,plumber_city;
    DBHelper DB;
    AdapterPlumber adapterPlumber;
    TextView plumberlist_name,plumberlist_mobile,plumberlist_email,plumberlist_city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumberlist);
        DB = new DBHelper(this);
        plumber_name =new ArrayList<>();
        plumber_mobile =new ArrayList<>();
        plumber_email =new ArrayList<>();
        plumber_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_plumberlist);
        adapterPlumber = new AdapterPlumber(this,plumber_name,plumber_mobile,plumber_email,plumber_city);
        recyclerView.setAdapter(adapterPlumber);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchPlumber();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No plumber available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                plumber_name.add(cursor.getString(0));
                plumber_mobile.add(cursor.getString(3));
                plumber_email.add(cursor.getString(1));
                plumber_city.add(cursor.getString(5));
            }
        }
    }

}