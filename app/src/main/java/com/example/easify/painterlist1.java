package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class painterlist1 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> painter1_name,painter1_mobile,painter1_email,painter1_city;
    DBHelper DB;
    AdapterPainter1 adapterPainter1;

    String useremail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painterlist1);
        useremail = getIntent().getStringExtra("key_email");
        DB = new DBHelper(this);
        painter1_name =new ArrayList<>();
        painter1_mobile =new ArrayList<>();
        painter1_email =new ArrayList<>();
        painter1_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_painterlist1);
        adapterPainter1 = new AdapterPainter1(this,painter1_name,painter1_mobile,painter1_email,painter1_city,useremail);
        recyclerView.setAdapter(adapterPainter1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchPainter1();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No painter available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                painter1_name.add(cursor.getString(0));
                painter1_email.add(cursor.getString(1));
                painter1_mobile.add(cursor.getString(3));
                painter1_city.add(cursor.getString(5));
            }
        }
    }

}