package com.example.easify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class changeuserpassword extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout changeuserpassworddrawerLayout;
    NavigationView changeuserpasswordnavigationView;
    Toolbar changeuserpasswordtoolbar;
    TextView dashboardemail,dashboarduser;
    String email,username,mobile,address,city,password;
    DBHelper DB;
    EditText changeuseroldpassword,changeusernewpassword;
    Button changeuserpasswordbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeuserpassword);
        changeuseroldpassword = findViewById(R.id.changeuseroldpassword);
        changeusernewpassword = findViewById(R.id.changeusernewpassword);
        changeuserpassworddrawerLayout = findViewById(R.id.changeuserpassworddrawerlayout);
        changeuserpasswordnavigationView = findViewById(R.id.changeuserpasswordnavview);
        changeuserpasswordtoolbar = findViewById(R.id.changeuserpasswordtoolbar);


        changeuserpasswordbtn=findViewById(R.id.changeuserpasswordbtn);
        DB =new DBHelper(this);

        email = getIntent().getStringExtra("key_email");
        ArrayList<UserModel> arrUser = new ArrayList<>();
        arrUser = DB.fetchUser(email);
        if (!arrUser.isEmpty()) {
            UserModel userModel = arrUser.get(0);
            username = userModel.username;
            email = userModel.email;
            password = userModel.password;
        }
        setSupportActionBar(changeuserpasswordtoolbar);
        changeuserpasswordnavigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,changeuserpassworddrawerLayout,changeuserpasswordtoolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        changeuserpassworddrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        changeuserpasswordnavigationView.setNavigationItemSelectedListener(this);
        View headerView = changeuserpasswordnavigationView.getHeaderView(0);
        dashboardemail = headerView.findViewById(R.id.dashboardemail);
        dashboarduser = headerView.findViewById(R.id.dashboarduser);
        dashboardemail.setText(email);
        dashboarduser.setText(username);

        changeuserpasswordbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Oldpassword = changeuseroldpassword.getText().toString();
                String Newpassword = changeusernewpassword.getText().toString();
                if(Oldpassword.equals(password)) {
                    boolean success = DB.changeuserpassword(Newpassword,email);
                    if (success) {
                        Toast.makeText(changeuserpassword.this, "Updated sucessfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(changeuserpassword.this, "Failed to update", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(changeuserpassword.this, "Wrong Old password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        if(changeuserpassworddrawerLayout.isDrawerOpen(GravityCompat.START)){
            changeuserpassworddrawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navhome:
                Intent intent1 = new Intent(changeuserpassword.this,userdashboard.class);
                intent1.putExtra("key_email",email);
                startActivity(intent1);
                break;
            case R.id.navservices:
                Intent intent2 = new Intent(changeuserpassword.this,edituser.class);
                intent2.putExtra("key_email",email);
                startActivity(intent2);
                break;
            case R.id.navnchangepassword:
                break;
            case R.id.navhistory:
                break;
            case R.id.navpayment:
                break;
            case R.id.navlogout:
                Intent intent = new Intent(changeuserpassword.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}