package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class driverlist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> driver_name,driver_mobile,driver_email,driver_city;
    DBHelper DB;
    AdapterDriver adapterDriver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driverlist);
        DB = new DBHelper(this);
        driver_name =new ArrayList<>();
        driver_mobile =new ArrayList<>();
        driver_email =new ArrayList<>();
        driver_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_driverlist);
        adapterDriver = new AdapterDriver(this,driver_name,driver_mobile,driver_email,driver_city);
        recyclerView.setAdapter(adapterDriver);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchDriver();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No driver available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                driver_name.add(cursor.getString(0));
                driver_email.add(cursor.getString(1));
                driver_mobile.add(cursor.getString(3));
                driver_city.add(cursor.getString(5));
            }
        }
    }

}