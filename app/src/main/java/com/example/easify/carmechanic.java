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

public class carmechanic extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout_carmechanic;
    NavigationView navigationView_carmechanic;
    Toolbar toolbar_carmechanic;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carmechanic);

        drawerLayout_carmechanic = findViewById(R.id.drawerlayout_carmechanic);
        navigationView_carmechanic = findViewById(R.id.navview_carmechanic);
        toolbar_carmechanic = findViewById(R.id.toolbar_carmechanic);

        setSupportActionBar(toolbar_carmechanic);
        navigationView_carmechanic.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout_carmechanic,toolbar_carmechanic,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout_carmechanic.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_carmechanic.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout_carmechanic.isDrawerOpen(GravityCompat.START)){
            drawerLayout_carmechanic.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navhome:
                Intent intent1 = new Intent(carmechanic.this,userdashboard.class);
                startActivity(intent1);
                break;
            case R.id.navservices:
                Intent intent2 = new Intent(carmechanic.this,userdashboard.class);
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
                Intent intent = new Intent(carmechanic.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}