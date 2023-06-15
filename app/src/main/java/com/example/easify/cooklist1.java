package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class cooklist1 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> cook1_name,cook1_mobile,cook1_email,cook1_city;
    DBHelper DB;
    AdapterCook1 adapterCook1;

    String useremail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooklist1);
        useremail = getIntent().getStringExtra("key_email");
        DB = new DBHelper(this);
        cook1_name =new ArrayList<>();
        cook1_mobile =new ArrayList<>();
        cook1_email =new ArrayList<>();
        cook1_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_cooklist1);
        adapterCook1 = new AdapterCook1(this,cook1_name,cook1_mobile,cook1_email,cook1_city,useremail);
        recyclerView.setAdapter(adapterCook1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchCook1();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No Cook available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                cook1_name.add(cursor.getString(0));
                cook1_email.add(cursor.getString(1));
                cook1_mobile.add(cursor.getString(3));
                cook1_city.add(cursor.getString(5));
            }
        }
    }

}