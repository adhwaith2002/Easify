package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class electricianlist1 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> electrician1_name,electrician1_mobile,electrician1_email,electrician1_city;
    DBHelper DB;
    AdapterElectrician1 adapterElectrician1;

    String useremail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricianlist1);
        useremail = getIntent().getStringExtra("key_email");
        DB = new DBHelper(this);
        electrician1_name =new ArrayList<>();
        electrician1_mobile =new ArrayList<>();
        electrician1_email =new ArrayList<>();
        electrician1_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_electricianlist1);
        adapterElectrician1 = new AdapterElectrician1(this,electrician1_name,electrician1_mobile,electrician1_email,electrician1_city,useremail);
        recyclerView.setAdapter(adapterElectrician1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchElectrician1();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No electrician available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                electrician1_name.add(cursor.getString(0));
                electrician1_email.add(cursor.getString(1));
                electrician1_mobile.add(cursor.getString(3));
                electrician1_city.add(cursor.getString(5));
            }
        }
    }

}