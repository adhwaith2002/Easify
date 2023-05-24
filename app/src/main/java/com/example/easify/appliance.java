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
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class appliance extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout_appliance;
    NavigationView navigationView_appliance;
    Toolbar toolbar_appliance;
    Button appliancebook;
    String email;
    TextView dashboardemail,dashboarduser;
    DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appliance);
        drawerLayout_appliance = findViewById(R.id.drawerlayout_appliance);
        navigationView_appliance = findViewById(R.id.navview_appliance);
        appliancebook = findViewById(R.id.appliancebook);
        toolbar_appliance = findViewById(R.id.toolbar_appliance);
        DB =new DBHelper(this);
        email = getIntent().getStringExtra("key_email");
        ArrayList<UserModel> arrUser = new ArrayList<>();
        if (email != null) {
            arrUser = DB.fetchUser(email);
        } else {
            // Handle the case when the email is null
        }
        String username = arrUser.get(0).username;


        setSupportActionBar(toolbar_appliance);
        navigationView_appliance.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout_appliance,toolbar_appliance,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout_appliance.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_appliance.setNavigationItemSelectedListener(this);
        View headerView = navigationView_appliance.getHeaderView(0);
        dashboardemail = headerView.findViewById(R.id.dashboardemail);
        dashboarduser = headerView.findViewById(R.id.dashboarduser);
        dashboardemail.setText(email);
        dashboarduser.setText(username);
        appliancebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(appliance.this,appliancelist.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout_appliance.isDrawerOpen(GravityCompat.START)){
            drawerLayout_appliance.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navhome:
                Intent intent1 = new Intent(appliance.this,userdashboard.class);
                intent1.putExtra("key_email",email);
                startActivity(intent1);
                break;
            case R.id.navservices:
                Intent intent2 = new Intent(appliance.this,userdashboard.class);
                intent2.putExtra("key_email",email);
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
                Intent intent = new Intent(appliance.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}