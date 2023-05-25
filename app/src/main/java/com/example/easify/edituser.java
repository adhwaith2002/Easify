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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class edituser extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout editdrawerLayout;
    NavigationView editnavigationView;
    Toolbar edittoolbar;
    TextView dashboardemail,dashboarduser;
    String email,username,mobile,address,city,password;
    DBHelper DB;
    EditText editusername,editemail,editmobile,editaddress,editcity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edituser);

        editdrawerLayout = findViewById(R.id.editdrawerlayout);
        editnavigationView = findViewById(R.id.editnavview);
        edittoolbar = findViewById(R.id.edittoolbar);
        editusername = findViewById(R.id.editusername);
        editemail = findViewById(R.id.editemail);
        editmobile = findViewById(R.id.editmobile);
        editaddress = findViewById(R.id.editaddress);
        editcity = findViewById(R.id.editcity);
        DB =new DBHelper(this);

        email = getIntent().getStringExtra("key_email");
        ArrayList<UserModel> arrUser = new ArrayList<>();
        arrUser = DB.fetchUser(email);
        if (!arrUser.isEmpty()) {
            UserModel userModel = arrUser.get(0);
            username = userModel.username;
            email = userModel.email;
            password = userModel.password;
            mobile = userModel.mobile;
            address = userModel.address;
            city = userModel.city;
        }
        setSupportActionBar(edittoolbar);
        editnavigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,editdrawerLayout,edittoolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        editdrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        editnavigationView.setNavigationItemSelectedListener(this);
        View headerView = editnavigationView.getHeaderView(0);
        dashboardemail = headerView.findViewById(R.id.dashboardemail);
        dashboarduser = headerView.findViewById(R.id.dashboarduser);
        dashboardemail.setText(email);
        dashboarduser.setText(username);
        editusername.setText(username);
        editemail.setText(email);
        editmobile.setText(mobile);
        editaddress.setText(address);
        editcity.setText(city);;


    }

    @Override
    public void onBackPressed() {
        if(editdrawerLayout.isDrawerOpen(GravityCompat.START)){
            editdrawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navhome:
                Intent intent1 = new Intent(edituser.this,userdashboard.class);
                intent1.putExtra("key_email",email);
                startActivity(intent1);
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
                Intent intent = new Intent(edituser.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}