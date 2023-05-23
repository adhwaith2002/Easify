package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class carmechaniclist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> carmechanic_name,carmechanic_mobile,carmechanic_email,carmechanic_city;
    DBHelper DB;
    AdapterCarmechanic adapterCarmechanic;
    TextView carmechaniclist_name,carmechaniclist_mobile,carmechaniclist_email,carmechaniclist_city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carmechaniclist);
        DB = new DBHelper(this);
        carmechanic_name =new ArrayList<>();
        carmechanic_mobile =new ArrayList<>();
        carmechanic_email =new ArrayList<>();
        carmechanic_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_carmechaniclist);
        adapterCarmechanic = new AdapterCarmechanic(this,carmechanic_name,carmechanic_mobile,carmechanic_email,carmechanic_city);
        recyclerView.setAdapter(adapterCarmechanic);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchCarmechanic();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No Car mechanic available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                carmechanic_name.add(cursor.getString(0));
                carmechanic_email.add(cursor.getString(1));
                carmechanic_mobile.add(cursor.getString(3));
                carmechanic_city.add(cursor.getString(5));
            }
        }
    }

}