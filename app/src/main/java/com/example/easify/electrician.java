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

public class electrician extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout_electrician;
    NavigationView navigationView_electrician;
    Toolbar toolbar_electrician;
    Button electricianbook;
    String email;
    TextView dashboardemail,dashboarduser;
    DBHelper DB;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrician);

        drawerLayout_electrician = findViewById(R.id.drawerlayout_electrician);
        navigationView_electrician = findViewById(R.id.navview_electrician);
        toolbar_electrician = findViewById(R.id.toolbar_electrician);
        electricianbook = findViewById(R.id.electricianbook);
        DB =new DBHelper(this);
        email = getIntent().getStringExtra("key_email");
        ArrayList<UserModel> arrUser = new ArrayList<>();
        if (email != null) {
            arrUser = DB.fetchUser(email);
        } else {
            // Handle the case when the email is null
        }
        String username = arrUser.get(0).username;


        setSupportActionBar(toolbar_electrician);
        navigationView_electrician.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout_electrician,toolbar_electrician,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout_electrician.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_electrician.setNavigationItemSelectedListener(this);
        View headerView = navigationView_electrician.getHeaderView(0);
        dashboardemail = headerView.findViewById(R.id.dashboardemail);
        dashboarduser = headerView.findViewById(R.id.dashboarduser);
        dashboardemail.setText(email);
        dashboarduser.setText(username);
        electricianbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(electrician.this,electricianlist.class);
                intent.putExtra("key_email",email);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {
        if(drawerLayout_electrician.isDrawerOpen(GravityCompat.START)){
            drawerLayout_electrician.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navhome:
                Intent intent1 = new Intent(electrician.this,userdashboard.class);
                intent1.putExtra("key_email",email);
                startActivity(intent1);
                break;
            case R.id.navservices:
                Intent intent2 = new Intent(electrician.this,edituser.class);
                intent2.putExtra("key_email",email);
                startActivity(intent2);
                break;
            case R.id.navnchangepassword:
                Intent intent3 = new Intent(electrician.this,changeuserpassword.class);
                intent3.putExtra("key_email",email);
                startActivity(intent3);
                break;
            case R.id.navhistory:
                break;
            case R.id.navpayment:
                break;
            case R.id.navlogout:
                Intent intent = new Intent(electrician.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}