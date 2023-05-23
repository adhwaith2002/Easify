package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class paintinglist extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> painter_name,painter_mobile,painter_email,painter_city;
    DBHelper DB;
    AdapterPainter adapterPainter;
    TextView painterlist_name,painterlist_mobile,painterlist_email,painterlist_city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paintinglist);
        DB = new DBHelper(this);
        painter_name =new ArrayList<>();
        painter_mobile =new ArrayList<>();
        painter_email =new ArrayList<>();
        painter_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_painterlist);
        adapterPainter = new AdapterPainter(this,painter_name,painter_mobile,painter_email,painter_city);
        recyclerView.setAdapter(adapterPainter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
    }

    private void displayData(){
        Cursor cursor = DB.fetchPainter();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No painter available", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                painter_name.add(cursor.getString(0));
                painter_email.add(cursor.getString(1));
                painter_mobile.add(cursor.getString(3));
                painter_city.add(cursor.getString(5));
            }
        }
    }
}