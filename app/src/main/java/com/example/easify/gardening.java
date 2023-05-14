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

public class gardening extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout_gardening;
    NavigationView navigationView_gardening;
    Toolbar toolbar_gardening;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gardening);
        drawerLayout_gardening = findViewById(R.id.drawerlayout_gardening);
        navigationView_gardening = findViewById(R.id.navview_gardening);
        toolbar_gardening = findViewById(R.id.toolbar_gardening);

        setSupportActionBar(toolbar_gardening);
        navigationView_gardening.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout_gardening,toolbar_gardening,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout_gardening.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_gardening.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout_gardening.isDrawerOpen(GravityCompat.START)){
            drawerLayout_gardening.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navhome:
                Intent intent1 = new Intent(gardening.this,userdashboard.class);
                startActivity(intent1);
                break;
            case R.id.navservices:
                Intent intent2 = new Intent(gardening.this,userdashboard.class);
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
                Intent intent = new Intent(gardening.this,MainActivity.class);
                startActivity(intent);
                break;

        }

        return true;
    }
}