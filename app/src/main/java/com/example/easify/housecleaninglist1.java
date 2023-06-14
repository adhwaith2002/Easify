package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class housecleaninglist1 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> housecleaning1_name,housecleaning1_mobile,housecleaning1_email,housecleaning1_city;
    DBHelper DB;
    AdapterHousecleaning1 adapterHousecleaning1;

    String useremail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housecleaninglist1);
        useremail = getIntent().getStringExtra("key_email");
        DB = new DBHelper(this);
        housecleaning1_name =new ArrayList<>();
        housecleaning1_mobile =new ArrayList<>();
        housecleaning1_email =new ArrayList<>();
        housecleaning1_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_housecleaninglist1);
        adapterHousecleaning1 = new AdapterHousecleaning1(this,housecleaning1_name,housecleaning1_mobile,housecleaning1_email,housecleaning1_city,useremail);
        recyclerView.setAdapter(adapterHousecleaning1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchHousecleaning1();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No House cleaning available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                housecleaning1_name.add(cursor.getString(0));
                housecleaning1_email.add(cursor.getString(1));
                housecleaning1_mobile.add(cursor.getString(3));
                housecleaning1_city.add(cursor.getString(5));
            }
        }
    }

}