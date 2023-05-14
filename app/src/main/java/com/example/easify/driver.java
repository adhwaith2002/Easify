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

public class driver extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout_driver;
    NavigationView navigationView_driver;
    Toolbar toolbar_driver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        drawerLayout_driver = findViewById(R.id.drawerlayout_driver);
        navigationView_driver = findViewById(R.id.navview_driver);
        toolbar_driver = findViewById(R.id.toolbar_driver);

        setSupportActionBar(toolbar_driver);
        navigationView_driver.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout_driver, toolbar_driver, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout_driver.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_driver.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout_driver.isDrawerOpen(GravityCompat.START)) {
            drawerLayout_driver.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navhome:
                Intent intent1 = new Intent(driver.this,userdashboard.class);
                startActivity(intent1);
                break;
            case R.id.navservices:
                Intent intent2 = new Intent(driver.this,userdashboard.class);
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
                Intent intent = new Intent(driver.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}