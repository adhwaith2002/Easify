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

public class cook extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout_cook;
    NavigationView navigationView_cook;
    Toolbar toolbar_cook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook);
        drawerLayout_cook = findViewById(R.id.drawerlayout_cook);
        navigationView_cook = findViewById(R.id.navview_cook);
        toolbar_cook = findViewById(R.id.toolbar_cook);

        setSupportActionBar(toolbar_cook);
        navigationView_cook.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout_cook, toolbar_cook, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout_cook.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_cook.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout_cook.isDrawerOpen(GravityCompat.START)) {
            drawerLayout_cook.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navhome:
                Intent intent1 = new Intent(cook.this,userdashboard.class);
                startActivity(intent1);
                break;
            case R.id.navservices:
                Intent intent2 = new Intent(cook.this,userdashboard.class);
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
                Intent intent = new Intent(cook.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}