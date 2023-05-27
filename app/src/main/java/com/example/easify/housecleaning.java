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

public class housecleaning extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout_housecleaning;
    NavigationView navigationView_housecleaning;
    Toolbar toolbar_housecleaning;
    Button housecleaningbook;
    String email;
    TextView dashboardemail,dashboarduser;
    DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housecleaning);
        drawerLayout_housecleaning = findViewById(R.id.drawerlayout_housecleaning);
        navigationView_housecleaning = findViewById(R.id.navview_housecleaning);
        housecleaningbook = findViewById(R.id.housecleaningbook);
        toolbar_housecleaning = findViewById(R.id.toolbar_housecleaning);
        DB =new DBHelper(this);
        email = getIntent().getStringExtra("key_email");
        ArrayList<UserModel> arrUser = new ArrayList<>();
        if (email != null) {
            arrUser = DB.fetchUser(email);
        } else {
            // Handle the case when the email is null
        }
        String username = arrUser.get(0).username;


        setSupportActionBar(toolbar_housecleaning);
        navigationView_housecleaning.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout_housecleaning,toolbar_housecleaning,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout_housecleaning.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_housecleaning.setNavigationItemSelectedListener(this);
        View headerView = navigationView_housecleaning.getHeaderView(0);
        dashboardemail = headerView.findViewById(R.id.dashboardemail);
        dashboarduser = headerView.findViewById(R.id.dashboarduser);
        dashboardemail.setText(email);
        dashboarduser.setText(username);
        housecleaningbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(housecleaning.this,housecleaninglist.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout_housecleaning.isDrawerOpen(GravityCompat.START)){
            drawerLayout_housecleaning.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navhome:
                Intent intent1 = new Intent(housecleaning.this,userdashboard.class);
                intent1.putExtra("key_email",email);
                startActivity(intent1);
                break;
            case R.id.navservices:
                Intent intent2 = new Intent(housecleaning.this,edituser.class);
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
                Intent intent = new Intent(housecleaning.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}