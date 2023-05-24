package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class gardeninglist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> gardening_name,gardening_mobile,gardening_email,gardening_city;
    DBHelper DB;
    AdapterGardening adapterGardening;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardeninglist);
        DB = new DBHelper(this);
        gardening_name =new ArrayList<>();
        gardening_mobile =new ArrayList<>();
        gardening_email =new ArrayList<>();
        gardening_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_gardeninglist);
        adapterGardening = new AdapterGardening(this,gardening_name,gardening_mobile,gardening_email,gardening_city);
        recyclerView.setAdapter(adapterGardening);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchGardening();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No gardener available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                gardening_name.add(cursor.getString(0));
                gardening_email.add(cursor.getString(1));
                gardening_mobile.add(cursor.getString(3));
                gardening_city.add(cursor.getString(5));
            }
        }
    }

}