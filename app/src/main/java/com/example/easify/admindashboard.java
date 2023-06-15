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

public class admindashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout admindrawerLayout;
    NavigationView adminnavigationView;
    Toolbar admintoolbar;
    TextView dashboardadminemail,dashboardadmin;
    String email;
    DBHelper DB;

    ImageView adminplumberimage,adminpaintingimage,admincarmechanicimage,adminelectricianimage,adminhousecleaningimage,adminapplianceimage,admintreecuttingimage,admingardeningimage,admincookimage,admindriverimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindashboard);

        admindrawerLayout = findViewById(R.id.admindrawerlayout);
        adminnavigationView = findViewById(R.id.adminnavview);
        admintoolbar = findViewById(R.id.admintoolbar);
        adminplumberimage = findViewById(R.id.adminplumberimage);
        adminpaintingimage = findViewById(R.id.adminpaintingimage);
        admincarmechanicimage = findViewById(R.id.admincarmechanicimage);
        adminelectricianimage = findViewById(R.id.adminelectricianimage);
        adminhousecleaningimage = findViewById(R.id.adminhousecleaningimage);
        adminapplianceimage = findViewById(R.id.adminapplianceimage);
        admintreecuttingimage = findViewById(R.id.admintreecuttingimage);
        admingardeningimage = findViewById(R.id.admingardeningimage);
        admincookimage = findViewById(R.id.admincookimage);
        admindriverimage = findViewById(R.id.admindriverimage);
        DB =new DBHelper(this);
        email = getIntent().getStringExtra("key_email");
        ArrayList<AdminModel> arrUser = new ArrayList<>();
        if (email != null) {
            arrUser = DB.fetchAdmin(email);
        } else {

        }
        String username = arrUser.get(0).username;

        adminplumberimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admindashboard.this,plumberlist1.class);
                intent.putExtra("key_email",email);
                startActivity(intent);
            }
        });
        adminpaintingimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admindashboard.this, painterlist1.class);
                intent.putExtra("key_email",email);
                startActivity(intent);
            }
        });

        admincarmechanicimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admindashboard.this,carmechaniclist1.class);
                intent.putExtra("key_email",email);
                startActivity(intent);
            }
        });

        adminelectricianimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admindashboard.this,electricianlist1.class);
                intent.putExtra("key_email",email);
                startActivity(intent);
            }
        });

        adminhousecleaningimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admindashboard.this,housecleaninglist1.class);
                intent.putExtra("key_email",email);
                startActivity(intent);
            }
        });

        adminapplianceimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admindashboard.this,appliancelist1.class);
                intent.putExtra("key_email",email);
                startActivity(intent);
            }
        });

        admintreecuttingimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admindashboard.this,treecuttinglist1.class);
                intent.putExtra("key_email",email);
                startActivity(intent);
            }
        });

        admingardeningimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admindashboard.this,gardeninglist1.class);
                intent.putExtra("key_email",email);
                startActivity(intent);
            }
        });

        admincookimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admindashboard.this,cooklist1.class);
                intent.putExtra("key_email",email);
                startActivity(intent);
            }
        });

        admindriverimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admindashboard.this,driverlist1.class);
                intent.putExtra("key_email",email);
                startActivity(intent);
            }
        });




        setSupportActionBar(admintoolbar);
        adminnavigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,admindrawerLayout,admintoolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        admindrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        adminnavigationView.setNavigationItemSelectedListener(this);
        View headerView = adminnavigationView.getHeaderView(0);
        dashboardadminemail = headerView.findViewById(R.id.dashboardadminemail);
        dashboardadmin = headerView.findViewById(R.id.dashboardadmin);
        dashboardadminemail.setText(email);
        dashboardadmin.setText(username);
    }

    @Override
    public void onBackPressed() {
        if(admindrawerLayout.isDrawerOpen(GravityCompat.START)){
            admindrawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.adminnavhome:
                break;
            case R.id.adminedit:
                Intent intent1 = new Intent(admindashboard.this,editadmin.class);
                intent1.putExtra("key_email",email);
                startActivity(intent1);
                break;
            case R.id.adminadd:
                Intent intent2 = new Intent(admindashboard.this,addadmin.class);
                intent2.putExtra("key_email",email);
                startActivity(intent2);
                break;
            case R.id.adminnavnotification:
                Toast.makeText(this, "No Notifications", Toast.LENGTH_SHORT).show();
                break;
            case R.id.adminnavhistory:
                break;
            case R.id.adminnavpayment:
                break;
            case R.id.adminnavlogout:
                Intent intent = new Intent(admindashboard.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}