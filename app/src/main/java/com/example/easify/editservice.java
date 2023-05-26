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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class editservice extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout editservicedrawerLayout;
    NavigationView editservicenavigationView;
    Toolbar editservicetoolbar;
    TextView dashboardservicename,dashboardserviceemail;
    String email,table,name,mobile,address,city,password;
    DBHelper DB;
    EditText editserviceusername,editserviceemail,editservicemobile,editserviceaddress,editservicecity;
    Button editservicebtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editservice);

        editservicedrawerLayout = findViewById(R.id.editservicedrawerlayout);
        editservicenavigationView = findViewById(R.id.editservicenavview);
        editservicetoolbar = findViewById(R.id.editservicetoolbar);
        editserviceusername = findViewById(R.id.editserviceusername);
        editserviceemail = findViewById(R.id.editserviceemail);
        editservicemobile = findViewById(R.id.editservicemobile);
        editserviceaddress = findViewById(R.id.editserviceaddress);
        editservicecity = findViewById(R.id.editservicecity);
        editservicebtn = findViewById(R.id.editservicebtn);
        DB =new DBHelper(this);
        table = getIntent().getStringExtra("key_table");
        email = getIntent().getStringExtra("key_email");

        if ("plumber".equals(table)){
            ArrayList<ServiceModel> arrService = new ArrayList<>();
            arrService = DB.collectPlumber(email);
            if (!arrService.isEmpty()) {
                ServiceModel serviceModel = arrService.get(0);
                name = serviceModel.username;
                email = serviceModel.email;
                password = serviceModel.password;
                mobile = serviceModel.mobile;
                address = serviceModel.address;
                city = serviceModel.city;
            }
        }
        else if("painter".equals(table)){
            ArrayList<ServiceModel> arrService = new ArrayList<>();
            arrService = DB.collectPainter(email);
            if (!arrService.isEmpty()) {
                ServiceModel serviceModel = arrService.get(0);
                name = serviceModel.username;
                email = serviceModel.email;
                password = serviceModel.password;
                mobile = serviceModel.mobile;
                address = serviceModel.address;
                city = serviceModel.city;
            }
        }
        else if("carmechanic".equals(table)){
            ArrayList<ServiceModel> arrService = new ArrayList<>();
            arrService = DB.collectCarmechanic(email);
            if (!arrService.isEmpty()) {
                ServiceModel serviceModel = arrService.get(0);
                name = serviceModel.username;
                email = serviceModel.email;
                password = serviceModel.password;
                mobile = serviceModel.mobile;
                address = serviceModel.address;
                city = serviceModel.city;
            }
        }
        else if("electrician".equals(table)){
            ArrayList<ServiceModel> arrService = new ArrayList<>();
            arrService = DB.collectElectrician(email);
            if (!arrService.isEmpty()) {
                ServiceModel serviceModel = arrService.get(0);
                name = serviceModel.username;
                email = serviceModel.email;
                password = serviceModel.password;
                mobile = serviceModel.mobile;
                address = serviceModel.address;
                city = serviceModel.city;
            }
        }
        else if("housecleaner".equals(table)){
            ArrayList<ServiceModel> arrService = new ArrayList<>();
            arrService = DB.collectHousecleaner(email);
            if (!arrService.isEmpty()) {
                ServiceModel serviceModel = arrService.get(0);
                name = serviceModel.username;
                email = serviceModel.email;
                password = serviceModel.password;
                mobile = serviceModel.mobile;
                address = serviceModel.address;
                city = serviceModel.city;
            }
        }
        else if("appliancerepair".equals(table)){
            ArrayList<ServiceModel> arrService = new ArrayList<>();
            arrService = DB.collectAppliancerepair(email);
            if (!arrService.isEmpty()) {
                ServiceModel serviceModel = arrService.get(0);
                name = serviceModel.username;
                email = serviceModel.email;
                password = serviceModel.password;
                mobile = serviceModel.mobile;
                address = serviceModel.address;
                city = serviceModel.city;
            }
        }
        else if("treecutter".equals(table)){
            ArrayList<ServiceModel> arrService = new ArrayList<>();
            arrService = DB.collectTreecutter(email);
            if (!arrService.isEmpty()) {
                ServiceModel serviceModel = arrService.get(0);
                name = serviceModel.username;
                email = serviceModel.email;
                password = serviceModel.password;
                mobile = serviceModel.mobile;
                address = serviceModel.address;
                city = serviceModel.city;
            }
        }
        else if ("gardener".equals(table)) {
            ArrayList<ServiceModel> arrService = DB.collectGardener(email);
            if (!arrService.isEmpty()) {
                ServiceModel serviceModel = arrService.get(0);
                name = serviceModel.username;
                email = serviceModel.email;
                password = serviceModel.password;
                mobile = serviceModel.mobile;
                address = serviceModel.address;
                city = serviceModel.city;
            }
        }
        else if("cook".equals(table)){
            ArrayList<ServiceModel> arrService = new ArrayList<>();
            arrService = DB.collectCook(email);
            if (!arrService.isEmpty()) {
                ServiceModel serviceModel = arrService.get(0);
                name = serviceModel.username;
                email = serviceModel.email;
                password = serviceModel.password;
                mobile = serviceModel.mobile;
                address = serviceModel.address;
                city = serviceModel.city;
            }
        }
        else if("driver".equals(table)){
            ArrayList<ServiceModel> arrService = new ArrayList<>();
            arrService = DB.collectDriver(email);
            if (!arrService.isEmpty()) {
                ServiceModel serviceModel = arrService.get(0);
                name = serviceModel.username;
                email = serviceModel.email;
                password = serviceModel.password;
                mobile = serviceModel.mobile;
                address = serviceModel.address;
                city = serviceModel.city;
            }
        }

        setSupportActionBar(editservicetoolbar);
        editservicenavigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,editservicedrawerLayout,editservicetoolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        editservicedrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        editservicenavigationView.setNavigationItemSelectedListener(this);
        View headerView = editservicenavigationView.getHeaderView(0);
        dashboardserviceemail = headerView.findViewById(R.id.dashboardserviceemail);
        dashboardservicename = headerView.findViewById(R.id.dashboardservicename);
        dashboardserviceemail.setText(email);
        dashboardservicename.setText(name);
        editserviceusername.setText(name);
        editserviceemail.setText(email);
        editservicemobile.setText(mobile);
        editserviceaddress.setText(address);
        editservicecity.setText(city);
        if ("plumber".equals(table))
        {
            editservicebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String updatedUsername = editserviceusername.getText().toString();
                    String updatedEmail = editserviceemail.getText().toString();
                    String updatedMobile = editservicemobile.getText().toString();
                    String updatedAddress = editserviceaddress.getText().toString();
                    String updatedCity = editservicecity.getText().toString();

                    boolean success = DB.editplumber(updatedUsername, updatedEmail, updatedMobile, updatedAddress, updatedCity,email);
                    if (success) {
                        Toast.makeText(editservice.this, "updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(editservice.this, "updation failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else if ("painter".equals(table))
        {
            editservicebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String updatedUsername = editserviceusername.getText().toString();
                    String updatedEmail = editserviceemail.getText().toString();
                    String updatedMobile = editservicemobile.getText().toString();
                    String updatedAddress = editserviceaddress.getText().toString();
                    String updatedCity = editservicecity.getText().toString();

                    boolean success = DB.editpainter(updatedUsername, updatedEmail, updatedMobile, updatedAddress, updatedCity,email);
                    if (success) {
                        Toast.makeText(editservice.this, "updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(editservice.this, "updation failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else if ("carmechanic".equals(table))
        {
            editservicebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String updatedUsername = editserviceusername.getText().toString();
                    String updatedEmail = editserviceemail.getText().toString();
                    String updatedMobile = editservicemobile.getText().toString();
                    String updatedAddress = editserviceaddress.getText().toString();
                    String updatedCity = editservicecity.getText().toString();

                    boolean success = DB.editcarmechanic(updatedUsername, updatedEmail, updatedMobile, updatedAddress, updatedCity,email);
                    if (success) {
                        Toast.makeText(editservice.this, "updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(editservice.this, "updation failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else if ("electrician".equals(table))
        {
            editservicebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String updatedUsername = editserviceusername.getText().toString();
                    String updatedEmail = editserviceemail.getText().toString();
                    String updatedMobile = editservicemobile.getText().toString();
                    String updatedAddress = editserviceaddress.getText().toString();
                    String updatedCity = editservicecity.getText().toString();

                    boolean success = DB.editelectrician(updatedUsername, updatedEmail, updatedMobile, updatedAddress, updatedCity,email);
                    if (success) {
                        Toast.makeText(editservice.this, "updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(editservice.this, "updation failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else if ("housecleaner".equals(table))
        {
            editservicebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String updatedUsername = editserviceusername.getText().toString();
                    String updatedEmail = editserviceemail.getText().toString();
                    String updatedMobile = editservicemobile.getText().toString();
                    String updatedAddress = editserviceaddress.getText().toString();
                    String updatedCity = editservicecity.getText().toString();

                    boolean success = DB.edithousecleaner(updatedUsername, updatedEmail, updatedMobile, updatedAddress, updatedCity,email);
                    if (success) {
                        Toast.makeText(editservice.this, "updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(editservice.this, "updation failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else if ("appliancerepair".equals(table))
        {
            editservicebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String updatedUsername = editserviceusername.getText().toString();
                    String updatedEmail = editserviceemail.getText().toString();
                    String updatedMobile = editservicemobile.getText().toString();
                    String updatedAddress = editserviceaddress.getText().toString();
                    String updatedCity = editservicecity.getText().toString();

                    boolean success = DB.editappliancerepair(updatedUsername, updatedEmail, updatedMobile, updatedAddress, updatedCity,email);
                    if (success) {
                        Toast.makeText(editservice.this, "updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(editservice.this, "updation failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else if ("treecutter".equals(table))
        {
            editservicebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String updatedUsername = editserviceusername.getText().toString();
                    String updatedEmail = editserviceemail.getText().toString();
                    String updatedMobile = editservicemobile.getText().toString();
                    String updatedAddress = editserviceaddress.getText().toString();
                    String updatedCity = editservicecity.getText().toString();

                    boolean success = DB.edittreecutter(updatedUsername, updatedEmail, updatedMobile, updatedAddress, updatedCity,email);
                    if (success) {
                        Toast.makeText(editservice.this, "updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(editservice.this, "updation failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else if ("gardener".equals(table))
        {
            editservicebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String updatedUsername = editserviceusername.getText().toString();
                    String updatedEmail = editserviceemail.getText().toString();
                    String updatedMobile = editservicemobile.getText().toString();
                    String updatedAddress = editserviceaddress.getText().toString();
                    String updatedCity = editservicecity.getText().toString();

                    boolean success = DB.editgardener(updatedUsername, updatedEmail, updatedMobile, updatedAddress, updatedCity,email);
                    if (success) {
                        Toast.makeText(editservice.this, "updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(editservice.this, "updation failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else if ("cook".equals(table))
        {
            editservicebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String updatedUsername = editserviceusername.getText().toString();
                    String updatedEmail = editserviceemail.getText().toString();
                    String updatedMobile = editservicemobile.getText().toString();
                    String updatedAddress = editserviceaddress.getText().toString();
                    String updatedCity = editservicecity.getText().toString();

                    boolean success = DB.editcook(updatedUsername, updatedEmail, updatedMobile, updatedAddress, updatedCity,email);
                    if (success) {
                        Toast.makeText(editservice.this, "updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(editservice.this, "updation failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else if ("driver".equals(table))
        {
            editservicebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String updatedUsername = editserviceusername.getText().toString();
                    String updatedEmail = editserviceemail.getText().toString();
                    String updatedMobile = editservicemobile.getText().toString();
                    String updatedAddress = editserviceaddress.getText().toString();
                    String updatedCity = editservicecity.getText().toString();

                    boolean success = DB.editdriver(updatedUsername, updatedEmail, updatedMobile, updatedAddress, updatedCity,email);
                    if (success) {
                        Toast.makeText(editservice.this, "updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(editservice.this, "updation failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        if(editservicedrawerLayout.isDrawerOpen(GravityCompat.START)){
            editservicedrawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.servicenavhome:
                Intent intent1 = new Intent(editservice.this,serviceproviderdashboard.class);
                intent1.putExtra("key_email",email);
                intent1.putExtra("key_table",table);
                startActivity(intent1);
                break;
            case R.id.servicenavstatus:

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
                Intent intent = new Intent(editservice.this,MainActivity.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}