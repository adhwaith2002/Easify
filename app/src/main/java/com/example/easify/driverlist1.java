package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class driverlist1 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> driver1_name,driver1_mobile,driver1_email,driver1_city;
    DBHelper DB;
    AdapterDriver1 adapterDriver1;

    String useremail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driverlist1);
        useremail = getIntent().getStringExtra("key_email");
        DB = new DBHelper(this);
        driver1_name =new ArrayList<>();
        driver1_mobile =new ArrayList<>();
        driver1_email =new ArrayList<>();
        driver1_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_driverlist1);
        adapterDriver1 = new AdapterDriver1(this,driver1_name,driver1_mobile,driver1_email,driver1_city,useremail);
        recyclerView.setAdapter(adapterDriver1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchDriver1();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No Driver available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                driver1_name.add(cursor.getString(0));
                driver1_email.add(cursor.getString(1));
                driver1_mobile.add(cursor.getString(3));
                driver1_city.add(cursor.getString(5));
            }
        }
    }

}