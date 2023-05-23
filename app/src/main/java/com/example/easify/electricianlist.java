package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class electricianlist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> electrician_name,electrician_mobile,electrician_email,electrician_city;
    DBHelper DB;
    AdapterElectrician adapterElectrician;
    TextView electricianlist_name,electricianlist_mobile,electricianlist_email,electricianlist_city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricianlist);
        DB = new DBHelper(this);
        electrician_name =new ArrayList<>();
        electrician_mobile =new ArrayList<>();
        electrician_email =new ArrayList<>();
        electrician_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_electricianlist);
        adapterElectrician = new AdapterElectrician(this,electrician_name,electrician_mobile,electrician_email,electrician_city);
        recyclerView.setAdapter(adapterElectrician);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchElectrician();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No electrician available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                electrician_name.add(cursor.getString(0));
                electrician_email.add(cursor.getString(1));
                electrician_mobile.add(cursor.getString(3));
                electrician_city.add(cursor.getString(5));
            }
        }
    }

}