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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;

public class SecondActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout googledrawerLayout;
    NavigationView googlenavigationView;
    Toolbar googletoolbar;
    TextView dashboardemail,dashboarduser;
    String personName,personEmail;
    DBHelper DB;

    ImageView googleplumberimage,googlepaintingimage,googlecarmechanicimage,googleelectricianimage,googlehousecleaningimage,googleapplianceimage,googletreecuttingimage,googlegardeningimage,googlecookimage,googledriverimage;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        googledrawerLayout = findViewById(R.id.googledrawerlayout);
        googlenavigationView = findViewById(R.id.googlenavview);
        googletoolbar = findViewById(R.id.googletoolbar);
        googleplumberimage = findViewById(R.id.googleplumberimage);
        googlepaintingimage = findViewById(R.id.googlepaintingimage);
        googlecarmechanicimage = findViewById(R.id.googlecarmechanicimage);
        googleelectricianimage = findViewById(R.id.googleelectricianimage);
        googlehousecleaningimage = findViewById(R.id.googlehousecleaningimage);
        googleapplianceimage = findViewById(R.id.googleapplianceimage);
        googletreecuttingimage = findViewById(R.id.googletreecuttingimage);
        googlegardeningimage = findViewById(R.id.googlegardeningimage);
        googlecookimage = findViewById(R.id.googlecookimage);
        googledriverimage = findViewById(R.id.googledriverimage);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
             personName = acct.getDisplayName();
             personEmail = acct.getEmail();
        }
        googleplumberimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,googleplumber.class);
                intent.putExtra("key_email",personEmail);
                intent.putExtra("key_name",personName);
                startActivity(intent);
            }
        });
        googlepaintingimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,googlepainter.class);
                intent.putExtra("key_email",personEmail);
                intent.putExtra("key_name",personName);
                startActivity(intent);
            }
        });

        googlecarmechanicimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,googlecarmechanic.class);
                intent.putExtra("key_email",personEmail);
                intent.putExtra("key_name",personName);
                startActivity(intent);
            }
        });

        googleelectricianimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,googleelectrician.class);
                intent.putExtra("key_email",personEmail);
                intent.putExtra("key_name",personName);
                startActivity(intent);
            }
        });

        googlehousecleaningimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,googlehousecleaning.class);
                intent.putExtra("key_email",personEmail);
                intent.putExtra("key_name",personName);
                startActivity(intent);
            }
        });

        googleapplianceimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,googleappliance.class);
                intent.putExtra("key_email",personEmail);
                intent.putExtra("key_name",personName);
                startActivity(intent);
            }
        });

        googletreecuttingimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,googletreecutter.class);
                intent.putExtra("key_email",personEmail);
                intent.putExtra("key_name",personName);
                startActivity(intent);
            }
        });

        googlegardeningimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,googlegardener.class);
                intent.putExtra("key_email",personEmail);
                intent.putExtra("key_name",personName);
                startActivity(intent);
            }
        });

        googlecookimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,googlecook.class);
                intent.putExtra("key_email",personEmail);
                intent.putExtra("key_name",personName);
                startActivity(intent);
            }
        });

        googledriverimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,googledriver.class);
                intent.putExtra("key_email",personEmail);
                intent.putExtra("key_name",personName);
                startActivity(intent);
            }
        });


        setSupportActionBar(googletoolbar);
        googlenavigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,googledrawerLayout,googletoolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        googledrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        googlenavigationView.setNavigationItemSelectedListener(this);
        View headerView = googlenavigationView.getHeaderView(0);
        dashboardemail = headerView.findViewById(R.id.dashboardemail);
        dashboarduser = headerView.findViewById(R.id.dashboarduser);
        dashboardemail.setText(personEmail);
        dashboarduser.setText(personName);
    }

    @Override
    public void onBackPressed() {
        if(googledrawerLayout.isDrawerOpen(GravityCompat.START)){
            googledrawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.googlenavhome:
                break;

            case R.id.googlenavnotification:
                Toast.makeText(this, "No Notifications", Toast.LENGTH_SHORT).show();
                break;
            case R.id.googlenavhistory:
                break;
            case R.id.googlenavpayment:
                break;
            case R.id.googlenavlogout:
                    signOut();
                    break;

        }
        return true;
    }

    void signOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                finish();
                startActivity(new Intent(SecondActivity.this,MainActivity.class));
            }
        });
    }
}