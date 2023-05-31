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

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class googlecarmechanic extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout_googlecarmechanic;
    NavigationView navigationView_googlecarmechanic;
    Toolbar toolbar_googlecarmechanic;
    String email,name;
    TextView dashboardemail,dashboarduser;
    DBHelper DB;
    Button googlecarmechanicbook;
    GoogleSignInClient gsc;
    GoogleSignInOptions gso;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googlecarmechanic);
        drawerLayout_googlecarmechanic = findViewById(R.id.drawerlayout_googlecarmechanic);
        navigationView_googlecarmechanic = findViewById(R.id.navview_googlecarmechanic);
        googlecarmechanicbook = findViewById(R.id.googlecarmechanicbook);
        toolbar_googlecarmechanic = findViewById(R.id.toolbar_googlecarmechanic);
        email = getIntent().getStringExtra("key_email");
        name = getIntent().getStringExtra("key_name");
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);



        setSupportActionBar(toolbar_googlecarmechanic);
        navigationView_googlecarmechanic.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout_googlecarmechanic,toolbar_googlecarmechanic,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout_googlecarmechanic.addDrawerListener(toggle);
        toggle.syncState();

        navigationView_googlecarmechanic.setNavigationItemSelectedListener(this);
        View headerView = navigationView_googlecarmechanic.getHeaderView(0);
        dashboardemail = headerView.findViewById(R.id.dashboardemail);
        dashboarduser = headerView.findViewById(R.id.dashboarduser);
        dashboardemail.setText(email);
        dashboarduser.setText(name);
        googlecarmechanicbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(googlecarmechanic.this,carmechaniclist.class);
                intent.putExtra("key_email",email);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout_googlecarmechanic.isDrawerOpen(GravityCompat.START)){
            drawerLayout_googlecarmechanic.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.googlenavhome:
                Intent intent = new Intent(googlecarmechanic.this,SecondActivity.class);
                startActivity(intent);
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
                startActivity(new Intent(googlecarmechanic.this,MainActivity.class));
            }
        });
    }
}