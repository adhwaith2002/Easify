package com.example.easify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class electrician extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout_electrician;
    NavigationView navigationView_electrician;
    Toolbar toolbar_electrician;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrician);

        drawerLayout_electrician = findViewById(R.id.drawerlayout_electrician);
        navigationView_electrician = findViewById(R.id.navview_electrician);
        toolbar_electrician = findViewById(R.id.toolbar_electrician);

        setSupportActionBar(toolbar_electrician);
        navigationView_electrician.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout_electrician,toolbar_electrician,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout_electrician.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_electrician.setNavigationItemSelectedListener(this);

    }
    @Override
    public void onBackPressed() {
        if(drawerLayout_electrician.isDrawerOpen(GravityCompat.START)){
            drawerLayout_electrician.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navhome:
                Intent intent1 = new Intent(electrician.this,userdashboard.class);
                startActivity(intent1);
                break;
            case R.id.navservices:
                Intent intent2 = new Intent(electrician.this,userdashboard.class);
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
                Intent intent = new Intent(electrician.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}