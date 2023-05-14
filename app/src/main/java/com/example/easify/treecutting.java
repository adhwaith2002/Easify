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

public class treecutting extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout_treecutting;
    NavigationView navigationView_treecutting;
    Toolbar toolbar_treecutting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treecutting);
        drawerLayout_treecutting = findViewById(R.id.drawerlayout_treecutting);
        navigationView_treecutting = findViewById(R.id.navview_treecutting);
        toolbar_treecutting = findViewById(R.id.toolbar_treecutting);

        setSupportActionBar(toolbar_treecutting);
        navigationView_treecutting.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout_treecutting,toolbar_treecutting,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout_treecutting.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_treecutting.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout_treecutting.isDrawerOpen(GravityCompat.START)){
            drawerLayout_treecutting.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navhome:
                Intent intent1 = new Intent(treecutting.this,userdashboard.class);
                startActivity(intent1);
                break;
            case R.id.navservices:
                Intent intent2 = new Intent(treecutting.this,userdashboard.class);
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
                Intent intent = new Intent(treecutting.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}