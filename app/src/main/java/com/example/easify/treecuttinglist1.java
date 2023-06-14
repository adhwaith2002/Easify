package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class treecuttinglist1 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> treecutting1_name,treecutting1_mobile,treecutting1_email,treecutting1_city;
    DBHelper DB;
    AdapterTreecutting1 adapterTreecutting1;

    String useremail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treecuttinglist1);
        useremail = getIntent().getStringExtra("key_email");
        DB = new DBHelper(this);
        treecutting1_name =new ArrayList<>();
        treecutting1_mobile =new ArrayList<>();
        treecutting1_email =new ArrayList<>();
        treecutting1_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_treecuttinglist1);
        adapterTreecutting1 = new AdapterTreecutting1(this,treecutting1_name,treecutting1_mobile,treecutting1_email,treecutting1_city,useremail);
        recyclerView.setAdapter(adapterTreecutting1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchTreecutting1();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No Tree cutter available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                treecutting1_name.add(cursor.getString(0));
                treecutting1_email.add(cursor.getString(1));
                treecutting1_mobile.add(cursor.getString(3));
                treecutting1_city.add(cursor.getString(5));
            }
        }
    }

}