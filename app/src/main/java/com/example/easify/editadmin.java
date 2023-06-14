package com.example.easify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class editadmin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout editadmindrawerLayout;
    NavigationView editadminnavigationView;
    Toolbar editadmintoolbar;
    TextView dashboardadminemail,dashboardadmin;
    String email,username,mobile,address,city,password;
    DBHelper DB;
    EditText editadminusername,editadminemail,editadminmobile,editadminaddress,editadmincity;
    Button editadminbtn;
    AlertDialog.Builder builder;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editadmin);

        editadmindrawerLayout = findViewById(R.id.editadmindrawerlayout);
        editadminnavigationView = findViewById(R.id.editadminnavview);
        editadmintoolbar = findViewById(R.id.editadmintoolbar);
        editadminusername = findViewById(R.id.editadminusername);
        editadminemail = findViewById(R.id.editadminemail);
        editadminmobile = findViewById(R.id.editadminmobile);
        editadminaddress = findViewById(R.id.editadminaddress);
        editadmincity = findViewById(R.id.editadmincity);
        editadminbtn=findViewById(R.id.editadminbtn);
        DB =new DBHelper(this);

        email = getIntent().getStringExtra("key_email");
        ArrayList<AdminModel> arrUser = new ArrayList<>();
        arrUser = DB.fetchAdmin(email);
        if (!arrUser.isEmpty()) {
            AdminModel adminModel = arrUser.get(0);
            username = adminModel.username;
            email = adminModel.email;
            password = adminModel.password;
            mobile = adminModel.mobile;
            address = adminModel.address;
            city = adminModel.city;
        }
        setSupportActionBar(editadmintoolbar);
        editadminnavigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,editadmindrawerLayout,editadmintoolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        editadmindrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        editadminnavigationView.setNavigationItemSelectedListener(this);
        View headerView = editadminnavigationView.getHeaderView(0);
        dashboardadminemail = headerView.findViewById(R.id.dashboardadminemail);
        dashboardadmin = headerView.findViewById(R.id.dashboardadmin);
        dashboardadminemail.setText(email);
        dashboardadmin.setText(username);
        editadminusername.setText(username);
        editadminemail.setText(email);
        editadminmobile.setText(mobile);
        editadminaddress.setText(address);
        editadmincity.setText(city);
        builder = new AlertDialog.Builder(this);
        editadminbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updatedUsername = editadminusername.getText().toString();
                String updatedEmail = editadminemail.getText().toString();
                String updatedMobile = editadminmobile.getText().toString();
                String updatedAddress = editadminaddress.getText().toString();
                String updatedCity = editadmincity.getText().toString();

                boolean success = DB.editadmin(updatedUsername, updatedEmail, updatedMobile, updatedAddress, updatedCity,email);
                if (success) {
                    builder.setTitle("Sucess").setMessage("Updated sucessfully").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    }).show();
                } else {
                    Toast.makeText(editadmin.this, "Failed to update", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(editadmindrawerLayout.isDrawerOpen(GravityCompat.START)){
            editadmindrawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.adminnavhome:
                 Intent intent1 = new Intent(editadmin.this,admindashboard.class);
                 intent1.putExtra("key_email",email);
                 startActivity(intent1);
                break;
            case R.id.adminedit:
                break;
            case R.id.adminadd:
                Intent intent2 = new Intent(editadmin.this,addadmin.class);
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
                Intent intent = new Intent(editadmin.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}