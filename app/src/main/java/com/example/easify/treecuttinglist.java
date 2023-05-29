package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class treecuttinglist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> treecutting_name,treecutting_mobile,treecutting_email,treecutting_city;
    DBHelper DB;
    AdapterTreecutting adapterTreecutting;
    String useremail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treecuttinglist);
        useremail = getIntent().getStringExtra("key_email");
        DB = new DBHelper(this);
        treecutting_name =new ArrayList<>();
        treecutting_mobile =new ArrayList<>();
        treecutting_email =new ArrayList<>();
        treecutting_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_treecuttinglist);
        adapterTreecutting = new AdapterTreecutting(this,treecutting_name,treecutting_mobile,treecutting_email,treecutting_city,useremail);
        recyclerView.setAdapter(adapterTreecutting);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();


    }

    private void displayData(){
        Cursor cursor = DB.fetchTreecutting();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No tree cutter available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                treecutting_name.add(cursor.getString(0));
                treecutting_email.add(cursor.getString(1));
                treecutting_mobile.add(cursor.getString(3));
                treecutting_city.add(cursor.getString(5));
            }
        }
    }

}