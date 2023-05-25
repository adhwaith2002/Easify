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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class serviceproviderdashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout_serviceproviderdashboard;
    NavigationView navigationView_serviceproviderdashboard;
    Toolbar toolbar_serviceproviderdashboard;
    String email;
    TextView dashboardservicename,dashboardserviceemail;
    DBHelper DB;
    Button viewappointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serviceproviderdashboard);
        drawerLayout_serviceproviderdashboard = findViewById(R.id.drawerlayout_serviceproviderdashboard);
        navigationView_serviceproviderdashboard = findViewById(R.id.navview_serviceproviderdashboard);
        toolbar_serviceproviderdashboard = findViewById(R.id.toolbar_serviceproviderdashboard);
        viewappointment = findViewById(R.id.viewappointment);
        DB =new DBHelper(this);
        email = getIntent().getStringExtra("key_email");
        //ArrayList<UserModel> arrUser = new ArrayList<>();
        //if (email != null) {
          //  arrUser = DB.fetchUser(email);
        //} else {
            // Handle the case when the email is null
        //}
        //String username = arrUser.get(0).username;


        setSupportActionBar(toolbar_serviceproviderdashboard);
        navigationView_serviceproviderdashboard.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout_serviceproviderdashboard, toolbar_serviceproviderdashboard, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout_serviceproviderdashboard.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_serviceproviderdashboard.setNavigationItemSelectedListener(this);
        View headerView = navigationView_serviceproviderdashboard.getHeaderView(0);
        dashboardserviceemail = headerView.findViewById(R.id.dashboardserviceemail);
        dashboardservicename = headerView.findViewById(R.id.dashboardservicename);
        dashboardserviceemail.setText(email);
        //dashboarduser.setText(username);

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout_serviceproviderdashboard.isDrawerOpen(GravityCompat.START)) {
            drawerLayout_serviceproviderdashboard.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.servicenavhome:
                //Intent intent1 = new Intent(se.this,userdashboard.class);
                //intent1.putExtra("key_email",email);
                //startActivity(intent1);
                break;
            case R.id.servicenavstatus:
                //Intent intent2 = new Intent(cook.this,userdashboard.class);
                //intent2.putExtra("key_email",email);
                //startActivity(intent2);
                break;
            case R.id.servicenavnotification:
                Toast.makeText(this, "No Notifications", Toast.LENGTH_SHORT).show();
                break;
            case R.id.servicenavedit:
                break;
            case R.id.servicenavhistory:
                break;
            case R.id.servicenavappointment:
                break;
            case R.id.navlogout:
                Intent intent = new Intent(serviceproviderdashboard.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}