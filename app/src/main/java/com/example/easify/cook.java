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

public class cook extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout_cook;
    NavigationView navigationView_cook;
    Toolbar toolbar_cook;
    String email;
    TextView dashboardemail,dashboarduser;
    DBHelper DB;
    Button cookbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook);
        drawerLayout_cook = findViewById(R.id.drawerlayout_cook);
        navigationView_cook = findViewById(R.id.navview_cook);
        toolbar_cook = findViewById(R.id.toolbar_cook);
        cookbook = findViewById(R.id.cookbook);
        DB =new DBHelper(this);
        email = getIntent().getStringExtra("key_email");
        ArrayList<UserModel> arrUser = new ArrayList<>();
        if (email != null) {
            arrUser = DB.fetchUser(email);
        } else {
            // Handle the case when the email is null
        }
        String username = arrUser.get(0).username;


        setSupportActionBar(toolbar_cook);
        navigationView_cook.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout_cook, toolbar_cook, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout_cook.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_cook.setNavigationItemSelectedListener(this);
        View headerView = navigationView_cook.getHeaderView(0);
        dashboardemail = headerView.findViewById(R.id.dashboardemail);
        dashboarduser = headerView.findViewById(R.id.dashboarduser);
        dashboardemail.setText(email);
        dashboarduser.setText(username);
        cookbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cook.this,cooklist.class);
                intent.putExtra("key_email",email);
                startActivity(intent);
            }
        });
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
                intent1.putExtra("key_email",email);
                startActivity(intent1);
                break;
            case R.id.navservices:
                Intent intent2 = new Intent(cook.this,edituser.class);
                intent2.putExtra("key_email",email);
                startActivity(intent2);
                break;
            case R.id.navnchangepassword:
                Intent intent3 = new Intent(cook.this,changeuserpassword.class);
                intent3.putExtra("key_email",email);
                startActivity(intent3);
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