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
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class addadmin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout addadmindrawerLayout;
    NavigationView addadminnavigationView;
    Toolbar addadmintoolbar;
    TextView dashboardadminemail,dashboardadmin;
    String email,username,mobile,address,city,password;
    DBHelper DB;
    EditText addadminusername,addadminemail,addadminpassword,addadminmobile,addadminaddress,addadmincity;
    Button addadminbtn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addadmin);

        addadmindrawerLayout = findViewById(R.id.addadmindrawerlayout);
        addadminnavigationView = findViewById(R.id.addadminnavview);
        addadmintoolbar = findViewById(R.id.addadmintoolbar);
        addadminusername = findViewById(R.id.addadminusername);
        addadminemail = findViewById(R.id.addadminemail);
        addadminpassword = findViewById(R.id.addadminpassword);
        addadminmobile = findViewById(R.id.addadminmobile);
        addadminaddress = findViewById(R.id.addadminaddress);
        addadmincity = findViewById(R.id.addadmincity);
        addadminbtn=findViewById(R.id.addadminbtn);
        DB =new DBHelper(this);

        email = getIntent().getStringExtra("key_email");
        ArrayList<AdminModel> arrUser = new ArrayList<>();
        if (email != null) {
            arrUser = DB.fetchAdmin(email);
        } else {

        }
        String username = arrUser.get(0).username;

        setSupportActionBar(addadmintoolbar);
        addadminnavigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,addadmindrawerLayout,addadmintoolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        addadmindrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        addadminnavigationView.setNavigationItemSelectedListener(this);
        View headerView = addadminnavigationView.getHeaderView(0);
        dashboardadminemail = headerView.findViewById(R.id.dashboardadminemail);
        dashboardadmin = headerView.findViewById(R.id.dashboardadmin);
        dashboardadminemail.setText(email);
        dashboardadmin.setText(username);
        addadminbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username1 = addadminusername.getText().toString();
                String email1 = addadminemail.getText().toString();
                String password1 = addadminpassword.getText().toString();
                String mobile1 = addadminmobile.getText().toString();
                String address1 = addadminaddress.getText().toString();
                String city1 = addadmincity.getText().toString();
                if(TextUtils.isEmpty(username1) || TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1) || TextUtils.isEmpty(mobile1) || TextUtils.isEmpty(address1) || TextUtils.isEmpty(city1))
                    Toast.makeText(addadmin.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuser = DB.checkemail(email1);
                    if(checkuser == false){
                        Boolean insert = DB.insertAdminData(username1,email1,password1,mobile1,address1,city1);
                        if(insert == true){
                            Toast.makeText(addadmin.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(addadmin.this,admindashboard.class);
                            intent.putExtra("key_email",email);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(addadmin.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(addadmin.this, "User Already exists", Toast.LENGTH_SHORT).show();
                    }
                }
                }
        });
    }

    @Override
    public void onBackPressed() {
        if(addadmindrawerLayout.isDrawerOpen(GravityCompat.START)){
            addadmindrawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.adminnavhome:
                Intent intent1 = new Intent(addadmin.this,admindashboard.class);
                intent1.putExtra("key_email",email);
                startActivity(intent1);
                break;
            case R.id.adminedit:
                Intent intent2 = new Intent(addadmin.this,editadmin.class);
                intent2.putExtra("key_email",email);
                startActivity(intent2);
                break;
            case R.id.adminadd:
                break;
            case R.id.adminnavnotification:
                Toast.makeText(this, "No Notifications", Toast.LENGTH_SHORT).show();
                break;
            case R.id.adminnavhistory:
                break;
            case R.id.adminnavpayment:
                break;
            case R.id.adminnavlogout:
                Intent intent = new Intent(addadmin.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}