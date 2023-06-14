package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class appliancelist1 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> appliance1_name,appliance1_mobile,appliance1_email,appliance1_city;
    DBHelper DB;
    AdapterAppliance1 adapterAppliance1;

    String useremail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliancelist1);
        useremail = getIntent().getStringExtra("key_email");
        DB = new DBHelper(this);
        appliance1_name =new ArrayList<>();
        appliance1_mobile =new ArrayList<>();
        appliance1_email =new ArrayList<>();
        appliance1_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_appliancelist1);
        adapterAppliance1 = new AdapterAppliance1(this,appliance1_name,appliance1_mobile,appliance1_email,appliance1_city,useremail);
        recyclerView.setAdapter(adapterAppliance1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchAppliance1();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No appliance repairer available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                appliance1_name.add(cursor.getString(0));
                appliance1_email.add(cursor.getString(1));
                appliance1_mobile.add(cursor.getString(3));
                appliance1_city.add(cursor.getString(5));
            }
        }
    }

}