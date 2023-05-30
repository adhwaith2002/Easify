package com.example.easify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class userlist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> user_name,user_mobile,user_email,user_address,user_city;
    DBHelper DB;
    AdapterUser adapterUser;
    String email,useremail,table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        email = getIntent().getStringExtra("key_email");
        table = getIntent().getStringExtra("key_table");
        DB = new DBHelper(this);
        user_name =new ArrayList<>();
        user_mobile =new ArrayList<>();
        user_email =new ArrayList<>();
        user_address =new ArrayList<>();
        user_city =new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview_userlist);
        adapterUser = new AdapterUser(this,user_name,user_mobile,user_email,user_address,user_city);
        recyclerView.setAdapter(adapterUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchdata();
        displayData();
    }

    private void fetchdata(){

        if ("plumber".equals(table)){
            ArrayList<UserModel> arrUser = new ArrayList<>();
            arrUser = DB.collectUserPlumber(email);
            if (!arrUser.isEmpty()) {
                UserModel UserModel = arrUser.get(0);
                useremail = UserModel.email;

            }
        }
        else if("painter".equals(table)){
            ArrayList<UserModel> arrUser = new ArrayList<>();
            arrUser = DB.collectUserPainter(email);
            if (!arrUser.isEmpty()) {
                UserModel UserModel = arrUser.get(0);
                useremail = UserModel.email;

            }
        }
        else if("carmechanic".equals(table)){
            ArrayList<UserModel> arrUser = new ArrayList<>();
            arrUser = DB.collectUserCarmechanic(email);
            if (!arrUser.isEmpty()) {
                UserModel UserModel = arrUser.get(0);
                useremail = UserModel.email;

            }
        }
        else if("electrician".equals(table)){
            ArrayList<UserModel> arrUser = new ArrayList<>();
            arrUser = DB.collectUserElectrician(email);
            if (!arrUser.isEmpty()) {
                UserModel UserModel = arrUser.get(0);
                useremail = UserModel.email;

            }
        }
        else if("housecleaner".equals(table)){
            ArrayList<UserModel> arrUser = new ArrayList<>();
            arrUser = DB.collectUserCleanner(email);
            if (!arrUser.isEmpty()) {
                UserModel UserModel = arrUser.get(0);
                useremail = UserModel.email;

            }
        }
        else if("appliancerepair".equals(table)){
            ArrayList<UserModel> arrUser = new ArrayList<>();
            arrUser = DB.collectUserAppliancerepair(email);
            if (!arrUser.isEmpty()) {
                UserModel UserModel = arrUser.get(0);
                useremail = UserModel.email;

            }
        }
        else if("treecutter".equals(table)){
            ArrayList<UserModel> arrUser = new ArrayList<>();
            arrUser = DB.collectUserTreecutter(email);
            if (!arrUser.isEmpty()) {
                UserModel UserModel = arrUser.get(0);
                useremail = UserModel.email;

            }
        }
        else if("gardener".equals(table)){
            ArrayList<UserModel> arrUser = new ArrayList<>();
            arrUser = DB.collectUserGardener(email);
            if (!arrUser.isEmpty()) {
                UserModel UserModel = arrUser.get(0);
                useremail = UserModel.email;

            }
        }
        else if("cook".equals(table)){
            ArrayList<UserModel> arrUser = new ArrayList<>();
            arrUser = DB.collectUserCook(email);
            if (!arrUser.isEmpty()) {
                UserModel UserModel = arrUser.get(0);
                useremail = UserModel.email;
                Log.d("email",useremail);

            }
        }
        else if("driver".equals(table)){
            ArrayList<UserModel> arrUser = new ArrayList<>();
            arrUser = DB.collectUserDriver(email);
            if (!arrUser.isEmpty()) {
                UserModel UserModel = arrUser.get(0);
                useremail = UserModel.email;

            }
        }
    }


    private void displayData() {
        Cursor cursor = DB.fetchuserlist(useremail);
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No users", Toast.LENGTH_SHORT).show();
            return;
        }

        int columnIndexName = cursor.getColumnIndex("username");
        int columnIndexEmail = cursor.getColumnIndex("email");
        int columnIndexMobile = cursor.getColumnIndex("mobile");
        int columnIndexAddress = cursor.getColumnIndex("address");
        int columnIndexCity = cursor.getColumnIndex("city");

        while (cursor.moveToNext()) {
            user_name.add(cursor.getString(columnIndexName));
            user_email.add(cursor.getString(columnIndexEmail));
            user_mobile.add(cursor.getString(columnIndexMobile));
            user_address.add(cursor.getString(columnIndexAddress));
            user_city.add(cursor.getString(columnIndexCity));
        }

        adapterUser.notifyDataSetChanged();
        cursor.close();
    }




}