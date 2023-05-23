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

public class painting extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout_painting;
    NavigationView navigationView_painting;
    Toolbar toolbar_painting;
    String email;
    TextView dashboardemail,dashboarduser;
    DBHelper DB;
    Button paintingbook;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painting);

        drawerLayout_painting = findViewById(R.id.drawerlayout_painting);
        navigationView_painting = findViewById(R.id.navview_painting);
        paintingbook = findViewById(R.id.paintingbook);
        toolbar_painting = findViewById(R.id.toolbar_painting);
        DB =new DBHelper(this);
        email = getIntent().getStringExtra("key_email");
        ArrayList<UserModel> arrUser = new ArrayList<>();
        if (email != null) {
            arrUser = DB.fetchUser(email);
        } else {
            // Handle the case when the email is null
        }
        String username = arrUser.get(0).username;


        setSupportActionBar(toolbar_painting);
        navigationView_painting.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout_painting,toolbar_painting,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout_painting.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_painting.setNavigationItemSelectedListener(this);
        View headerView = navigationView_painting.getHeaderView(0);
        dashboardemail = headerView.findViewById(R.id.dashboardemail);
        dashboarduser = headerView.findViewById(R.id.dashboarduser);
        dashboardemail.setText(email);
        dashboarduser.setText(username);
        paintingbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(painting.this,paintinglist.class);
                startActivity(intent);
            }
        });
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
                intent1.putExtra("key_email",email);
                startActivity(intent1);
                break;
            case R.id.navservices:
                Intent intent2 = new Intent(painting.this,userdashboard.class);
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
                Intent intent = new Intent(painting.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}
