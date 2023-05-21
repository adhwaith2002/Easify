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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class userdashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView dashboardemail,dashboarduser;
    String email;
    DBHelper DB;

    ImageView plumberimage,paintingimage,carmechanicimage,electricianimage,housecleaningimage,applianceimage,treecuttingimage,gardeningimage,cookimage,driverimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdashboard);

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navview);
        toolbar = findViewById(R.id.toolbar);
        plumberimage = findViewById(R.id.plumberimage);
        paintingimage = findViewById(R.id.paintingimage);
        carmechanicimage = findViewById(R.id.carmechanicimage);
        electricianimage = findViewById(R.id.electricianimage);
        housecleaningimage = findViewById(R.id.housecleaningimage);
        applianceimage = findViewById(R.id.applianceimage);
        treecuttingimage = findViewById(R.id.treecuttingimage);
        gardeningimage = findViewById(R.id.gardeningimage);
        cookimage = findViewById(R.id.cookimage);
        driverimage = findViewById(R.id.driverimage);
        DB =new DBHelper(this);

        email = getIntent().getStringExtra("key_email");

        ArrayList<UserModel> arrUser = new ArrayList<>();
        if (email != null) {
            arrUser = DB.fetchUser(email);
        } else {
            // Handle the case when the email is null
        }
        String username = arrUser.get(0).username;

        plumberimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userdashboard.this,plumber.class);
                intent.putExtra("key_email",email);
                startActivity(intent);
            }
        });
        paintingimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userdashboard.this,painting.class);
                startActivity(intent);
            }
        });

        carmechanicimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userdashboard.this,carmechanic.class);
                startActivity(intent);
            }
        });

        electricianimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userdashboard.this,electrician.class);
                startActivity(intent);
            }
        });

        housecleaningimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userdashboard.this,housecleaning.class);
                startActivity(intent);
            }
        });

        applianceimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userdashboard.this,appliance.class);
                startActivity(intent);
            }
        });

        treecuttingimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userdashboard.this,treecutting.class);
                startActivity(intent);
            }
        });

        gardeningimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userdashboard.this,gardening.class);
                startActivity(intent);
            }
        });

        cookimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userdashboard.this,cook.class);
                startActivity(intent);
            }
        });

        driverimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userdashboard.this,driver.class);
                startActivity(intent);
            }
        });




        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        dashboardemail = headerView.findViewById(R.id.dashboardemail);
        dashboarduser = headerView.findViewById(R.id.dashboarduser);
        dashboardemail.setText(email);
        dashboarduser.setText(username);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navhome:
                break;
            case R.id.navservices:
                break;
            case R.id.navnotification:
                Toast.makeText(this, "No Notifications", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navhistory:
                break;
            case R.id.navpayment:
                break;
            case R.id.navlogout:
                Intent intent = new Intent(userdashboard.this,MainActivity.class);
                startActivity(intent);
                break;

        }
    return true;
    }
}