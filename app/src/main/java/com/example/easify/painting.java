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

public class painting extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout_painting;
    NavigationView navigationView_painting;
    Toolbar toolbar_painting;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painting);

        drawerLayout_painting = findViewById(R.id.drawerlayout_painting);
        navigationView_painting = findViewById(R.id.navview_painting);
        toolbar_painting = findViewById(R.id.toolbar_painting);

        setSupportActionBar(toolbar_painting);
        navigationView_painting.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout_painting,toolbar_painting,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout_painting.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_painting.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout_painting.isDrawerOpen(GravityCompat.START)){
            drawerLayout_painting.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.navhome:
                Intent intent1 = new Intent(painting.this,userdashboard.class);
                startActivity(intent1);
                break;
            case R.id.navservices:
                Intent intent2 = new Intent(painting.this,userdashboard.class);
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
                Intent intent = new Intent(painting.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}
