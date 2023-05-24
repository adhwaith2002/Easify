package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class appliancelist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> appliance_name,appliance_mobile,appliance_email,appliance_city;
    DBHelper DB;
    AdapterAppliance adapterAppliance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliancelist);
        DB = new DBHelper(this);
        appliance_name =new ArrayList<>();
        appliance_mobile =new ArrayList<>();
        appliance_email =new ArrayList<>();
        appliance_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_appliancelist);
        adapterAppliance = new AdapterAppliance(this,appliance_name,appliance_mobile,appliance_email,appliance_city);
        recyclerView.setAdapter(adapterAppliance);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchAppliance();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No appliance repairer available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                appliance_name.add(cursor.getString(0));
                appliance_email.add(cursor.getString(1));
                appliance_mobile.add(cursor.getString(3));
                appliance_city.add(cursor.getString(5));
            }
        }
    }

}