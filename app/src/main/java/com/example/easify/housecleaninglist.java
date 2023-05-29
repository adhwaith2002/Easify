package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class housecleaninglist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> housecleaning_name,housecleaning_mobile,housecleaning_email,housecleaning_city;
    DBHelper DB;
    AdapterHousecleaning adapterHousecleaning;
    String useremail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housecleaninglist);
        useremail = getIntent().getStringExtra("key_email");
        DB = new DBHelper(this);
        housecleaning_name =new ArrayList<>();
        housecleaning_mobile =new ArrayList<>();
        housecleaning_email =new ArrayList<>();
        housecleaning_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_housecleaninglist);
        adapterHousecleaning = new AdapterHousecleaning(this,housecleaning_name,housecleaning_mobile,housecleaning_email,housecleaning_city,useremail);
        recyclerView.setAdapter(adapterHousecleaning);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchHousecleaning();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No Housecleaning available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                housecleaning_name.add(cursor.getString(0));
                housecleaning_email.add(cursor.getString(1));
                housecleaning_mobile.add(cursor.getString(3));
                housecleaning_city.add(cursor.getString(5));
            }
        }
    }

}