package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class carmechaniclist1 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> carmechanic1_name,carmechanic1_mobile,carmechanic1_email,carmechanic1_city;
    DBHelper DB;
    AdapterCarmechanic1 adapterCarmechanic1;

    String useremail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carmechaniclist1);
        useremail = getIntent().getStringExtra("key_email");
        DB = new DBHelper(this);
        carmechanic1_name =new ArrayList<>();
        carmechanic1_mobile =new ArrayList<>();
        carmechanic1_email =new ArrayList<>();
        carmechanic1_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_carmechaniclist1);
        adapterCarmechanic1 = new AdapterCarmechanic1(this,carmechanic1_name,carmechanic1_mobile,carmechanic1_email,carmechanic1_city,useremail);
        recyclerView.setAdapter(adapterCarmechanic1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchCarmechanic1();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No Car mechanic available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                carmechanic1_name.add(cursor.getString(0));
                carmechanic1_email.add(cursor.getString(1));
                carmechanic1_mobile.add(cursor.getString(3));
                carmechanic1_city.add(cursor.getString(5));
            }
        }
    }

}