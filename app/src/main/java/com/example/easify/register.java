package com.example.easify;


import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class register extends AppCompatActivity {

    TextView signuptitle;
    EditText username, email, password, mobile, address, city;
    Button registerbtn, loginpage;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        mobile = findViewById(R.id.mobile);
        address = findViewById(R.id.address);
        city = findViewById(R.id.city);
        registerbtn = findViewById(R.id.registernbtn);
        loginpage = findViewById(R.id.loginpage);
        DB =new DBHelper(this);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username1 = username.getText().toString();
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();
                String mobile1 = mobile.getText().toString();
                String address1 = address.getText().toString();
                String city1 = city.getText().toString();
                if(TextUtils.isEmpty(username1) || TextUtils.isEmpty(email1) || TextUtils.isEmpty(password1) || TextUtils.isEmpty(mobile1) || TextUtils.isEmpty(address1) || TextUtils.isEmpty(city1))
                    Toast.makeText(register.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuser = DB.checkemail(email1);
                    if(checkuser == false){
                        Boolean insert = DB.insertData(username1,email1,password1,mobile1,address1,city1);
                        if(insert == true){
                            Toast.makeText(register.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(register.this,MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(register.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(register.this, "User Already exists", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        loginpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}