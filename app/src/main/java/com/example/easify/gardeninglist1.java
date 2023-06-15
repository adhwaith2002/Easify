package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class gardeninglist1 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> gardening1_name,gardening1_mobile,gardening1_email,gardening1_city;
    DBHelper DB;
    AdapterGardening1 adapterGardening1;

    String useremail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardeninglist1);
        useremail = getIntent().getStringExtra("key_email");
        DB = new DBHelper(this);
        gardening1_name =new ArrayList<>();
        gardening1_mobile =new ArrayList<>();
        gardening1_email =new ArrayList<>();
        gardening1_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_gardeninglist1);
        adapterGardening1 = new AdapterGardening1(this,gardening1_name,gardening1_mobile,gardening1_email,gardening1_city,useremail);
        recyclerView.setAdapter(adapterGardening1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchGardening1();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No Gardener available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                gardening1_name.add(cursor.getString(0));
                gardening1_email.add(cursor.getString(1));
                gardening1_mobile.add(cursor.getString(3));
                gardening1_city.add(cursor.getString(5));
            }
        }
    }

}