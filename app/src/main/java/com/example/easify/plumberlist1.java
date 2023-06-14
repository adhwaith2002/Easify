package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class plumberlist1 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> plumber1_name,plumber1_mobile,plumber1_email,plumber1_city;
    DBHelper DB;
    AdapterPlumber1 adapterPlumber1;

    String useremail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumberlist1);
        useremail = getIntent().getStringExtra("key_email");
        DB = new DBHelper(this);
        plumber1_name =new ArrayList<>();
        plumber1_mobile =new ArrayList<>();
        plumber1_email =new ArrayList<>();
        plumber1_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_plumberlist1);
        adapterPlumber1 = new AdapterPlumber1(this,plumber1_name,plumber1_mobile,plumber1_email,plumber1_city,useremail);
        recyclerView.setAdapter(adapterPlumber1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchPlumber1();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No plumber available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                plumber1_name.add(cursor.getString(0));
                plumber1_email.add(cursor.getString(1));
                plumber1_mobile.add(cursor.getString(3));
                plumber1_city.add(cursor.getString(5));
            }
        }
    }

}