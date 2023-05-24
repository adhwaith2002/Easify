package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class cooklist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> cook_name,cook_mobile,cook_email,cook_city;
    DBHelper DB;
    AdapterCook adapterCook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooklist);
        DB = new DBHelper(this);
        cook_name =new ArrayList<>();
        cook_mobile =new ArrayList<>();
        cook_email =new ArrayList<>();
        cook_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_cooklist);
        adapterCook = new AdapterCook(this,cook_name,cook_mobile,cook_email,cook_city);
        recyclerView.setAdapter(adapterCook);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchCook();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No cook available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                cook_name.add(cursor.getString(0));
                cook_email.add(cursor.getString(1));
                cook_mobile.add(cursor.getString(3));
                cook_city.add(cursor.getString(5));
            }
        }
    }

}