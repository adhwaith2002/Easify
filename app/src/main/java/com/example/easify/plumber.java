package com.example.easify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class plumber extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout_plumber;
    NavigationView navigationView_plumber;
    Toolbar toolbar_plumber;
    String email;
    TextView dashboardemail,dashboarduser;
    DBHelper DB;
    Button plumberbook;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber);
        drawerLayout_plumber = findViewById(R.id.drawerlayout_plumber);
        navigationView_plumber = findViewById(R.id.navview_plumber);
        plumberbook = findViewById(R.id.plumberbook);
        toolbar_plumber = findViewById(R.id.toolbar_plumber);
        DB =new DBHelper(this);
        email = getIntent().getStringExtra("key_email");
        ArrayList<UserModel> arrUser = new ArrayList<>();
        if (email != null) {
            arrUser = DB.fetchUser(email);
        } else {
            // Handle the case when the email is null
        }
        String username = arrUser.get(0).username;


        setSupportActionBar(toolbar_plumber);
        navigationView_plumber.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout_plumber,toolbar_plumber,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout_plumber.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_plumber.setNavigationItemSelectedListener(this);
        View headerView = navigationView_plumber.getHeaderView(0);
        dashboardemail = headerView.findViewById(R.id.dashboardemail);
        dashboarduser = headerView.findViewById(R.id.dashboarduser);
        dashboardemail.setText(email);
        dashboarduser.setText(username);
        plumberbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plumber.this,plumberlist.class);
                intent.putExtra("key_email",email);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout_plumber.isDrawerOpen(GravityCompat.START)){
            drawerLayout_plumber.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.navhome:
                Intent intent1 = new Intent(plumber.this,userdashboard.class);
                intent1.putExtra("key_email",email);
                startActivity(intent1);
                break;
            case R.id.navservices:
                Intent intent2 = new Intent(plumber.this,edituser.class);
                intent2.putExtra("key_email",email);
                startActivity(intent2);
                break;
            case R.id.navnchangepassword:
                Intent intent3 = new Intent(plumber.this,changeuserpassword.class);
                intent3.putExtra("key_email",email);
                startActivity(intent3);
                break;
            case R.id.navhistory:
                break;
            case R.id.navpayment:
                break;
            case R.id.navlogout:
                Intent intent = new Intent(plumber.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}