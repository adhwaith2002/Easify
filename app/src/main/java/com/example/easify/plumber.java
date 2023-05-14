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
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class plumber extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout_plumber;
    NavigationView navigationView_plumber;
    Toolbar toolbar_plumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber);
        drawerLayout_plumber = findViewById(R.id.drawerlayout_plumber);
        navigationView_plumber = findViewById(R.id.navview_plumber);
        toolbar_plumber = findViewById(R.id.toolbar_plumber);



        setSupportActionBar(toolbar_plumber);
        navigationView_plumber.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout_plumber,toolbar_plumber,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout_plumber.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_plumber.setNavigationItemSelectedListener(this);
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
                startActivity(intent1);
                break;
            case R.id.navservices:
                Intent intent2 = new Intent(plumber.this,userdashboard.class);
                startActivity(intent2);
                break;
            case R.id.navnotification:
                Toast.makeText(this, "No Notifications", Toast.LENGTH_SHORT).show();
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